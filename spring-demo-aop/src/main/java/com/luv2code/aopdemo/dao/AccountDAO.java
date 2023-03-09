package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    public void addAccount(){

        System.out.println(getClass()+ ": DOING DB WORK: ADDING A ACCOUNT");

    }

}
