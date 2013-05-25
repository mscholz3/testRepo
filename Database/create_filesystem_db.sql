drop database filesystem;
create database filesystem;
use filesystem;

create table series (
	series_id smallint(10) unsigned not null auto_increment,
	series_name varchar(45) not null,
	primary key (series_id),
	key idx_series_name (series_name),
	unique index series_name_unique (series_name asc)
) default charset=utf8;

create table season (
	season_id smallint(10) unsigned not null auto_increment,
	season_name varchar(45) not null,
	season_series_id smallint(10) unsigned not null,
	primary key (season_id),
	constraint fk_season_series foreign key (season_series_id) references series (series_id) on update cascade,
	unique index season_name_series_id_unique (season_series_id asc, season_name asc)
) default charset=utf8;

create table episode (
	episode_id smallint(10) unsigned not null auto_increment,
	episode_name varchar(50) not null,
	episode_season_id smallint(10) unsigned not null,
	primary key (episode_id),
	constraint fk_episode_season foreign key (episode_season_id) references season (season_id) on update cascade,
	unique index episode_name_season_id_unique (episode_season_id asc, episode_name asc)
) default charset=utf8;

