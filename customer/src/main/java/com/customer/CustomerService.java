package com.customer;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    private CustomerRepository customerRepository;
    private final RestTemplate restTemplate;

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

        // saveAndFlush will give us access to customerId
        customerRepository.saveAndFlush(customer);

        // Checking if the customer is fraudulent
        FraudCheckResponse fraudCheckResponse =restTemplate.getForObject(
                "http://FRAUD/api/v1/fraud-check/{customerId}",
                FraudCheckResponse.class,customer.getId()
        );

        if (fraudCheckResponse.isFraudster()) {
            throw  new IllegalStateException("Fraudster");
        }

    }
}
