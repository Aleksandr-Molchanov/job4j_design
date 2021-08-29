create table person(
	id serial primary key,
	name text,
	age smallint,
	weight double precision
);
insert into person(name, age, weight) values('Александр', 33, 65.5);
select * from person;
update person set weight = 66.5;
select * from person;
delete from person;
select * from person;