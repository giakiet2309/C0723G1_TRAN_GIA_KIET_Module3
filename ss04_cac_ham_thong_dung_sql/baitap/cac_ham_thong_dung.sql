create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class(
	class_id int not null auto_increment primary key,
	class_name varchar(60) not null,
	start_date datetime not null,
	status bit
);
create table student(
	student_id int not null auto_increment primary key,
	student_name varchar(30) not null,
	address varchar(50),
	phone varchar(20),
	status bit,
	class_id int not null,
	foreign key (class_id) references class (class_id)
);
create table subjects(
	sub_id int not null auto_increment primary key,
	sub_name varchar(30) not null,
	credit tinyint not null default 1 check ( credit >= 1 ),
	status bit default 1
);
create table mark(
	mark_id int not null auto_increment primary key,
	sub_id int not null,
	student_id int not null,
	mark float default 0 check ( mark between 0 and 100),
	exam_times tinyint default 1,
	unique (sub_id, student_id),
	foreign key (sub_id) references subjects (sub_id),
	foreign key (student_id) references student (student_id)
);
insert into class
values (1, 'a1', '2008-12-20', 1);
insert into class
values (2, 'a2', '2008-12-22', 1);
insert into class
values (3, 'b3', current_date, 0);

insert into student (student_name, address, phone, status, class_id)
values ('hung', 'ha noi', '0912113113', 1, 1);
insert into student (student_name, address, status, class_id)
values ('hoa', 'hai phong', 1, 1);
insert into student (student_name, address, phone, status, class_id)
values ('manh', 'hcm', '0123123123', 0, 2);

insert into subjects
values
	(1, 'cf', 5, 1),
	(2, 'c', 10, 1),
	(3, 'hdj', 5, 1),
	(4, 'rdbms', 10, 1);
insert into mark (sub_id, student_id, mark, exam_times)
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
inner join max_mark on max_mark.sub_id = subjects.sub_id;

-- hiển thị các thông tin sinh viên và điểm trung bình của mỗi sinh viên xếp hạng theo thứ tự điểm giảm dần
select student.student_name, avg(mark.mark) as average
from student
left join mark on student.student_id = mark.student_id
group by student.student_id
order by average;