package sk.itsovy.kutka.aopdemo.dao;

import org.springframework.stereotype.Component;

import sk.itsovy.kutka.aopdemo.Account;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;
    private String serviceCode;

    public List<Account> findAccounts(boolean tripWire) {

        if (tripWire) {
            throw new RuntimeException("Nope.");
        }

        List<Account> myAccounts = new ArrayList<>();

        Account temp1 = new Account("John", "Silver");
        Account temp2 = new Account("Muhammad", "Gold");
        Account temp3 = new Account("Luca", "Ruby");

        myAccounts.add(temp1);
        myAccounts.add(temp2);
        myAccounts.add(temp3);

        return myAccounts;
    }

    public void addAccount(Account account, boolean vipFlag) {

        System.out.println(getClass() + ": DOING MY DB WORK: ADDING AN ACCOUNT");

    }

    public boolean doWork() {
        System.out.println(getClass() + ": Do Something");
        return false;
    }

    public String getName() {
        System.out.println("getName" + getClass());
        return name;
    }

    public void setName(String name) {
        System.out.println("setName" + getClass());
        this.name = name;
    }

    public String getServiceCode() {
        System.out.println("getServiceCode" + getClass());
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        System.out.println("setService" + getClass());
        this.serviceCode = serviceCode;
    }
}

