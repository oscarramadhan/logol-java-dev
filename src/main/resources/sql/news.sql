create database logol_oscar;

create table logol_oscar.news (
	id varchar(32) primary key,
	title varchar(32) not null,
	description text null,
	created_at datetime not null
);