insert into role(name) values ('Пользователь');
insert into role(name) values ('Администратор');
insert into role(name) values ('Разработчик');

insert into users(name, role_id) VALUES ('Ivan', 1);
insert into users(name, role_id) VALUES ('Petr', 3);
insert into users(name, role_id) VALUES ('Olya', 2);

insert into rules(name) values ('enable');
insert into rules(name) values ('admin');
insert into rules(name) values ('root');

insert into role_rules(role_id, rules_id) values (1, 1);
insert into role_rules(role_id, rules_id) values (2, 2);
insert into role_rules(role_id, rules_id) values (3, 3);

insert into category(name) values ('Срочная');
insert into category(name) values ('В порядке очереди');

insert into state(name) values ('Новая');
insert into state(name) values ('В процессе');
insert into state(name) values ('Выполнена');

insert into item(users_id, category_id, state_id) values (1, 2, 1);
insert into item(users_id, category_id, state_id) values (2, 1, 3);
insert into item(users_id, category_id, state_id) values (3, 1, 2);

insert into comments(name, item_id) VALUES ('aaa', 1);
insert into comments(name, item_id) VALUES ('bbb', 1);
insert into comments(name, item_id) VALUES ('ccc', 3);

insert into attachs(name, item_id) VALUES ('C\progect\data\abc.png', 1);