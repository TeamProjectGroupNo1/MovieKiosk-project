CREATE TABLE movie_ticket(
   id varchar2(10) NOT NULL,
   movie_name varchar2(30) NOT NULL,
   place varchar2(10) NOT NULL,
   ticket_date varchar2(10) NOT NULL,
   start_time varchar2(10) NOT NULL,
   end_time varchar2(10) NOT NULL,
   type_cnt varchar2(30) NOT NULL,
   seat varchar2(50) NOT NULL
);
select * from movie_ticket order by id;
select * from movie_ticket order by ticket_date, start_time;
delete from movie_ticket where id = 'Mary' and movie_name = 'Soul';
select count (*) from movie_ticket where id = 'Henry';
select * from movie_ticket where id = 'Henry';
select * from movie_ticket where id = 'Henry' 
                                and ( ticket_date > to_char(SYSDATE, 'YYYY-MM-DD')
                                or ( ticket_date = to_char(SYSDATE, 'YYYY-MM-DD') 
                                and END_TIME > to_char(SYSDATE, 'HH:MM') ) ) 
                                order by ticket_date, start_time;
select * from movie_ticket where id = 'Henry' 
                                and (ticket_date < to_char(SYSDATE, 'YYYY-MM-DD') 
                                or ( ticket_date = to_char(SYSDATE, 'YYYY-MM-DD')
                                and END_TIME < to_char(SYSDATE, 'HH:MM'))) 
                                order by ticket_date DESC, start_time DESC;

insert into movie_ticket values('Henry', 'Avengers_01', '1관', '2012-05-01', '20:05', '23:11', '일반 2', 'J06, J07');
insert into movie_ticket values('Henry', 'Avengers_02', '1관', '2015-05-01', '20:05', '23:11', '일반 2', 'J06, J07');
insert into movie_ticket values('Henry', 'Avengers_03', '1관', '2018-05-01', '20:05', '23:11', '일반 2', 'J06, J07');
insert into movie_ticket values('Henry', 'Avengers_04', '1관', '2021-03-14', '04:05', '07:11', '일반 2', 'J06, J07');
insert into movie_ticket values('Henry', 'Parasite', '1관', '2021-03-14', '01:00', '05:00', '일반 2', 'H04, H05');
insert into movie_ticket values('Henry', 'HarryPotter_08', '4관', '2021-03-23', '16:15', '18:31', '일반 2', 'K10, K11');
insert into movie_ticket values('Henry', 'Soul', '1관', '2021-03-24', '14:55', '17:11', '일반 2', 'H04, H05');

insert into movie_ticket values('Annie', 'Avengers_04', '2관', '2021-03-23', '15:20', '18:26', '일반 1, 청소년 1', 'I04, I05');

insert into movie_ticket values('Mary', 'Avengers_04', '2관', '2021-03-14', '14:00', '22:00', '일반 1, 청소년 1', 'I04, I05');
insert into movie_ticket values('Mary', 'HarryPotter_08', '3관', '2021-03-22', '20:30', '22:46', '일반 1', 'K03');
insert into movie_ticket values('Mary', 'Parasite', '2관', '2021-03-23', '21:00', '23:16', '일반 1, 우대 2', 'F06, F07, F08');
insert into movie_ticket values('Mary', 'Soul', '5관', '2021-03-24', '10:45', '12:37', '일반 1, 청소년 1', 'E04, E05');

insert into movie_ticket values('Andrew', 'HarryPotter_08', '4관', '2021-03-23', '16:15', '18:31', '일반 2', 'F10, F11');
insert into movie_ticket values('Susan', 'Soul', '2관', '2021-03-23', '21:00', '23:16', '일반 1, 청소년 2', 'F06, F07, F08');
insert into movie_ticket values('Frank', 'Soul', '1관', '2021-03-24', '14:55', '17:11', '청소년 2', 'C01, C02');
insert into movie_ticket values('Grace', 'Parasite', '5관', '2021-03-22', '10:45', '12:37', '일반 1', 'E08');
insert into movie_ticket values('Michael', 'Parasite', '6관', '2021-03-24', '21:40', '23:32', '일반 3', 'H08, J09');

commit;