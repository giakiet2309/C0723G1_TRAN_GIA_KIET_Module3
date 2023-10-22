drop database if exists ung_dung_quan_ly_net;
create database if not exists ung_dung_quan_ly_net;
use ung_dung_quan_ly_net;

create table loai_khach (
ma_loai_khach int primary key auto_increment,
ten_loai_khach varchar(50) not null
);
create table khach_hang (
ma_khach_hang int primary key auto_increment,
ten_khach_hang varchar(50) not null,
sdt_khach_hang varchar(50) not null,
email varchar(50) not null,
ma_loai_khach int not null,
foreign key(ma_loai_khach)
REFERENCES loai_khach(ma_loai_khach)
);
create table may_tinh (
ma_may int primary key auto_increment,
hang_san_xuat varchar(50) not null,
vi_tri_dat_may varchar(50) not null,
tien_gio float
);
create table loai_dich_vu_di_kem (
ma_loai_dich_vu_di_kem int primary key auto_increment,
ten_loai_dich_vu_di_kem varchar(50) not null
);
create table dich_vu(
hoa_don int primary key auto_increment,
thoi_gian_bat_dau datetime not null,
thoi_gian_ket_thuc datetime not null,
ma_may int not null,
ma_khach_hang int not null,
foreign key(ma_may)
references may_tinh(ma_may),
foreign key(ma_khach_hang)
references khach_hang(ma_khach_hang)
);
create table dich_vu_chi_tiet (
ma_dich_vu_chi_tiet int primary key auto_increment,
ten_dich_vu_chi_tiet varchar(50) not null,
ma_loai_dich_vu_di_kem int not null,
hoa_don int,
foreign key(ma_loai_dich_vu_di_kem)
references loai_dich_vu_di_kem(ma_loai_dich_vu_di_kem),
foreign key(hoa_don)
references dich_vu(hoa_don)
);
