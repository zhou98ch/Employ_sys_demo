package em.service.impl;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;


import em.dao.EmployeeDao;
import em.domain.Employee;
import em.domain.PageBean;
import em.service.EmployeeService;

@Transactional
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDao employeeDao;

	public void setEmployeeDao(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public Employee login(Employee employee) {
		Employee currentEmployee = employeeDao.findByUsernameandPassword(employee);
		return currentEmployee;
	}

	@Override
	public PageBean<Employee> findByPage(Integer currPage) {
		PageBean<Employee> pageBean = new PageBean<Employee>();
		
		pageBean.setCurrPage(currPage);
		
		int pageSize = 3;
		pageBean.setPageSize(pageSize); 
		
		int totalCount = employeeDao.findCount();
		pageBean.setTotalCount(totalCount);
		
		double tc = totalCount;
		Double n = Math.ceil(tc/pageSize);//int pageCount = (totalCount%pageSize)==0?(totalCount/pageSize):(totalCount/pageSize)+1;
		pageBean.setTotalPage(n.intValue());
		
		int start = (currPage-1)*pageSize;
		List<Employee> list = employeeDao.findByPage(start,pageSize);
		pageBean.setList(list);
		
//		ActionContext.getContext().put("list", list); 
		return pageBean; 
		
	}

	@Override
	public void save(Employee employee) {
		employeeDao.save(employee);
		
	}

	@Override
	public Employee findById(Integer eid) {
		return employeeDao.findById(eid);
		
	}

	@Override
	public void update(Employee employee) {
		employeeDao.update(employee);
		
	}

	@Override
	public void delete(Employee employee) {
		employeeDao.delete(employee);
		
	}
}
