package com.example.list_member.service;



import com.example.list_member.model.Customer;
import com.example.list_member.repository.CustomerRepo;


import java.util.List;

public class CustomerService {
    public static List<Customer> displayCustomer(){
        return CustomerRepo.display();
    }
}
