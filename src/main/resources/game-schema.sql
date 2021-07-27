
drop table if exists game CASCADE;
 
create table game (
	id integer PRIMARY KEY AUTO_INCREMENT,
	genre varchar(255), 
	name varchar(255), 
	platform varchar(255), 
	player_type varchar(255)
);