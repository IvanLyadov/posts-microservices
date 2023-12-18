drop table if exists post;

create table if not exists post (
   id serial primary key,
   title varchar(255),
   description varchar(255)
);