package em.dao;

import java.util.List;

import em.domain.Employee;

public interface EmployeeDao {

	Employee findByUsernameandPassword(Employee employee);

	int findCount();

	List<Employee> findByPage(int start, int pageSize);

	void save(Employee employee);

	Employee findById(Integer eid);

	void update(Employee employee);

	void delete(Employee employee);

}
