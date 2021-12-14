package entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.ElementCollection;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;

@Entity
public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3897095622281332522L;
	@Id
	private Long id;
	private String userName;
	private String userEmail;
	private String userPassword;
	
	@ElementCollection(fetch = FetchType.EAGER)
	private Set<String> researchAreas;
	
	@ElementCollection
	private List<Comment> listOfComments;
	
	@Embedded
	private Address userAddress;

	private Gender gender;
	
	public User() {
		// TODO Auto-generated constructor stub
	}

	

	public User(Long id, String userName, String userEmail, String userPassword, Set<String> researchAreas,
			Address userAddress, Gender gender) {
		super();
		this.id = id;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPassword = userPassword;
		this.researchAreas = researchAreas;
		this.userAddress = userAddress;
		this.gender = gender;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}

	public String getUserPassword() {
		return userPassword;
	}

	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}

	public Set<String> getResearchAreas() {
		return researchAreas;
	}

	public void setResearchAreas(Set<String> researchAreas) {
		this.researchAreas = researchAreas;
	}

	public List<Comment> getListOfComments() {
		return listOfComments;
	}

	public void setListOfComments(List<Comment> listOfComments) {
		this.listOfComments = listOfComments;
	}

	
	public Address getUserAddress() {
		return userAddress;
	}



	public void setUserAddress(Address userAddress) {
		this.userAddress = userAddress;
	}



	public Gender getGender() {
		return gender;
	}



	public void setGender(Gender gender) {
		this.gender = gender;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userEmail=" + userEmail + ", userPassword="
				+ userPassword + ", researchAreas=" + researchAreas + ", listOfComments=" + listOfComments + "]";
	}
	
	
}
