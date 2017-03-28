package com.capgemini.dao.impl;

import java.util.Date;
import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerInProjectDao;
import com.capgemini.domain.WorkerInProjectEntity;
import com.capgemini.enumerated.TypeOfFunction;

@Repository
public class WorkerInProjectDaoImpl extends AbstractDao<WorkerInProjectEntity, Long> implements WorkerInProjectDao {

	@Override
	public WorkerInProjectEntity findWorkerByWorkerIdAndProjectId(Long workerId, Long projectId) {
		TypedQuery<WorkerInProjectEntity> query = entityManager.createQuery(
				"select worker from WorkerInProjectEntity worker where (worker.id) =:workerId and (project.id) =:projectId",
				WorkerInProjectEntity.class);
		query.setParameter("workerId", workerId);
		query.setParameter("projectId", projectId);
		return query.getSingleResult();
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProject(Long projectId) {
		TypedQuery<WorkerInProjectEntity> query = entityManager.createQuery(
				"select worker from WorkerInProjectEntity worker where (project.id) =:projectId",
				WorkerInProjectEntity.class);
		query.setParameter("projectId", projectId);
		return query.getResultList();
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProjectLongerThanXMonth(Long projectId, int valueOfMonth) {
		TypedQuery<WorkerInProjectEntity> query = entityManager.createQuery(
				"select w from WorkerInProjectEntity w where (w.project.id) =:projectId and TIMESTAMPDIFF(MONTH,w.start_event,w.stop_event) >(:month)",
				WorkerInProjectEntity.class);
		query.setParameter("projectId", projectId);
		query.setParameter("month", valueOfMonth);
		return query.getResultList();
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProjectRoleX(Long projectId, TypeOfFunction function) {
		TypedQuery<WorkerInProjectEntity> query = entityManager.createQuery(
				"select w from WorkerInProjectEntity w where (w.project.id) =:projectId and (w.function) =:function and (w.start_event) between '2003-03-11' AND '2011-05-30'",
				WorkerInProjectEntity.class);
		query.setParameter("projectId", projectId);
		query.setParameter("function", function);
		return query.getResultList();
	}

	@Override
	public List<WorkerInProjectEntity> findWorkersInProjectInDate(Date date) {
		TypedQuery<WorkerInProjectEntity> query = entityManager.createQuery(
				"select w from WorkerInProjectEntity w where (w.start_event)> (:date) AND ((w.stop_event is null)or((w.stop_event)< (:date))) GROUP BY (w.project.id) HAVING COUNT(w.project.id)>3",
				WorkerInProjectEntity.class);
		query.setParameter("date", date);
		return query.getResultList();
	}

}