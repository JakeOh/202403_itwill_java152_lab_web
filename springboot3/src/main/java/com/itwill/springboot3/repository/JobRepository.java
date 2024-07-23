package com.itwill.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Job;

public interface JobRepository extends JpaRepository<Job, String> {

}
