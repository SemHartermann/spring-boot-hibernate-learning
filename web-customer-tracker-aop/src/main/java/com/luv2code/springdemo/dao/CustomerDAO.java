package com.luv2code.springdemo.dao;

import com.luv2code.springdemo.entity.Customer;

import java.util.List;

public interface CustomerDAO {

    public List<Customer> getCustomers();
    public List<Customer> getCustomers(int theSortField);

    public void saveCustomer(Customer customer);

    public Customer getCustomerById(int id);

    public void deleteCustomerById(int id);

    public List<Customer> searchCustomers(String theSearchName);
}
