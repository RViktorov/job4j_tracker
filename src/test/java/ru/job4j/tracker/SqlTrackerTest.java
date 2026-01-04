package ru.job4j.tracker;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Properties;

import static org.assertj.core.api.Assertions.*;

class SqlTrackerTest {

    private static Connection connection;

    @BeforeAll
    public static void initConnection() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("db/liquibase_test.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")

            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @AfterAll
    public static void closeConnection() throws SQLException {
        connection.close();
    }

    @AfterEach
    public void wipeTable() throws SQLException {
        try (PreparedStatement statement = connection.prepareStatement("DELETE FROM items")) {
            statement.execute();
        }
    }

    @Test
    public void whenSaveItemAndFindByGeneratedIdThenMustBeTheSame() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);
        assertThat(tracker.findById(item.getId())).isEqualTo(item);
    }

    @Test
    void whenReplaceExistingItemThenTrueReturnedAndItemUpdated() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("old name");
        tracker.add(item);

        Item updated = new Item("new name");
        updated.setCreated(LocalDateTime.now());
        boolean replaced = tracker.replace(item.getId(), updated);
        Item result = tracker.findById(item.getId());
        assertThat(replaced).isTrue();
        assertThat(result.getName()).isEqualTo("new name");
    }

    @Test
    void whenDeleteItemThenItIsNotFound() {
        SqlTracker tracker = new SqlTracker(connection);
        Item item = new Item("item");
        tracker.add(item);

        tracker.delete(item.getId());
        Item result = tracker.findById(item.getId());
        assertThat(result).isNull();
    }

    @Test
    void whenFindByNameThenReturnOnlyMatchingItems() {
        SqlTracker tracker = new SqlTracker(connection);
        Item first = new Item("task");
        Item second = new Item("task");
        Item third = new Item("other");

        tracker.add(first);
        tracker.add(second);
        tracker.add(third);
        List<Item> result = tracker.findByName("task");

        assertThat(result).hasSize(2);
        assertThat(result).containsExactlyInAnyOrder(first, second);
    }

    @Test
    void whenFindByIdForNonExistingItemThenNullReturned() {
        SqlTracker tracker = new SqlTracker(connection);
        Item result = tracker.findById(123);
        assertThat(result).isNull();
    }

}