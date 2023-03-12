package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AccountDAO {

    private String name;

    private String level;

    private String ServiceCode;

    public List<Account> findAccounts(){

        List<Account> myAccounts = new ArrayList();

        Account account1 = new Account("Sem","User");
        Account account2 = new Account("Kostya","Moder");
        Account account3 = new Account("Egor","Admin");

        myAccounts.add(account1);
        myAccounts.add(account2);
        myAccounts.add(account3);

        return myAccounts;

    }

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass()+ ": DOING DB WORK: ADDING A ACCOUNT");

    }

    public boolean doWork(){

        System.out.println(getClass()+ ": doWork()");

        return false;

    }

    public String getName() {
        System.out.println(getClass()+":in getName()");
        return name;
    }

    public void setName(String name) {
        System.out.println(getClass()+":in setName()");
        this.name = name;
    }

    public String getLevel() {
        System.out.println(getClass()+":in getLevel()");
        return level;
    }

    public void setLevel(String level) {

        System.out.println(getClass()+":in setLevel()");
        this.level = level;
    }

    public String getServiceCode() {

        System.out.println(getClass()+":in getServiceCode()");
        return ServiceCode;
    }

    public void setServiceCode(String serviceCode) {

        System.out.println(getClass()+":in setServiceCode()");

        ServiceCode = serviceCode;
    }
}
