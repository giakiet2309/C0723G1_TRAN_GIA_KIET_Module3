CREATE DATABASE demo;
USE demo; 
create table users ( 
      id int(3) NOT NULL AUTO_INCREMENT, 
      name varchar(120) NOT NULL, 
      email varchar(220) NOT NULL, 
      country varchar(120), 
      PRIMARY KEY (id) 
);
insert into users(name, email, country) values('Minh','minh@codegym.vn','Viet Nam');
insert into users(name, email, country) values('Kante','kante@che.uk','Kenia');
DELIMITER $$
CREATE PROCEDURE display_all()
BEGIN
 SELECT * FROM users;
 END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE update_all(id_user int , name_user varchar(120) , email_user varchar(120) , country_user varchar(120))
BEGIN
update user  set name = name_user , email = email_user , country = country_user where id = id_user;
 SELECT * FROM users;
 END$$
DELIMITER ;

DELIMITER $$
CREATE PROCEDURE delete_all(id_user int)
BEGIN
delete from users where id = id_user;
 END$$
DELIMITER ;
