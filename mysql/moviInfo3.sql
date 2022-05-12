drop database movieInfo;
create database movieInfo;
use movieInfo;
drop table movie;
drop table person;
drop table role;

create table movieInfo(
movieinfoNum int not null primary key,
영화이름 varchar(30) not null
);
create table movieReleaseInfo(
releaseNum int not null primary key,
movieinfoNum int not null unique,
foreign key(movieinfoNum) references movieINfo(movieinfoNum),
개봉연도 int not null,
개봉월 int not null
);

create table moviePlot(
movieplotNum int not null primary key,
movieinfoNum int not null unique,
foreign key(movieinfoNum) references movieINfo(movieinfoNum),
줄거리 varchar(500)
);

create table movieReport(
reportNum int not null primary key,
movieinfoNum int not null unique,
foreign key(movieinfoNum) references movieINfo(movieinfoNum),
매출액 int not null,
관객수 int not null,
평점 decimal(3,2) not null,
review1 varchar(500),
review2 varchar(500),
review3 varchar(500)
);

-- <용어 정의>
-- crew : 배우, staff포괄
-- actor : 배우
-- staff : 배우외 제작진(감독 포함)
create table personInfo(
personNum int not null primary key,
이름 varchar(30) not null,
주민등록성별 varchar(30) not null,
출생년도 int,
키 decimal(10,2),
몸무게 decimal(10,2),
배우자 varchar(30)
);
create table actorInfo(
actorNum int not null primary key,
personNum int not null unique,
foreign key(personNum) references personInfo(personNum),
대표작품 varchar(30), 
대표역할 varchar(30)
);
create table staffInfo(
staffNum int not null primary key,
personNum int not null unique,
foreign key(personNum) references personInfo(personNum),
대표작품 varchar(30)
);
create table actorRole(
actorroleNum int not null primary key,
movieinfoNum int not null ,
foreign key(movieinfoNum) references movieINfo(movieinfoNum),
역할이름 varchar(30),
actorNum int not null,
foreign key(actorNum) references actorINfo(actorNum)
);



-- 1. movieInfo
insert into movieInfo values(1,'기생충');
insert into movieInfo values(2,'밀정');
insert into movieInfo values(3,'괴물');
insert into movieInfo values(4,'특송');
insert into movieInfo values(5,'도둑들');
insert into movieInfo values(6,'베를린');
insert into movieInfo values(7,'서복');
select * from movieInfo;

-- 2. movieReport --> report번호p, 영화번호f, 매출액, 관객수, 평점, 리뷰1, 리뷰2, 리뷰3
insert into movieReport values(1, 1,00,10310000,9.07,'재밌었어요','충격적','와우강추'); -- 기생충
insert into movieReport values(2, 2,00,7500000,8.57,'재밌었어요','충격적','와우강추'); -- 밀정
insert into movieReport values(3, 3,00,10910000,8.62,'재밌었어요','충격적','와우강추'); -- 괴물
insert into movieReport values(4, 4,00,440000,7.53,'재밌었어요','충격적','와우강추'); -- 특송
insert into movieReport values(5, 5,00,12980000,7.64,'재밌었어요','충격적','와우강추'); -- 도둑들
insert into movieReport values(6, 6,00,7160000,7.87,'재밌었어요','충격적','와우강추'); -- 베를린
insert into movieReport values(7, 7,00,380000,8.21,'재밌었어요','충격적','와우강추'); -- 서복

-- 3. movieReleaseInfo --> 개봉번호p, 영화번호f, 개봉연도, 개봉월
insert into movieReleaseInfo values(1,1,2019,05);-- 기생충
insert into movieReleaseInfo values(2,2,2016,09);-- 밀정
insert into movieReleaseInfo values(3,3,2006,07); -- 괴물
insert into movieReleaseInfo values(4,4,2022,01);-- 특송
insert into movieReleaseInfo values(5,5,2012,07);-- 도둑들
insert into movieReleaseInfo values(6,6,2013,01);-- 베를린
insert into movieReleaseInfo values(7,7,2021,04);-- 서복

