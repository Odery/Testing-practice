package com.vakamisu.testing.di;

import java.time.LocalDate;
import java.util.List;

public interface CustomerService {

    public List<Customer> loadCustomers();

    public List<Customer> getCustomers();

    public LocalDate getLoadTime();

}
