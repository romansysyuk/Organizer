drop database if exists `organizer`;
create database `organizer`;

use `organizer`;

drop table if exists `user_info`;
create table `user_info`(
	`user_info_id` int(10) not null auto_increment primary key,
	`first_name` varchar(50) not null,
	`last_name` varchar(50) not null,
	`birthday` date not null,
	`email` varchar(70) not null,
	`username` varchar(20) not null,
	unique key `uni_user_info_username` (username)
);

insert into `user_info` (first_name, last_name, birthday, email, username) values ('Petro','Petro','1991-07-10','matyashps@gmail.com','petro');

drop table if exists `users`;
CREATE  TABLE `users` (
	`user_id` int(10) not null auto_increment,
  `username` VARCHAR(45) NOT NULL primary key,
  `password` VARCHAR(60) NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  UNIQUE KEY `uni_users_username` (user_id)
  );
  
  INSERT INTO `users`(username, password, enabled)
VALUES ('petro','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
  

drop table if exists `user_roles`;
CREATE TABLE `user_roles` (
  `user_role_id` INT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(20) NOT NULL,
  `role` VARCHAR(20) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY `uni_username_role` (role, username),
  KEY `fk_username_idx` (username),
  CONSTRAINT `fk_username` FOREIGN KEY (username) REFERENCES `users` (username));

  insert into `user_roles` values (1,'petro','ROLE_SUPERADMIN');
  insert into `user_roles` values (2,'petro','ROLE_ADMIN');
  insert into `user_roles` values (3,'petro','ROLE_USER');
  
drop table if exists `event`;
create table `event`(
	`eventId` int(10) not null auto_increment primary key,
	`eventDate` date not null,
	`eventName` varchar(50) not null,
	`description` varchar(1000),
	`personLogin` varchar(20) not null
);