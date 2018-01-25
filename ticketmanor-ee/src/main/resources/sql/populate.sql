-- Populate Acts and Venues here, but not Events (which are date-dependant;
-- those are created by the FakeDataLoaderEjb

-- ACTS

insert into acts(id, title, type, year) values( -100, 'Star Wars Episode 15: The Next Jedi', 0, 2021);
insert into acts(id, title, type, year) values( -63, 'Elton John', 2, 0);
insert into acts(id, title, type, year) values( -62, 'Tom Petty', 2, 0);
insert into acts(id, title, type, year) values( -61, 'Neil Diamond', 2, 0);
insert into acts(id, title, type, year) values( -60, 'Sun Never Sets: The Musical', 2, 0);
insert into acts(id, title, type, year) values( -54, 'Real Madrid vs Barcelona', 3, 0);
insert into acts(id, title, type, year) values( -53, 'Blackhawks vs Canucks', 3, 0);
insert into acts(id, title, type, year) values( -52, 'Red Sox vs Maple Leafs', 3, 0);
insert into acts(id, title, type, year) values( -51, 'Blue Jays vs Mets', 3, 0);
insert into acts(id, title, type, year) values( -50, 'Nicks vs Raptors', 3, 0);
insert into acts(id, title, type, year) values( -49, 'Bruce Springsteen', 2, 0);
insert into acts(id, title, type, year) values( -43, 'Bob Sieger', 2, 0);
insert into acts(id, title, type, year) values( -42, 'Coldplay', 2, 0);
insert into acts(id, title, type, year) values( -41, 'AC/DC', 2, 0);
insert into acts(id, title, type, year) values( -39, 'Metallica', 2, 0);
insert into acts(id, title, type, year) values( -38, 'One Direction', 2, 0);
insert into acts(id, title, type, year) values( -37, 'Luke Bryan', 2, 0);
insert into acts(id, title, type, year) values( -36, 'Lana Del Rey', 2, 0);
insert into acts(id, title, type, year) values( -35, 'Kenny Chesney', 2, 0);
insert into acts(id, title, type, year) values( -34, 'Houston Rodeo', 2, 0);
insert into acts(id, title, type, year) values( -33, 'Garth Brooks', 2, 0);
insert into acts(id, title, type, year) values( -32, 'Foo Fighters', 2, 0);
insert into acts(id, title, type, year) values( -31, 'Fleetwood Mac', 2, 0);
insert into acts(id, title, type, year) values( -30, 'Bob Seger', 2, 0);
insert into acts(id, title, type, year) values( -29, 'Billy Joel', 2, 0);
insert into acts(id, title, type, year) values( -28, 'Bette Midler', 2, 0);
insert into acts(id, title, type, year) values( -27, 'Ariana Grande', 2, 0);
insert into acts(id, title, type, year) values( -26, 'Wynonna Judd', 2, 0);
insert into acts(id, title, type, year) values( -25, 'U2', 2, 0);
insert into acts(id, title, type, year) values( -24, 'Toronto Symphony Orchestra', 2, 0);
insert into acts(id, title, type, year) values( -23, 'The Who', 2, 0);
insert into acts(id, title, type, year) values( -22, 'The Twinkies', 2, 0);
insert into acts(id, title, type, year) values( -21, 'The Script', 2, 0);
insert into acts(id, title, type, year) values( -20, 'The Eagles', 2, 0);
insert into acts(id, title, type, year) values( -19, 'The Clash', 2, 0);
insert into acts(id, title, type, year) values( -18, 'Taylor Swift', 2, 0);
insert into acts(id, title, type, year) values( -17, 'Rod Stewart', 2, 0);
insert into acts(id, title, type, year) values( -16, 'Neil Young', 2, 0);
insert into acts(id, title, type, year) values( -15, 'Meghan Trainor', 2, 0);
insert into acts(id, title, type, year) values( -14, 'Maroon 5', 2, 0);
insert into acts(id, title, type, year) values( -13, 'Los Angeles Philharmonic', 2, 0);
insert into acts(id, title, type, year) values( -12, 'London Symphony', 2, 0);
insert into acts(id, title, type, year) values( -11, 'Leonard Cohen', 2, 0);
insert into acts(id, title, type, year) values( -10, 'Lady Gaga', 2, 0);
insert into acts(id, title, type, year) values( -9, 'Kenny Chesney', 2, 0);
insert into acts(id, title, type, year) values( -8, 'Justin Bieber', 2, 0);
insert into acts(id, title, type, year) values( -7, 'Garth Brooks', 2, 0);
insert into acts(id, title, type, year) values( -6, 'Foo Fighters', 2, 0);
insert into acts(id, title, type, year) values( -5, 'Eric Clapton', 2, 0);
insert into acts(id, title, type, year) values( -4, 'Eddie Money', 2, 0);
insert into acts(id, title, type, year) values( -3, 'Boston Pops', 2, 0);
insert into acts(id, title, type, year) values( -2, 'Beach Boys', 2, 0);
insert into acts(id, title, type, year) values( -1, 'Rush', 2, 1980);
insert into acts(id, title, type, year) values( 1, 'Act One', 2, 2018);

-- VENUES

insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 6, 'Flippingdon', null, null, null, 'United Centre', null, null);
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 7, 'London', 'UK', null, null, 'London Palladium', null, null);
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 1, 'New York', 'US', 40.764938, -73.979897, 'Carnegie Hall', 'NY', '881 Seventh Avenue');
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 4, 'San Francisco', 'US', null, null, 'Candlestick Park', null, null);
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 2, 'Toronto', 'CA', 43.646596, -79.386413, 'Roy Thompson Hall', 'ON', '60 Simcoe Street');
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 5, 'Toronto', 'CA', null, null, 'Maple Leaf Gardens', null, null);
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 3, 'Toronto', 'CA', null, null, 'Rogers Stadium', null, null);
insert into venues(id, city, country, lat, lng, name, provstate, streetaddress) values ( 8, 'Toronto', 'CA', null, null, 'Air Canada Centre', null, null);
