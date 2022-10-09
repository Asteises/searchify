create table USERS (
    id uuid primary key,
    name varchar(255),
    chat_id bigint not null
);
