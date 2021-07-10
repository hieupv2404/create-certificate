package com.hieupv.service.impl;

import com.hieupv.dao.StudentDAO;
import com.hieupv.entity.Student;
import com.hieupv.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(rollbackFor = Exception.class)
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentDAO;

    @Override
    public List<Student> getAllStudent() {
        return studentDAO.getStudentList();
    }

    @Override
    public void save(Student student) {

    }

    @Override
    public Student findStudentById(int studentId) {
        return null;
    }

    @Override
    public void delete(int studentId) {

    }

    @Override
    public Student findStudentByUsernameAndPassword(String username, String password) throws Exception {
        Student studentOptional = studentDAO.findByUsernameAndPassword(username, password);
        if(studentOptional == null){
            throw new Exception("Student Not Found");
        }
        return studentOptional;
    }
}
