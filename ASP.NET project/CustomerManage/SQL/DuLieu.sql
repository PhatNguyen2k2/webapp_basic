create table tblChatLieu(
   MaChatLieu varchar(20) not null primary key,
   TenChatLieu varchar(50)
)
create table tblHang(
   MaHang varchar(30) not null primary key,
   TenHang varchar(50),
   MaChatLieu varchar(20),
   Soluong int,
   DonGiaNhap float,
   DonGiaBan float,
   Anh varchar(50),
   GhiChu nvarchar(100),
   constraint fk_tblHang foreign key (MaChatLieu) references tblChatLieu(MaChatLieu)
)
create table tblCongViec(
   MaCV varchar(30) not null primary key,
   TenCV nvarchar(30),
   Luong float
)
create table tblNhanVien(
   MaNhanVien varchar(50) not null primary key,
   TenNhanVien varchar(50),
   NgaySinh date,
   GioiTinh nvarchar(10),
   DiaChi nvarchar(100),
   DienThoai varchar(11),
   MaCV varchar(30),
   constraint fk_tblNhanVien foreign key (MaCV) references tblCongViec(MaCV)
)
create table tblKhach(
   MaKhach varchar(30) not null primary key,
   TenKhach nvarchar(50),
   DiaChi nvarchar(100),
   DienThoai varchar(11)
)

create table tblHDBan(
   MaHDBan varchar(30) not null primary key,
   MaNhanVien varchar(50),
   NgayBan date,
   MaKhach varchar(30),
   TongTien float,
   constraint fk_tblHDBan1 foreign key (MaNhanVien) references tblNhanVien(MaNhanVien),
   constraint fk_tblHDBan2 foreign key (MaKhach) references tblKhach(MaKhach)
)
create table tblChiTietHDBan(
   MaHDBan varchar(30),
   MaHang varchar(30),
   SoLuong int,
   GiamGia float,
   ThanhTien float,
   primary key(MaHDBan, MaHang),
   constraint fk_tblChiTietHDBan1 foreign key (MaHDBan) references tblHDBan(MaHDBan),
   constraint fk_tblChiTietHDBan2 foreign key (MaHang) references tblHang(MaHang)
)