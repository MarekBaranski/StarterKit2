package com.capgemini.dao.impl;

import java.util.List;

import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.WorkerEntity;

@Repository
public class WorkerDaoImpl extends AbstractDao<WorkerEntity, Long> implements WorkerDao {

	@Override
	public List<WorkerEntity> findWorkerByNameAndSurname(String firstname, String surname) {
		TypedQuery<WorkerEntity> query = entityManager.createQuery(
				"select worker from WorkerEntity worker where upper(worker.firstname) like concat (upper(:firstname), '%') and (worker.surname) like concat(upper(:surname), '%')",
				WorkerEntity.class);
		query.setParameter("firstname", firstname);
		query.setParameter("surname", surname);
		return query.getResultList();
	}

	@Override
	public List<WorkerEntity> findWorkerByIdDepartment(Long departmentId) {
		TypedQuery<WorkerEntity> query = entityManager.createQuery(
				"select worker from WorkerEntity worker where (worker.department.id) =:id", WorkerEntity.class);
		query.setParameter("id", departmentId);
		return query.getResultList();
	}

	@Override
	public List<WorkerEntity> findWorkerById(Long id) {
		TypedQuery<WorkerEntity> query = entityManager
				.createQuery("select worker from WorkerEntity worker where (worker.id) =:id", WorkerEntity.class);
		query.setParameter("id", id);
		return query.getResultList();
	}

}
