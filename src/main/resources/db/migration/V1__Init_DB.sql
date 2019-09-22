create sequence hibernate_sequence start with 12 increment by 1;

create table book (
    book_id bigint not null,
    author varchar(255),
    availability boolean,
    description varchar(255),
    name varchar(255),
    user_id integer,
    primary key (book_id)
    );

create table user (
    user_id integer not null,
    active boolean not null,
    password varchar(255),
    username varchar(255),
    primary key (user_id)
    );

create table user_role (
    user_id integer not null,
    roles varchar(255)
    );

alter table book add constraint book_user_fk foreign key (user_id) references user;

alter table user_role add constraint user_role_user_fk foreign key (user_id) references user;
