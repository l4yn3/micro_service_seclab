package com.l4yn3.microserviceseclab.dao;

import com.l4yn3.microserviceseclab.data.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

// 创建PersionRespository的Dao对象，供Controller使用
public interface PersonRepository extends JpaRepository<Person, String> {

    public List<Person> findPersonByUsername(String username);

    @Query("SELECT nickname FROM Person WHERE nickname = '?1'")
    public List<Person> findPersonByNickname(String nickname);
}
