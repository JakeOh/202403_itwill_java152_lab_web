package com.itwill.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Location;

public interface LocationRepository extends JpaRepository<Location, Integer> {

}
