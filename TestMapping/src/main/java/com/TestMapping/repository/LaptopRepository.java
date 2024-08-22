package com.TestMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestMapping.entity.Laptop;

public interface LaptopRepository extends JpaRepository<Laptop, Long> {

}
