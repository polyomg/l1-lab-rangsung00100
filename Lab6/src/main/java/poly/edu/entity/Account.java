package poly.edu.entity;

import java.util.List;
import java.util.Set;

import org.hibernate.annotations.Nationalized;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Account")
public class Account {

	private String username;
	private String password;
	private String fullname;
	private String email;
	private String photo;
	private Boolean activated;
	private Boolean admin;
	private List<Order> orderses;

	public Account() {
	}

	public Account(String username) {
		this.username = username;
	}

	public Account(String username, String password, String fullname, String email, String photo, Boolean activated,
			Boolean admin, List<Order> orderses) {
		this.username = username;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.photo = photo;
		this.activated = activated;
		this.admin = admin;
		this.orderses = orderses;
	}

	@Id

	@Column(name = "Username", unique = true, nullable = false)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "Password")
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "Fullname")
	@Nationalized
	public String getFullname() {
		return this.fullname;
	}

	public void setFullname(String fullname) {
		this.fullname = fullname;
	}

	@Column(name = "Email")
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Photo")
	public String getPhoto() {
		return this.photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	@Column(name = "Activated")
	public Boolean getActivated() {
		return this.activated;
	}

	public void setActivated(Boolean activated) {
		this.activated = activated;
	}

	@Column(name = "Admin")
	public Boolean getAdmin() {
		return this.admin;
	}

	public void setAdmin(Boolean admin) {
		this.admin = admin;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "account")
	public List<Order> getOrderses() {
		return this.orderses;
	}

	public void setOrderses(List<Order> orderses) {
		this.orderses = orderses;
	}

}
