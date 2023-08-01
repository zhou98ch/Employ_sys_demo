package em.dao.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import em.dao.DepartmentDao;
import em.domain.Department;

public class DepartmentDaoImpl extends HibernateDaoSupport implements DepartmentDao {

	@Override
	public int findCount() {
		String qryString = "SELECT count(*) FROM Department";
		List<Long> list = this.getHibernateTemplate().find(qryString); //!! the return type is a list
		if(list.size()>0) {
			return list.get(0).intValue();
		}
		return 0;
	}

	@Override
	public List<Department> findByPage(int start, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Department.class);
		List<Department> list = this.getHibernateTemplate().findByCriteria(criteria,start,pageSize);
//		System.out.println(list.get(0).getDname());
//		System.out.println(list.get(1).getDname());
		return list;
	}

	@Override
	public void save(Department department) {
		this.getHibernateTemplate().save(department);
		
	}

	@Override
	public Department findById(Integer did) {
		
		return this.getHibernateTemplate().get(Department.class, did);
	}

	@Override
	public void update(Department department) {
		this.getHibernateTemplate().update(department);
		
	}

	@Override
	public void delete(Department department) {
		
		this.getHibernateTemplate().delete(department);
	}

	@Override
	public List<Department> findAll() {
		return this.getHibernateTemplate().find("FROM Department");

	}

}
