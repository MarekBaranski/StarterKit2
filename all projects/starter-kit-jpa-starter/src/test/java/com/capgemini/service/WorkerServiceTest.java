package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.ObjectOptimisticLockingFailureException;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.DepartmentEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.WorkerInProjectEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WorkerServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private WorkerService workerService;

	@Autowired
	private WorkerInProjectService workerInProjectService;

	@Autowired
	EntityManager em;

	@Test
	public void testShouldFindWorkerByIdDepartment() {
		// given
		Long departmentId = 1L;
		// when
		List<WorkerEntity> workerEntity = workerService.findWorkerByIdDepartment(departmentId);
		// then

		assertFalse(workerEntity.isEmpty());
		assertEquals("Barański", workerEntity.get(0).getSurname());
	}

	@Test
	public void testShouldFindWorkerById() {
		// given

		Long id = 1L;

		// when
		List<WorkerEntity> workerEntity = workerService.findWorkerById(id);
		// then
		assertNotNull(workerEntity);
		assertFalse(workerEntity.isEmpty());
		assertEquals("Barański", workerEntity.get(0).getSurname());
	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldThrowExceptionWhenDepartmentIdIsNull() {
		// given
		Long departmentId = 5L;
		// when
		List<WorkerEntity> workerEntity = workerService.findWorkerByIdDepartment(departmentId);
		// then
		
	}

	@Test
	public void testForException() throws Exception {
		// given
		Long departmentId = 5L;
		// when
		thrown.expect(IllegalArgumentException.class);
		thrown.expectMessage("brak tego departamentu");
		@SuppressWarnings("unused")
		List<WorkerEntity> workerEntity = workerService.findWorkerByIdDepartment(departmentId);
		// then
		fail("This method should throw SomeException");

	}

	@Test
	public void testShouldFindWorkerByNameAndSurname() {
		// given

		String firstname = "Avery";
		String surname = "Idczak";
		// when
		List<WorkerEntity> workerEntity = workerService.findWorkerByNameAndSurname(firstname, surname);
		// then
		assertNotNull(workerEntity);
		assertFalse(workerEntity.isEmpty());
		assertEquals("Idczak", workerEntity.get(0).getSurname());
	}

	@Test
	public void testShouldNotFindWorkerByNameAndSurname() {
		// given

		String firstname = "Marek";
		String surname = "Nowak";
		// when
		List<WorkerEntity> workerEntity = workerService.findWorkerByNameAndSurname(firstname, surname);
		// then
		assertTrue(workerEntity.isEmpty());

	}

	@SuppressWarnings("deprecation")
	@Test
	public void testShouldAddNewWorker() {
		// given
		WorkerEntity worker = new WorkerEntity();
		worker.setFirstname("Michalina");
		worker.setSurname("Lwowska");
		worker.setDate_of_birthday(new Date(82, 9, 10));
		worker.setPesel("82091907993");
		// when
		List<WorkerEntity> workers = new ArrayList<WorkerEntity>();

		workerService.addWorker(worker);
		em.flush();
		em.clear();
		workers.addAll(workerService.findWorkerByNameAndSurname(worker.getFirstname(), worker.getSurname()));

		// then
		assertEquals(1, workers.size());
		assertEquals(worker.getSurname(), workers.get(0).getSurname());

	}

	@SuppressWarnings("deprecation")
	@Test(expected = IllegalArgumentException.class)
	public void testShouldNotAddNewWorkerButNameIsNull() {
		// given
		WorkerEntity worker = new WorkerEntity();

		worker.setSurname("Lwowska");
		worker.setDate_of_birthday(new Date(82, 9, 10));
		worker.setPesel("82091907993");
		// when
		List<WorkerEntity> workers = new ArrayList<WorkerEntity>();

		workerService.addWorker(worker);
		em.flush();
		em.clear();

		// then
		workers.addAll(workerService.findWorkerByNameAndSurname(worker.getFirstname(), worker.getSurname()));
		assertEquals(1, workers.size());
		assertEquals(worker.getSurname(), workers.get(0).getSurname());

	}

	@SuppressWarnings("deprecation")
	@Test(expected = IllegalArgumentException.class)
	public void testShouldNotAddNewWorkerButPeselIsUse() {
		// given
		WorkerEntity worker = new WorkerEntity();
		List<WorkerEntity> workersBeforeAdd = new ArrayList<WorkerEntity>();
		workersBeforeAdd.addAll(workerService.findAll());

		worker.setFirstname("Renata");
		worker.setSurname("Lwowska");
		worker.setDate_of_birthday(new Date(82, 9, 18));
		worker.setPesel("59012863653");
		// when
		List<WorkerEntity> workers = new ArrayList<WorkerEntity>();

		workerService.addWorker(worker);
		em.flush();
		em.clear();

		// then
		workers.addAll(workerService.findWorkerByNameAndSurname(worker.getFirstname(), worker.getSurname()));
		assertEquals(1, workers.size());
		assertEquals(worker.getSurname(), workers.get(0).getSurname());

	}

	@Test
	public void testShouldDeleteWorker() {
		// given
		Long id = 4L;

		WorkerEntity worker = new WorkerEntity();
		worker = workerService.findOne(id);
		int sizeBeforeDelete = (workerService.getWorkerList().size());
		// when
		workerService.deleteWorker(worker);
		em.flush();
		em.clear();
		worker = workerService.findOne(id);
		int sizeAfterDelete = (workerService.getWorkerList().size());

		// then
		assertEquals(worker, null);
		assertNotEquals(sizeBeforeDelete, sizeAfterDelete);

	}

	@Test
	public void testShouldDeleteWorkerFromAll() {
		// given
		Long id = 6L;
		WorkerEntity worker = new WorkerEntity();
		worker = workerService.findOne(id);
		List<WorkerInProjectEntity> workerInProjectBeforeDelete = new ArrayList<WorkerInProjectEntity>();
		workerInProjectBeforeDelete.addAll(workerInProjectService.getWorkerList());
		int sizeWorkerInProjectBeforDelete = (workerInProjectService.getWorkerList().size());

		// when
		workerService.deleteWorker(worker);
		em.flush();
		em.clear();
		List<WorkerInProjectEntity> workerInProjectAfterDelete = new ArrayList<WorkerInProjectEntity>();
		workerInProjectAfterDelete.addAll(workerInProjectService.getWorkerList());
		int sizeWorkerInProjectAfterDelete = (workerInProjectService.getWorkerList().size());

		// then
		assertNotEquals(sizeWorkerInProjectBeforDelete, sizeWorkerInProjectAfterDelete);
		assertEquals(workerInProjectBeforeDelete.get(5).getWorker().getSurname(), "Wołowiec");
		assertNotEquals(workerInProjectAfterDelete.get(5).getWorker().getSurname(), "Wołowiec");
	}

	@Test
	public void testShouldUpdateDateOfWorker() {
		// given
		Long id = 1L;
		WorkerEntity worker = new WorkerEntity();
		worker = workerService.findOne(id);
		String oldName = worker.getFirstname();
		worker.setFirstname("Zuzia");

		// when
		workerService.updateWorker(worker);
		em.flush();
		em.clear();
		WorkerEntity updateWorker = new WorkerEntity();
		updateWorker = workerService.findOne(id);
		String newName = updateWorker.getFirstname();
		// then

		assertNotEquals(oldName, newName);
	}

	@Test
	public void testShouldUpdateDateOfWorkerInAll() {
		// given
		Long id = 1L;
		WorkerEntity worker = new WorkerEntity();
		worker = workerService.findOne(id);
		String oldName = worker.getFirstname();
		worker.setFirstname("Zuzia");

		// when
		workerService.updateWorker(worker);
		em.flush();
		em.clear();
		WorkerInProjectEntity updateWorker = new WorkerInProjectEntity();
		updateWorker = workerInProjectService.findOne(id);
		String newName = updateWorker.getWorker().getFirstname();
		// then

		assertNotEquals(oldName, newName);
		assertEquals("Jina", oldName);
		assertEquals("Zuzia", worker.getFirstname());
		assertEquals("Zuzia", updateWorker.getWorker().getFirstname());
	}

	@Test
	public void testShouldChangeVersion() {
		// given
		Long id = 1L;
		WorkerEntity worker = new WorkerEntity();
		worker = workerService.findOne(id);
		worker.setFirstname("Zuzia");
		long versionBeforeUpdate = worker.getVersion();

		// when
		workerService.updateWorker(worker);
		em.flush();
		em.clear();

		long versionAfterUpdate = worker.getVersion();
		// then

		assertTrue(versionBeforeUpdate == 0);
		assertTrue(versionAfterUpdate == 1);

	}

	@Test(expected = ObjectOptimisticLockingFailureException.class)
	public void testShouldOptimisticLocking() {
		// given
		Long id = 1L;
		WorkerEntity worker = new WorkerEntity();
		WorkerEntity worker2 = new WorkerEntity();
		worker = workerService.findOne(id);
		em.detach(worker);
		worker2 = workerService.findOne(id);

		worker2.setFirstname("Zuzia");

		// when
		workerService.updateWorker(worker2);
		em.flush();

		// then
		workerService.updateWorker(worker);
	}

	@Test
	public void testShouldAddWorkerToDepartment() {
		// given
		Long id = 4L;

		WorkerEntity worker = new WorkerEntity();
		worker = workerService.findOne(id);
		Long oldIdDepartment = worker.getDepartment().getId();
		DepartmentEntity department = new DepartmentEntity(null, "finance", "finance@baza.pl", "711001010",
				"+48100101010");

		// when

		worker.setDepartment(department);
		workerService.updateWorker(worker);

		WorkerEntity updateWorker = new WorkerEntity();
		updateWorker = workerService.findOne(id);
		Long newIdDepartment = updateWorker.getDepartment().getId();
		// then

		assertNotEquals(oldIdDepartment, newIdDepartment);

	}

}
