package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.WorkerEntity;

public interface WorkerService {

	List<WorkerEntity> findWorkerByNameAndSurname(String firstname, String surname);

	List<WorkerEntity> findWorkerByIdDepartment(Long departmentId);

	List<WorkerEntity> findWorkerById(Long id);

	public void deleteWorker(WorkerEntity worker);

	WorkerEntity addWorker(WorkerEntity worker);

	WorkerEntity updateWorker(WorkerEntity worker);

	public List<WorkerEntity> getWorkerList();

	WorkerEntity findOne(long id);

	List<WorkerEntity> findAll();

}
