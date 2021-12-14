package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "departments")
public class Department implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3194157035841760406L;
	@Id
	private String id;
	private String location;
	private String name;
	
//	@OneToMany(mappedBy = "department")
//	private List<Employee> listEmployees;
	
	public Department() {
		super();
	}
	public Department(String id, String location, String name) {
		super();
		this.id = id;
		this.location = location;
		this.name = name;
	}
	public Department(String id) {
		super();
		this.id = id;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Department [id=" + id + ", location=" + location + ", name=" + name + "]";
	}
	
	
}
