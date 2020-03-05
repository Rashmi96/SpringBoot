package com.student.database.service;

import com.student.database.model.Customer;

import java.util.List;

public interface CustomerService {
    Customer addCustomer(Customer customer);

    List<Customer> getCustomers();

    Customer getCustomer(int customerid);

    Customer updateCustomer(int customerid, Customer customer);

    void deletecustomer(int customerid);
}
