CREATE database agendadb;


CREATE database agendadb;


create table agendadb.telefone
(
  id bigserial not null
    constraint user_pkeytel
    primary key,
  ddd varchar(200),
  numero varchar(200),
  id_pessoa int,
CONSTRAINT fk_PesTel FOREIGN KEY (id_pessoa) REFERENCES agendadb.pessoa(id)
);




