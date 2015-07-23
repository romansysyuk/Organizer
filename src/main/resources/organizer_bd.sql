drop database if exists `organizer`;
create database `organizer`;

use `organizer`;

drop table if exists `person`;
create table `person`(
	`personId` int(10) not null auto_increment primary key,
	`firstName` varchar(20) not null,
	`lastName` varchar(30) not null,
	`birthday` date not null,
	`email` varchar(70) not null,
	`login` varchar(20) not null,
	`password` varchar(30) not null
);

insert into `person` values (1,'Petro','Petro','1991-07-10','matyashps@gmail.com','matyashps','matyashgtnhj');

drop table if exists `personrole`;
create table `personrole`(
	`roleName` varchar(20) not null,
	`login` varchar(20) not null
);

insert into `personrole` values ('ROLE_ADMIN', 1);

drop table if exists `event`;
create table `event`(
	`eventId` int(10) not null auto_increment primary key,
	`eventDate` date not null,
	`eventName` varchar(50) not null,
	`description` varchar(1000)
);