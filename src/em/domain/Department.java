package em.domain;
import java.util.Set;
import java.util.HashSet;

public class Department {
	private Integer did;
	private String dname;
	private String dintro;
	
	private Set<Employee>employees=new HashSet<Employee>();
	
	public Integer getDid() {
		return did;
	}
	public void setDid(Integer did) {
		this.did = did;
	}
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	public String getDintro() {
		return dintro;
	}
	public void setDintro(String dintro) {
		this.dintro = dintro;
	}
	public Set<Employee> getEmployees() {
		return employees;
	}
	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}
}
