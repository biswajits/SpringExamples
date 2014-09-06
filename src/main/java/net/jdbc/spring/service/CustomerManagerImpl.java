package net.jdbc.spring.service;

import org.springframework.transaction.annotation.Transactional;

import net.jdbc.spring.dao.CustomerDAO;
import net.jdbc.spring.model.Customer;

public class CustomerManagerImpl implements CustomerManager {
	
	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}
}
