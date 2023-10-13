use ung_dung_quan_ly_furama;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự
-- “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where nhan_vien.ho_ten like 'H%' for like 'T%' or like 'K%'
and length(nhan_vien.ho_ten) <= 15;
	