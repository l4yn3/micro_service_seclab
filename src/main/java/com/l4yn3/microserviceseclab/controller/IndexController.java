package com.l4yn3.microserviceseclab.controller;

import com.l4yn3.microserviceseclab.data.Student;
import com.l4yn3.microserviceseclab.data.Teacher;
import com.l4yn3.microserviceseclab.logic.IndexLogic;
import com.l4yn3.microserviceseclab.mapper.IStudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/sqlinjection")
public class IndexController {

    @Autowired
    IndexLogic indexLogic;

    @Autowired
    IStudentMapper iStudentMapper;

    @RequestMapping(value = "/one")
    public List<Student> one(@RequestParam(value = "username") String username) {
        return indexLogic.getStudent(username);
    }

    // in 类型的注入问题
    @PostMapping(value = "/in")
    public List<Student> in(@RequestBody List<String> user_list) {
        return indexLogic.getStudentWithIn(user_list);
    }

    // 这并不是一个注入，如果SAST扫描器将这个报为SQL注入漏洞，那么这是一个误报问题
    @PostMapping(value = "/longin")
    public List<Student> longin(@RequestBody List<Long> user_list) {
        return indexLogic.getStudentWithInLong(user_list);
    }

    @PostMapping(value = "/object")
    public List<Student> objectParam(@RequestBody Student user) {
        return indexLogic.getStudent(user.getUsername());
    }

    // 这里并不存在注入，只是用来测试看SAST扫描器是否将这个误报为SQL注入漏洞
    @PostMapping(value = "/objectint")
    public List<Student> objectIntParam(@RequestBody Student user) {
        return indexLogic.getStudentById(user.getId());
    }

    // 测试Lombok插件是否会影响漏洞的判断
    @PostMapping(value = "/object_lombok")
    public List<Teacher> objectLomBok(@RequestBody Teacher user) {
        return indexLogic.getTeacherById(user.getName());
    }

    @RequestMapping(value = "/optinal_like")
    public List<Student> optionalLike(@RequestParam(value = "username") Optional<String> optinal_username) {
        return indexLogic.getStudentWithOptional(optinal_username);
    }

    @RequestMapping(value = "/myBatis")
    public List<Student> myBatis(@RequestParam(value = "name") String name) {
        return iStudentMapper.queryAll(name);
    }
}
