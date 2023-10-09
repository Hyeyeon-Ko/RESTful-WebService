insert into users
values (90001, current_timestamp(), 'User1', 'test1111', '701010-1111111');
insert into users
values (90002, current_timestamp(), 'User2', 'test2222', '801010-1111111');
insert into users
values (90003, current_timestamp(), 'User3', 'test3333', '901010-1111111');

insert into post values(10001, 'My first post',90001);
insert into post values(10002, 'My second post',90001);