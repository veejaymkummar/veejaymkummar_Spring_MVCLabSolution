package com.rnd.colreg.dao;

import java.util.List;

import com.rnd.colreg.entity.Student;

public interface Studentdao {

	public boolean AddStudent(Student student);

	public boolean UpdateStudent(Student student);

	public boolean DeleteStudent(int id);

	public Student getStudentById(int id);

	public List<Student> getAllStudents();

}
