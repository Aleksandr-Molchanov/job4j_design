create table bodys(
    id serial primary key,
    name varchar(255)
);

create table engines(
    id serial primary key,
    name varchar(255)
);

create table transmissions(
    id serial primary key,
    name varchar(255)
);

create table cars(
    id serial primary key,
    name varchar(255),
	bodys_id int references bodys(id),
	engines_id int references engines(id),
	transmissions_id int references transmissions(id)
);

insert into bodys(name) values ('body1'), ('body2'), ('body3'), ('body4'), ('body5');
insert into engines(name) values ('engine1'), ('engine2'), ('engine3');
insert into transmissions(name) values ('transmission1'), ('transmission2');
insert into cars(name, bodys_id, engines_id, transmissions_id) 
values ('car1', 1, 1, 1), ('car2', 2, 2, 2);

--список всех машин и все привязанные к ним детали
select c.name, b.name, e.name, t.name from cars as c 
join bodys b on c.bodys_id = b.id
join engines e on c.engines_id = e.id
join transmissions t on c.transmissions_id = t.id;

--вывести отдельно детали (1 деталь - 1 запрос), которые не используются НИ в одной машине, кузова, двигатели, коробки передач
select b.name from bodys b left join cars c on b.id = c.bodys_id where c.bodys_id is null;
select e.name from engines e left join cars c on e.id = c.bodys_id where c.bodys_id is null;
select t.name from transmissions t left join cars c on t.id = c.bodys_id where c.bodys_id is null;