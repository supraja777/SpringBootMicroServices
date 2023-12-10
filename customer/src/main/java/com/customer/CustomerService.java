package com.customer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;


    public void registerCustomer(CustomerRegistrationRequest request) {
        // Use the builder to create a CustomerEntity instance
        CustomerEntity customer = CustomerEntity.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        // Check if email is valid
        // Check if email already exists in the database
        // Store the customer in the database

        customerRepository.save(customer);
    }
}
