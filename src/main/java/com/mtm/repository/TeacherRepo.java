package com.mtm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mtm.dto.Teacher;

@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Integer> {

}
