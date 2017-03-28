SELECT 
    worker.firstname, worker.surname, project.name
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
        JOIN
    project ON worker_in_project.project_id = project.id
        AND worker_in_project.stop_event IS NULL;

