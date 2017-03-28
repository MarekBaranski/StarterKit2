package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class DepartmentEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = true, length = 45)
	private String name;
	@Column(nullable = false, unique = true, length = 45)
	private String email;
	@Column(nullable = false, unique = true, length = 45)
	private String phone;
	@Column(nullable = false, unique = true, length = 45)
	private String mobile;

	@OneToMany(mappedBy = "department", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WorkerEntity> workers;

	public DepartmentEntity() {

	}

	public DepartmentEntity(Long id, String name, String email, String phone, String mobile) {

		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.mobile = mobile;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
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

}
