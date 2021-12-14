package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "employees")
public class Employee implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7361427619733530636L;

	@Id
	private String id;
	
	private Date dateOfBirth;
	
	@Column(nullable = false, unique = true)
	private String email;
	
	@Column(nullable = false)
	private String firstName;
	
	@Column(nullable = false)
	private String lastName;
	
	@ElementCollection(fetch = FetchType.EAGER)	
	private Set<String> phones;
	
	@Enumerated(EnumType.STRING)
	private Gender gender;

//	@OneToMany(mappedBy = "employee")
//	private List<Proposal> listProposal;

	@ManyToOne
	@JoinColumn(name = "departmentId")
	private Department department;

	public Employee(String id, Date dateOfBirth, String email, String firstName, String lastName, Set<String> phones,
			Gender gender) {
		super();
		this.id = id;
		this.dateOfBirth = dateOfBirth;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phones = phones;
		this.gender = gender;
	}

	public Employee() {
		super();
	}

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Set<String> getPhones() {
		return phones;
	}

	public void setPhones(Set<String> phones) {
		this.phones = phones;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", dateOfBirth=" + dateOfBirth + ", email=" + email + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", phones=" + phones + ", gender=" + gender + "]";
	}	
	
}
