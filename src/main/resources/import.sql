-- import.sql for TicketManor project

insert into venues(id, name) values(-1, 'Carnegie Hall');

insert into acts(id, title, year) values(-1, 'Rush', 1980);
insert into Acts(id, title, year) values(-2, 'Foo Fish', 2020);

insert into Acts (id, title, type, year) values (-3, 'Star Wars Bloopers', 0, 2001);
insert into Movie (id, director) values (-3, 'George Lucas');

insert into Events (id, what_id, date_time, where_id) values (-1, -3, '2016-06-22T14:00', null);

insert into people(id, firstName, lastName) values(-1, 'System', 'Administrator');
insert into members(id) values(-1);


