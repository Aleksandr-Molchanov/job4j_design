CREATE TABLE company
(
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);

CREATE TABLE person
(
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company (id, name) values (1, 'a'), (2, 'b'), (3, 'c'), (4, 'd'), (5, 'e');
insert into person (id, name, company_id) values (1, 'olya', 1), (2, 'vasya', 1), (3, 'vika', 2), (4, 'igor', 3), (5, 'lena', 4), (6, 'sasha', 5);

--имена всех person, которые не состоят в компании с id = 5 и название компании для каждого человека
select p.name, c.name from person as p
join company c on p.company_id = c.id where p.company_id = 5;

--выбрать название компании с максимальным количеством человек + количество человек в этой компании
select c.name, count(c.id) from person as p
join company c on p.company_id = c.id
group by c.name
order by count(c.id) DESC
limit 1;