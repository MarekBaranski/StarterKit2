
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('jeden', 'a1', 'UserJeden', 'Pierwszy', 'jeden@wp.pl', 'lubie szachy', 'Gram całe zycie, bo lubie');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('dwa', 'b2', 'UserDwa', 'Drugi', 'dwa@wp.pl', 'lubie bardzo szachy','Gram od urodzeni');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('trzy', 'c3', 'UserTrzy', 'trzeci', 'trzy@wp.pl', 'lubie super szachy','Gram bo chcę');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('cztery', 'd4', 'UserCztery', 'Czwarty', 'cztery@wp.pl', 'lubie trochę szachy','Gram czasami');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('piec', 'e5', 'UserPiec', 'Piaty', 'piec@wp.pl', 'nie lubie grac w szachy','Gram bo moj brat gra');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('szesc', 'f6', 'UserSzesc', 'Szosty', 'szesc@wp.pl', 'lubie isc do kina','Dzien bez kina dniem straconym');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('siedem', 'g7', 'UserSiedem', 'Siodmy', 'siedem@wp.pl', 'lubie pić kawę','chwytaj dzien');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('osiem', 'h8', 'UserOsiem', 'Osmy', 'osiem@wp.pl', 'Lubie wakacje','Zawsze jezdze w gory');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('dziewiec', 'i9', 'UserDziewiec', 'Dziewiaty', 'Dziewiec@wp.pl', 'Nic nie lubie','Nic nie lubie i zyje');
INSERT INTO baza_chess.user (login, password, name, surname, email, about_me, life_motto) values ('dziesiec', 'j10', 'UserDziesiec', 'Dziesiaty', 'Dziesiec@wp.pl', 'gram w gry','Gram NFS II');

INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (6, 19, 620, 2);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (14, 14, 1470, 5);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (14, 7, 1475, 4);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (1, 11, 125, 3);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (15, 5, 1555, 9);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (12, 12, 1235, 1);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (14, 8, 1410, 7);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (15, 5, 1555, 6);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (13, 9, 1345, 8);
INSERT INTO baza_chess.statistic (level, position, points, user_entity_id) values (19, 1, 1990, 10);


INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN1',1,2);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN2',2,5);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('DRAWN',3,4);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN1',4,3);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN1',5,9);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN2',6,1);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN1',7,7);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('DRAWN',8,6);
INSERT INTO baza_chess.matchs (result, user1_id, user2_id) values ('WIN2',9,8);


