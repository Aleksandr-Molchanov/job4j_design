 create table drivers(
     id serial primary key,
     name varchar(255)
 );
 
 create table category(
     id serial primary key,
     name varchar(255)
 );
 
 create table drivers_category(
     id serial primary key,
     drivers_id int references drivers(id),
     category_id int references category(id)
 );
 
insert into drivers(name) values ('Ivan');
insert into drivers(name) values ('Kirill');
insert into drivers(name) values ('Roman');

insert into category(name) values ('A');
insert into category(name) values ('B');
insert into category(name) values ('C');

insert into drivers_category(drivers_id, category_id) values (1, 2);
insert into drivers_category(drivers_id, category_id) values (1, 3);
insert into drivers_category(drivers_id, category_id) values (2, 2);
insert into drivers_category(drivers_id, category_id) values (3, 1);
insert into drivers_category(drivers_id, category_id) values (3, 2);
insert into drivers_category(drivers_id, category_id) values (3, 3);