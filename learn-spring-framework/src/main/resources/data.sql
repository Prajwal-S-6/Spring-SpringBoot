insert into users values (1, 'praj');
insert into users values (2, 'harsh');

insert into employee values (1, 'e1', 2000, 'password');
insert into employee values (2, 'e2', 3000, 'password');

ALTER TABLE EMPLOYEE ALTER COLUMN id RESTART WITH 3;