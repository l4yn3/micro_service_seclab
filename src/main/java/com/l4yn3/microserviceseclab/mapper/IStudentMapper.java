package com.l4yn3.microserviceseclab.mapper;

import com.l4yn3.microserviceseclab.data.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface IStudentMapper {

    // 查询数据
    public List<Student> queryAll(@Param(value = "name") String username);
}
