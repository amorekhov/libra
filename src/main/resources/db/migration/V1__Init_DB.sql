create sequence hibernate_sequence start with 12 increment by 1;

create table book (
    book_id bigint not null,
    author varchar(255),
    availability boolean,
    description varchar(255),
    name varchar(255),
    primary key (book_id)
    );

create table orders (
    orders_id bigint not null,
    book_id bigint,
    user_id integer,
    primary key (orders_id)
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

alter table orders add constraint orders_book_fk foreign key (book_id) references book;

alter table orders add constraint orders_user_fk foreign key (user_id) references user;

alter table user_role add constraint user_role_user_fk foreign key (user_id) references user;
