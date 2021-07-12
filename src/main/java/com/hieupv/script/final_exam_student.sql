create table student
(
    id       int auto_increment
        primary key,
    name     varchar(50) not null,
    username varchar(50) null,
    password varchar(50) null
);

INSERT INTO final_exam.student (id, name, username, password) VALUES (1, 'Hieu', 'hieupv', '1');
INSERT INTO final_exam.student (id, name, username, password) VALUES (2, 'HieuPV', 'hieumpos', '1');