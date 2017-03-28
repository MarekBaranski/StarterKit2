#tworzenie uzytkownika
CREATE USER 'marek'@'localhost' IDENTIFIED BY 'haslo';
CREATE USER 'piotrek'@'localhost' IDENTIFIED BY 'haslohaslo';
CREATE USER 'ania'@'localhost' IDENTIFIED BY 'haslohaslohaslo';
CREATE USER 'user_ro'@'localhost' IDENTIFIED BY 'password';
CREATE USER 'user_rw'@'localhost' IDENTIFIED BY 'passwordpassword';

#a nadawanie grantów
GRANT SELECT ON mydb.* TO 'user_ro'@'localhost';
#b nadawanie garntów
GRANT SELECT, DELETE, UPDATE, INSERT ON mydb.project TO 'user_rw'@'localhost';

#odbieranie uprawnien
REVOKE UPDATE ON  mydb.project FROM 'user_rw'@'localhost';