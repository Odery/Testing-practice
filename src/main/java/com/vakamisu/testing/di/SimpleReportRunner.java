package com.vakamisu.testing.di;

public class SimpleReportRunner {

    public static void main(String[] args) {
        CustomerService service = new DbCustomerService();
        System.out.println(service.getLoadTime());

        CustomerAnalyseService customerAnalyseService = new CustomerAnalyseService(service);
        System.out.println(customerAnalyseService.getLoadTime());

        CustomerReportService reportService = new CustomerReportService(customerAnalyseService);

        reportService.report();
    }
}
