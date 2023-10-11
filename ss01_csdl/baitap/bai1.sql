create database demo;

use demo;

create table Class(
 id int primary key auto_increment not null,
 name varchar(200)
);

create table Teacher(
id int primary key auto_increment  ,
name varchar(200),
age int,
country varchar(200)
);
insert into Class (name) values("kiet");
insert into Teacher(name,age,country) values("kiet",23,"Lào");
insert into Teacher(name,age,country) values("Long",21,"Mỹ");
insert into Teacher(name,age,country) values("Giang",26,"VN");
