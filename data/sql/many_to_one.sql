create table sex(
    id serial primary key,
    name varchar(255)
);

create table people(
    id serial primary key,
    name varchar(255),
    position_id int references sex(id)
);

insert into sex(name) values ('men');
insert into sex(name) values ('women');
insert into people(name, sex_id) VALUES ('Ivan', 1);
insert into people(name, sex_id) VALUES ('Olya', 2);
insert into people(name, sex_id) VALUES ('Vika', 2);

select * from people;

select * from sex where id in (select id from people);