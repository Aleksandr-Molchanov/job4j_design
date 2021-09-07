create table type(
    id serial primary key,
    name varchar(255)
);

create table product(
    id serial primary key,
    name varchar(255),
	type_id int references type(id),
    expired_date date,
	price float
);

insert into type(name) values ('Сыр'), ('Молоко'), ('Мороженое');
insert into product(name, type_id, expired_date, price) 
values ('Сыр Моцарелла', 1, date '08-Jan-2021', 500.00), 
('Сыр Плавленный', 1, date '08-Jan-2022', 200.00),
('Молоко Веселый молочник', 2, date '08-Jan-2022', 50.00),
('Молоко Домик в деревне', 2, date '08-Jan-2021', 50.00),
('Мороженое 48 копеек', 3, date '08-Jan-2022', 60.00),
('Мороженое Золотой слиток', 3, date '08-Jan-2022', 60.00);

select * from product as p
join type t on p.type_id = t.id
where t.name = 'Сыр';

select * from product where name like '%Мороженое%';

select * from product where expired_date < current_date;

select name, price from product where price = (select max(price) from product);

select t.name, count(p.name) from product as p
join type t on p.type_id = t.id
group by t.name;

select p.name, t.name, p.expired_date, p.price from product as p
join type t on p.type_id = t.id
where t.name = 'Сыр' or t.name = 'Молоко';

select t.name from product as p
join type t on p.type_id = t.id
group by t.name
having count(p.name) < 10;

select p.name, p.expired_date, p.price, t.name from product as p
join type t on p.type_id = t.id 
group by p.name, p.expired_date, p.price, t.name