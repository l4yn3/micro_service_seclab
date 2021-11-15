package com.l4yn3.microserviceseclab.logic;

import com.l4yn3.microserviceseclab.data.Student;
import com.l4yn3.microserviceseclab.data.Teacher;
import com.l4yn3.microserviceseclab.db.IndexDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IndexLogic {

    @Autowired
    IndexDb indexDb;

    public List<Student> getStudent(String username) {
        return indexDb.getStudent(username);
    }

    public List<Student> getStudentById(Integer id) {
        return indexDb.getStudentById(id);
    }

    public List<Student> getStudentWithOptional(Optional<String> username) {
        return indexDb.getStudentWithOptional(username);
    }

    public List<Student> getStudentWithIn(List<String> user_list) {
        return indexDb.getStudentWithIn(user_list);
    }

    public List<Student> getStudentWithInLong(List<Long> user_list) {
        return indexDb.getStudentWithInLong(user_list);
    }

    public List<Teacher> getTeacherById(String userName) {
        return indexDb.getTeacherById(userName);
    }

}
