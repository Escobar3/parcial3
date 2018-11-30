create database Pr;

use  pr;

create table students (
SID integer not null,
name varchar(30),
lapellido varchar(30),
email varchar(30),
primary key(SID)
);

create table EXERCISE(
CAT varchar(1),
ENO integer,
TOPIC varchar(30),
MAXPT INTEGER,
primary key (CAT,ENO)
);


create table RESULTS(
SID integer not null,
CAT VARCHAR(1),
ENO INTEGER NOT NULL,
POINS INTEGER,
FOREIGN KEY (SID) references students(SID),
FOREIGN KEY (CAT,ENO) references EXERCISE(CAT,ENO)
);

insert into students VALUES(101,'Ann','Smith','......');
insert into students VALUES(102,'michael','jones','');
insert into students VALUES(103,'Richart','Turner','......');
insert into students VALUES(104,'Maria','Brown','......');

insert into EXERCISE VALUES('H',1,'Rel.alg',10);
insert into EXERCISE VALUES('H',2,'SLQ',10);
insert into EXERCISE VALUES('M',1,'SQL',14);

insert into RESULTS VALUES(101,'H',1,10);
insert into RESULTS VALUES(101,'H',2,8);
insert into RESULTS VALUES(101,'M',1,12);

insert into RESULTS VALUES(102,'H',1,9);
insert into RESULTS VALUES(102,'H',2,9);
insert into RESULTS VALUES(102,'M',1,10);

insert into RESULTS VALUES(103,'H',1,5);
insert into RESULTS VALUES(103,'M',1,7);


 Select * from students where   NOT exists (select 1 from RESULTS where students.SID = results.SID);
SELECT * FROM students WHERE students.sid NOT IN (SELECT results.SID FROM results) ;


select results.sid, sum( results.POINS)as t from  results where ENO=1 group by results.sid having (t) >= all
(select  sum( results.POINS)as t from  results where ENO=1 group by results.sid) ;
 

  
