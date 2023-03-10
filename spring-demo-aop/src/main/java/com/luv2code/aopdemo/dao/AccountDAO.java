package com.luv2code.aopdemo.dao;

import com.luv2code.aopdemo.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(Account account, boolean vipFlag){

        System.out.println(getClass()+ ": DOING DB WORK: ADDING A ACCOUNT");

    }

    public boolean doWork(){

        System.out.println(getClass()+ ": DOING DB WORK:Hey AMA MAMA CRIMINAL!");

        return true;

    }

}
