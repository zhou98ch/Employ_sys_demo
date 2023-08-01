package em.dao;

import java.util.List;

import em.domain.Department;

public interface DepartmentDao {

	int findCount();

	List<Department> findByPage(int start, int pageSize);

	void save(Department department);

	Department findById(Integer did);

	void update(Department department);

	void delete(Department department);

	List<Department> findAll();




}