-- 4. moviePlot --> movieplot번호p, 영화번호f, 줄거리
insert into moviePlot values(1,1,'전원백수로 살 길 막막하지만 사이는 좋은 기택(송강호) 가족. 장남 기우(최우식)에게 명문대생 친구가 연결시켜 준 고액 과외 자리는 모처럼 싹튼 고정수입의 희망이다. 온 가족의 도움과 기대 속에 박사장(이선균) 집으로 향하는 기우. 글로벌 IT기업 CEO인 박사장의 저택에 도착하자 젊고 아름다운 사모...');-- 기생충
insert into moviePlot values(2,2,'1920년대 일제강점기. 조선인 출신 일본경찰 이정출(송강호)은 무장독립운동 단체 의열단의 뒤를 캐라는 특명으로 의열단의 리더 김우진(공유)에게 접근하고, 한 시대의 양 극단에 서 있는 두 사람은 서로의 정체와 의도를 알면서도 속내를 감춘 채 가까워진다. 출처를 알 수 없는 정보가 쌍방간에 새어나가...');-- 밀정
insert into moviePlot values(3,3,'햇살 가득한 평화로운 한강 둔치 아버지(변희봉)가 운영하는 한강 매점, 늘어지게 낮잠 자던 강두(송강호)는 잠결에 들리는 ‘아빠’라는 소리에 벌떡 일어난다. 올해 중학생이 된 딸 현서(고아성)가 잔뜩 화가 나있다. 꺼내놓기도 창피한 오래된 핸드폰과, 학부모 참관 수업에 술 냄새 풍기...'); -- 괴물
insert into moviePlot values(4,4,'예상치 못한 배송사고로 걷잡을 수 없는 사건에 휘말린 특송 전문 드라이버 ‘은하’. 어쩌다 맡게 된 반송 불가 수하물에 출처를 알 수 없는 300억까지! 경찰과 국정원의 타겟이 되어 도심 한복판 모든 것을 건 추격전을 벌이게 되는데… NO브레이크! FULL엑셀! 성공률 100% 특송 전문 드라...');-- 특송
insert into moviePlot values(5,5,'한 팀으로 활동 중인 한국의 도둑 뽀빠이와 예니콜, 씹던껌, 잠파노. 미술관을 터는데 멋지게 성공한 이들은 뽀빠이의 과거 파트너였던 마카오박이 제안한 홍콩에서의 새로운 계획을 듣게 된다. 여기에 마카오박이 초대하지 않은 손님, 감옥에서 막 출소한 금고털이 팹시가 합류하고 5명은 각자 인생 최고... ');-- 도둑들
insert into moviePlot values(6,6,'거대한 국제적 음모가 숨겨진 운명의 도시 베를린. 그 곳에 상주하는 국정원 요원 정진수는 불법무기거래장소를 감찰하던 중 국적불명, 지문마저 감지되지 않는 일명 ‘고스트’ 비밀요원 표종성의 존재를 알게 된다. 그의 정체를 밝혀내기 위해 뒤를 쫓던 정진수는 그 배후에 숨겨진 엄청난 국제적 음모를 ... ');-- 베를린
insert into moviePlot values(7,7,'과거 트라우마를 안겨준 사건으로 인해 외부와 단절된 삶을 살아가고 있는 전직 요원 ‘기헌’은 정보국으로부터 거절할 수 없는 마지막 제안을 받는다. 줄기세포 복제와 유전자 조작을 통해 만들어진 실험체 ‘서복’을 안전하게 이동시키는 일을 맡게 된 것. 하지만 임무 수행과 동시에 예기치 못한 공격..');-- 서복
select * from moviePlot;

-- 5. personInfo --> personNum P, 이름, 주민등록성별, 출생년도, 키, 몸무게, 배우자
insert into personInfo values(1,'이정재','남',1978,180.0,70.0,null);
insert into personInfo values(2,'박소담','남',1995,165.2,45.0,null);
insert into personInfo values(3,'최우식','남',1996,180.0,60.0,null);
insert into personInfo values(4,'송강호','남',1972,180.0,80.0,null); -- ---이름....
insert into personInfo values(5,'조여정','여',1978,160.0,40.0,null);
insert into personInfo values(6,'이선균','남',1975,180.0,60.0,null);
insert into personInfo values(7,'이정은','여',1968,165.0,55.0,null);
insert into personInfo values(8,'한지민','여',1989,165.0,45.0,null);
insert into personInfo values(9,'공유','남',1989,185.0,70.0,null);
insert into personInfo values(10,'전지현','여',1970,170.0,45.0,null);
insert into personInfo values(11,'김혜수','여',1965,165.0,45.0,null);
insert into personInfo values(12,'하정우','남',1965,180.0,75.0,null);
insert into personInfo values(13,'봉준호','남',1965,180.0,80.0,null);
insert into personInfo values(14,'김지운','남',1972,180.0,80.0,null);
insert into personInfo values(15,'박대민','남',1972,180.0,80.0,null);
insert into personInfo values(16,'최동훈','남',1972,180.0,80.0,null);
insert into personInfo values(17,'류승완','남',1972,180.0,80.0,null);
insert into personInfo values(18,'이용주','남',1972,180.0,80.0,null);
insert into personInfo values(19,'변희봉','남',1972,180.0,80.0,null);
insert into personInfo values(20,'박해일','남',1972,180.0,80.0,null);
insert into personInfo values(21,'배두나','여',1972,180.0,80.0,null);
insert into personInfo values(22,'송새벽','남',1972,180.0,80.0,null);
insert into personInfo values(23,'김의성','남',1972,180.0,80.0,null);
insert into personInfo values(24,'한석규','남',1972,180.0,80.0,null);
insert into personInfo values(25,'류승범','남',1972,180.0,80.0,null);
insert into personInfo values(26,'이경영','남',1972,180.0,80.0,null);
insert into personInfo values(27,'박보검','남',1972,180.0,80.0,null);
insert into personInfo values(28,'조우진','남',1972,180.0,80.0,null);
select * from personInfo;

