package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает операции системы банка
 *
 * @author ROMAN VIKTOROV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение данных по клиентам осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход данные клиента  и добавляет ее в коллекцию.
     *
     * @param user клиент
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод удаляет клиента из коллекции по паспорту.
     *
     * @param passport клиент
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, ""));
    }

    /**
     * Метод осушествляет поиск клиента по паспорту.
     *
     * @param passport клиент
     * @return возвращает данные клиента или null если не находит клиента
     */
    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
                break;
            }
        }
        return result;
    }

    /**
     * Метод осуществляет поиск клиента по паспорту и добавляет ему счет.
     *
     * @param passport клиент
     * @param account  счет
     */
    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null && !users.get(foundUser).contains(account)) {
            users.get(foundUser).add(account);
        }
    }

    /**
     * Метод осуществляет поиск счета клиента по паспорту .
     *
     * @param passport  клиент
     * @param requisite реквизиты счета
     * @return возвращает данные счета или null если не находит счет
     */
    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> foundValue = users.get(foundUser);
            for (Account foundAccount : foundValue) {
                if (foundAccount.getRequisite().equals(requisite)) {
                    account = foundAccount;
                    break;
                }
            }
        }
        return account;
    }

    /**
     * Метод осуществляет перевод денежных средств между счетами .
     *
     * @param sourcePassport       паспорт клиент отправителя средств
     * @param sourceRequisite      реквизиты счета с которого производится перечисление
     * @param destinationPassport  паспорт клиент получателя средств
     * @param destinationRequisite реквизиты счета на который производится перечисление
     * @return true если перевод средств произведен, false если перевод не произведен
     */
    public boolean transferMoney(String sourcePassport, String sourceRequisite,
                                 String destinationPassport, String destinationRequisite,
                                 double amount) {
        boolean result = false;
        Account startAccount = findByRequisite(sourcePassport, sourceRequisite);
        Account finishAccount = findByRequisite(destinationPassport, destinationRequisite);
        if ((startAccount != null && finishAccount != null) && startAccount.getBalance() >= amount) {
            startAccount.setBalance(startAccount.getBalance() - amount);
            finishAccount.setBalance(finishAccount.getBalance() + amount);
            result = true;
        }
        return result;
    }

    /**
     * Метод возвращает список счетов клиента .
     *
     * @param user данные клиента
     * @return возвращает список счетов
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}