package em.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import em.dao.DepartmentDao;
import em.domain.Department;
import em.domain.PageBean;
import em.service.DepartmentService;

@Transactional
public class DepartmentServiceImpl implements DepartmentService {
	private DepartmentDao departmentDao;

	public void setDepartmentDao(DepartmentDao departmentDao) {
		this.departmentDao = departmentDao;
	}

	//paging search
	@Override
	public PageBean<Department> findByPage(Integer currentPage) {
		System.out.println("service find page"+currentPage);
		PageBean<Department> pageBean = new PageBean<Department>();
		
		pageBean.setCurrPage(currentPage);
		
		int pageSize = 2;
		pageBean.setPageSize(pageSize);
		
		int totalCount = departmentDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		double tcnt = totalCount;
		Double tpg = Math.ceil(tcnt/pageSize);
		pageBean.setTotalPage(tpg.intValue());
		
		int start = (currentPage-1)*pageSize;
		List<Department> list = departmentDao.findByPage(start,pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	//save new department
	@Override
	public void save(Department department) {
		departmentDao.save(department);
		
	}

	@Override
	public Department findById(Integer did) {
		
		return departmentDao.findById(did);
	}

	@Override
	public void update(Department department) {
		departmentDao.update(department);
		
	}

	@Override
	public void delete(Department department) {
		departmentDao.delete(department);
		
	}

	@Override
	public List<Department> findAll() {
		return departmentDao.findAll();
		
	}
}
