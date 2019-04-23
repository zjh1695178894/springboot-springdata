package com.bjsxt.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.pojo.Users;
@Repository
public class UsersDaoImpl implements UsersDao {
	@PersistenceContext(name="entityManagerFactory") 
	private EntityManager entityManager;
	@Override
	public void insertUsers(Users users) {
		// TODO Auto-generated method stub
		this.entityManager.persist(users);
	}

	@Override
	public void updateUsers(Users users) {
		// TODO Auto-generated method stub
		this.entityManager.merge(users);
	}

	@Override
	public void deleteUsers(Users users) {
		// TODO Auto-generated method stub
		this.entityManager.remove(users);
	}

	@Override
	public Users selectUserById(Integer userid) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Users.class, userid);
	}

	@Override
	public List<Users> selectUserByName(String name) {
		return this.entityManager.createQuery("from Users where username= :abc").setParameter("abc", name).getResultList();
	}

	@Override 
	public List<Users> selectUserByNameUseSQL(String username) { 
		return this.entityManager.createNativeQuery("select * from t_users where username= ?", Users.class).setParameter(1,username).getResultList(); 
	}
	@Override 
	public List<Users> selectUserByNameUseCriteria(String username) {
		CriteriaBuilder builder = this.entityManager.getCriteriaBuilder();
		CriteriaQuery<Users> query = builder.createQuery(Users.class);
		Root<Users> root = query.from(Users.class);
		 Predicate predicate = builder.equal(root.get("username"),username);
		 query.where(predicate);
		 TypedQuery<Users> createQuery = this.entityManager.createQuery(query);
		return createQuery.getResultList();
	}

}
