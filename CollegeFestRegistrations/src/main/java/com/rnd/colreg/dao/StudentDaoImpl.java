package com.rnd.colreg.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.rnd.colreg.entity.Student;

@Repository
public class StudentDaoImpl implements Studentdao {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentDaoImpl(SessionFactory sessionfactory) {
		this.sessionFactory = sessionfactory;
		try {
			session = sessionFactory.getCurrentSession();

		} catch (HibernateException exception) {
			session = sessionFactory.openSession();
		}
	}

	@Override
	public boolean AddStudent(Student student) {
		Transaction Txn = session.beginTransaction();
		session.save(student);
		Txn.commit();
		return true;
	}

	@Override
	public boolean UpdateStudent(Student student) {
		Transaction Txn = session.beginTransaction();
		session.merge(student);
		Txn.commit();
		return true;
	}

	@Override
	public boolean DeleteStudent(int id) {
		Transaction Txn = session.beginTransaction();
		Student student = session.get(Student.class, id);
		session.delete(student);
		Txn.commit();
		return true;
	}

	@Override
	public Student getStudentById(int Id) {
		return session.get(Student.class, Id);
	}

	@Override
	public List<Student> getAllStudents() {

		return session.createQuery("from Student", Student.class).getResultList();
	}

}
