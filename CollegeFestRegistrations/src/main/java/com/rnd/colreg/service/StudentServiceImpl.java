package com.rnd.colreg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rnd.colreg.dao.Studentdao;
import com.rnd.colreg.entity.Student;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private Studentdao studentdao;

	@Override
	public boolean Add(Student student) {
		return studentdao.AddStudent(student);
	}

	@Override
	public boolean Update(Student student) {
		return studentdao.UpdateStudent(student);
	}

	@Override
	public boolean Delete(int id) {
		return studentdao.DeleteStudent(id);
	}

	@Override
	public Student getById(int id) {
		return studentdao.getStudentById(id);
	}

	@Override
	public List<Student> getAll() {
		return studentdao.getAllStudents();
	}

	@Override
	public List<Student> retrieveAllStudentsOrderByName() {
		List<Student> studentList = studentdao.getAllStudents();
		studentList.sort((s1, s2) -> s1.getName().compareTo(s2.getName()));
		return studentList;
	}

}
