package com.example.testdemo.Dao;

import com.example.testdemo.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.Table;

@Repository
@Table(name="user")
public interface DemoDao extends CrudRepository<User, Integer> {
    User findFirstByUserid(int userid);
    User save(User user);
}
