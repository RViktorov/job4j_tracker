package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(String passport) {
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                users.remove(user);
            }
        }
    }

    public User findByPassport(String passport) {
        User result = null;
        for (User user : users.keySet()) {
            if (user.getPassport().equals(passport)) {
                result = user;
            }
        }
        return result;
    }

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        for (Map.Entry<User, List<Account>> user : users.entrySet()) {
            if (user.getKey().equals(foundUser) && !user.getValue().contains(account)) {
                user.getValue().add(account);
            }
        }
    }

    public Account findByRequisite(String passport, String requisite) {
        Account account = null;
        User foundUser = findByPassport(passport);
        if (foundUser != null) {
            List<Account> foundValue = users.get(foundUser);
            for (Account foundAccount : foundValue) {
                if (foundAccount.getRequisite().equals(requisite)) {
                    account = foundAccount;
                }
            }
        }
        return account;
    }

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

    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}