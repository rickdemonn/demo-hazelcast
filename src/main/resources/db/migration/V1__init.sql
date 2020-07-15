create table books (
  id          serial not null,
  title       varchar(25),
  author      varchar(25),
  primary key (id)
);

alter table books owner to postgres;



