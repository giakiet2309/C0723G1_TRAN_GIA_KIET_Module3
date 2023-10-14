use ung_dung_quan_ly_furama;

-- 2.Hiển thị thông tin của tất cả nhân viên có trong hệ thống có tên bắt đầu là một trong các ký tự
-- “H”, “T” hoặc “K” và có tối đa 15 kí tự.
select * from nhan_vien
where (nhan_vien.ho_ten like 'H%') or (nhan_vien.ho_ten like 'T%' )or(nhan_vien.ho_ten like 'K%')
and length(nhan_vien.ho_ten) <= 15;
	-- 3.Hiển thị thông tin của tất cả khách hàng có độ tuổi từ 18 đến 50 tuổi và có địa chỉ ở “Đà Nẵng”
-- hoặc “Quảng Trị”.
SELECT * FROM khach_hang WHERE timestampdiff(year, khach_hang.ngay_sinh,now()) BETWEEN 18 AND 50 AND (dia_chi like '%Đà Nẵng' OR dia_chi like '%Quảng Trị');
    -- 4.Đếm xem tương ứng với mỗi khách hàng đã từng đặt phòng bao nhiêu lần. Kết quả hiển thị được sắp xếp
-- tăng dần theo số lần đặt phòng của khách hàng. Chỉ đếm những khách hàng nào có Tên loại khách hàng là
-- “Diamond”.
select khach_hang.ho_ten, loai_khach.ten_loai_khach, count(*) as so_lan_dat_phong
from khach_hang
inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
inner join hop_dong on khach_hang.ma_khach_hang = hop_dong.ma_khach_hang
where loai_khach.ten_loai_khach like "%Diamond%"
group by khach_hang.ho_ten, loai_khach.ten_loai_khach
order by so_lan_dat_phong;
-- 5.Hiển thị ma_khach_hang, ho_ten, ten_loai_khach, ma_hop_dong, ten_dich_vu, ngay_lam_hop_dong,
-- ngay_ket_thuc, tong_tien (Với tổng tiền được tính theo công thức như sau:
-- Chi Phí Thuê + Số Lượng * Giá, với Số Lượng và Giá là từ bảng dich_vu_di_kem, hop_dong_chi_tiet)
-- cho tất cả các khách hàng đã từng đặt phòng. (những khách hàng nào chưa từng đặt phòng cũng phải
-- hiển thị ra).
select 
	khach_hang.ma_khach_hang,
	khach_hang.ho_ten, 
	loai_khach.ten_loai_khach, 
	hop_dong.ma_hop_dong,
	dich_vu.ten_dich_vu, 
	hop_dong.ngay_lam_hop_dong, 
	hop_dong.ngay_ket_thuc,
	sum(dich_vu.chi_phi_thue + ifnull(dich_vu_di_kem.gia, 0) * ifnull(hop_dong_chi_tiet.so_luong, 0)) as tong_tien
from khach_hang
	inner join loai_khach on khach_hang.ma_loai_khach = loai_khach.ma_loai_khach
	left join hop_dong on hop_dong.ma_khach_hang = khach_hang.ma_khach_hang
	left join dich_vu on hop_dong.ma_dich_vu = dich_vu.ma_dich_vu
	left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
	left join dich_vu_di_kem on hop_dong_chi_tiet.ma_dich_vu_di_kem = dich_vu_di_kem.ma_dich_vu_di_kem
group by 
	khach_hang.ma_khach_hang, 
    khach_hang.ho_ten, 
    loai_khach.ten_loai_khach, 
    hop_dong.ma_hop_dong,
	dich_vu.ten_dich_vu, 
    hop_dong.ngay_lam_hop_dong, 
    hop_dong.ngay_ket_thuc
