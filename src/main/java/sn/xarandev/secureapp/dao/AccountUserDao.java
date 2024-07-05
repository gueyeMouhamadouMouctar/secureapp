package sn.xarandev.secureapp.dao;

import java.util.Optional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import sn.xarandev.secureapp.config.HibernateUtil;
import sn.xarandev.secureapp.entities.AccountUserEntity;
import sn.xarandev.secureapp.repository.Repository;

public class AccountUserDao extends Repository<AccountUserEntity> implements IAccountUserDao{
	
	private Session session = HibernateUtil.getSessionFactory().openSession();

	@Override
	public Optional<AccountUserEntity> login(String email, String password) {
		
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<AccountUserEntity> cr = cb.createQuery(AccountUserEntity.class) ;
		Root<AccountUserEntity> account = cr.from(AccountUserEntity.class) ;
		
		// Predicate
		Predicate predicateEmail = cb.equal(account.get("email"), email) ;
		Predicate predicatePassword = cb.equal(account.get("password"), password) ;		
		Predicate predicateFinal = cb.and(predicateEmail, predicatePassword) ;
		
		cr.select(account);
		cr.where(predicateFinal) ;
		
		
		return Optional.ofNullable(session.createQuery(cr).getSingleResult()) ;
	}

}
