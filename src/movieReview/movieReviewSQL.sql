CREATE TABLE movie_review(
   id varchar2(10) NOT NULL,
   movie_name varchar2(30) NOT NULL,
   star_rate number(2,1) NOT NULL,
   movie_comment varchar2(50) NOT NULL
);
select * from movie_review;

insert into MOVIE_REVIEW values('eunh', '어벤져스:엔드게임', 5, '마블 3000만큼 사랑합니다');
insert into MOVIE_REVIEW values('hiuh', '어벤져스', 5, 'Avengers Assemble!');
insert into MOVIE_REVIEW values('ubola', '어벤져스', 5, 'I''m Ironman.');

insert into MOVIE_REVIEW values('SIN', '소울', 5, '당신이 무의미하다고 느끼는 일상의 나열같은 인생도 무의미하지 않다는걸 보여주는 연출에서 강한 인상을 받았습니다 눈에 보이지 않는 "삶의 목적"만 찾다가 현재를 낭비하지말고 살아간다는 자체를 즐기세요!');
insert into MOVIE_REVIEW values('kjc', '소울', 5, '목적 없이 산다고 혼나는 줄 알았다.');
insert into MOVIE_REVIEW values('9mym', '소울', 5, '진짜 내 인생 애니메이션으로 등극..');

insert into MOVIE_REVIEW values('lrisRossiibaker', '해리포터', 5, '역대 최강의 반전 스네이프 !! 7편을 보면... 해리포터의 진정한 주인공은 스네이프인거 같다.... 멋진 남자. 용기 있는 남자.');
insert into MOVIE_REVIEW values('yiyi8', '해리포터', 5, '10년간의 마법기차여행을 마칩니다 이 긴 여행이 우리에겐 추억이 되어버렸네');
insert into MOVIE_REVIEW values('zp_0', '해리포터', 5, '해리 아들로 또 만들었음 좋겠어요 영원히 안끝날꺼 같았는데 허전하고 아쉽다ㅠㅠ 해리포터랑 어렸을때부터 함께했는데ㅠㅠ최고의영화!');

insert into MOVIE_REVIEW values('brilliant', '기생충', 5, '비에 젖지 않는 고급 장난감 텐트와, 비에 젖다 못해 잠겨버리는 반지하 가구');
insert into MOVIE_REVIEW values('priv ', '기생충', 5, '최근 본 영화중 가장 충격적이었음... 근데 보니까 15세말고 19세 걸어야될것같던데...');
insert into MOVIE_REVIEW values('papi', '기생충', 5, '지하철이라는 단어가 언급되는 순간, 대다수의 관객은 자신이 어디에 이입할 지를 안다.');

select * from movie_review where id = 'eunh' and movie_name = '어벤져스';

commit;