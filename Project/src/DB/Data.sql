USE [master]
GO
/****** Object:  Database [QuanLySinhVien_Offcial]    Script Date: 7/7/2022 2:21:15 PM ******/
CREATE DATABASE [QuanLySinhVien_Offcial]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'QuanLySinhVien_Offcial', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLySinhVien_Offcial.mdf' , SIZE = 8192KB , MAXSIZE = UNLIMITED, FILEGROWTH = 65536KB )
 LOG ON 
( NAME = N'QuanLySinhVien_Offcial_log', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL15.MSSQLSERVER\MSSQL\DATA\QuanLySinhVien_Offcial_log.ldf' , SIZE = 8192KB , MAXSIZE = 2048GB , FILEGROWTH = 65536KB )
 WITH CATALOG_COLLATION = DATABASE_DEFAULT
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET COMPATIBILITY_LEVEL = 150
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [QuanLySinhVien_Offcial].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ARITHABORT OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET  ENABLE_BROKER 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET RECOVERY FULL 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET  MULTI_USER 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET DB_CHAINING OFF 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET TARGET_RECOVERY_TIME = 60 SECONDS 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET DELAYED_DURABILITY = DISABLED 
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET ACCELERATED_DATABASE_RECOVERY = OFF  
GO
EXEC sys.sp_db_vardecimal_storage_format N'QuanLySinhVien_Offcial', N'ON'
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET QUERY_STORE = OFF
GO
USE [QuanLySinhVien_Offcial]
GO
/****** Object:  UserDefinedFunction [dbo].[fc_Diem_Chu]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_Diem_Chu]
(
	@DiemC real,
	@DiemB real,
	@DiemTL1 real,
	@DiemTL2 real
)
returns char(50)
AS
BEGIN
	Declare @temp real;
	Declare @results char(50);
	set @temp = dbo.fc_Diem_Trung_Binh(@DiemC,@DiemB,@DiemTL1,@DiemTL2);
	if(@temp < 4)
		set @results = 'F';
	else if(@temp >= 4 and @temp < 5)
		set @results = 'D';
	else if(@temp >= 5 and @temp < 6)
		set @results = 'D+';
	else if(@temp >= 6 and @temp < 6.5)
		set @results = 'C';
	else if(@temp >= 6.5 and @temp < 7)
		set @results = 'C+';
	else if(@temp >= 7 and @temp < 8)
		set @results = 'B';
	else if(@temp >= 8 and @temp < 8.5)
		set @results = 'B+';
	else if(@temp >= 8.5)
		set @results = 'A';
	return @results;

END


GO
/****** Object:  UserDefinedFunction [dbo].[fc_Diem_He_Four]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_Diem_He_Four]
(
	@DiemTrungBinh real
)
returns real
AS
BEGIN
	Declare @temp real;
	Declare @results real;
	set @temp = @DiemTrungBinh;
	if(@temp < 4)
		set @results = 0;
	else if(@temp >= 4 and @temp < 5)
		set @results = 1;
	else if(@temp >= 5 and @temp < 6)
		set @results = 1.5;
	else if(@temp >= 6 and @temp < 6.5)
		set @results = 2;
	else if(@temp >= 6.5 and @temp < 7)
		set @results = 2.5;
	else if(@temp >= 7 and @temp < 8)
		set @results = 3;
	else if(@temp >= 8 and @temp < 8.5)
		set @results = 3.5;
	else if(@temp >= 8.5)
		set @results = 4;
	return @results;

END


GO
/****** Object:  UserDefinedFunction [dbo].[fc_Diem_Trung_Binh]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date, ,>
-- Description:	<Description, ,>
-- =============================================
CREATE FUNCTION [dbo].[fc_Diem_Trung_Binh]
(
	@DiemC real,
	@DiemB real,
	@DiemTL1 real,
	@DiemTL2 real
)
returns real
AS
BEGIN
	Declare @DiemThi real;
	set @DiemThi = @DiemTL1;
	if(@DiemTL2 is not null)
		begin
			set @DiemThi = @DiemTL2;
		end
	else
		begin
			if(@DiemTL1>@DiemTL2)
			begin
				set @DiemThi = @DiemTL1;
			end
		end
	Declare @DiemTrungBinh real;
	set @DiemTrungBinh = format(((@DiemC*0.1) + (@DiemB*0.3) + (@DiemThi*0.6)),'00.00');
	return @DiemTrungBinh;

END


GO
/****** Object:  UserDefinedFunction [dbo].[fc_Diem_Trung_Binh_He_bon]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_Diem_Trung_Binh_He_bon]
(
	@mssv nvarchar(10)
)
returns real
AS
BEGIN
	declare @result real;
	select @result = sum(dbo.fc_Diem_He_Four(d.Diem_Trung_Binh)*h.SoTinChi)/sum(h.SoTinChi) from DIEM d inner join HOC_PHAN h on d.MaHocPhan = h.MaHocPhan where d.MaSinhVien = @mssv; 
	return format(@result,'00.00');

END


GO
/****** Object:  UserDefinedFunction [dbo].[fc_Diem_Trung_Binh_He_bon_theo_ki]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_Diem_Trung_Binh_He_bon_theo_ki]
(
	@mssv nvarchar(50),
	@namhoc int,
	@kihoc int
)
returns real
AS
BEGIN
	declare @result real;
	select @result = sum(dbo.fc_Diem_He_Four(d.Diem_Trung_Binh)*h.SoTinChi)/sum(h.SoTinChi) from DIEM d inner join HOC_PHAN h on d.MaHocPhan = h.MaHocPhan where d.MaSinhVien = @mssv and h.NamHoc = @namhoc and h.TenHocKy = @kihoc;
	return format(@result,'00.00');

END


GO
/****** Object:  UserDefinedFunction [dbo].[fc_HinhThuc]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_HinhThuc]
(
	@loai real
)
returns nvarchar (100)
AS
BEGIN
	declare @result nvarchar(100);
	if(@loai < 0.5)
	set @result = N'Đuổi Học';
	else if(@loai >= 0.5 and @loai < 1.5)
	set @result = N'Đình chỉ 1 năm';
	else if(@loai >= 1.5 and @loai < 1.8)
	set @result = N'Cảnh cáo lần 1';
	else if(@loai >= 1.8 and @loai < 2.5)
	set @result = N'Xếp Loại Trung Bình';
	else if(@loai >= 2.5 and @loai < 3.0)
	set @result = N'Xếp Loại Khá';
	else if(@loai >= 3.0 and @loai < 3.5)
	set @result = N'Xếp Loại Giỏi';
	else if(@loai >= 3.5)
	set @result = N'Xếp Loại Xuất Sắc';
	return @result;

END


GO
/****** Object:  UserDefinedFunction [dbo].[fc_Kiem_Tra_Ton_Tai]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_Kiem_Tra_Ton_Tai]
(
	@MSSV nchar(50),
	@MaHocPhan char(50)
)
returns int
as
begin
	Declare @temp int;
	set @temp = (select count(*) from DIEM where MaSinhVien = @MSSV and MaHocPhan = @MaHocPhan);
	return (@temp);
end


GO
/****** Object:  UserDefinedFunction [dbo].[fc_SoTinChiDat]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE FUNCTION [dbo].[fc_SoTinChiDat]
(
	@mssv nvarchar(10)
)
returns int
as
begin
	declare @result int;
	select @result =  sum(h.SoTinChi) from DIEM d inner join HOC_PHAN h on d.MaHocPhan = h.MaHocPhan where d.MaSinhVien = @mssv and d.Diem_Trung_Binh >=4;
	return @result;
end


GO
/****** Object:  Table [dbo].[DIEM]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DIEM](
	[MaSinhVien] [nvarchar](10) NOT NULL,
	[MaHocPhan] [nvarchar](10) NOT NULL,
	[DiemC] [real] NULL,
	[DiemB] [real] NULL,
	[DiemTL1] [real] NULL,
	[DIEMTL2] [real] NULL,
	[Diem_Trung_Binh] [real] NULL,
	[Diem_Chu] [char](10) NULL,
	[Xoa] [bit] NULL,
 CONSTRAINT [PK__KET_QUA__6A3BD8503B8FF990] PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC,
	[MaHocPhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HOC_PHAN]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HOC_PHAN](
	[MaHocPhan] [nvarchar](10) NOT NULL,
	[TenHocPhan] [nvarchar](200) NOT NULL,
	[SoTinChi] [int] NOT NULL,
	[PhongHoc] [nvarchar](10) NOT NULL,
	[MaGiangVien] [nvarchar](10) NOT NULL,
	[NamHoc] [int] NOT NULL,
	[TenHocKy] [int] NOT NULL,
	[SoTietHoc] [int] NOT NULL,
 CONSTRAINT [PK_HOC_PHAN] PRIMARY KEY CLUSTERED 
(
	[MaHocPhan] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[SINH_VIEN]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[SINH_VIEN](
	[MaSinhVien] [nvarchar](10) NOT NULL,
	[HoTenSinhVien] [nvarchar](50) NOT NULL,
	[NgaySinh] [date] NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[MaLop] [nvarchar](10) NOT NULL,
	[SoDienThoai] [nvarchar](11) NOT NULL,
	[MatKhau] [nvarchar](50) NOT NULL,
	[Email] [nvarchar](1000) NOT NULL,
	[MaHeDaoTao] [nvarchar](50) NOT NULL,
	[ThoiGianHoc] [nvarchar](2) NOT NULL,
	[SoDienThoaiGiaDinh] [nvarchar](11) NOT NULL,
	[HoTenBo] [nvarchar](50) NOT NULL,
	[HoTenMe] [nvarchar](50) NOT NULL,
	[NoiSinh] [nvarchar](150) NOT NULL,
	[NgayNhapHoc] [date] NOT NULL,
 CONSTRAINT [PK_sv] PRIMARY KEY CLUSTERED 
(
	[MaSinhVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_qldsv_Diem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_qldsv_Diem]
AS
SELECT        dbo.SINH_VIEN.MaSinhVien, dbo.SINH_VIEN.HoTenSinhVien, dbo.DIEM.Diem_Trung_Binh, dbo.DIEM.Diem_Chu, dbo.HOC_PHAN.MaHocPhan, dbo.HOC_PHAN.TenHocPhan
FROM            dbo.DIEM INNER JOIN
                         dbo.HOC_PHAN ON dbo.DIEM.MaHocPhan = dbo.HOC_PHAN.MaHocPhan INNER JOIN
                         dbo.SINH_VIEN ON dbo.DIEM.MaSinhVien = dbo.SINH_VIEN.MaSinhVien
GO
/****** Object:  Table [dbo].[LOP]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[LOP](
	[MaLop] [nvarchar](10) NOT NULL,
	[TenLop] [nvarchar](50) NOT NULL,
	[MaKhoa] [nvarchar](10) NOT NULL,
	[MaGiangVien] [nvarchar](10) NOT NULL,
 CONSTRAINT [PK_class] PRIMARY KEY CLUSTERED 
(
	[MaLop] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  View [dbo].[view_qldsv_CanhCao]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_qldsv_CanhCao]
AS
SELECT DISTINCT sv.MaSinhVien, sv.HoTenSinhVien, dbo.fc_Diem_Trung_Binh_He_bon_theo_ki(sv.MaSinhVien, hp.NamHoc, hp.TenHocKy) AS DiemSo, l.MaKhoa, hp.NamHoc, hp.TenHocKy, l.MaLop, l.TenLop
FROM            dbo.DIEM AS d INNER JOIN
                         dbo.HOC_PHAN AS hp ON d.MaHocPhan = hp.MaHocPhan INNER JOIN
                         dbo.SINH_VIEN AS sv ON d.MaSinhVien = sv.MaSinhVien INNER JOIN
                         dbo.LOP AS l ON l.MaLop = sv.MaLop
GO
/****** Object:  View [dbo].[view_qldsv_top_Diem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_qldsv_top_Diem]
AS
SELECT DISTINCT sv.MaSinhVien, sv.HoTenSinhVien, dbo.fc_Diem_Trung_Binh_He_bon_theo_ki(sv.MaSinhVien, hp.NamHoc, hp.TenHocKy) AS DiemSo, l.MaKhoa, hp.NamHoc, hp.TenHocKy
FROM            dbo.DIEM AS d INNER JOIN
                         dbo.HOC_PHAN AS hp ON d.MaHocPhan = hp.MaHocPhan INNER JOIN
                         dbo.SINH_VIEN AS sv ON d.MaSinhVien = sv.MaSinhVien INNER JOIN
                         dbo.LOP AS l ON l.MaLop = sv.MaLop
GO
/****** Object:  View [dbo].[view_qldsv_ThongTin]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE VIEW [dbo].[view_qldsv_ThongTin]
AS
SELECT        dbo.LOP.MaLop, dbo.LOP.TenLop, dbo.SINH_VIEN.MaSinhVien, dbo.SINH_VIEN.HoTenSinhVien
FROM            dbo.LOP INNER JOIN
                         dbo.SINH_VIEN ON dbo.LOP.MaLop = dbo.SINH_VIEN.MaLop
GO
/****** Object:  Table [dbo].[DANG_NHAP]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[DANG_NHAP](
	[TenDangNhap] [nvarchar](50) NOT NULL,
	[MatKhau] [nvarchar](20) NOT NULL,
	[HoTen] [nvarchar](50) NULL,
	[Email] [nvarchar](20) NULL,
	[Quyen] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_admin] PRIMARY KEY CLUSTERED 
(
	[TenDangNhap] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[GIANG_VIEN]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[GIANG_VIEN](
	[MaGiangVien] [nvarchar](10) NOT NULL,
	[HoTenGiangVien] [nvarchar](max) NOT NULL,
	[GioiTinh] [bit] NOT NULL,
	[SoDienThoai] [nvarchar](11) NOT NULL,
	[NoiSinh] [nvarchar](max) NOT NULL,
	[Email] [nvarchar](50) NOT NULL,
	[MaKhoa] [nvarchar](10) NOT NULL,
	[TrangThai] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_teacher] PRIMARY KEY CLUSTERED 
(
	[MaGiangVien] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]
GO
/****** Object:  Table [dbo].[HEDAOTAO]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[HEDAOTAO](
	[MaHeDaoTao] [nvarchar](50) NOT NULL,
	[TenHeDaoTao] [nvarchar](50) NOT NULL,
 CONSTRAINT [PK_HeDaoTao] PRIMARY KEY CLUSTERED 
(
	[MaHeDaoTao] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[KHOA]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[KHOA](
	[MaKhoa] [nvarchar](10) NOT NULL,
	[TenKhoa] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_faculties] PRIMARY KEY CLUSTERED 
(
	[MaKhoa] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON, OPTIMIZE_FOR_SEQUENTIAL_KEY = OFF) ON [PRIMARY]
) ON [PRIMARY]
GO
ALTER TABLE [dbo].[DIEM]  WITH CHECK ADD  CONSTRAINT [FK_DIEM_HOC_PHAN1] FOREIGN KEY([MaHocPhan])
REFERENCES [dbo].[HOC_PHAN] ([MaHocPhan])
GO
ALTER TABLE [dbo].[DIEM] CHECK CONSTRAINT [FK_DIEM_HOC_PHAN1]
GO
ALTER TABLE [dbo].[DIEM]  WITH CHECK ADD  CONSTRAINT [FK_DIEM_SINH_VIEN1] FOREIGN KEY([MaSinhVien])
REFERENCES [dbo].[SINH_VIEN] ([MaSinhVien])
GO
ALTER TABLE [dbo].[DIEM] CHECK CONSTRAINT [FK_DIEM_SINH_VIEN1]
GO
ALTER TABLE [dbo].[HOC_PHAN]  WITH CHECK ADD  CONSTRAINT [FK_HOC_PHAN_GIANG_VIEN1] FOREIGN KEY([MaGiangVien])
REFERENCES [dbo].[GIANG_VIEN] ([MaGiangVien])
GO
ALTER TABLE [dbo].[HOC_PHAN] CHECK CONSTRAINT [FK_HOC_PHAN_GIANG_VIEN1]
GO
ALTER TABLE [dbo].[LOP]  WITH CHECK ADD  CONSTRAINT [FK_LOP_GIANG_VIEN1] FOREIGN KEY([MaGiangVien])
REFERENCES [dbo].[GIANG_VIEN] ([MaGiangVien])
GO
ALTER TABLE [dbo].[LOP] CHECK CONSTRAINT [FK_LOP_GIANG_VIEN1]
GO
ALTER TABLE [dbo].[LOP]  WITH CHECK ADD  CONSTRAINT [FK_LOP_KHOA] FOREIGN KEY([MaKhoa])
REFERENCES [dbo].[KHOA] ([MaKhoa])
GO
ALTER TABLE [dbo].[LOP] CHECK CONSTRAINT [FK_LOP_KHOA]
GO
ALTER TABLE [dbo].[SINH_VIEN]  WITH CHECK ADD  CONSTRAINT [FK_SINH_VIEN_HEDAOTAO1] FOREIGN KEY([MaHeDaoTao])
REFERENCES [dbo].[HEDAOTAO] ([MaHeDaoTao])
GO
ALTER TABLE [dbo].[SINH_VIEN] CHECK CONSTRAINT [FK_SINH_VIEN_HEDAOTAO1]
GO
ALTER TABLE [dbo].[SINH_VIEN]  WITH CHECK ADD  CONSTRAINT [FK_SINH_VIEN_LOP] FOREIGN KEY([MaLop])
REFERENCES [dbo].[LOP] ([MaLop])
GO
ALTER TABLE [dbo].[SINH_VIEN] CHECK CONSTRAINT [FK_SINH_VIEN_LOP]
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_DangNhap]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_DangNhap] 
	(
	@TenDangNhap nvarchar(50),
	@Matkhau nvarchar(20)
)
AS
BEGIN
	select * from DANG_NHAP where TenDangNhap =@TenDangNhap and MatKhau = @Matkhau
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_DangNhap_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[sp_qldsv_DangNhap_UpdateItem]
	(
	@tendangnhap nvarchar(50),
	@MatKhau nvarchar(20),
	@hoten nvarchar(50),
	@email nvarchar(20)
)
AS
BEGIN
	update DANG_NHAP set HoTen = @hoten, Email = @email,MatKhau =@MatKhau where TenDangNhap = @tendangnhap
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_Check]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[sp_qldsv_Diem_Check]
	(@Mssv nvarchar(10),
	@MaHocPhan nvarchar(10)
)
AS

begin
	select * from DIEM where MaSinhVien = @Mssv and MaHocPhan = @MaHocPhan
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Diem_DeleteItem]
(
	@MSSV nvarchar(10),
	@MaHocPhan nvarchar(10)
)
as
begin
	if(dbo.fc_Kiem_Tra_Ton_Tai(@MSSV,@MaHocPhan) > 0)
		begin
			update DIEM set Xoa = 1
			where MaSinhVien = @MSSV and MaHocPhan = @MaHocPhan
		end
	else
		begin
			print('Hiện chưa có tính năng này');
		end
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Diem_GetAll]
	
AS
select * from DIEM
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_GetAll_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Diem_GetAll_dk](
	@id_Diem int
)
as
	select * from DIEM where MaSinhVien = @id_Diem
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_GetAll_mssv]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[sp_qldsv_Diem_GetAll_mssv]
	(
	@mssv nvarchar(10)
)
AS

	select * from DIEM where MaSinhVien = @mssv
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_GetInfor]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Diem_GetInfor](
	@Mssv nvarchar(10),
	@Mahocphan nvarchar(10)
)
AS
BEGIN
	select * from DIEM where MaSinhVien=@Mssv and MaHocPhan = @Mahocphan
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Diem_InsertItem](
	@MaSinhVien nvarchar(10),
	@MaHocPhan nvarchar(10),
	@DiemC real,
	@DiemB real,
	@DiemTL1 real,
	@DiemTL2 real
)
as
	insert into DIEM
	values(@MaSinhVien,@MaHocPhan,@DiemC,@DiemB,@DiemTL1,@DiemTL2,dbo.fc_Diem_Trung_Binh(@DiemC,@DiemB,@DiemTL1,@DiemTL2),dbo.fc_Diem_Chu(@DiemC,@DiemB,@DiemTL1,@DiemTL2),0)
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Diem_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Diem_UpdateItem](
	@MaSinhVien nvarchar(10),
	@MaHocPhan nvarchar(10),
	@DiemC real,
	@DiemB real,
	@DiemTL1 real,
	@DiemTL2 real,
	@Xoa bit 

)
as
begin
	if(dbo.fc_Kiem_Tra_Ton_Tai(@MaSinhVien,@MaHocPhan) > 0)
		begin
			update DIEM set DiemC = @DiemC , DiemB = @DiemB, DiemTL1 = @DiemTL1, DiemTL2 = @DiemTL2, Diem_Trung_Binh = dbo.fc_Diem_Trung_Binh(@DiemC,@DiemB,@DiemTL1,@DiemTL2), Diem_Chu = dbo.fc_Diem_Chu(@DiemC,@DiemB,@DiemTL1,@DiemTL2),Xoa=@Xoa
			where MaSinhVien = @MaSinhVien and MaHocPhan = @MaHocPhan
		end
	else
		begin
			print('Hiện chưa có tính năng này');
		end
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Finding]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Finding]
	(
	@mssv nvarchar(10)
)
AS
BEGIN
	select dbo.fc_SoTinChiDat(@mssv) as SoTinChiDat, dbo.fc_Diem_Trung_Binh_He_bon(@mssv) as DiemTrungBinh 
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_GiangVien_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_GiangVien_DeleteItem]
(

@MaGiangVien nvarchar(10)

)
as
begin
delete from GIANG_VIEN  
where MaGiangVien=@MaGiangVien

end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_GiangVien_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_GiangVien_GetAll]
	
AS
BEGIN
	select * from GIANG_VIEN 
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_GiangVien_GetAll_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_GiangVien_GetAll_dk]
(
@MaGV nvarchar(10)
)	
AS
BEGIN
	select * from GIANG_VIEN  
where MaGiangVien=@MaGV
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_GiangVien_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_GiangVien_InsertItem]
(
@MaGiangVien nvarchar(10),
@HoTenGiangVien nvarchar(Max),
@GioiTinh bit,
@SoDienThoai nvarchar(11),
@NoiSinh nvarchar(max),
@Email nvarchar(50),
@MaKhoa nvarchar(10),
@TrangThai nvarchar(50)
)
as
begin
insert into GIANG_VIEN values (@MaGiangVien,@HoTenGiangVien,@GioiTinh,@SoDienThoai,@NoiSinh,@Email,@MaKhoa,@TrangThai) 
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_GiangVien_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_GiangVien_UpdateItem]
(
@dk nvarchar(50),
@MaGiangVien nvarchar(10),
@HoTenGiangVien nvarchar(Max),
@GioiTinh bit,
@SoDienThoai nvarchar(11),
@NoiSinh nvarchar(max),
@Email nvarchar(50),
@MaKhoa nvarchar(10),
@TrangThai nvarchar(50)
)
as
begin
update  GIANG_VIEN set  MaGiangVien=@MaGiangVien,HoTenGiangVien=@HoTenGiangVien,GioiTinh=@GioiTinh,SoDienThoai=@SoDienThoai,NoiSinh= @NoiSinh,Email= @Email,MaKhoa=@MaKhoa,TrangThai=@TrangThai
where MaGiangVien=@dk

end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HeDaoTao_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[sp_qldsv_HeDaoTao_DeleteItem]
	(

@MaHeDaoTao nvarchar(50)

)
as
begin
	delete from HEDAOTAO where MaHeDaoTao = @MaHeDaoTao
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HeDaoTao_Get_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HeDaoTao_Get_dk]
	(
	@MaHeDaoTao nvarchar(50)
)
AS
BEGIN
	select * from HEDAOTAO where MaHeDaoTao=@MaHeDaoTao
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HeDaoTao_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HeDaoTao_GetAll]
	
AS
BEGIN
	select * from HEDAOTAO order by MaHeDaoTao ASC
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HeDaoTao_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HeDaoTao_InsertItem]
	(
	@MaHeDaoTao nvarchar(50),
	@TenHeDaoTao nvarchar(50)
  )
 as
  begin
	insert into HEDAOTAO values(@MaHeDaoTao,@TenHeDaoTao)
  end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HeDaoTao_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HeDaoTao_UpdateItem](
	@Dk nvarchar(50),
	@MaHeDaoTao nvarchar(10),
	@TenHeDaoTao nvarchar(50)
  )
  as
begin
	update HEDAOTAO set MaHeDaoTao = @MaHeDaoTao,TenHeDaoTao=@TenHeDaoTao where MaHeDaoTao = @Dk
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HocPhan_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HocPhan_DeleteItem](
	@MaHocPhan nvarchar(10)
)
as
delete HOC_PHAN where MaHocPhan = @MaHocPhan
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HocPhan_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HocPhan_GetAll]

AS
select * from HOC_PHAN
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HocPhan_GetAll_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HocPhan_GetAll_dk]
	(
	@MaHocPhan nvarchar(10)
)
AS
select * from HOC_PHAN where MaHocPhan = @MaHocPhan
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HocPhan_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HocPhan_InsertItem](
	@MaHocPhan nvarchar(10),
	@TenHocPhan nvarchar(200),
	@SoTinChi int,
	@PhongHoc nvarchar(10),
	@MaGiangVien nvarchar(10),
	@NamHoc int,
	@TenHocKy int,
	@SoTietHoc int		
)
as
insert into HOC_PHAN values(@MaHocPhan,@TenHocPhan,@SoTinChi,@PhongHoc,@MaGiangVien,@NamHoc,@TenHocKy,@SoTietHoc)
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_HocPhan_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_HocPhan_UpdateItem](
	@dk nvarchar(50),
	@MaHocPhan nvarchar(10),
	@TenHocPhan nvarchar(200),
	@SoTinChi int,
	@PhongHoc nvarchar(10),
	@MaGiangVien nvarchar(10),
	@NamHoc int,
	@TenHocKy int,
	@SoTietHoc int		
)
as
update HOC_PHAN set MaHocPhan=@MaHocPhan,TenHocPhan=@TenHocPhan,SoTinChi=@SoTinChi,PhongHoc=@PhongHoc,MaGiangVien=@MaGiangVien,NamHoc=@NamHoc,TenHocKy=@TenHocKy,SoTietHoc=@SoTietHoc where MaHocPhan=@dk
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Khoa_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Khoa_DeleteItem](
	@MaKhoa nvarchar(10)
)
as
begin
	delete from KHOA where MaKhoa = @MaKhoa
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Khoa_Get_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Khoa_Get_dk]
	(
	@MaKhoa nvarchar(10)
)
AS
BEGIN
	select * from KHOA where MaKhoa=@MaKhoa
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Khoa_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Khoa_GetAll]
	
AS
BEGIN
	select * from KHOA order by MaKhoa ASC
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Khoa_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Khoa_InsertItem](
	@MaKhoa nvarchar(10),
	@TenKhoa nvarchar(200)
  )
  as
  begin
	insert into KHOA values(@MaKhoa,@TenKhoa)
  end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Khoa_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Khoa_UpdateItem](
	@Dk nvarchar(50),
	@MaKhoa nvarchar(10),
	@TenKhoa nvarchar(200)
  )
  as
begin
	update KHOA set MaKhoa = @MaKhoa,TenKhoa=@TenKhoa where MaKhoa = @Dk
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Lop_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Lop_DeleteItem](
	@MaLop nvarchar(10)
)
as
begin
	Delete from LOP where MaLop = @MaLop
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Lop_Get_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Lop_Get_dk]
	(
@MaLop nvarchar(10)
)
AS
BEGIN
	select * from LOP where MaLop = @MaLop
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Lop_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Lop_GetAll]
	
AS
BEGIN
	select * from LOP
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Lop_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Lop_InsertItem](
	@MaLop nvarchar(10),
	@TenLop nvarchar(50),
	@MaKhoa nvarchar(10),
	@MaGiangVien nvarchar(10)
)
as
begin
	insert into LOP(MaLop,TenLop,MaKhoa,MaGiangVien)
	values (@MaLop,@TenLop,@MaKhoa,@MaGiangVien);
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Lop_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Lop_UpdateItem](
	@dk nvarchar(50),
	@MaLop nvarchar(10),
	@TenLop nvarchar(50),
	@MaKhoa nvarchar(10),
	@MaGiangVien nvarchar(10)
)
as
begin
	update LOP set MaLop = @MaLop, TenLop = @TenLop, MaKhoa = @MaKhoa, MaGiangVien = @MaGiangVien where MaLop = @dk
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_Search_HocPhan]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_Search_HocPhan](
	@parameter nvarchar(1000)
)
as
begin
select * from HOC_PHAN 
	where MaHocPhan like '%'+@parameter+'%' or TenHocPhan like '%'+@parameter+'%'
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_SinhVien_DeleteItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_SinhVien_DeleteItem](
	@MaSinhVien nvarchar(10)
)
as
delete SINH_VIEN where MaSinhVien = @MaSinhVien
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_SinhVien_GetAll]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_SinhVien_GetAll]
	
AS
begin
	select * from SINH_VIEN
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_SinhVien_GetAll_dk]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_SinhVien_GetAll_dk]
	(
	@MaSinhVien nvarchar(10)
)
AS
select * from SINH_VIEN where MaSinhVien = @MaSinhVien
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_SinhVien_InsertItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_SinhVien_InsertItem](
	@MaSinhVien nvarchar(10),
	@HoTenSinhVien nvarchar(50),
	@NgaySinh date,
	@GioiTinh bit,
	@MaLop nvarchar(10),
	@SoDienThoai nvarchar(11),
	@MatKhau nvarchar(50),
	@Email nvarchar(1000),
	@MaHeDaoTao nvarchar(50),
	@ThoiGianHoc nvarchar(2),
	@SoDienThoaiGiaDinh nvarchar(11),
	@HoTenBo nvarchar(50),
	@HoTenMe nvarchar(50),
	@NoiSinh nvarchar(150),
	@NgayNhapHoc date
)
as
insert into SINH_VIEN values(@MaSinhVien,@HoTenSinhVien,@NgaySinh,@GioiTinh,@MaLop,@SoDienThoai,@MatKhau,@Email,@MaHeDaoTao,@ThoiGianHoc,@SoDienThoaiGiaDinh,@HoTenBo,@HoTenMe,@NoiSinh,@NgayNhapHoc)
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_SinhVien_UpdateItem]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_SinhVien_UpdateItem](
	@dk nvarchar(50),
	@MaSinhVien nvarchar(10),
	@HoTenSinhVien nvarchar(50),
	@NgaySinh date,
	@GioiTinh bit,
	@MaLop nvarchar(10),
	@SoDienThoai nvarchar(11),
	@MatKhau nvarchar(50),
	@Email nvarchar(1000),
	@MaHeDaoTao nvarchar(50),
	@ThoiGianHoc nvarchar(2),
	@SoDienThoaiGiaDinh nvarchar(11),
	@HoTenBo nvarchar(50),
	@HoTenMe nvarchar(50),
	@NoiSinh nvarchar(150),
	@NgayNhapHoc date
)
as
update SINH_VIEN set MaSinhVien=@MaSinhVien,HoTenSinhVien=@HoTenSinhVien,NgaySinh=@NgaySinh,GioiTinh=@GioiTinh,MaLop=@MaLop,SoDienThoai=@SoDienThoai,MatKhau=@MatKhau,Email=@Email,MaHeDaoTao=@MaHeDaoTao,ThoiGianHoc=@ThoiGianHoc,SoDienThoaiGiaDinh=@SoDienThoaiGiaDinh,HoTenBo=@HoTenBo,HoTenMe=@HoTenMe,NoiSinh=@NoiSinh,NgayNhapHoc=@NgayNhapHoc where MaSinhVien=@dk
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_View_Diem_sv_MonHoc]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
-- =============================================
-- Author:		<Author,,Name>
-- Create date: <Create Date,,>
-- Description:	<Description,,>
-- =============================================
CREATE PROCEDURE [dbo].[sp_qldsv_View_Diem_sv_MonHoc]
	(
	@mahp nvarchar(10)
)
AS
BEGIN
	select * from view_qldsv_Diem where MaHocPhan = @mahp
END

GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_View_sv_lop]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_View_sv_lop](
	@malop nvarchar(10)
)
as
begin
	select * from view_qldsv_ThongTin where MaLop =@malop
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_View_ThongKe_CanhCao]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_View_ThongKe_CanhCao](
	@namhoc int,
	@hocky int
)
as
begin
	select MaLop,TenLop,MaSinhVien,HoTenSinhVien,DiemSo,dbo.fc_HinhThuc(DiemSo) as HinhThuc from view_qldsv_CanhCao
			where NamHoc = @namhoc and  TenHocKy = @hocky and DiemSo < 1.8
			order by MaLop
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_View_ThongKe_HocBong]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_View_ThongKe_HocBong](
	@dieukien real,
	@soluong int,
	@makhoa nvarchar(10),
	@namhoc int,
	@hocky int
)
as
begin
	select top (@soluong) MaSinhVien,HoTenSinhVien,DiemSo,dbo.fc_HinhThuc(DiemSo) as HinhThuc from view_qldsv_top_Diem
			where MaKhoa = @makhoa and NamHoc = @namhoc and  TenHocKy = @hocky and DiemSo >= @dieukien
			order by DiemSo desc
end
GO
/****** Object:  StoredProcedure [dbo].[sp_qldsv_View_Year]    Script Date: 7/7/2022 2:21:16 PM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO

CREATE PROCEDURE [dbo].[sp_qldsv_View_Year]
as
begin
	select distinct NamHoc from HOC_PHAN
end
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[28] 2[25] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "d"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 221
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hp"
            Begin Extent = 
               Top = 6
               Left = 259
               Bottom = 136
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 3
         End
         Begin Table = "l"
            Begin Extent = 
               Top = 6
               Left = 467
               Bottom = 136
               Right = 637
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sv"
            Begin Extent = 
               Top = 6
               Left = 675
               Bottom = 136
               Right = 873
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_CanhCao'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_CanhCao'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "DIEM"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 221
            End
            DisplayFlags = 280
            TopColumn = 5
         End
         Begin Table = "HOC_PHAN"
            Begin Extent = 
               Top = 6
               Left = 259
               Bottom = 136
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "SINH_VIEN"
            Begin Extent = 
               Top = 6
               Left = 467
               Bottom = 136
               Right = 665
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_Diem'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_Diem'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[40] 4[20] 2[20] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "LOP"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 208
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "SINH_VIEN"
            Begin Extent = 
               Top = 6
               Left = 246
               Bottom = 136
               Right = 444
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_ThongTin'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_ThongTin'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPane1', @value=N'[0E232FF0-B466-11cf-A24F-00AA00A3EFFF, 1.00]
Begin DesignProperties = 
   Begin PaneConfigurations = 
      Begin PaneConfiguration = 0
         NumPanes = 4
         Configuration = "(H (1[41] 4[21] 2[31] 3) )"
      End
      Begin PaneConfiguration = 1
         NumPanes = 3
         Configuration = "(H (1 [50] 4 [25] 3))"
      End
      Begin PaneConfiguration = 2
         NumPanes = 3
         Configuration = "(H (1 [50] 2 [25] 3))"
      End
      Begin PaneConfiguration = 3
         NumPanes = 3
         Configuration = "(H (4 [30] 2 [40] 3))"
      End
      Begin PaneConfiguration = 4
         NumPanes = 2
         Configuration = "(H (1 [56] 3))"
      End
      Begin PaneConfiguration = 5
         NumPanes = 2
         Configuration = "(H (2 [66] 3))"
      End
      Begin PaneConfiguration = 6
         NumPanes = 2
         Configuration = "(H (4 [50] 3))"
      End
      Begin PaneConfiguration = 7
         NumPanes = 1
         Configuration = "(V (3))"
      End
      Begin PaneConfiguration = 8
         NumPanes = 3
         Configuration = "(H (1[56] 4[18] 2) )"
      End
      Begin PaneConfiguration = 9
         NumPanes = 2
         Configuration = "(H (1 [75] 4))"
      End
      Begin PaneConfiguration = 10
         NumPanes = 2
         Configuration = "(H (1[66] 2) )"
      End
      Begin PaneConfiguration = 11
         NumPanes = 2
         Configuration = "(H (4 [60] 2))"
      End
      Begin PaneConfiguration = 12
         NumPanes = 1
         Configuration = "(H (1) )"
      End
      Begin PaneConfiguration = 13
         NumPanes = 1
         Configuration = "(V (4))"
      End
      Begin PaneConfiguration = 14
         NumPanes = 1
         Configuration = "(V (2))"
      End
      ActivePaneConfig = 0
   End
   Begin DiagramPane = 
      Begin Origin = 
         Top = 0
         Left = 0
      End
      Begin Tables = 
         Begin Table = "d"
            Begin Extent = 
               Top = 6
               Left = 38
               Bottom = 136
               Right = 221
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "hp"
            Begin Extent = 
               Top = 6
               Left = 259
               Bottom = 136
               Right = 429
            End
            DisplayFlags = 280
            TopColumn = 3
         End
         Begin Table = "l"
            Begin Extent = 
               Top = 6
               Left = 467
               Bottom = 136
               Right = 637
            End
            DisplayFlags = 280
            TopColumn = 0
         End
         Begin Table = "sv"
            Begin Extent = 
               Top = 6
               Left = 675
               Bottom = 136
               Right = 873
            End
            DisplayFlags = 280
            TopColumn = 0
         End
      End
   End
   Begin SQLPane = 
   End
   Begin DataPane = 
      Begin ParameterDefaults = ""
      End
   End
   Begin CriteriaPane = 
      Begin ColumnWidths = 11
         Column = 1440
         Alias = 900
         Table = 1170
         Output = 720
         Append = 1400
         NewValue = 1170
         SortType = 1350
         SortOrder = 1410
         GroupBy = 1350
         Filter = 1350
         Or = 1350
         Or = 1350
         Or = 1350
      End
   End
End
' , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_top_Diem'
GO
EXEC sys.sp_addextendedproperty @name=N'MS_DiagramPaneCount', @value=1 , @level0type=N'SCHEMA',@level0name=N'dbo', @level1type=N'VIEW',@level1name=N'view_qldsv_top_Diem'
GO
USE [master]
GO
ALTER DATABASE [QuanLySinhVien_Offcial] SET  READ_WRITE 
GO
