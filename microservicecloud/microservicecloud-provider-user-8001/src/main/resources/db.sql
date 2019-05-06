drop database if exists cloudDB;
create database cloudDB default character set utf8;
create table user(
	id bigint primary key auto_increment,
	uname varchar(20),
	password varchar(20),
	db_source varchar(20) 
);
insert into user values(null,'lv','1234',database());
