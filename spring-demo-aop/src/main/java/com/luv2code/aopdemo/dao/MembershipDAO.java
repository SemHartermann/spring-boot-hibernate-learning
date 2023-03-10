package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount(){

        System.out.println(getClass()+ ": DOING STAFF4IK: ADDING A MEMBERSHIP ACCOUNT");

    }

    public void goToSleep(){

        System.out.println(getClass()+ ": AMA GOING TO SLEEP MAMAAMA");

    }

    public void ratatouille(){

        System.out.println(getClass()+ ": DOING STAFF4IK: ADDING A ratatouille");

    }

}
