create database project305;
use project305;
create table emp_details(
	id int not null ,
	name varchar(255) not null,
    primary key (id),
    password varchar(255) not null,
    leaves int,
    duty int,
    reqDuty int,
    reqLeave int
    ) 
    
    select * from emp_details;

    create table mang_details(
	id int not null ,
	name varchar(255) not null,
    primary key (id),
    password varchar(255) not null,
    leaves int,
    duty int
    ) 
    
    select * from mang_details;
    
    create table places(
    id int not null primary key ,
    name char(1) not null,
    status int
    )
    
    select * from places;
    
    
    create table schedule(
    id int primary key not null auto_increment,
    emp_id int,
   foreign key (emp_id) references emp_details(id),
   date date,
   place char(1),
   start time,
   end time
    );
    
    ALTER TABLE schedule AUTO_INCREMENT=100;
     select * from schedule;
    
  