package com.org.vaild.dto;

import com.org.vaild.entity.Customer;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {

    @NotNull(message = "customer name should not be null")
    @NotEmpty(message = "customer name should not be empty")
    private String name;
    @Email(message = "not a vaild email address")
    private String email;

    @NotNull(message = "gender should not be null")
    private String gender;

    @Min(value = 18,message = "Min age should be 18")
    @Max(value = 60,message = "max age should be 60")
    private int age;

    public static Customer prepareCustomer(CustomerDto customerDto){
        Customer customer=new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setGender(customerDto.getGender());
        customer.setAge(customerDto.getAge());
        return customer;
    }
}
