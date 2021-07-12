package com.hieupv.dao;

import com.hieupv.entity.Student;
import com.hieupv.entity.Subject;

import java.util.List;

public interface SubjectDAO {
    List<Subject> getSubjectList(Student student);

   Subject getSubjectById(int theId);

    List<Subject> findSubjectByNotCertificate(Student student);
}
