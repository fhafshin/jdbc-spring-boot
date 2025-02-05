CREATE TABLE IF NOT EXISTS employee
(

    id
    integer
    NOT
    NULL,
    first_name
    varchar
(
    30
) DEFAULT NULL,
    last_name varchar
(
    30
) DEFAULT NULL,
    PRIMARY KEY
(
    id
)
    );

CREATE TABLE IF NOT EXISTS book
(

    id
    integer
    NOT
    NULL,
    title
    varchar
(
    30
) DEFAULT NULL,
    author varchar
(
    30
) DEFAULT NULL,
    PRIMARY KEY
(
    id
)
    );