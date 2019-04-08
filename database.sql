

create database faza1;
use faza1;

CREATE TABLE Hotel(
HotelID varchar(20) not null,
EmployeeID varchar(20)  not null,
HotelName text  not null, 
Location text  not null, 
RoomsNO integer  not null,
PRIMARY KEY (HotelID)
);

CREATE TABLE Employees(
EmployeeID varchar(20) not null, 
Name varchar(20) not null, 
LastName varchar(20) not null, 
Phone varchar(20) not null, 
JobTime text not null,
PRIMARY KEY (EmployeeID)
);

Create Table Reservation (
ReservationID varchar(10),
GuestID varchar(10),
HotelID varchar(10),
Available text,
RoomID varchar(10),
PRIMARY KEY (ReservationID),
FOREIGN KEY (GuestID) REFERENCES Guest (GuestID) ,
FOREIGN KEY (HotelID) REFERENCES Hotel (HotelID) ,
FOREIGN KEY (RoomID) REFERENCES Room (RoomID) 
);


CREATE TABLE Room(
RoomID varchar(20) NOT NULL,
RoomType varchar (20) NOT NULL,
GuestID varchar (20) NOT NULL,
ReservationID varchar (20) NOT NULL,
CheckInDate date NOT NULL,
CheckOutDate date NOT NULL,
PRIMARY KEY (RoomID),
FOREIGN KEY (GuestID) REFERENCES Guest (GuestID),
FOREIGN KEY (ReservationID) REFERENCES Reservation(ReservationID)
);

CREATE TABLE GUEST(
GuestID varchar(10),
ReservationID varchar(10),
Name text,
LastName text,
Phone varchar(50),
Address text,
Room int,
No_OfAdults int,
No_OfChildren int,
primary key (GuestID),
foreign key (ReservationID) references Reservation (ReservationID)
);

CREATE TABLE Invoice(
InvoiceID varchar (20) NOT NULL,
GuestID varchar (20) NOT NULL,
Amount varchar (30) NOT NULL,
Date date NOT NULL,
PayingMethod varchar(30) NOT NULL,
PRIMARY KEY (InvoiceID),
FOREIGN KEY (GuestID) REFERENCES Guest (GuestID)
);
