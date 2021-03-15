CREATE TABLE movie_review(
   id varchar2(10) NOT NULL,
   movie_name varchar2(30) NOT NULL,
   star_rate number(2,1) NOT NULL,
   movie_comment varchar2(50) NOT NULL
);
select * from movie_review;

insert into MOVIE_REVIEW values('Henry', 'Avengers_01', 4, '재밌습니다');
insert into MOVIE_REVIEW values('Henry', 'Avengers_02', 4.5, '다음편이 기대돼요');
insert into MOVIE_REVIEW values('Henry', 'Avengers_03', 5, '너무 재미있어요');
select * from movie_review where id = 'Henry' and movie_name = 'Avengers_04';

commit;