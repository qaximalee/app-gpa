package com.ihsinformatics.gpaconvertor.hbservices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ihsinformatics.gpaconvertor.hbentities.Student;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;
import com.ihsinformatics.gpaconvertor.singleton.HibernateUtils;

public class StudentDAO implements HCrudOperations<Student> {

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		List<Student> students = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			students = session.createQuery("from Student", Student.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return students;
	}

	@Override
	public Student getSingle(int id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		// Session session = HibernateUtils.getSessionFactory().openSession()
		try (Session session = HibernateUtils.getHibernateSession()) {
			String hql = "FROM Student Std WHERE Std.studentId = :student_id";
			Query<Student> query = session.createQuery(hql);
			query.setParameter("student_id", id);
			student = query.getSingleResult();// query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return student;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM Student Std " + "WHERE Std.studentId = :student_id";
			Query query = session.createQuery(hql);
			query.setParameter("student_id", id);
			int result = query.executeUpdate();
			transaction.commit();
			if (result == 1)
				deleted = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return deleted;
	}

	@Override
	public boolean update(Student data) {
		// TODO Auto-generated method stub
		boolean updated = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			session.update(data);
			transaction.commit();
			updated = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		return updated;
	}

	@Override
	public boolean save(Student data) {
		// TODO Auto-generated method stub
		boolean saved = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student objects
			session.save(data);
			// commit transaction
			transaction.commit();

			saved = true;
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}

		return saved;
	}
}
