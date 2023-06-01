CREATE database agendadb;


create table agendadb.pessoa
(
  id bigserial not null
    constraint user_pkey
    primary key,
  nome varchar(200),
  email varchar(200)
);
