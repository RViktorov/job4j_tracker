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
        users.remove(new User(passport, ""));
    }

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

    public void addAccount(String passport, Account account) {
        User foundUser = findByPassport(passport);
        if (foundUser != null && !users.get(foundUser).contains(account)) {
            users.get(foundUser).add(account);
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
                    break;
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