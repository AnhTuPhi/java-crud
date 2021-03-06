package com.java.container.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.container.entity.User;

@Repository
public interface UsersRepository extends JpaRepository<User, Long>{

}
