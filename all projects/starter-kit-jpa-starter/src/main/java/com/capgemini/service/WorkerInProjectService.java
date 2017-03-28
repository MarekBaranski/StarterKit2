package com.capgemini.service;

import java.util.Date;
import java.util.List;

import com.capgemini.domain.WorkerInProjectEntity;
import com.capgemini.enumerated.TypeOfFunction;

public interface WorkerInProjectService {

	WorkerInProjectEntity addWorkerToProject(WorkerInProjectEntity workerInProject);

	public List<WorkerInProjectEntity> getWorkerList();

	List<WorkerInProjectEntity> getProjectList();

	WorkerInProjectEntity findOne(Long id);

	WorkerInProjectEntity findWorkerByWorkerIdAndProjectIdAndFillEndDate(Long workerId, Long projectId);

	List<WorkerInProjectEntity> findWorkersInProject(Long projectId);

	List<WorkerInProjectEntity> findWorkersInProjectLongerThanXMonth(Long projectId, int valueOfMonth);

	List<WorkerInProjectEntity> findWorkersInProjectRoleX(Long projectId, TypeOfFunction function);

	List<WorkerInProjectEntity> findWorkersInProjectInDate(Date date);

}
