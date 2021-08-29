create table cars(
    id serial primary key,
	name varchar(255)
);

create table serial_number(
    id serial primary key,
	number int
);

create table cars_serial_number(
    id serial primary key,
    cars_id int references cars(id) unique,
    serial_number_id int references serial_number(id) unique
);

insert into cars(name) values ('Car1');
insert into cars(name) values ('Car2');

insert into serial_number(number) values (111111);
insert into serial_number(number) values (222222);

insert into cars_serial_number(cars_id, serial_number_id) values (1, 1);
insert into cars_serial_number(cars_id, serial_number_id) values (2, 2);