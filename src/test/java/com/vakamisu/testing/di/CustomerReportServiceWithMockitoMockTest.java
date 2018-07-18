package com.vakamisu.testing.di;

import org.junit.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CustomerReportServiceWithMockitoMockTest {
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
        CustomerService mockCustomerService = Mockito.mock(CustomerService.class);
        Mockito.when(mockCustomerService.getCustomers()).thenReturn(expampleCustomerList);

        CustomerAnalyseService service = new CustomerAnalyseService(mockCustomerService);

        //When
        List<Customer> customers = service.getCustomersWithNameLike("chuk");

        //Then
        assertEquals(expectedCustomerList, customers);
        Mockito.verify(mockCustomerService).loadCustomers();
    }
}
