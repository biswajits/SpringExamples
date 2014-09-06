package net.jdbc.spring.main;

import net.jdbc.spring.model.Address;
import net.jdbc.spring.model.Customer;
import net.jdbc.spring.service.CustomerManager;
import net.jdbc.spring.service.CustomerManagerImpl;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TranscationManagerMain {
	
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring-config.xml");
 
        CustomerManager customerManager = ctx.getBean("customerManager",
                CustomerManagerImpl.class);
 
        Customer cust = createDummyCustomer();
        customerManager.createCustomer(cust);
 
        ctx.close();
    }
 
    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
    }
}
