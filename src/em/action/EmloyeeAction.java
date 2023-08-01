package em.action;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import em.domain.Department;
import em.domain.Employee;
import em.domain.PageBean;
import em.service.DepartmentService;
import em.service.EmployeeService;

public class EmloyeeAction extends ActionSupport implements ModelDriven<Employee>{
	
	//object for ModelDriven
	private Employee employee = new Employee();
	
	/**
	 * implement ModelDriven
	 */
	@Override
	public Employee getModel() {
		// 
		return employee;
	}
	
	//inject service
	private EmployeeService employeeService;
	public void setEmployeeService(EmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	
	private DepartmentService departmentService;
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	/**
	 * LOGIN ACTION
	 * @return
	 */
	public String login() {
		System.out.println("login....");
		Employee currentEmployee = employeeService.login(employee);
		if(currentEmployee == null) {
			//login fail
			this.addActionError("username or password is invalid.");
			return "INPUT";
		}else {
			//login success
			ActionContext.getContext().getSession().put("currentEmployee", currentEmployee);
			return "SUCCESS";
		}
		
	}
	
	//paging
	private Integer currPage = 1;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public String findAll(){
		PageBean<Employee> pageBean = employeeService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
		return "FINDALL";
	}
	
	public String saveUI(){
		
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "SAVEUI";
		}
	public String save(){
		
		employeeService.save(employee);
//		System.out.println("action save");
		return "SAVESUCCESS";
	}
	
	public String edit(){
		employee = employeeService.findById(employee.getEid());
		List<Department> list = departmentService.findAll();
		ActionContext.getContext().getValueStack().set("list",list);
		return "EDITSUCCESS";
	}
	public String update(){
		
		employeeService.update(employee);
		return "UPDATESUCCESS";
	}
	public String delete(){
		 employee = employeeService.findById(employee.getEid());
		 employeeService.delete(employee);
		 return "DELETESUCCESS";
	}
	
	
}
