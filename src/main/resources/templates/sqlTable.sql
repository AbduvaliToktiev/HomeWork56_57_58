create table homework56-57-58.users(
    id serial primary key,
    fio varchar not null,
    email varchar unique,
    passord varchar not null
);


create table homework56-57-58.tasks(
  id serial unique,
  header varchar not null,
  description varchar not null,
  publication_date timestamp not null,
  user_id integer references create table homework56-57-58.users(id)
  status varchar not null
);