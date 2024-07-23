package com.itwill.springboot3.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.itwill.springboot3.domain.Country;

public interface CountryRepository extends JpaRepository<Country, String> {

}
