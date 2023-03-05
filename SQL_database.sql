IF NOT EXISTS(SELECT * FROM sys.databases WHERE name = 'dbstore')
  BEGIN
    CREATE DATABASE dbstore;

    END
	go
use dbstore;

drop table facture;
drop table users;
drop table address;


create table address (
id 			int		 		NOT NULL constraint pk2_id primary key identity(1,1),
country 	varchar(255)	NOT NULL,
province	varchar(255)	NOT NULL,
city		varchar(255)	NOT NULL,
street		varchar(255),
house_no	varchar(20)		NOT NULL,
flat_no		varchar(20)
);


create table users (
id 			int				NOT NULL constraint pk1_id primary key identity(1,1),
name		varchar(255)	NOT NULL,
lastname 	varchar(255)	NOT NULL,
username 	varchar(255)	NOT NULL,
password 	varchar(255)	NOT NULL,
enabled 	bit				NOT NULL,
addressId	int				NOT NULL
);

ALTER TABLE users
ADD FOREIGN KEY (addressId) REFERENCES address(id);

create table facture (
id 				int				NOT NULL constraint pk3_id primary key identity(1,1),
title	 		varchar(255)	NOT NULL,
orderDate	 	date			NOT NULL,
repDate 		date			NOT NULL,
total	 		decimal(8,2)	NOT NULL,
userId			int				NOT NULL
);

ALTER TABLE facture
ADD FOREIGN KEY (userId) REFERENCES users(id);


insert into address(country, province, city, street, house_no, flat_no)
values ('Polska', 'ma³opolskie', 'Kraków', 'Wiœlana', '11', '4'),
('Polska', 'mazowiecie', 'Warszawa', '1 maja', '12', '3A'),
('Polska', 'ma³opolskie', 'Kraków', 'Rynek', '12', '2A'),
('Polska', 'wielkopolskie', 'Poznañ', 'Szewska', '4', '12');

insert into users(name, lastname, username, password, enabled, addressId)
values ('Jan', 'Kowalski', 'jan99', 'jan99', 1, 1),
('Maria', 'Nowak', 'maria99', 'maria99', 1, 2),
('Marian', 'Wolski', 'marian99', 'marian99', 1, 3),
('Anna', 'Smokowska', 'anna99', 'anna9', 1, 4);


insert into facture(title, orderDate, repDate, total, userId)
values ('Fa11/123', '2023-02-23', '2023-03-23', 3999.99, 1),
('Fa14/9999', '2023-02-01', '2023-03-01', 99.99, 1),
('Fa85/4232', '2023-01-02', '2023-02-02', 854.62, 2),
('Fa11/321', '2023-02-26', '2023-03-26', 1112.00, 4),
('Fa68/461', '2023-02-26', '2023-03-26', 689.99, 3),
('Fa77/789', '2023-02-16', '2023-03-16', 1876.89, 3);


