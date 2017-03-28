package com.capgemini.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capgemini.enumerated.TypeOfFunction;

@Entity
@Table(name = "worker_in_project")
public class WorkerInProjectEntity extends AbstractEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(nullable = false, unique = false, columnDefinition = "DATE", length = 11)
	private Date start_event;
	@Column(nullable = true, unique = false, columnDefinition = "DATE", length = 11)
	private Date stop_event;
	@Enumerated(EnumType.STRING)
	@Column
	private TypeOfFunction function;
	@Column(nullable = false, unique = false, length = 6)
	private Float daily_salary;

	@ManyToOne
	private ProjectEntity project;

	@ManyToOne
	private WorkerEntity worker;

	public WorkerInProjectEntity() {

	}

	public WorkerInProjectEntity(Long id, Date start_event, Date stop_event, TypeOfFunction function,
			Float daily_salary) {

		this.id = id;
		this.start_event = start_event;
		this.stop_event = stop_event;
		this.function = function;
		this.daily_salary = daily_salary;
	}

	public WorkerInProjectEntity(Date start_event, TypeOfFunction function, Float daily_salary, ProjectEntity project,
			WorkerEntity worker) {
		super();
		this.start_event = start_event;
		this.function = function;
		this.daily_salary = daily_salary;
		this.project = project;
		this.worker = worker;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getStart_event() {
		return start_event;
	}

	public void setStart_event(Date start_event) {
		this.start_event = start_event;
	}

	public Date getStop_event() {
		return stop_event;
	}

	public void setStop_event(Date stop_event) {
		this.stop_event = stop_event;
	}

	public TypeOfFunction getFunction() {
		return function;
	}

	public void setFunction(TypeOfFunction function) {
		this.function = function;
	}

	public Float getDaily_salary() {
		return daily_salary;
	}

	public void setDaily_salary(Float daily_salary) {
		this.daily_salary = daily_salary;
	}

	public ProjectEntity getProject() {
		return project;
	}

	public void setProject(ProjectEntity project) {
		this.project = project;
	}

	public WorkerEntity getWorker() {
		return worker;
	}

	public void setWorker(WorkerEntity worker) {
		this.worker = worker;
	}

}
