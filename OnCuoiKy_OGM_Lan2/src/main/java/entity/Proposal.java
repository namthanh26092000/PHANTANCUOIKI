package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "proposals")
public class Proposal implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5386543250056006180L;
	@Id
	private String id;
	private Date date;
	
	@Column(columnDefinition = "text")
	private String pcontent;
	
	@Column(nullable = false)
	private String title;
	

	@ManyToOne
	@JoinColumn(name = "employeeId")
	private Employee employee;


	public Proposal() {
		super();
	}


	public Proposal(String id, Date date, String pcontent, String title) {
		super();
		this.id = id;
		this.date = date;
		this.pcontent = pcontent;
		this.title = title;
	}
	
	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public String getPcontent() {
		return pcontent;
	}


	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Employee getEmployee() {
		return employee;
	}


	public void setEmployee(Employee employee) {
		this.employee = employee;
	}


	@Override
	public String toString() {
		return "Proposal [id=" + id + ", date=" + date + ", pcontent=" + pcontent + ", title=" + title + "]";
	}
	
	
	
	
	
}



