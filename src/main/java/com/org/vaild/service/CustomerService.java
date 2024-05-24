package com.org.vaild.service;

import com.org.vaild.dto.CustomerDto;
import com.org.vaild.entity.Customer;
import com.org.vaild.exception.CustomerNotFoundException;
import com.org.vaild.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService implements CustomerServiceImpl {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer saveCustomer(CustomerDto customerDto){
        return customerRepository.save(CustomerDto.prepareCustomer(customerDto));
    }

    @Override
    public List<Customer> getAllCustomers(){

        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomer(int customerId) throws CustomerNotFoundException {

        Customer customer =customerRepository.findByCustomerId(customerId);

        if(customer!=null){
            return customer;
        }else {
            throw new CustomerNotFoundException("customer not fount with id" + customerId);
        }
    }
}
