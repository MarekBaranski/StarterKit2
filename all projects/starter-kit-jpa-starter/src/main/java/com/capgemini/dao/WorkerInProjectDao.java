package com.capgemini.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.domain.WorkerInProjectEntity;
import com.capgemini.enumerated.TypeOfFunction;

public interface WorkerInProjectDao extends Dao<WorkerInProjectEntity, Long> {

	WorkerInProjectEntity findWorkerByWorkerIdAndProjectId(Long workerId, Long projectId);

	List<WorkerInProjectEntity> findWorkersInProject(Long projectId);

	List<WorkerInProjectEntity> findWorkersInProjectLongerThanXMonth(Long projectId, int valueOfMonth);
	
	List<WorkerInProjectEntity> findWorkersInProjectRoleX(Long projectId, TypeOfFunction function);
	
	List<WorkerInProjectEntity> findWorkersInProjectInDate(Date date);

}
