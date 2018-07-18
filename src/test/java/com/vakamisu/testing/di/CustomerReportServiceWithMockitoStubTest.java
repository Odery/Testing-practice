package com.vakamisu.testing.di;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerReportServiceWithMockitoStubTest {

    private static final List<Customer> expectedCustomerList;
    private static final List<Customer> expampleCustomerList;

    static {
        expectedCustomerList = Arrays.asList(
                new Customer("Oleg", "Klimchuk", "oleg_klimchuk@ex.com"),
                new Customer("Viktor", "Romchuk", "romcjuk@ex.com"),
                new Customer("Sergei", "Bondarchuk", "ser_bond@ex.com")
        );
        expampleCustomerList = Arrays.asList(
                new Customer("Oleg", "Klimchuk", "oleg_klimchuk@ex.com"),
                new Customer("Orest", "Homenko", "homenko@ex.com"),
                new Customer("Viktor", "Romchuk", "romcjuk@ex.com"),
                new Customer("Sergei", "Bondarchuk", "ser_bond@ex.com")
        );
    }

    @Test
    public void shouldSeparateCustomersByName() {
        //Given
        //Stub below
        CustomerService stubCustomerService = Mockito.mock(CustomerService.class);
        Mockito.when(stubCustomerService.getCustomers()).thenReturn(expampleCustomerList);

        CustomerAnalyseService service = new CustomerAnalyseService(stubCustomerService);

        //When
        List<Customer> customers = service.getCustomersWithNameLike("chuk");

        //Then
        assertEquals(expectedCustomerList, customers);
    }
}
