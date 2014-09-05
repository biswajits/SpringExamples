package net.jdbc.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import net.jdbc.spring.model.Employee;

public class EmployeeDAOJDBCTemplateImpl implements EmployeeDAO{

	private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	

	public void save(Employee employee) {
		String query = "insert into Employee (id, name, role) values (?,?,?)";
		
		
		
		Object[] args = new Object[] {employee.getId(), employee.getName(), employee.getRole()};
		
		int out = jdbcTemplate.update(query, args);
		
		if(out !=0){
			System.out.println("Employee saved with id="+employee.getId());
		}else System.out.println("Employee save failed with id="+employee.getId());
	}

	
	public Employee getById(int id) {
		String query = "select id, name, role from Employee where id = ?";
		
		//using RowMapper anonymous class, we can create a separate RowMapper for reuse
		Employee emp = jdbcTemplate.queryForObject(query, new Object[]{id}, new RowMapper<Employee>(){

			
			public Employee mapRow(ResultSet rs, int rowNum)
					throws SQLException {
				Employee emp = new Employee();
				emp.setId(rs.getInt("id"));
				emp.setName(rs.getString("name"));
				emp.setRole(rs.getString("role"));
				return emp;
			}});
		
		return emp;
	}

	public void update(Employee employee) {
		String query = "update Employee set name=?, role=? where id=?";
		Object[] args = new Object[] {employee.getName(), employee.getRole(), employee.getId()};
		
		int out = jdbcTemplate.update(query, args);
		if(out !=0){
			System.out.println("Employee updated with id="+employee.getId());
		}else System.out.println("No Employee found with id="+employee.getId());
	}

	public void deleteById(int id) {

		String query = "delete from Employee where id=?";
		
		int out = jdbcTemplate.update(query, id);
		if(out !=0){
			System.out.println("Employee deleted with id="+id);
		}else System.out.println("No Employee found with id="+id);
	}

	
	public List<Employee> getAll() {
		String query = "select id, name, role from Employee";
		List<Employee> empList = new ArrayList<Employee>();

		List<Map<String,Object>> empRows = jdbcTemplate.queryForList(query);
		
		for(Map<String,Object> empRow : empRows){
			Employee emp = new Employee();
			emp.setId(Integer.parseInt(String.valueOf(empRow.get("id"))));
			emp.setName(String.valueOf(empRow.get("name")));
			emp.setRole(String.valueOf(empRow.get("role")));
			empList.add(emp);
		}
		return empList;
	}

}
