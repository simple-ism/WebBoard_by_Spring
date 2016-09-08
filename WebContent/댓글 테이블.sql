create sequence s86_comment_no;

create table t86_comment (
	comment_no number(6) primary key,
	no number(6) not null,
	content varchar2(200) not null,
	id varchar2(20) not null,
	reg_date date default sysdate
);
