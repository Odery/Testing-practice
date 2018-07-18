package com.vakamisu.testing.di;

import org.junit.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerReportServiceWithHandWrittenStubTest {

    private static final List<Customer> expectedCustomerList;

    static {
        expectedCustomerList = expectedCustomers();
    }

    private static List<Customer> exampleCustomers() {
        return Arrays.asList(
                new Customer("Oleg", "Klimchuk", "oleg_klimchuk@ex.com"),
                new Customer("Orest", "Homenko", "homenko@ex.com"),
                new Customer("Viktor", "Romchuk", "romcjuk@ex.com"),
                new Customer("Sergei", "Bondarchuk", "ser_bond@ex.com")
        );
    }

    private static List<Customer> expectedCustomers() {
        return Arrays.asList(
                new Customer("Oleg", "Klimchuk", "oleg_klimchuk@ex.com"),
                new Customer("Viktor", "Romchuk", "romcjuk@ex.com"),
                new Customer("Sergei", "Bondarchuk", "ser_bond@ex.com")
        );
    }

    @Test
    public void shouldSeparateCustomersByName() {
        //Given
        //Stub below
        CustomerService stubCustomerService = new CustomerService() {
            @Override
            public List<Customer> loadCustomers() {
                return null;
            }

            @Override
            public List<Customer> getCustomers() {
                return exampleCustomers();
            }

            @Override
            public LocalDate getLoadTime() {
                return null;
            }
        };
        CustomerAnalyseService service = new CustomerAnalyseService(stubCustomerService);

        //When
        List<Customer> customers = service.getCustomersWithNameLike("chuk");

        //Then
        assertEquals(expectedCustomerList, customers);
    }
}
