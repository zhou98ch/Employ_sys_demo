package em.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;


import em.dao.EmployeeDao;
import em.domain.Department;
import em.domain.Employee;

public class EmployeeDaoImpl extends HibernateDaoSupport implements EmployeeDao {

	@Override
	public Employee findByUsernameandPassword(Employee employee) {
		String qryString = "FROM Employee where username = ? and password = ?";
		List<Employee> elist = this.getHibernateTemplate().find(qryString,employee.getUsername(),employee.getPassword());
		if(elist.size()>0) {
			return elist.get(0);
		}
		return null;
	}

	@Override
	public int findCount() {
		String qryString = "SELECT count(*) from Employee";
		List<Long> list = this.getHibernateTemplate().find(qryString);
		if(list.size()>0) {
			return list.get(0).intValue();
			
		}
		return 0;
	}

	@Override
	public List<Employee> findByPage(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Employee.class);
		List<Employee> list = this.getHibernateTemplate().findByCriteria(criteria,start,pageSize);
		return list;
	}

	@Override
	public void save(Employee employee) {
		this.getHibernateTemplate().save(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		
		return this.getHibernateTemplate().get(Employee.class, eid);
	}

	@Override
	public void update(Employee employee) {
		this.getHibernateTemplate().update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		this.getHibernateTemplate().delete(employee);
		
	}
	
}
