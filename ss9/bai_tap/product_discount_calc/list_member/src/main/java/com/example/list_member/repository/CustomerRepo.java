package com.example.list_member.repository;

import com.example.list_member.model.Customer;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CustomerRepo {
    private static final List<Customer> list = new ArrayList<>(Arrays.asList(new Customer("Trần Kiệt", LocalDate.parse("2003-03-21"), "Huế", "https://i.imgur.com/7TWXFm0.jpg"),
            new Customer("Trần Gia Kiệt", LocalDate.parse("2003-03-21"), "Đà Nẵng", "https://i.imgur.com/7TWXFm0.jpg"),
            new Customer("Trần Gia Kiệt", LocalDate.parse("2003-03-21"), "Mỹ", "https://i.imgur.com/7TWXFm0.jpg"),
            new Customer("Trần Gia Kiệt", LocalDate.parse("2003-03-21"), "Đình", "https://i.imgur.com/7TWXFm0.jpg"),
            new Customer("Trần Gia Kiệt", LocalDate.parse("2003-03-21"), "Hải Phòng", "https://i.imgur.com/7TWXFm0.jpg")));
    public static List<Customer> display(){
        return list;

    }
}
