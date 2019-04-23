package com.bjsxt.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.pojo.Users;
@Repository
public class UsersDaoImpl implements UsersDao {
	@Autowired
	private HibernateTemplate hibernateTemplate;
	@Override
	public void insertUsers(Users users) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.save(users);
	}

	@Override
	public void updateUsers(Users users) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.update(users);
	}

	@Override
	public void deleteUsers(Users users) {
		// TODO Auto-generated method stub
		this.hibernateTemplate.delete(users);
	}

	@Override
	public Users selectUserById(Integer userid) {
		// TODO Auto-generated method stub
		return this.hibernateTemplate.get(Users.class, userid);
	}

	@Override
	public List<Users> selectUserByName(String name) {
		Session session = hibernateTemplate.getSessionFactory().getCurrentSession();
		Query query = session.createQuery("from Users where username= :abc");
		Query query2 = query.setString("abc", name);
		return query2.list();
	}

}
