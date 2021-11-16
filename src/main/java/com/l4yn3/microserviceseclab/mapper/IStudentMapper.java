package com.l4yn3.microserviceseclab.mapper;

import com.l4yn3.microserviceseclab.data.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IStudentMapper {

    // 查询数据
    public List<Student> queryAll(@Param(value = "name") String username);

    // 注解式SQL查询写法，看扫描软件是否能够扫描出此注入漏洞
    @Select("select * from students where username ='${name}'")
    public List<Student> queryAllByAnnotations(@Param(value = "name") String username);

}
