DROP DATABASE IF EXISTS `red`;
CREATE DATABASE `red` default charset=utf8 ;
use `red`;


delete from mysql.user where User = 'red_user';
grant select,update,delete,insert on `red`.* to 'red_user'@'%' identified by 'red_pwd';
grant select,update,delete,insert on `red`.* to 'red_user'@'localhost' identified by 'red_pwd';
flush privileges;