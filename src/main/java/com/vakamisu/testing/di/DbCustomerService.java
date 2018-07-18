package com.vakamisu.testing.di;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class DbCustomerService implements CustomerService {
    private final String url = "jdbc:mysql://localhost/spring_web_app?serverTimezone=UTC";
    private final String user = "root";
    private final String pass = "root";

    private Connection con;
    private Statement stm;

    private List<Customer> customers;
    private LocalDate loadTime;

    public DbCustomerService() {
        getConnection();
        loadCustomers();
    }

    @Override
    public List<Customer> loadCustomers() {
        loadTime = getDate();
        customers = new ArrayList<>();

        try {
            ResultSet rs = stm.executeQuery("SELECT * FROM customer");
            while (rs.next()) {
                String firsName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                String email = rs.getString("email");

                customers.add(new Customer(firsName, lastName, email));
            }
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
        return customers;
    }

    private LocalDate getDate() {
        return LocalDate.now();
    }

    private void getConnection() {
        try {
            con = DriverManager.getConnection(url, user, pass);
            stm = con.createStatement();
        } catch (SQLException exc) {
            exc.printStackTrace();
        }
    }

    @Override
    public LocalDate getLoadTime() {
        return loadTime;
    }

    @Override
    public List<Customer> getCustomers() {
        if (customers == null) {
            loadCustomers();
        }
        return customers;
    }
}
