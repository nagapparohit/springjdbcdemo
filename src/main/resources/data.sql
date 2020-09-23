/*create table person (
id integer not null,
name varchar(255) not null,
location varchar(255),
birth_date timestamp,
primary key(id)
);*/

insert into person(id,name,location,birth_date)
values(10001,'ranga','syndey',sysdate());
insert into person(id,name,location,birth_date)
values(10002,'amit','punjab',sysdate());
insert into person(id,name,location,birth_date)
values(10003,'peter','england',sysdate());