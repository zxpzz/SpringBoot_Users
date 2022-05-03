drop table if exists users;
create table users(id int auto_increment primary key ,uname varchar(20),password varchar(10),age int);


insert into users(uname, password, age) values ('zxp','1234',100);
insert into users(uname, password, age) values ('zz','123',20);



select*from users