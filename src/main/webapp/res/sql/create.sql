create table Students(
	id 	 		varchar(20)		 constraint Students_id_pk primary key
,	passwd 		varchar(20) 		 constraint Students_passwd_nn not null
,	gender 		varchar(15) 		 constraint Students_gender_nn not null
);

insert into Students
values('leeS', '1234', 'M');

insert into Students
values('kimY', '2345', 'W');

commit;

create table Grade(
	id  		varchar(20) 	 constraint Grade_id_fk references Students(id)
,	KO  	 	number(10) 		 constraint Grade_KO_nn not null
,	EN	   		number(10) 		 constraint Grade_EN_nn not null
,	MT 	  		number(10) 		 constraint Grade_MT_nn not null
,	SI	   		number(10) 		 constraint Grade_SI_nn not null
);

insert into Grade
values('leeS', 75, 35, 80, 100);

insert into Grade
values('kimY', 13, 98, 100, 25);

commit;