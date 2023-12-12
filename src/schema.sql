drop database if exists blog;
create database blog;
use blog;

create table user(
	pid int auto_increment, 
	name varchar(40) unique, 
	primary key(pid)
);

create table follows(
	pid int, 
	pid_followed int,  -- the user who is being following by pid
	primary key(pid, pid_followed),
	foreign key(pid) references user(pid), 
	foreign key(pid_followed) references user(pid)
);

create table blog (
	bid int primary key auto_increment, 
	pid int,  -- user who wrote the message 
	time timestamp default(current_timestamp),  
	content varchar(250),
	foreign key(pid) references user(pid)
);

create table MarkAsRead (
	pid int,  
	bid int,  
	primary key(pid, bid),
	foreign key(pid) references user(pid), 
	foreign key(bid) references blog(bid)
);

insert into user values 
(1, 'lily'), 
(2, 'david'), 
(3, 'aaron'), 
(4, 'meui-meui');

insert into follows values 
( 1, 2), 
( 1, 3), 
( 2, 4), 
( 2, 1), 
( 2, 3), 
( 3, 1);

insert into blog(pid, content)  values 
(1, "This is my first message."), 
(1, "I am currently traveling to New York for Christimas."),
(2, "I am traveling to New York to see Lily for Christmas."), 
(3, "I am wondering if it is safe to travel."), 
(4, "What is the weather like in New York?");

