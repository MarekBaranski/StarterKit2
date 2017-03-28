package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "worker")
public class WorkerEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = false, length = 45)
	private String firstname;
	@Column(nullable = false, unique = false, length = 45)
	private String surname;
	@Column(nullable = false, unique = true, length = 11)
	private String pesel;
	@Column(nullable = false, unique = false, length = 11)
	private Date date_of_birthday;
	@Column(nullable = true, unique = false, length = 45)
	private String email;
	@Column(nullable = true, unique = false, length = 45)
	private String phone;
	@Column(nullable = true, unique = false, length = 45)
	private String mobile;

	@ManyToOne
	private DepartmentEntity department;

	@OneToMany(mappedBy = "worker", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WorkerInProjectEntity> workersInProject;

	public WorkerEntity() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getPesel() {
		return pesel;
	}

	public void setPesel(String pesel) {
		this.pesel = pesel;
	}

	public String getEmail() {
		return email;
	}

	public Date getDate_of_birthday() {
		return date_of_birthday;
	}

	public void setDate_of_birthday(Date date_of_birthday) {
		this.date_of_birthday = date_of_birthday;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public DepartmentEntity getDepartment() {
		return department;
	}

	public void setDepartment(DepartmentEntity department) {
		this.department = department;
	}

	public List<WorkerInProjectEntity> getWorkersInProject() {
		return workersInProject;
	}

	public void setWorkersInProject(List<WorkerInProjectEntity> workersInProject) {
		this.workersInProject = workersInProject;
	}

}
