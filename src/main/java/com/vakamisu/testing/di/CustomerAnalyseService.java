package com.vakamisu.testing.di;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CustomerAnalyseService {
    private CustomerService service;

    public CustomerAnalyseService(CustomerService service) {
        this.service = service;
    }

    public int totalCustomers() {
        return service.getCustomers().size();
    }

    public List<Customer> getCustomersWithNameLike(String like) {
        List<Customer> byNameList = new ArrayList<>();

        if (like != null) {
            for (Customer customer : service.getCustomers()) {
                if (customer.getFirstName().contains(like) ||
                        customer.getLastName().contains(like)) {
                    byNameList.add(customer);
                }
            }
        }

        return byNameList;
    }

    public List<Customer> getAllCustomers() {
        return service.getCustomers();
    }

    public List<String> getEmails() {
        List<String> emails = new ArrayList<>();

        for (Customer customer : service.getCustomers()) {
            emails.add(customer.getEmail());
        }

        return emails;
    }

    public LocalDate getLoadTime() {
        return service.getLoadTime();
    }
}
