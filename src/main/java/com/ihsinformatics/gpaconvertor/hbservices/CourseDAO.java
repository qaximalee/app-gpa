package com.ihsinformatics.gpaconvertor.hbservices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ihsinformatics.gpaconvertor.hbentities.Course;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;
import com.ihsinformatics.gpaconvertor.singleton.HibernateUtils;

public class CourseDAO implements HCrudOperations<Course> {

	@Override
	public List<Course> getAll() {
		// TODO Auto-generated method stub
		List<Course> courses = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			courses = session.createQuery("from Course", Course.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return courses;
	}

	@Override
	public Course getSingle(int id) {
		// TODO Auto-generated method stub
		Course course = new Course();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM Course Crs WHERE Crs.courseId = :course_id";
			Query<Course> query = session.createQuery(hql, Course.class);
			query.setParameter("course_id", id);
			course = query.getSingleResult();// query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return course;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM Course Crs " + "WHERE Crs.courseId = :course_id";
			Query<Course> query = session.createQuery(hql, Course.class);
			query.setParameter("course_id", id);
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
	public boolean update(Course data) {
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
	public boolean save(Course data) {
		// TODO Auto-generated method stub
		boolean saved = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the course objects
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
