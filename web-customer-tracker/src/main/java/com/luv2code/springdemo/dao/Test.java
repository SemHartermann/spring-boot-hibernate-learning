package com.luv2code.springdemo.dao;

public class Test {

    public static void main(String[] args) {
        CustomerDAO customer = new CustomerDAOImpl();

        System.out.println(customer.getCustomers());
    }

}