order by khach_hang.ma_khach_hang;
-- 6.Hiển thị ma_dich_vu, ten_dich_vu, dien_tich, chi_phi_thue, ten_loai_dich_vu của tất cả các loại
-- dịch vụ chưa từng được khách hàng thực hiện đặt từ quý 1 của năm 2021 (Quý 1 là tháng 1, 2, 3).
select dv.ma_dich_vu, dv.ten_dich_vu, ldv.ten_loai_dich_vu, dv.dien_tich, dv.chi_phi_thue
from dich_vu dv
join hop_dong hd on dv.ma_dich_vu = hd.ma_dich_vu
join loai_dich_vu ldv on dv.ma_loai_dich_vu=ldv.ma_loai_dich_vu
where hd.ngay_lam_hop_dong >= '2021-04-01'
group by dv.ma_dich_vu;
    -- 7.Hiển thị thông tin ma_dich_vu, ten_dich_vu, dien_tich, so_nguoi_toi_da, chi_phi_thue,
-- ten_loai_dich_vu của tất cả các loại dịch vụ đã từng được khách hàng đặt phòng trong năm 2020
-- nhưng chưa từng được khách hàng đặt phòng trong năm 2021.
create view hop_dong_2020 as
select * from `hop_dong`
where year(`hop_dong`.`ngay_lam_hop_dong`) = 2020;
create view hop_dong_2021 as
select * from `hop_dong`
where year(`hop_dong`.`ngay_lam_hop_dong`) = 2021;
select
	dich_vu.ma_dich_vu as "Mã dịch vụ",
    dich_vu.ten_dich_vu as "Tên dịch vụ",
    dich_vu.dien_tich as "Diện tích",
    dich_vu.so_nguoi_toi_da as "Số người tối đa",
    dich_vu.chi_phi_thue as "Chi phí thuê",
    loai_dich_vu.ten_loai_dich_vu as "Loại dich vụ"
from `dich_vu`
	inner join loai_dich_vu on dich_vu.ma_loai_dich_vu = loai_dich_vu.ma_loai_dich_vu
    inner join hop_dong_2020 on dich_vu.ma_dich_vu = hop_dong_2020.ma_dich_vu
    left join hop_dong_2021 on dich_vu.ma_dich_vu = hop_dong_2021.ma_dich_vu
where
	hop_dong_2021.ma_dich_vu is null
group by 
	dich_vu.ma_dich_vu;

-- 8.Hiển thị thông tin ho_ten khách hàng có trong hệ thống, với yêu cầu ho_ten không trùng nhau.
-- Học viên sử dụng theo 3 cách khác nhau để thực hiện yêu cầu trên.
select ho_ten from khach_hang
group by ho_ten;

select ho_ten from khach_hang
union
select ho_ten from khach_hang;

select distinct ho_ten from khach_hang;

-- 9.Thực hiện thống kê doanh thu theo tháng, nghĩa là tương ứng với mỗi tháng trong năm 2021 thì
-- sẽ có bao nhiêu khách hàng thực hiện đặt phòng.
select month(hd.ngay_lam_hop_dong) as `thang`, count(hd.ma_khach_hang) as `so_khach_hang`
from khach_hang kh
join hop_dong hd on kh.ma_khach_hang = hd.ma_khach_hang
where year(hd.ngay_lam_hop_dong) = 2021
group by thang
order by thang;

-- 10.Hiển thị thông tin tương ứng với từng hợp đồng thì đã sử dụng bao nhiêu dịch vụ đi kèm.
-- Kết quả hiển thị bao gồm ma_hop_dong, ngay_lam_hop_dong, ngay_ket_thuc, tien_dat_coc,
-- so_luong_dich_vu_di_kem (được tính dựa trên việc sum so_luong ở dich_vu_di_kem).
select 
	hop_dong.ma_hop_dong,
    hop_dong.ngay_lam_hop_dong,
    hop_dong.ngay_ket_thuc,
    hop_dong.tien_dat_coc,
    sum(ifnull(hop_dong_chi_tiet.so_luong, 0)) as "Số lượng dịch vụ đi kèm"
from hop_dong
left join hop_dong_chi_tiet on hop_dong.ma_hop_dong = hop_dong_chi_tiet.ma_hop_dong
group by 
	hop_dong.ma_hop_dong
order by
	hop_dong.ma_hop_dong;