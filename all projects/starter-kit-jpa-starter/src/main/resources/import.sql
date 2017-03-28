--insert into book (id, title) values (1, 'Pierwsza książka');
--insert into book (id, title) values (2, 'Druga książka');
--insert into book (id, title) values (3, 'Trzecia książka');
--
--insert into author (id, first_name, last_name) values (7, 'Jan', 'Kowalski');
--insert into author (id, first_name, last_name) values (8, 'Zbigniew', 'Nowak');
--insert into author (id, first_name, last_name) values (9, 'Janusz', 'Jankowski');
--
--insert into book_author(book_id, author_id) values (1, 7);
--insert into book_author(book_id, author_id) values (1, 8);
--insert into book_author(book_id, author_id) values (2, 8);
--insert into book_author(book_id, author_id) values (3, 9);
--


INSERT INTO baza_workbench.department (id, name,email, phone, mobile) values (null, 'finance', 'finance@baza.pl', '711001010', '+48100101010');
INSERT INTO baza_workbench.department (id, name,email, phone, mobile) values (null, 'logistic','logistic@baza.pl', '712001010', '+48100202020');
INSERT INTO baza_workbench.department (id, name,email, phone, mobile) values (null, 'auto','auto@baza.pl', '713001010', '+48100303030');
INSERT INTO baza_workbench.department (id, name,email, phone, mobile) values (null, 'hr','hr@baza.pl', '714001010', '+48100404040');


INSERT INTO baza_workbench.project (id, name, type) values (null, 'audi', 'EXTERNAL'); 
INSERT INTO baza_workbench.project (id, name, type) values (null, 'my_page', 'INTERNAL');
INSERT INTO baza_workbench.project (id, name, type) values (null, 'daimler', 'EXTERNAL');
INSERT INTO baza_workbench.project (id, name, type) values (null, 'service', 'INTERNAL');

INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null,'Jina','Barański', '49101035333','1949-10-10','baranski@baza.pl', '712001011', '+48100202022','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Josiah','Guz','59012863653','1959-1-28','guz@baza.pl', '712001012', '+48100202032','2');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Charissa','Skórski','59091483568','1959-9-14','skorski@baza.pl', '712001012', '+48100202032','2');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Jacklyn','Fiedorowicz','80101485421','1980-10-14','fiedorowicz@baza.pl', '712001011', '+48100202023','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Avery','Idczak','98103024359','1998-10-30','idczak@baza.pl', '712001011', '+48100202042','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Marco','Wołowiec','92120353832','1992-12-3','wolowiec@baza.pl', '712001011', '+48100202024','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Emory','Gronowski','92092487971','1992-9-24','gronowski@baza.pl', '712001011', '+48100202025','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Sherri','Pomorski','46032612488','1946-3-26','pomorski@baza.pl', '712001011', '+48100202026','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Margarite','Abmalewski','47030911173','1947-3-9','abmalewski@baza.pl', '712001012', '+48100202027','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Hollis','Felczak','55101038696','1955-10-10','felczak@baza.pl', '712001013', '+48100202030','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Nu','GFzeszczuk','78083015965','1978-8-30','gfzeszczuk@baza.pl', '712001013', '+48100202031','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Jodie','Wosik','94030217846','1994-3-2','wosik@baza.pl', '712001013', '+48100202032','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Viva','Rybak','94030311793','1994-3-3','rybak@baza.pl', '712001013', '+48100202033','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Leandra','Wandzel','54062597129','1954-6-25','wandzel@baza.pl', '712001011', '+48100202034','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Lory','Trybuła','82011621975','1982-1-16','trybula@baza.pl', '712001012', '+48100202035','2');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Britta','Kazimierczak','53120311426','1953-12-3','kazimierczak@baza.pl', '712001011', '+48100202036','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Marcelina','Dybała','88032175347','1988-3-21','dybala@baza.pl', '712001011', '+48100202037','2');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Lucina','Abtkiewicz','62040835798','1962-4-8','abtkiewicz@baza.pl', '712001011', '+48100202038','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Christena','Goluch','70050453394','1970-5-4','goluch@baza.pl', '712001012', '+48100202039','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Ardell','Barski','55100957589','1955-10-9','barski@baza.pl', '712001011', '+48100202040','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Demetra','PFwelczyk','82011281647','1982-1-12','pfwelczyk@baza.pl', '712001012', '+48100202041','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Mohammad','Paszko','77100665239','1977-10-6','paszko@baza.pl', '712001011', '+48100202042','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Anjelica','Abyczka','57071475516','1957-7-14','abyczka@baza.pl', '712001012', '+48100202043','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Janessa','Płotka','43010362825','1943-1-3','plotka@baza.pl', '712001013', '+48100202044','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Agnus','Aberoń','43021349642','1943-2-13','aberon@baza.pl', '712001013', '+48100202045','1');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Gilma','Kurzawa','61030457394','1961-3-4','kurzawa@baza.pl', '712001011', '+48100202046','2');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Dembowski','Dedra','85050778437','1985-5-7','dedra@baza.pl', '712001011', '+48100202047','4');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Wan','Dec','90101236668','1990-10-12','dec@baza.pl', '712001013', '+48100202048','3');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Clarissa','Drapała','72070885573','1972-7-8','drapala@baza.pl', '712001012', '+48100202049','2');
INSERT INTO baza_workbench.worker (id, firstname, surname,pesel, date_of_birthday, email, phone, mobile, department_id) values (null, 'Sharmaine','Demianiuk','50042313448','1950-4-23','demianiuk@baza.pl', '712001013', '+48100202050','4');

INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,1,1,'1999-12-12',null,'PL','139');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,2,2,'1999-12-12',null,'PL','145');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,3,3,'1997-02-01','2013-04-15','FCD','212');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,4,4,'1995-01-01',null,'DEV','89');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,5,1,'1999-01-01','2015-04-04','DEV','200');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,6,2,'1999-12-12','2013-08-10','DEV','100');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,7,3,'1996-09-10',null,'PL','125');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,8,4,'2009-01-25',null,'TCD','180');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,26,1,'2010-10-10',null,'TCD','330');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,10,2,'2013-12-12',null,'FCD','165');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,11,3,'2002-01-09',null,'FCD','212');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,12,4,'2011-01-08',null,'PL','89');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,28,3,'2000-01-01',null,'DEV','200');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,14,2,'2017-02-01',null,'FCD','100');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,15,2,'2005-06-28','2008-11-30','DEV','125');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,16,4,'1998-05-05','2003-06-29','TCD','180');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,27,1,'2013-01-12',null,'TCD','100'); 
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,18,2,'2012-01-05','2012-08-10','FCD','125');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,19,3,'2004-11-25','2006-04-05','TCD','180');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,29,1,'1999-12-06',null,'TCD','330'); 
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,21,2,'2015-03-01',null,'FCD','165'); 
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,22,2,'2011-02-12',null,'FCD','212');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,23,4,'2006-03-15','2015-7-04','DEV','89');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,24,4,'1999-09-10','2001-01-31','DEV','200');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,25,1,'2008-09-01',null,'DEV','100');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,12,1,'2013-01-08',null,'DEV','345');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,28,4,'2009-01-01','2013-09-01','DEV','201');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,14,1,'2016-01-16',null,'FCD','95');
INSERT INTO baza_workbench.worker_in_project (id, worker_id, project_id, start_event, stop_event, function, daily_salary) values (null,15,3,'1998-06-17',null,'FCD','120');
