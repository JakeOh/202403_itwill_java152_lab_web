package com.itwill.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Region;

public interface RegionRepository extends JpaRepository<Region, Integer> {

}
