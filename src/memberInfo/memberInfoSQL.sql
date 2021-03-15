CREATE TABLE member_info(
   id varchar2(10) PRIMARY KEY NOT NULL,
   pwd varchar2(20) NOT NULL,
   gender INTEGER NOT NULL,
   age INTEGER NOT NULL
);
select * from member_info;

insert into member_info values('Henry', '123', 0, 25);
insert into member_info values('James', '111', 0, 19);
insert into member_info values('Jim', '222', 0, 33);
insert into member_info values('Peter', '333', 0, 56);
insert into member_info values('Frank', '444', 0, 47);
insert into member_info values('Andrew', '555', 0, 68);
insert into member_info values('Michael', '666', 0, 72);
insert into member_info values('William', '777', 0, 31);
insert into member_info values('Annie', '111', 1, 17);
insert into member_info values('Mary', '222', 1, 22);
insert into member_info values('Carol', '333', 1, 26);
insert into member_info values('Betty', '444', 1, 34);
insert into member_info values('Anna', '555', 1, 42);
insert into member_info values('Susan', '666', 1, 49);
insert into member_info values('Sally', '777', 1, 53);
insert into member_info values('Nancy', '888', 1, 65);
insert into member_info values('Grace', '999', 1, 70);

delete from member_Info where id = 'bbb';

commit;