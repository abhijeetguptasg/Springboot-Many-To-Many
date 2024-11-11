package com.mtm.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mtm.dto.Student;
import com.mtm.dto.Teacher;
import com.mtm.repository.StudentRepo;
import com.mtm.repository.TeacherRepo;

@Service
public class TeacherService {

	@Autowired
	TeacherRepo trepo;
	
	@Autowired
	StudentRepo srepo;
	
	public Teacher saveTeacher1(Teacher teacher)
	{
		Set<Student> students= new HashSet<>();
		
		for(Student s:teacher.getStudents())
		{
			Optional<Student> student= srepo.findById(s.getId());
			if(student.isPresent())
			{
				students.add(student.get());
			}
			else
			{
				students.add(s);
			}
		}
		
		teacher.getStudents().clear();
		teacher.setStudents(new ArrayList<>(students));
		return trepo.save(teacher);
		
	}
	
	public Teacher updateTeacher(int id, Teacher teacher)
	{
		Optional<Teacher> t= trepo.findById(id);
		
		if(t.isPresent())
		{
			teacher.setId(id);
			teacher.setStudents(t.get().getStudents());
			return trepo.save(teacher);
		}
		return null;
	}
	
	public Student updateStudent(int id, Student student)
	{
		Optional<Student> s= srepo.findById(id);
		
		if(s.isPresent())
		{
			student.setId(id);
			student.setTeachers(s.get().getTeachers());
			return srepo.save(student);
		}
		return null;
	}
	
	public List<Teacher> readTeachers()
	{
		List<Teacher> teachers= trepo.findAll();
		return teachers;
	}
}
