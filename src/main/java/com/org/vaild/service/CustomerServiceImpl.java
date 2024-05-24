package com.org.vaild.service;

import com.org.vaild.dto.CustomerDto;
import com.org.vaild.entity.Customer;
import com.org.vaild.exception.CustomerNotFoundException;

import java.util.List;

public interface CustomerServiceImpl {
    Customer saveCustomer(CustomerDto customerDto);

    List<Customer> getAllCustomers();

    Customer getCustomer(int customerId) throws CustomerNotFoundException;
}
