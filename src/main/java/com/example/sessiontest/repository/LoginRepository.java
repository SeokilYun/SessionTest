package com.example.sessiontest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sessiontest.entity.LoginEntity;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
	public LoginEntity findById(String id);
}
