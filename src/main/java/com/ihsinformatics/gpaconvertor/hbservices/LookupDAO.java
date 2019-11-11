package com.ihsinformatics.gpaconvertor.hbservices;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import com.ihsinformatics.gpaconvertor.hbentities.Lookup;
import com.ihsinformatics.gpaconvertor.interfaces.HCrudOperations;
import com.ihsinformatics.gpaconvertor.singleton.HibernateUtils;

public class LookupDAO implements HCrudOperations<Lookup> {

	@Override
	public List<Lookup> getAll() {
		// TODO Auto-generated method stub
		List<Lookup> lookups = new ArrayList<>();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			lookups = session.createQuery("from Lookup", Lookup.class).list();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return lookups;
	}

	@Override
	public Lookup getSingle(int id) {
		// TODO Auto-generated method stub
		Lookup lookup = new Lookup();
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			String hql = "FROM Lookup Lkup WHERE Lkup.lookupId = :lookup_id";
			Query<Lookup> query = session.createQuery(hql);
			query.setParameter("lookup_id", id);
			lookup = query.getSingleResult();// query.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lookup;
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		boolean deleted = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			transaction = session.beginTransaction();
			String hql = "DELETE FROM Lookup Lkup " + "WHERE Lkup.lookupId = :lookup_id";
			Query query = session.createQuery(hql);
			query.setParameter("lookup_id", id);
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
	public boolean update(Lookup data) {
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
	public boolean save(Lookup data) {
		// TODO Auto-generated method stub
		boolean saved = false;
		Transaction transaction = null;
		try (Session session = HibernateUtils.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the lookup objects
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
