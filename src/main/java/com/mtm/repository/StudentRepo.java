package com.mtm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtm.dto.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer> {

}
