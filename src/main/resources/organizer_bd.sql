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
	`password` varchar(30) not null,
);

drop table if exists `event`;
create table `event`(
	`eventId` int(10) not null auto_increment primary key,
	`eventDate` date not null,
	`eventName` varchar(50) not null,
	`personId` int(10) not null,
	`clasterId` int(10),
	`description` varchar(1000),
);