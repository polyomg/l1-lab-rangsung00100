USE MASTER
GO
CREATE DATABASE J5Shop
GO
USE J5Shop
GO
CREATE TABLE Categories(
	ID CHAR(4) PRIMARY KEY, 
	Name NVARCHAR(50), 
);
GO
CREATE TABLE Products(
	ID INT IDENTITY(1,1) PRIMARY KEY, 
	Name NVARCHAR(50), 
	Image NVARCHAR(50), 
	Price FLOAT,
	Create_Date DATE,
	Available BIT,
	CateloryID CHAR(4) REFERENCES Categories(ID),
);
GO
CREATE TABLE Account(
	Username NVARCHAR(50) PRIMARY KEY,
	Password NVARCHAR(50),
	Fullname NVARCHAR(50),
	Email NVARCHAR(50),
	Photo NVARCHAR(50),
	Activated BIT,
	Admin BIT
);
GO
CREATE TABLE Orders(
	ID BIGINT IDENTITY(100,1) PRIMARY KEY,
	Username NVARCHAR(50)  REFERENCES Account(Username),
	CreateDate DATETIME,
	Address NVARCHAR(100)
);
GO
CREATE TABLE OrdersDetails(
	ID BIGINT IDENTITY(1000,1) PRIMARY KEY,
	OrderID BIGINT REFERENCES Orders(ID),
	Products INT REFERENCES Products(ID),
	Price FLOAT,
	Quanlity INT
);
GO
INSERT INTO Categories (ID, Name)
VALUES 
('C001', N'Son môi'),
('C002', N'Trang điểm'),
('C003', N'Dưỡng da'),
('C004', N'Mắt & Mascara'),
('C005', N'Dụng cụ trang điểm');
GO
INSERT INTO Products (Name, Image, Price, Create_Date, Available, CateloryID)
VALUES
('Son môi đỏ', 'son_do.jpg', 199000, '2024-01-10', 1, 'C001'),
('Son môi hồng', 'son_hong.jpg', 209000, '2024-01-15', 1, 'C001'),
('Son dưỡng môi', 'son_duong.jpg', 150000, '2024-02-01', 1, 'C001'),
('Kem nền cao cấp', 'kem_nen.jpg', 350000, '2024-01-20', 1, 'C002'),
('Kem dưỡng trắng', 'kem_duong_trang.jpg', 499000, '2024-01-22', 1, 'C002'),
('Sữa rửa mặt', 'sua_rua_mat.jpg', 259000, '2024-02-05', 1, 'C003'),
('Toner dưỡng da', 'toner.jpg', 199000, '2024-02-08', 1, 'C003'),
('Mặt nạ dưỡng ẩm', 'mat_na.jpg', 129000, '2024-01-25', 1, 'C003'),
('Phấn phủ kiềm dầu', 'phan_phu.jpg', 299000, '2024-02-10', 1, 'C002'),
('Mascara chống thấm nước', 'mascara.jpg', 189000, '2024-01-18', 1, 'C004'),
('Chì kẻ mắt', 'chi_ke_mat.jpg', 99000, '2024-02-12', 1, 'C004'),
('Son kem lì', 'son_kem.jpg', 220000, '2024-02-15', 1, 'C001'),
('Serum dưỡng da', 'serum.jpg', 599000, '2024-01-28', 1, 'C002'),
('Kem chống nắng', 'kem_chong_nang.jpg', 330000, '2024-02-02', 1, 'C003'),
('Bộ cọ trang điểm', 'bo_co.jpg', 450000, '2024-01-30', 1, 'C005'),
('Phấn má hồng', 'phan_ma.jpg', 175000, '2024-02-14', 1, 'C002'),
('Sáp tẩy trang', 'tay_trang.jpg', 279000, '2024-01-26', 1, 'C003'),
('Gel rửa mặt nam', 'gel_nam.jpg', 199000, '2024-02-07', 1, 'C003'),
('Nước hoa hồng', 'nuoc_hoa_hong.jpg', 249000, '2024-02-09', 1, 'C003'),
('Bộ dưỡng da ban đêm', 'bo_duong_da.jpg', 799000, '2024-02-11', 1, 'C002');

