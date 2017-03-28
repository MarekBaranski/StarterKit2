set global sql_mode = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION,ONLY_FULL_GROUP_BY';

#SET sql_mode=(SELECT REPLACE(@@sql_mode,'ONLY_FULL_GROUP_BY',''));

select @@sql_mode;
select @@global.sql_mode; 

use mydb;

# zadanie 4
#a)

SELECT 
    firstname,
    surname,
    TIMESTAMPDIFF(YEAR,
        date_of_birthday,
        CURDATE()) AS above_40_years_old
FROM
    worker
WHERE
    (TIMESTAMPDIFF(YEAR,
        date_of_birthday,
        CURDATE())) > 40;
        

#a.1
SELECT 
    surname
FROM
    mydb.worker
WHERE
    surname LIKE '%ski%';
    
#a.2
SELECT 
    surname
FROM
    mydb.worker
WHERE
    surname NOT LIKE 'ab%';
    

#a.3
SELECT 
    surname
FROM
    mydb.worker
WHERE
    length(surname)>10;
    

#a.4
SELECT 
    surname
FROM
    mydb.worker
WHERE
    surname LIKE '_F%';
    
#b
SELECT 
    worker.firstname, worker.surname, department.name
FROM
    mydb.worker
        JOIN
    department ON worker.department_id = department.id
WHERE
    department_id = 1;


#c
SELECT 
    worker.firstname, worker.surname, worker.pesel, project.name
FROM
    mydb.worker worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
        JOIN
    project ON worker_in_project.project_id = project.id
WHERE
    worker.pesel = '54062597129';
    
    
#d
SELECT  
    worker.firstname,
    worker.surname,
    COUNT(worker_in_project.project_id) AS how_many_project_is_acctualy
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
WHERE
    worker.id=28
        AND worker_in_project.stop_event=null;
        
        
#e
SELECT 
    worker.firstname,
    worker.surname,
    COUNT(worker_in_project.project_id) AS how_many_project
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
WHERE
    worker.id = 27
        AND worker_in_project.function = 'PL'
        AND (YEAR(worker_in_project.start_event) <= YEAR(NOW()) - 1
        AND (YEAR(worker_in_project.stop_event) >= YEAR(NOW()) - 1)
        OR (YEAR(worker_in_project.start_event) <= YEAR(NOW()) - 1
        AND (ISNULL(worker_in_project.stop_event))));
        


#f
SELECT 
    name, type
FROM
    mydb.project
WHERE
    type = 'external';

#g 
SELECT 
    worker.firstname,
    worker.surname,
    department.name as 'department_name',
    worker_in_project.project_id,
    GROUP_CONCAT(worker_in_project.function
        ORDER BY worker_in_project.function ASC
        SEPARATOR ' , ') AS roles 
FROM
    mydb.department
        JOIN
    worker ON worker.department_id = department.id
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
WHERE
    worker.department_id = '2'
GROUP BY worker_in_project.worker_id, worker_in_project.project_id
HAVING COUNT(DISTINCT worker_in_project.function)>1;


#h  
SELECT 
    worker_in_project.worker_id,
    worker.firstname,
    worker.surname,
    worker_in_project.project_id,
     GROUP_CONCAT(DISTINCT worker_in_project.function
        ORDER BY worker_in_project.function ASC
        SEPARATOR ' , ') AS roles 
   
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
WHERE
    worker_in_project.function = 'TCD'
        OR worker_in_project.function = 'DEV'
GROUP BY worker_in_project.worker_id , worker_in_project.project_id
HAVING (COUNT(distinct(worker_in_project.function))>1);

  
  
#i
SELECT project.name, worker.firstname, worker.surname, worker_in_project.daily_salary FROM
worker JOIN worker_in_project ON worker.id= worker_in_project.worker_id
ORDER BY worker_in_project.daily_salary DESC LIMIT 1;

#i.1
SELECT 
    worker.firstname,
    worker.surname,
    worker.id,
    SUM(worker_in_project.daily_salary) AS sum_daily_sallary
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
WHERE
    ISNULL(worker_in_project.stop_event)
GROUP BY worker.id
ORDER BY SUM(worker_in_project.daily_salary) DESC
LIMIT 1;


#j 
SELECT 
    worker.firstname,
    worker.surname,
    worker_in_project.project_id,
    worker_in_project.start_event,
    worker_in_project.stop_event,
    project.name
FROM
    mydb.worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
        JOIN
    project ON worker_in_project.project_id = project.id
WHERE
    project.id = 4
        AND worker_in_project.start_event BETWEEN '2003-03-11' AND '2011-05-30';


#k
SELECT firstname, surname FROM worker WHERE isnull(department_id); 

#l
SELECT 
    worker.firstname,
    worker.surname,
    project.name,
    worker_in_project.daily_salary
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
        JOIN
    project ON worker_in_project.project_id = project.id
WHERE
    worker_in_project.project_id = 1
        AND worker_in_project.daily_salary > 150;
        

#m
SELECT 
    worker.firstname,
    worker.surname,
    worker.id,
    SUM(worker_in_project.daily_salary) AS sum_daily_sallary
FROM
    worker
        JOIN
    worker_in_project ON worker.id = worker_in_project.worker_id
WHERE
    ISNULL(worker_in_project.stop_event)
GROUP BY worker.id
HAVING SUM(worker_in_project.daily_salary) > 150;


#n
UPDATE worker SET surname="Wojcik" WHERE id=2; 

#o kasowanie uzytkownika z bazy
 DROP USER 'demo'@'localhost';

# kasowanie uzytkownika z tabeli
DELETE FROM worker
WHERE
    id = 34; 

#p
UPDATE project SET name="my_www" WHERE id=2; 






