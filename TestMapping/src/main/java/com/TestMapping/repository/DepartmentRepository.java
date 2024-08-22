package com.TestMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestMapping.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

}
