package net.spring.ex.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.spring.ex.dao.UserDAO;
import net.spring.ex.model.User;

@Service
public class UserServiceImpl implements UserService {

	private UserDAO userDAO;
	
	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
    public User getUser(String login) {
        return userDAO.getUser(login);
    }

}
