package sn.xarandev.secureapp.repository;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sn.xarandev.secureapp.config.HibernateUtil;

public class Repository<T> implements IRepository<T> {
	
	private Session session = HibernateUtil.getSessionFactory().openSession();
	private Transaction transaction = null ;

	@Override
	public boolean save(T t) {
		
		try {
			transaction = session.beginTransaction();
			session.save(t);
			transaction.commit();
			return true ;
		} catch (Exception e) {
			return false ;
		}
	}

	@Override
	public boolean update(T t) {
		try {
			transaction = session.beginTransaction();
			session.merge(t);
			transaction.commit();
			System.err.println("========================>  update seccess");
			return true ;
		} catch (Exception e) {
			System.err.println("========================>  update failed");
			return false ;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> list(T t) {

			CriteriaBuilder cb = session.getCriteriaBuilder();
			CriteriaQuery<T> cq = (CriteriaQuery<T>) cb.createQuery(t.getClass()) ;
			Root<T> root = (Root<T>) cq.from(t.getClass()) ;
			
			cq.select(root);
			return session.createQuery(cq).getResultList();	
	}

	@Override
	public boolean delete(int id, T t) {
		try {
			System.err.println("---------------------------->   t.getClass   ==  " + t.getClass());
			System.err.println("---------------------------->   id   ==  " + id);
			transaction = session.beginTransaction();
			session.delete(session.get(t.getClass(), id));
			transaction.commit();
			return true ;
		} catch (Exception e) {
			System.out.println("Error suppressing account");
			System.err.println(e);
			return false ;
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int id, T t) {
		// TODO Auto-generated method stub
		return (T) session.get(t.getClass(), id);
	}



}
