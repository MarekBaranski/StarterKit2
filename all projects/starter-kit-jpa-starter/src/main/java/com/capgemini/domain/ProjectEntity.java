package com.capgemini.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.capgemini.enumerated.TypeOfProject;

@Entity
@Table(name = "project")
public class ProjectEntity extends AbstractEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(nullable = false, unique = true, length = 45)
	private String name;

	@Enumerated(EnumType.STRING)
	@Column
	private TypeOfProject type;

	@OneToMany(mappedBy = "project", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<WorkerInProjectEntity> workersInProject;

	@Transient
	private int x;
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public ProjectEntity() {

	}

	public ProjectEntity(Long id, String name, TypeOfProject type) {

		this.id = id;
		this.name = name;
		this.type = type;
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

	public TypeOfProject getType() {
		return type;
	}

	public void setType(TypeOfProject type) {
		this.type = type;
	}

}
