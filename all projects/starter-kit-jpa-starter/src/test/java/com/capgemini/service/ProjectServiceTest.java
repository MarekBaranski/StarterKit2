package com.capgemini.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.capgemini.domain.ProjectEntity;
import com.capgemini.domain.WorkerInProjectEntity;
import com.capgemini.enumerated.TypeOfProject;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class ProjectServiceTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Autowired
	private ProjectService projectService;

	@Autowired
	EntityManager em;

	@Autowired
	private WorkerInProjectService workerInProjectService;

	@Test
	public void testShouldAddProject() {
		// given
		ProjectEntity project = new ProjectEntity();
		project.setName("opel");
		project.setType(TypeOfProject.EXTERNAL);
		// when
		List<ProjectEntity> projects = new ArrayList<ProjectEntity>();

		projectService.addProject(project);
		em.flush();
		em.clear();
		projects.addAll(projectService.getProjectList());

		// then
		assertEquals(5, projects.size());
		assertEquals("opel", projects.get(4).getName());

	}

	@Test(expected = IllegalArgumentException.class)
	public void testShouldNotAddNewProjectButNameIsNull() {
		// given
		ProjectEntity project = new ProjectEntity();

		project.setType(TypeOfProject.EXTERNAL);

		// when
		List<ProjectEntity> projects = new ArrayList<ProjectEntity>();

		projectService.addProject(project);
		em.flush();
		em.clear();
		// then
		projects.add(project);
		assertEquals(1, projects.size());

	}

	@Test
	public void testShouldDeleteProject() {
		// given
		Long id = 4L;

		ProjectEntity project = new ProjectEntity();
		project = projectService.findOne(id);
		int sizeBeforeDelete = (projectService.getProjectList().size());
		List<WorkerInProjectEntity> workerInProjectBeforeDelete = new ArrayList<WorkerInProjectEntity>();
		workerInProjectBeforeDelete.addAll(workerInProjectService.getWorkerList());
		int sizeWorkerInProjectBeforDelete = (workerInProjectService.getWorkerList().size());

		// when
		projectService.deleteProject(project);
		em.flush();
		em.clear();
		project = projectService.findOne(id);
		int sizeAfterDelete = (projectService.getProjectList().size());
		List<WorkerInProjectEntity> workerInProjectAfterDelete = new ArrayList<WorkerInProjectEntity>();
		workerInProjectAfterDelete.addAll(workerInProjectService.getWorkerList());
		int sizeWorkerInProjectAfterDelete = (workerInProjectService.getWorkerList().size());

		// then
		assertEquals(project, null);
		assertNotEquals(sizeBeforeDelete, sizeAfterDelete);
		assertNotEquals(sizeWorkerInProjectBeforDelete, sizeWorkerInProjectAfterDelete);

	}

	@Test
	public void testShouldUpdateProject() {
		// given
		Long id = 1L;
		ProjectEntity project = new ProjectEntity();
		project = projectService.findOne(id);
		String oldName = project.getName();
		project.setName("Mercedes");

		// when
		projectService.updateProject(project);
		em.flush();
		em.clear();
		WorkerInProjectEntity updateProject = new WorkerInProjectEntity();
		updateProject = workerInProjectService.findOne(id);
		String name = updateProject.getProject().getName();
		project = projectService.findOne(id);
		String newName = project.getName();
		// then

		assertNotEquals(oldName, newName);
		assertEquals("audi", oldName);
		assertEquals("Mercedes", newName);
		assertEquals("Mercedes", name);

	}

}
