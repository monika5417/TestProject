package com.TestMapping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.TestMapping.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
