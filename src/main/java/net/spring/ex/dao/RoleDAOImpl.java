package net.spring.ex.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import net.spring.ex.model.Role;

@Repository
public class RoleDAOImpl implements RoleDAO {
	
	private SessionFactory sessionFactory;
	 
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
        return this.sessionFactory.getCurrentSession();
    }

	@Override
	public Role getRole(int id) {
		Role role = (Role) getCurrentSession().load(Role.class, id);
        return role;
	}
}
