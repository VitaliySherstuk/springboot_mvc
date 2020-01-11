CREATE TABLE IF NOT EXISTS users(
    id       int not null auto_increment,
    name     varchar,
    password varchar,
    role     varchar,
    phone     varchar,
    PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS cars(
    id      int not null auto_increment,
    user_id int,
    make    varchar,
    model   varchar,
    year    int,
    cost    int,
    img     varchar,
    PRIMARY KEY (id)
);