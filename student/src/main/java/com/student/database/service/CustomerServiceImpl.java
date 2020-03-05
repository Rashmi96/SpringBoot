package com.student.database.service;

import com.student.database.model.Customer;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class CustomerServiceImpl implements CustomerService {
    private int customerid = 1;
    private List<Customer> customerList = new CopyOnWriteArrayList<>();

    @Override
    public Customer addCustomer(Customer customer)
    {
        customer.setCustomerid(customerid);
        customerList.add(customer);
        customerid++;
        return customer;
    }

    @Override
    public List<Customer> getCustomers()
    {
        return customerList;
    }

    @Override
    public Customer getCustomer(int customerid)
    {
        return customerList
                .stream()
                .filter(c -> c.getCustomerid() == customerid)
                .findFirst()
                .get();
    }

    @Override
    public Customer updateCustomer(int customerid, Customer customer)
    {
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerid() == customerid){
                        c.setFname(customer.getFname());
                        c.setLname(customer.getLname());
                        c.setEmail(customer.getEmail());
                    }
                });
        return customerList
                .stream()
                .filter(c -> c.getCustomerid() == customerid)
                .findFirst()
                .get();
    }

    @Override
    public void deletecustomer(int customerid)
    {
        customerList
                .stream()
                .forEach(c -> {
                    if(c.getCustomerid() == customerid){
                        customerList.remove(c);
                    }
                });
    }
}
