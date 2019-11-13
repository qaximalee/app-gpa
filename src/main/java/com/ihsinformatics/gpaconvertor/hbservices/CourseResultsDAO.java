package com.ihsinformatics.gpaconvertor.hbservices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ihsinformatics.gpaconvertor.hbentities.CourseResults;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;
import com.ihsinformatics.gpaconvertor.pojo.CourseResultsPOJO;
import com.ihsinformatics.gpaconvertor.singleton.HibernateUtils;

public class CourseResultsDAO implements HCrudOperations<CourseResults> {

	@Override
	public List<CourseResults> getAll() {
		// TODO Auto-generated method stub
		List<CourseResults> courseResultss = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			courseResultss = session.createQuery("from CourseResults", CourseResults.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return courseResultss;
	}

	@Override
	public CourseResults getSingle(int id) {
		// TODO Auto-generated method stub
		CourseResults courseResults = new CourseResults();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM CourseResults Crs_Rs WHERE Crs_Rs.courseResultId = :courseResult_id";
			Query<CourseResults> query = session.createQuery(hql, CourseResults.class);
			query.setParameter("courseResult_id", id);
			courseResults = query.getSingleResult();// query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return courseResults;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM CourseResults Crs_Rs " + "WHERE Crs_Rs.courseResultId = :courseResult_id";
			Query query = session.createQuery(hql);
			query.setParameter("courseResult_id", id);
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
	public boolean update(CourseResults data) {
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
	public boolean save(CourseResults data) {
		// TODO Auto-generated method stub
		boolean saved = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			// transaction = session.beginTransaction();
			// save the courseResults objects
			session.save(data);
			// commit transaction
			// transaction.commit();
			saved = true;
		} catch (Exception e) {
			// if (transaction != null) {
			// transaction.rollback();
			// }
			e.printStackTrace();
		}

		return saved;
	}

	public List<CourseResults> getAllCourseResultsBySemester(int semesterId, int studentId) {
		List<CourseResults> courseResults = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			Query query = session.createSQLQuery("CALL getCourseResults(:semesterId, :studentId)")
					.addEntity(CourseResults.class);
			query.setParameter("semesterId", semesterId);
			query.setParameter("studentId", studentId);
			courseResults = query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return courseResults;
	}

	public List<CourseResultsPOJO> getAllReadableResults() {
		List<CourseResultsPOJO> courseResults = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			courseResults = session.createSQLQuery("CALL getAllCourseResults()").list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return courseResults;
	}
}
