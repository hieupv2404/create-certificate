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

INSERT INTO final_exam.subject (id, name, score, process, certificate, student_id, date_of_done) VALUES (1, 'DevOps', 8.9, 100, 0, 1, '2021-07-12 12:35:44');
INSERT INTO final_exam.subject (id, name, score, process, certificate, student_id, date_of_done) VALUES (2, 'Java', 5, 90, 0, 1, '2021-07-12 12:35:44');
INSERT INTO final_exam.subject (id, name, score, process, certificate, student_id, date_of_done) VALUES (4, 'Java', 7, 96, 0, 2, '2021-07-12 12:35:44');