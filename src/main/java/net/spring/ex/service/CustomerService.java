package net.spring.ex.service;

import java.util.List;

import net.spring.ex.model.Customer;

public interface CustomerService {
	public void addCustomer(Customer p);
	 
    public void updateCustomer(Customer p);
 
    public List<Customer> listCustomers();
 
    public Customer getCustomerById(int id);
 
    public void removeCustomer(int id);
}