-- 6. actorInfo --> actor번호p, person번호f, 대표작품, 대표역할
insert into actorInfo values(1,1,'인천상륙작전','장학수'); -- 이정재
insert into actorInfo values(2,2,'기생충','기정'); -- 박소담
insert into actorInfo values(3,3,'기생충','기우'); -- 최우식
insert into actorInfo values(4,4,'기생충','기택'); -- 송강호
insert into actorInfo values(5,5,'기생충','연교'); -- 조여정
insert into actorInfo values(6,6,'기생충','동익'); -- 이선균
insert into actorInfo values(7,7,'기생충','문광'); -- 이정은
insert into actorInfo values(8,8,'조제','조제'); -- 한지민
insert into actorInfo values(9,9,'부산행','석우'); -- 공유
insert into actorInfo values(10,10,'도둑들','련정희'); -- 전지현
insert into actorInfo values(11,11,'도둑들','팹시'); -- 김혜수
insert into actorInfo values(12,12,'암살','하와이 피스톨'); -- 하정우
insert into actorInfo values(13,19,'괴물','희봉'); -- 변희봉
insert into actorInfo values(14,20,'괴물','남일'); -- 박해일
insert into actorInfo values(15,21,'괴물','남주'); -- 배두나
insert into actorInfo values(16,22,'특송','경필'); -- 송새벽
insert into actorInfo values(17,23,'특송','백사장'); -- 김의성
insert into actorInfo values(18,24,'베를린','정진수'); -- 한석규
insert into actorInfo values(19,25,'베를린','동명수'); -- 류승범
insert into actorInfo values(20,26,'베를린','리학수'); -- 이경영
insert into actorInfo values(21,27,'서복','서복'); -- 박보검
insert into actorInfo values(22,28,'서복','안부장'); -- 조우진



-- 7. staffInfo --> staff번호p, personNumf, 대표작품
insert into staffInfo values(1,13,'기생충'); -- 봉준호
insert into staffInfo values(2,14,'밀정'); -- 김지운
insert into staffInfo values(3,15,'특송'); -- 박대민
insert into staffInfo values(4,16,'암살'); -- 최동훈
insert into staffInfo values(5,17,'베테랑'); -- 류승완
insert into staffInfo values(6,18,'서복'); -- 이용주

-- 8. actorRole --> actorRole번호p, 영화번호f, 역할이름, actor번호F
insert into actorRole values(1,1,'기정',2);-- 기생충 박소담
insert into actorRole values(2,1,'기우',3);-- 기생충 최우식
insert into actorRole values(3,1,'기택',4);-- 기생충 송강호
insert into actorRole values(4,2,'이정출',4);-- 밀정 송강호
insert into actorRole values(5,2,'김우진',9);-- 밀정 공유
insert into actorRole values(6,2,'연계순',8);-- 밀정 한지민
insert into actorRole values(7,3,'희봉',13); -- 괴물 변희봉
insert into actorRole values(8,3,'남일',14); -- 괴물 박해일
insert into actorRole values(9,3,'남주',15); -- 괴물 배두나
insert into actorRole values(10,4,'경필',16);-- 특송 송새벽
insert into actorRole values(11,4,'백사장',17);-- 특송 김의성
insert into actorRole values(12,4,'은하',2);-- 특송 박소담
insert into actorRole values(13,5,'련정희',10);-- 도둑들 전지현
insert into actorRole values(14,5,'팹시',11);-- 도둑들 김혜수
insert into actorRole values(16,6,'정진수',18);-- 베를린 한석규
insert into actorRole values(17,6,'동명수',19);-- 베를린 류승범
insert into actorRole values(18,6,'리학수',20);-- 베를린 이경영
insert into actorRole values(19,7,'서복',21);-- 서복 박보검
insert into actorRole values(20,7,'민기헌',9);-- 서복 공유
insert into actorRole values(21,7,'안부장',22);-- 서복 조우진
select * from actorRole;
