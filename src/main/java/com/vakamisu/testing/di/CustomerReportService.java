package com.vakamisu.testing.di;

public class CustomerReportService {

    private CustomerAnalyseService service;

    public CustomerReportService(CustomerAnalyseService service) {
        this.service = service;
    }

    public void report() {
        System.out.println("Load time: " + service.getLoadTime());
        System.out.println("---------------------------");
        System.out.println("Customers in Service: " + service.totalCustomers() + "\n");
        printOutCustomers();
    }

    private void printOutCustomers() {
        for (Customer customer : service.getAllCustomers()) {
            System.out.println(customer);
            System.out.println("------------------------------------------------------");
        }
    }
}
