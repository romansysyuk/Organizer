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
	`username` varchar(45) not null,
	unique key `uni_user_info_username` (username)
);
insert into `user_info` (first_name, last_name, birthday, email, username) values ('Petro1','Petro1','1991-07-10','matyashps1@gmail.com','petro1');
insert into `user_info` (first_name, last_name, birthday, email, username) values ('Petro2','Petro2','1991-07-10','matyashps2@gmail.com','petro2');


drop table if exists `users`;
CREATE  TABLE `users` (
	`user_id` int(10) not null auto_increment,
  `username` VARCHAR(45) NOT NULL primary key,
  `password` VARCHAR(60) NOT NULL ,
  `enabled` TINYINT NOT NULL DEFAULT 1,
  UNIQUE KEY `uni_users_username` (user_id)
  );  
  INSERT INTO `users`(username, password, enabled) VALUES ('petro1','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
  INSERT INTO `users`(username, password, enabled) VALUES ('petro2','$2a$10$04TVADrR6/SPLBjsK0N30.Jf5fNjBugSACeGv1S69dZALR7lSov0y', true);
  

drop table if exists `user_roles`;
CREATE TABLE `user_roles` (
  `user_role_id` INT(10) NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `role` VARCHAR(20) NOT NULL default 'ROLE_USER',
  PRIMARY KEY (user_role_id),
  UNIQUE KEY `uni_username_role` (role, username),
  KEY `fk_username_idx` (username),
  CONSTRAINT `fk_username` FOREIGN KEY (username) REFERENCES `users` (username));
  insert into `user_roles` values (1,'petro1','ROLE_SUPERADMIN');
  insert into `user_roles` values (2,'petro1','ROLE_ADMIN');
  insert into `user_roles` values (3,'petro1','ROLE_USER');
  insert into `user_roles` values (4,'petro2','ROLE_USER');
  

drop table if exists `event`;
create table `event`(
	`eventId` int(10) not null auto_increment primary key,
	`eventDate` date not null,
	`eventName` varchar(50) not null,
	`description` varchar(1000),
	`username` varchar(45) not null,
	constraint `fk_event_username` foreign key (username) references `users` (username)
);

insert into `event` (eventDate, eventName, description, username) values ('2015-07-01', 'event1', 'petro1 event1 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-02', 'event2', 'petro1 event2 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-03', 'event3', 'petro1 event3 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-04', 'event4', 'petro1 event4 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-05', 'event5', 'petro1 event5 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-06', 'event6', 'petro1 event6 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-07', 'event7', 'petro1 event7 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-08', 'event8', 'petro1 event8 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-09', 'event9', 'petro1 event9 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-10', 'event10', 'petro1 event10 description', 'petro1');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-11', 'event1', 'petro2 event1 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-12', 'event2', 'petro2 event2 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-13', 'event3', 'petro2 event3 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-14', 'event4', 'petro2 event4 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-15', 'event5', 'petro2 event5 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-16', 'event6', 'petro2 event6 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-17', 'event7', 'petro2 event7 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-18', 'event8', 'petro2 event8 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-19', 'event9', 'petro2 event9 description', 'petro2');
insert into `event` (eventDate, eventName, description, username) values ('2015-07-20', 'event10', 'petro2 event10 description', 'petro2');
