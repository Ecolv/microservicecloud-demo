drop database if exists cloudDB3;
create database cloudDB3 default character set utf8;
use cloudDB3;
create table user(
	id bigint primary key auto_increment,
	uname varchar(20),
	password varchar(20),
	db_source varchar(20) 
);
insert into user values(null,'li','1234',database());
