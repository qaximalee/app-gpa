package com.ihsinformatics.gpaconvertor.hbservices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ihsinformatics.gpaconvertor.hbentities.CourseResults;
import com.ihsinformatics.gpaconvertor.hbentities.SemesterResults;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;
import com.ihsinformatics.gpaconvertor.pojo.SemesterResultsPOJO;
import com.ihsinformatics.gpaconvertor.singleton.HibernateUtils;

public class SemesterResultsDAO implements HCrudOperations<SemesterResults> {

	@Override
	public List<SemesterResults> getAll() {
		// TODO Auto-generated method stub
		List<SemesterResults> semesterResultss = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			semesterResultss = session.createQuery("from SemesterResults", SemesterResults.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return semesterResultss;
	}

	@Override
	public SemesterResults getSingle(int id) {
		// TODO Auto-generated method stub
		SemesterResults semesterResults = new SemesterResults();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM SemesterResults Std WHERE Std.semesterResultId = :semesterResults_id";
			Query<SemesterResults> query = session.createQuery(hql, SemesterResults.class);
			query.setParameter("semesterResults_id", id);
			semesterResults = query.getSingleResult();// query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return semesterResults;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM SemesterResults Std " + "WHERE Std.semesterResultId = :semesterResults_id";
			Query query = session.createQuery(hql);
			query.setParameter("semesterResults_id", id);
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
	public boolean update(SemesterResults data) {
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
	public boolean save(SemesterResults data) {
		// TODO Auto-generated method stub
		boolean saved = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {

			data.setcGPA(getCGPA(data.getStudent().getStudentId()));
			// start a transaction
			// transaction = session.beginTransaction();

			// String hql = "FROM SemesterResults Sem_RS WHERE Sem_RS.semester = :semesterID
			// AND Sem_RS.student = :studentID";
			String hql = "FROM SemesterResults Sem_RS WHERE Sem_RS.semester.semesterId = :semesterId AND Sem_RS.student.studentId = :studentId";
			Query<SemesterResults> query = session.createQuery(hql, SemesterResults.class);
			query.setParameter("semesterId", data.getSemester().getSemesterId());
			query.setParameter("studentId", data.getStudent().getStudentId());

			SemesterResults semesterResults = null;
			try {
				semesterResults = query.getSingleResult();
				int semResultsId = semesterResults.getSemesterResultId();
				data.setSemesterResultId(semResultsId);
				update(data);
				saved = true;
			} catch (Exception e) {
				// save the semesterResults objects
				session.save(data);
				saved = true;
				// commit transaction
				// transaction.commit();
			}
		} catch (Exception e) {
			// if (transaction != null) {
			// transaction.rollback();
			// }

			e.printStackTrace();
			saved = false;
		}

		return saved;
	}

	private double getCGPA(int studentId) {
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM CourseResults Crs_RS WHERE Crs_RS.student.studentId = :studentID";
			Query query = session.createQuery(hql);
			query.setParameter("studentID", studentId);
			List<CourseResults> courseResults = query.list();
			double cGPAPoints = 0.0;
			int totalCreditHours = 0;
			for (CourseResults results : courseResults) {
				cGPAPoints += results.getTotalPoints();
				totalCreditHours += 3;
			}
			double cGPA = cGPAPoints / totalCreditHours;
			return cGPA;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0.0;
	}

	@SuppressWarnings("unchecked")
	public List<SemesterResultsPOJO> getAllReadableResults() {

		List<SemesterResultsPOJO> semResults = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			semResults = session.createSQLQuery("CALL getAllSemesterResults()").addEntity(SemesterResultsPOJO.class)
					.list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return semResults;
	}
}
