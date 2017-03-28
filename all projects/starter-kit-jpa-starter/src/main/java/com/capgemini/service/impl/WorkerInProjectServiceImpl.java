package com.capgemini.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.WorkerInProjectDao;
import com.capgemini.domain.WorkerInProjectEntity;
import com.capgemini.enumerated.TypeOfFunction;
import com.capgemini.service.WorkerInProjectService;

@Service
@Transactional
public class WorkerInProjectServiceImpl implements WorkerInProjectService {

	@Autowired
	private WorkerInProjectDao workerInProjectDao;

	@Override
	public WorkerInProjectEntity addWorkerToProject(WorkerInProjectEntity workerInProject) {

		if (workerInProject.getFunction() == TypeOfFunction.PL) {
			throw new IllegalArgumentException("nie masz uprawnien do przypisania osoby z ta funckja do projektu");
		} else {

			return workerInProjectDao.save(workerInProject);
		}

	}

	@Override
	public List<WorkerInProjectEntity> getWorkerList() {
		return workerInProjectDao.findAll();
	}

	@Override
	public List<WorkerInProjectEntity> getProjectList() {
		return workerInProjectDao.findAll();
	}

	@Override
	public WorkerInProjectEntity findOne(Long id) {
		return workerInProjectDao.findOne(id);
	}

	@Override
	public WorkerInProjectEntity findWorkerByWorkerIdAndProjectIdAndFillEndDate(Long workerId, Long projectId) {

		WorkerInProjectEntity workerInProjectEntity = workerInProjectDao.findWorkerByWorkerIdAndProjectId(workerId,
				projectId);
		Date current = new Date();
		workerInProjectEntity.setStop_event(current);
		return workerInProjectEntity;
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProject(Long projectId) {
		return workerInProjectDao.findWorkersInProject(projectId);
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProjectLongerThanXMonth(Long projectId, int valueOfMonth) {
		return workerInProjectDao.findWorkersInProjectLongerThanXMonth(projectId, valueOfMonth);
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProjectRoleX(Long projectId, TypeOfFunction function) {
		return workerInProjectDao.findWorkersInProjectRoleX(projectId, function);
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProjectInDate(Date date) {
		return workerInProjectDao.findWorkersInProjectInDate(date);
	}

}
