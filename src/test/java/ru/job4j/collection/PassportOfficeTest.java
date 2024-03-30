package ru.job4j.collection;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PassportOfficeTest {
    @Test
    public void whenTestAddMethod() {
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        PassportOffice office = new PassportOffice();
        office.add(citizen);
        assertThat(office.get(citizen.getPassport())).isEqualTo(citizen);
    }

    @Test
    public void whenTestNotAddCitizen() {
        PassportOffice office = new PassportOffice();
        Citizen citizen = new Citizen("2f44a", "Petr Arsentev");
        office.add(citizen);
        Citizen citizenNew = new Citizen("2f44a", "Ivanov Ivan");
        boolean expected = office.add(citizenNew);
        assertThat(expected).isFalse();
    }
}