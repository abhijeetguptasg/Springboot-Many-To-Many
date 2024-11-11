package com.mtm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mtm.dto.Student;
import com.mtm.dto.Teacher;
import com.mtm.service.TeacherService;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

	@Autowired
	TeacherService service;
	
	@PostMapping("/save1")
	public Teacher saveTeache1(@RequestBody Teacher teacher)
	{
		return service.saveTeacher1(teacher);
	}
	
	@PatchMapping("/updateTeacher")
	public Teacher updateTeacher(@RequestParam int id, @RequestBody Teacher teacher)
	{
		return service.updateTeacher(id, teacher);
	}
	
	@PatchMapping("/updateStudent")
	public Student updateTeacher(@RequestParam int id, @RequestBody Student student)
	{
		return service.updateStudent(id, student);
	}
	
	@GetMapping("/readTeacher")
	public List<Teacher> readTeachers()
	{
		return service.readTeachers();
	}
}

