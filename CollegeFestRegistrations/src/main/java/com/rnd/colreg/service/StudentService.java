package com.rnd.colreg.service;

import java.util.List;

import com.rnd.colreg.entity.Student;

public interface StudentService {

	public boolean Add(Student student);

	public boolean Update(Student student);

	public boolean Delete(int id);

	public Student getById(int id);

	public List<Student> getAll();

	public List<Student> retrieveAllStudentsOrderByName();
}
