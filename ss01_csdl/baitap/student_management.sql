create database student_management;

use student_management;

create table class(
 class_id int primary key auto_increment ,
 class_name varchar(200)
);

create table teacher(
teacher_id int primary key auto_increment  ,
teacher_name varchar(200),
teacher_age int,
teacher_country varchar(200)
);
insert into class (class_name) values("kiet");
insert into teacher(teacher_name,teacher_age,teacher_country) values("kiet",23,"Lào");
insert into teacher(teacher_name,teacher_age,teacher_country) values("Long",21,"Mỹ");
insert into teacher(teacher_name,teacher_age,teacher_country) values("Giang",26,"VN");
