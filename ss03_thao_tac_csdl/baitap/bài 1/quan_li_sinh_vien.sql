create database quan_ly_sinh_vien;
use quan_ly_sinh_vien;
create table class (
    class_id int auto_increment primary key,
    class_name varchar(60) not null,
    start_date datetime not null,
    class_status bit(1) default 1
);
create table student (
    student_id int  auto_increment primary key,
    student_name varchar(30) not null,
    address varchar(50),
    phone varchar(20),
    student_status bit(1) default 1,
    class_id int not null,
    foreign key (class_id)
        references class (class_id)
);
create table subjects (
    sub_id int auto_increment primary key,
    sub_name varchar(30) not null,
    credit tinyint not null default 1 check (credit >= 1),
    subjects_status bit(1) default 1
);

create table mark (
    mark_id int  auto_increment primary key,
    sub_id int not null,
    student_id int not null,
    mark float default 0 check (mark between 0 and 100),
    exam_times tinyint default 1,
    unique (sub_id , student_id),
    foreign key (sub_id)
        references subjects (sub_id),
    foreign key (student_id)
        references Student (student_id)
);

-- Hiển thị tất cả các sinh viên có tên bắt đầu bảng ký tự ‘h’
select * from student
where student_name like 'H%';

-- Hiển thị các thông tin lớp học có thời gian bắt đầu vào tháng 12.
SELECT *
FROM class
WHERE month(class.start_date) = 12;

-- Hiển thị tất cả các thông tin môn học có credit trong khoảng từ 3-5.
SELECT *
FROM subjects
WHERE subjects.credit between 3 and 5;

-- thay đổi mã lớp(ClassId) của sinh viên có tên ‘hung’ là 2.
SET sql_safe_updates = 0;
UPDATE student
SET class_id = 2
WHERE student_name like "Hung";
SET sql_safe_updates = 1;

-- Hiển thị các thông tin: StudentName, Subname, Mark. dữ liệu sắp xếp theo điểm thi (mark) giảm dần. nếu trùng sắp theo tên tăng dần.
SELECT *
FROM mark
LEFT JOIN student ON mark.student_id = student.student_id
ORDER BY mark.mark desc, student.student_name asc;
