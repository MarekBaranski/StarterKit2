package com.capgemini.service;

import java.util.List;

import com.capgemini.domain.ProjectEntity;

public interface ProjectService {

	public void deleteProject(ProjectEntity project);

	ProjectEntity addProject(ProjectEntity project);

	ProjectEntity updateProject(ProjectEntity project);

	public List<ProjectEntity> getProjectList();

	public ProjectEntity findOne(Long id);

}
