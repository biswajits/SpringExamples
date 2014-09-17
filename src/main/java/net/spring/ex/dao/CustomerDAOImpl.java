package net.spring.ex.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.spring.ex.model.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	

	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

	@Override
	public void addCustomer(Customer p) {
		getCurrentSession().persist(p);
	}

	@Override
	public void updateCustomer(Customer p) {
		getCurrentSession().update(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
        List<Customer> customersList = getCurrentSession().createQuery("from Customer").list();
        return customersList;
	}

	@Override
	public Customer getCustomerById(int id) {
        Customer c = (Customer) getCurrentSession().load(Customer.class, new Integer(id));
        return c;
	}

	@Override
	public void removeCustomer(int id) {
        Customer c = (Customer) getCurrentSession().load(Customer.class, new Integer(id));
        if (c != null) {
        	getCurrentSession().delete(c);
        }
	}
}
