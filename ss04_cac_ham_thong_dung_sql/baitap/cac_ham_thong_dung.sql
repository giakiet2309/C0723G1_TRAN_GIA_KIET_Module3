create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
	classid int not null auto_increment primary key,
	classname varchar(60) not null,
	startdate datetime not null,
	status bit
);
create table student(
	studentid int not null auto_increment primary key,
	studentname varchar(30) not null,
	address varchar(50),
	phone varchar(20),
	status bit,
	classid int not null,
	foreign key (classid) references class (classid)
);
create table subjects(
	subid int not null auto_increment primary key,
	subname varchar(30) not null,
	credit tinyint not null default 1 check ( credit >= 1 ),
	status bit default 1
);
create table mark(
	markid int not null auto_increment primary key,
	subid int not null,
	studentid int not null,
	mark float default 0 check ( mark between 0 and 100),
	examtimes tinyint default 1,
	unique (subid, studentid),
	foreign key (subid) references subjects (subid),
	foreign key (studentid) references student (studentid)
);
insert into class
values (1, 'a1', '2008-12-20', 1);
insert into class
values (2, 'a2', '2008-12-22', 1);
insert into class
values (3, 'b3', current_date, 0);

insert into student (studentname, address, phone, status, classid)
values ('hung', 'ha noi', '0912113113', 1, 1);
insert into student (studentname, address, status, classid)
values ('hoa', 'hai phong', 1, 1);
insert into student (studentname, address, phone, status, classid)
values ('manh', 'hcm', '0123123123', 0, 2);

insert into subjects
values
	(1, 'cf', 5, 1),
	(2, 'c', 10, 1),
	(3, 'hdj', 5, 1),
	(4, 'rdbms', 10, 1);
insert into mark (subid, studentid, mark, examtimes)
values
	(1, 1, 8, 1),
       (2, 2, 10, 2),
       (2, 3, 12, 1);
    
-- --------------------------------------------------------------------------------------------------------

-- hiển thị thông tin các môn học có credit lớn nhất
select *
from subjects
where subjects.credit = (select max(subjects.credit) from subjects);

-- hiển thị thông tin môn học có điểm thi lớn nhất
create view max_mark as
	select *
	from mark
	order by mark.mark desc
	limit 1;
select *
from subjects
inner join max_mark on max_mark.subid = subjects.subid;

-- hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên xếp hạng theo thứ tự điểm giảm dần
select student.studentname, avg(mark.mark) as average
from student
left join mark on student.studentid = mark.studentid
group by student.studentid
order by average;