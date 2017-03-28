package com.capgemini.service;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.ProjectEntity;
import com.capgemini.domain.WorkerEntity;
import com.capgemini.domain.WorkerInProjectEntity;
import com.capgemini.enumerated.TypeOfFunction;
import com.capgemini.enumerated.TypeOfProject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class WorkerInProjectTest {

	@Autowired
	private WorkerInProjectService workerInProjectService;

	@Autowired
	EntityManager em;

	@SuppressWarnings("deprecation")
	@Test
	public void testShouldAddWorkerToProject() {
		// given
		WorkerEntity worker = new WorkerEntity();
		worker.setFirstname("Michalina");
		worker.setSurname("Lwowska");
		worker.setDate_of_birthday(new Date(82, 9, 10));
		worker.setPesel("82091907993");

		Date current = new Date();

		ProjectEntity project = new ProjectEntity();
		project.setName("opel");
		project.setType(TypeOfProject.EXTERNAL);

		WorkerInProjectEntity workerInProject = new WorkerInProjectEntity(current, TypeOfFunction.FCD, 135f, project,
				worker);

		WorkerInProjectEntity work = workerInProjectService.addWorkerToProject(workerInProject);

		assertNotNull(work);
		assertEquals("Michalina", work.getWorker().getFirstname());

	}

	@SuppressWarnings("deprecation")
	@Test(expected = IllegalArgumentException.class)
	public void testShouldNotAddWorkerToProjectAndThrowEsceptionButFunctionIsPl() {
		// given
		WorkerEntity worker = new WorkerEntity();
		worker.setFirstname("Michalina");
		worker.setSurname("Lwowska");
		worker.setDate_of_birthday(new Date(82, 9, 10));
		worker.setPesel("82091907993");

		Date current = new Date();

		ProjectEntity project = new ProjectEntity();
		project.setName("opel");
		project.setType(TypeOfProject.EXTERNAL);

		WorkerInProjectEntity workerInProject = new WorkerInProjectEntity(current, TypeOfFunction.PL, 135f, project,
				worker);

		WorkerInProjectEntity work = workerInProjectService.addWorkerToProject(workerInProject);

		assertNotNull(work);
		assertEquals("Michalina", work.getWorker().getFirstname());

	}

	@Test
		public void testShouldDeletedWorkerFromProjectAndFillCurrentDate() {
		// given
		WorkerInProjectEntity worker = new WorkerInProjectEntity();

		worker = workerInProjectService.findOne(7L);

		Date stop_event = worker.getStop_event();

		worker = workerInProjectService.findWorkerByWorkerIdAndProjectIdAndFillEndDate(7L, 3L);

		assertNotNull(worker);
		assertEquals(stop_event, null);
		assertNotEquals(worker.getStop_event(), null);

	}

	@Test
	public void testShouldFindWorkerFromProjectX() {
		// given
		Long projectId = 1L;
		// when
		List<WorkerInProjectEntity> workerInProjectEntity = workerInProjectService.findWorkersInProject(projectId);
		// then

		
		assertEquals(8, workerInProjectEntity.size());

	}

	@Test
	public void testShouldFindWorkerFromProjectWhichWorkingLongerThanXMonth() {
		// given
		Long projectId = 3L;
		int valueOfMonth = 3;
		// when
		List<WorkerInProjectEntity> workerInProjectEntity = workerInProjectService
				.findWorkersInProjectLongerThanXMonth(projectId, valueOfMonth);
		// then

		
		assertEquals(2, workerInProjectEntity.size());

	}

	@Test
	public void testShouldFindWorkerFromProjectBetweenDate() {
		// given
		Long projectId = 4L;
		TypeOfFunction function = TypeOfFunction.DEV;
		// when
		List<WorkerInProjectEntity> workerInProjectEntity = workerInProjectService.findWorkersInProjectRoleX(projectId,
				function);
		// then

		assertEquals(workerInProjectEntity.size(), 2);

		for (int i = 0; i < workerInProjectEntity.size(); i++) {

			if (workerInProjectEntity.get(i).getWorker().getId() == 23
					|| workerInProjectEntity.get(i).getWorker().getId() == 28) {

				workerInProjectEntity.remove(i);
				i--;
			}

		}
		assertTrue(workerInProjectEntity.isEmpty());
	}

	@Test
	public void testShouldfindWorkersInProjectInDate() throws ParseException {
		// given
		String dateString = "2008-08-13";
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		Date date = new Date();

		date = format.parse(dateString);

		// when
		List<WorkerInProjectEntity> workerInProjectEntity = workerInProjectService.findWorkersInProjectInDate(date);
		// then

		assertFalse(workerInProjectEntity.isEmpty());
		assertEquals(2, workerInProjectEntity.size());
		assertEquals("audi", workerInProjectEntity.get(0).getProject().getName());
		assertEquals("my_page", workerInProjectEntity.get(1).getProject().getName());
	}

}
