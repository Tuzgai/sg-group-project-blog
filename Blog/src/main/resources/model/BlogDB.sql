DROP DATABASE IF EXISTS Blog;

CREATE DATABASE Blog;

use Blog;

create table user(
id int primary key auto_increment,
`name` varchar(45) not null,
username varchar(45) not null unique,
password varchar(100) not null,
email varchar(45) not null,
enabled boolean not null);

create table role(
id int primary key auto_increment,
role varchar(30) not null
);

create table user_role(
user_id int not null,
role_id int not null,
primary key(user_id, role_id),
foreign key (user_id) references user(id),
foreign key (role_id) references role(id));


Create table post(
id int primary key not null auto_increment,
title varchar(100) not null,
body varchar(15000) not null,
time time not null,
Date date not null,
isfeatured boolean not null,
user_id  int not null,
approved boolean not null,
foreign key (user_id)
references User(id)
);

Create table tags(
`name` varchar(45) primary key
);

Create table postTags(
id  int not null,
foreign key (id)
references post(id),
`name` varchar(45) not null,
foreign key (`name`)
references tags(`name`)
);