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

insert into `person` values (1,'Petro','Petro','1991-07-10','matyashps@gmail.com','111','111');

drop table if exists `roles`;
CREATE TABLE `roles` (
  `role_id` INT(11) NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(20) NOT NULL,
  `role` enum ('SUPERADMIN','ADMIN','USER') DEFAULT 'USER',
  PRIMARY KEY (role_id),
  UNIQUE KEY uni_login_role (role, login),
  KEY fk_login_idx (login),
  CONSTRAINT fk_login FOREIGN KEY (login) REFERENCES person (login)
  );

  insert into `roles` values (1,'111','SUPERADMIN');
  
drop table if exists `event`;
create table `event`(
	`eventId` int(10) not null auto_increment primary key,
	`eventDate` date not null,
	`eventName` varchar(50) not null,
	`description` varchar(1000),
	`personLogin` varchar(20) not null
);