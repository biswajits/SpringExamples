package net.spring.ex.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.spring.ex.model.User;

@Repository
public class UserDAOImpl implements UserDAO {
	
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

	@Override
	public User getUser(String login) {
		List<User> userList = new ArrayList<User>();
        Query query = getCurrentSession().createQuery("from User u where u.login = :login");
        query.setParameter("login", login);
        userList = query.list();
        if (userList.size() > 0)
            return userList.get(0);
        else
            return null;    
	}
}
