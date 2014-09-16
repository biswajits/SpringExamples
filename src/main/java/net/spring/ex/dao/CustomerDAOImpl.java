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
	 
    public void setSessionFactory(SessionFactory sf) {
        this.sessionFactory = sf;
    }

	@Override
	public void addCustomer(Customer p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(p);
	}

	@Override
	public void updateCustomer(Customer p) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(p);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Customer> listCustomers() {
		Session session = this.sessionFactory.getCurrentSession();
        List<Customer> customersList = session.createQuery("from Customer").list();
        return customersList;
	}

	@Override
	public Customer getCustomerById(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Customer c = (Customer) session.load(Customer.class, new Integer(id));
        return c;
	}

	@Override
	public void removeCustomer(int id) {
		Session session = this.sessionFactory.getCurrentSession();
        Customer c = (Customer) session.load(Customer.class, new Integer(id));
        if (c != null) {
            session.delete(c);
        }
	}
}
