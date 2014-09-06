package net.jdbc.spring.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;

import net.jdbc.spring.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource  dataSource;
	
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public void create(Customer customer) {
		 String queryCustomer = "insert into Customer (id, name) values (?,?)";
	        String queryAddress = "insert into Address (id, address,country) values (?,?,?)";
	 
	        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
	 
	        jdbcTemplate.update(queryCustomer, new Object[] { customer.getId(),
	                customer.getName() });
	        System.out.println("Inserted into Customer Table Successfully");
	        jdbcTemplate.update(queryAddress, new Object[] { customer.getId(),
	                customer.getAddress().getAddress(),
	                customer.getAddress().getCountry() });
	        System.out.println("Inserted into Address Table Successfully");

	}

}
