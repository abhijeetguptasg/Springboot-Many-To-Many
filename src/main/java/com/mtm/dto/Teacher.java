package com.mtm.dto;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Teacher {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	String subject;
	double fees;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="teacher_student", joinColumns = @JoinColumn(name="teacher_id"), 
	inverseJoinColumns = @JoinColumn(name="student_id"))
	List<Student> students;
	
	public Teacher() {
		// TODO Auto-generated constructor stub
	}

	public Teacher(String name, String subject, double fees, List<Student> students) {
		super();
		this.name = name;
		this.subject = subject;
		this.fees = fees;
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public double getFees() {
		return fees;
	}

	public void setFees(double fees) {
		this.fees = fees;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	@Override
	public String toString() {
		return "Teacher [id=" + id + ", name=" + name + ", subject=" + subject + ", fees=" + fees + ", students="
				+ students + "]";
	}
	
	
}
