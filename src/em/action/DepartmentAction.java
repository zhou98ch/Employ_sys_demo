package em.action;

import em.domain.Department;
import em.domain.PageBean;
import em.service.DepartmentService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
 
@SuppressWarnings("serial")
public class DepartmentAction extends ActionSupport implements ModelDriven<Department>{
	private Department department = new Department();
	@Override
	public Department getModel() {
		return department;
	}
	
	private int currPage=1;
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	
	public String findAll(){
		System.out.println("action find page"+currPage);
		PageBean<Department> pageBean = departmentService.findByPage(currPage);
		ActionContext.getContext().getValueStack().push(pageBean);
//		System.out.println(pageBean.getList().get(0).getDname());
//		System.out.println(pageBean.getList().get(1).getDname());
		return "FINDALL";
		
		
	}
	
	
	//inject departmentservice
	private DepartmentService departmentService;
	//!!! don't need getter 
//	public DepartmentService getDepartmentService() {
//		return departmentService;
//	}
	public void setDepartmentService(DepartmentService departmentService) {
		this.departmentService = departmentService;
	}
	
	
	//jump to the page of adding
	public String saveUI(){
		return "SAVEUI";
	}
	
	//add new department
	public String save(){
//		System.out.println("!!!!!!action.save ");
		departmentService.save(department);
		return "SAVESUCCESS";
	}

	//edit department
	public String edit(){
		department = departmentService.findById(department.getDid());
		System.out.println("actionedit");
		return "EDITSUCCESS";
	}
	//update department
	public String update(){
		departmentService.update(department);
		return "UPDATESUCCESS";
	}
	//delete
	public String delete(){
		department = departmentService.findById(department.getDid());
		departmentService.delete(department); //cascade delete
		return "DELETESUCCESS";
	}
	
	

}
