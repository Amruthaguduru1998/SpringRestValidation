package com.org.vaild.controller;

import com.org.vaild.dto.CustomerDto;
import com.org.vaild.entity.Customer;
import com.org.vaild.exception.CustomerNotFoundException;
import com.org.vaild.service.CustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping("/add")
    public Customer saveCustomer(@RequestBody @Valid CustomerDto customerDto){
       return customerService.saveCustomer(customerDto);
    }

    @GetMapping("/all")
    public List<Customer> getAll(){
        return customerService.getAllCustomers();
    }

    @GetMapping("/{customerId}")
    public Customer getCustomerById(@PathVariable int customerId) throws CustomerNotFoundException {
        return customerService.getCustomer(customerId);
    }

}
