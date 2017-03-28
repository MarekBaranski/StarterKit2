package com.capgemini.dao;

import java.util.List;

import com.capgemini.domain.WorkerEntity;

public interface WorkerDao extends Dao<WorkerEntity, Long> {

	List<WorkerEntity> findWorkerByNameAndSurname(String firstname, String surname);

	List<WorkerEntity> findWorkerByIdDepartment(Long departmentId);
	
	List<WorkerEntity> findWorkerById(Long id);
	
	



		
}
