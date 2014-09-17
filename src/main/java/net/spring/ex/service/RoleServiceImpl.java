package net.spring.ex.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import net.spring.ex.dao.RoleDAO;
import net.spring.ex.model.Role;

@Service
public class RoleServiceImpl implements RoleService {

	private RoleDAO roleDAO;
	 
	public void setRoleDAO(RoleDAO roleDAO) {
		this.roleDAO = roleDAO;
	}

	@Transactional
    public Role getRole(int id) {
        return roleDAO.getRole(id);
    }

}
