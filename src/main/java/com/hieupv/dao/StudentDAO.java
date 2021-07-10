package com.hieupv.dao;

import com.hieupv.entity.Student;

import java.util.List;
import java.util.Optional;

public interface StudentDAO {
    List<Student> getStudentList();

   Student  getStudent(int theId);

    Student findByUsernameAndPassword(String username, String password);
}
