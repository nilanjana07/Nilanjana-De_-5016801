package com.example.BookStore.service;

import com.example.BookStore.model.Customer;
import com.example.BookStore.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public Customer updateCustomer(Long id, Customer updatedCustomer) {
        return customerRepository.findById(id)
            .map(customer -> {
                customer.setName(updatedCustomer.getName());
                customer.setEmail(updatedCustomer.getEmail());
                customer.setPhoneNumber(updatedCustomer.getPhoneNumber());
                return customerRepository.save(customer);
            })
            .orElseGet(() -> {
                updatedCustomer.setId(id);
                return customerRepository.save(updatedCustomer);
            });
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
