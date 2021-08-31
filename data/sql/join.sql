create table sex(
    id serial primary key,
    name varchar(255)
);

create table people(
    id serial primary key,
    name varchar(255),
    sex_id int references sex(id)
);

insert into sex(name) values ('men');
insert into sex(name) values ('women');
insert into people(name, sex_id) VALUES ('Ivan', 1);
insert into people(name, sex_id) VALUES ('Olya', 2);
insert into people(name, sex_id) VALUES ('Vika', 2);

select pp.name, s.name from people as pp join sex as s on pp.sex_id = s.id;
select pp.name as Имя, s.name as Пол from people as pp join sex as s on pp.sex_id = s.id;
select pp.name as Имя, s.name as Пол from people as pp join sex as s on pp.sex_id = s.id where sex_id = 1;