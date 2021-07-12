create table student
(
    id       int auto_increment
        primary key,
    name     varchar(50) not null,
    username varchar(50) null,
    password varchar(50) null
);

create table subject
(
    id           int auto_increment
        primary key,
    name         varchar(50)              null,
    score        float(5, 2) default 0.00 null,
    process      int         default 0    null,
    certificate  int         default 0    null,
    student_id   int                      null,
    date_of_done timestamp                null,
    constraint subject___fk__student
        foreign key (student_id) references student (id)
);

