create table user_google
(
    id    varchar(100) not null
        constraint user_google_pkey
            primary key,
    name  varchar(255),
    email varchar(255)
);
