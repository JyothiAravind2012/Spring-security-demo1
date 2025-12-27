package com.example.springSecurityExample.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springSecurityExample.modal.User;

@Repository
public interface UserRepos extends JpaRepository<User, Integer> {

	User findByUserName(String userName);

}
