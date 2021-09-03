create table departments(
    id serial primary key,
    name varchar(255)
);

create table emploees(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

insert into departments(name) values ('Деп. управления персоналом');
insert into departments(name) values ('Деп. эксплуатации');
insert into departments(name) values ('Деп. развития');

insert into emploees(name, departments_id) values ('Иванов', 1);
insert into emploees(name, departments_id) values ('Петров', 2);
insert into emploees(name, departments_id) values ('Сидоров', 1);
insert into emploees(name, departments_id) values ('Федоров', null);
insert into emploees(name, departments_id) values ('Ионов', null);
insert into emploees(name, departments_id) values ('Гончаров', 1);

select d.name from departments d left join emploees e on d.id = e.departments_id where e.id is null;

select * from emploees e left join departments d on e.departments_id = d.id;
select * from departments d right join emploees e on e.departments_id = d.id;

select * from departments d left join emploees e on d.id = e.departments_id;
select * from emploees e right join departments d on e.departments_id = d.id;

select * from emploees e cross join departments d;

create table teens(
    name varchar(255),
	gender varchar(255)
);

insert into teens(name, gender) values ('Оля', 'Женский');
insert into teens(name, gender) values ('Вася', 'Мужской');
insert into teens(name, gender) values ('Вика', 'Женский');
insert into teens(name, gender) values ('Коля', 'Мужской');

select * from teens a cross join teens b where a.gender != b.gender;