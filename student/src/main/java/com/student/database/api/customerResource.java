package com.student.database.api;

import com.student.database.model.Customer;
import com.student.database.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
public class customerResource {

    @Autowired
    private CustomerServiceImpl customerService;

    @PostMapping
    public Customer addCustomer(@RequestBody Customer customer){
        return customerService.addCustomer(customer);
    }

    @GetMapping
    public List<Customer> getCustomers()
    {
        return customerService.getCustomers();
    }

    @GetMapping(value = "/{customerid}")
    public Customer getCustomer(@PathVariable("customerid") int customerid){
        return customerService.getCustomer(customerid);
    }

    @PutMapping(value = "/{customerid}")
    public Customer updateCustomer(@PathVariable("customerid") int customerid,@RequestBody Customer customer){
        return customerService.updateCustomer(customerid,customer);
    }

    @DeleteMapping(value = "/{customerid}")
    public void deletecustomer(@PathVariable("customerid") int customerid){
        customerService.deletecustomer(customerid);
    }
}
