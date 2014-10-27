package com.whroid.ee.test.springmvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.whroid.ee.test.springmvc.entity.User;

public interface UserRepository extends JpaRepository<User, String>{

}
