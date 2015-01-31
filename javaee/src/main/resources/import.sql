-- import.sql for TicketManor project

insert into venues(id, name, streetAddress, city, provState, country, lat, lng) values(1, 'Carnegie Hall', '881 Seventh Avenue', 'New York', 'NY', 'US', 40.764938, -73.979897);
insert into venues(id, name, streetAddress, city, provState, country, lat, lng) values(2, 'Roy Thompson Hall', '60 Simcoe Street', 'Toronto', 'ON', 'CA', 43.646596, -79.386413);

insert into acts(id, title, year) values(-1, 'Rush', 1980);
insert into acts(id, title, year) values(-2, 'Foo Fish', 2020);

insert into acts (id, title, type, year) values (-3, 'Star Wars Bloopers', 0, 2001);
insert into movies (id, director) values (-3, 'George Lucas');

-- ert into events (id, what_id, date_time, where_id) values (-1, -3, '2016-06-22 14:00:00', null);
insert into events (id, what_id, date_time, where_id) values (-1, -3, null, null);

insert into people(id, firstName, lastName) values(-1, 'System', 'Administrator');
insert into members(id) values(-1);


