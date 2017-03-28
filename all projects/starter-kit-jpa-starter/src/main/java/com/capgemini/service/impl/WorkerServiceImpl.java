package com.capgemini.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.capgemini.dao.WorkerDao;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.service.WorkerService;

@Service
@Transactional
public class WorkerServiceImpl implements WorkerService {

	@Autowired
	private WorkerDao workerDao;

	@Override
	public WorkerEntity findOne(long id) {
		return workerDao.findOne(id);
	}

	@Override
	public List<WorkerEntity> findWorkerByNameAndSurname(String firstname, String surname) {
		return workerDao.findWorkerByNameAndSurname(firstname, surname);
	}

	@Override
	public List<WorkerEntity> findWorkerByIdDepartment(Long departmentId) {

		List<WorkerEntity> workerList = new ArrayList<WorkerEntity>();
		if (departmentId <= 4L) {

			workerList.addAll(workerDao.findWorkerByIdDepartment(departmentId));
		} else {
			throw new IllegalArgumentException("brak tego departamentu");
		}
		return workerList;
	}
	//przypisac do findworke.. i dopiero pozniej wyrzucic exception

	@Override
	public void deleteWorker(WorkerEntity worker) {
		workerDao.delete(worker);
	}

	@Override
	public WorkerEntity addWorker(WorkerEntity worker) {

		if (worker.getFirstname() == null || worker.getSurname() == null || worker.getPesel() == null
				|| worker.getDate_of_birthday() == null) {

			throw new IllegalArgumentException("niepoprawne dane");
		}
		try {
			return workerDao.save(worker);
		} catch (DataIntegrityViolationException e) {
			throw new IllegalArgumentException("unikatowy pesel daj");
		}

	}

	@Override
	public WorkerEntity updateWorker(WorkerEntity worker) {
		return workerDao.update(worker);
	}

	@Override
	public List<WorkerEntity> getWorkerList() {
		return workerDao.findAll();
	}

	@Override
	public List<WorkerEntity> findWorkerById(Long id) {
		return workerDao.findWorkerById(id);
	}

	@Override
	public List<WorkerEntity> findAll() {
		return workerDao.findAll();
	}

}
