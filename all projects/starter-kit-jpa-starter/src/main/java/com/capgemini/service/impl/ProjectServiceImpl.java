package com.capgemini.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.dao.ProjectDao;
import com.capgemini.domain.ProjectEntity;
import com.capgemini.service.ProjectService;

@Service
@Transactional
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectDao projectDao;

	@Override
	public void deleteProject(ProjectEntity project) {
		projectDao.delete(project);

	}

	@Override
	public ProjectEntity addProject(ProjectEntity project) {

		if (project.getName() != null) {

			projectDao.save(project);
		} else

		{
			throw new IllegalArgumentException("brak nazwy projektu");
		}
		return project;
	}

	@Override
	public ProjectEntity updateProject(ProjectEntity project) {
		return projectDao.update(project);
	}

	@Override
	public List<ProjectEntity> getProjectList() {
		return projectDao.findAll();
	}

	@Override
	public ProjectEntity findOne(Long id) {
		return projectDao.findOne(id);
	}

}
