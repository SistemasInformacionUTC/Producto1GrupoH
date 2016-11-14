# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table company (
  id                            bigserial not null,
  name                          varchar(255),
  constraint pk_company primary key (id)
);

create table computer (
  id                            bigserial not null,
  name                          varchar(255),
  introduced                    timestamp,
  discontinued                  timestamp,
  company_id                    bigint,
  constraint pk_computer primary key (id)
);

create table memoria (
  id                            bigserial not null,
  codigo1                       integer,
  codigo2                       integer,
  computer_id                   bigint,
  constraint pk_memoria primary key (id)
);

alter table computer add constraint fk_computer_company_id foreign key (company_id) references company (id) on delete restrict on update restrict;
create index ix_computer_company_id on computer (company_id);

alter table memoria add constraint fk_memoria_computer_id foreign key (computer_id) references computer (id) on delete restrict on update restrict;
create index ix_memoria_computer_id on memoria (computer_id);


# --- !Downs

alter table if exists computer drop constraint if exists fk_computer_company_id;
drop index if exists ix_computer_company_id;

alter table if exists memoria drop constraint if exists fk_memoria_computer_id;
drop index if exists ix_memoria_computer_id;

drop table if exists company cascade;

drop table if exists computer cascade;

drop table if exists memoria cascade;

