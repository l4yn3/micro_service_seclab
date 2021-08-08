package com.l4yn3.microserviceseclab.controller;

import com.l4yn3.microserviceseclab.data.Student;
import com.l4yn3.microserviceseclab.logic.IndexLogic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sqlinjection")
public class IndexController {

    @Autowired
    IndexLogic indexLogic;

    @RequestMapping(value = "/one")
    public List<Student> one(@RequestParam(value = "username") String username) {
        return indexLogic.getStudent(username);
    }

    // in 类型的注入问题
    @PostMapping(value = "/in")
    public List<Student> in(@RequestBody List<String> user_list) {
        return indexLogic.getStudentWithIn(user_list);
    }

    @PostMapping(value = "/longin")
    public List<Student> longin(@RequestBody List<Long> user_list) {
        return indexLogic.getStudentWithInLong(user_list);
    }

    @PostMapping(value = "/object")
    public List<Student> objectParam(@RequestBody Student user) {
        return indexLogic.getStudent(user.getUsername());
    }

    @RequestMapping(value = "/optinal_like")
    public List<Student> optionalLike(@RequestParam(value = "username") Optional<String> optinal_username) {
        return indexLogic.getStudentWithOptional(optinal_username);
    }
}
