package com.hieupv.service;

import com.hieupv.entity.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudent();

    void save(Student student);

    Student findStudentById(int studentId);

    void delete(int studentId);

    Student findStudentByUsernameAndPassword(String username, String password) throws Exception;
}
