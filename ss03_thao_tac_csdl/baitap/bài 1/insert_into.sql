insert into class
values (1, 'A1', '2008-12-20', 1);
insert into class
values (2, 'A2', '2008-12-22', 1);
insert into class
values (3, 'B3', '2008-12-21', 1);

insert into student (student_name, address, phone, student_status, class_id)
values ('Hung', 'Ha Noi', '0912113113', 1, 1);
insert into student (student_name, address, student_status, class_id)
values ('Hoa', 'Hai phong', 1, 1);
insert into student (student_name, address, phone, student_status, class_id)
values ('Manh', 'HCM', '0123123123', 0, 2);

insert into subjects
values (1, 'CF', 5, 1),
       (2, 'C', 6, 1),
       (3, 'HDJ', 5, 1),
       (4, 'RDBMS', 10, 1);

insert into mark (sub_id, student_id, mark, exam_times)
values (1, 1, 8, 1),
       (2, 2, 10, 2),
       (2, 3, 12, 1);