package com.bjsxt.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.bjsxt.dao.UsersDao;
import com.bjsxt.pojo.Users;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml") 
public class UsersDaoImplTest {
	/*���ݿ���û�иñ��ʱ��Ҫ�޸�applicationContext.xml�еĹ���hibernate��SeesionFactory������
	<property name="hibernate.hbm2ddl.auto">create</property>
	�������Ժ����ѡ��update
	<property name="hibernate.hbm2ddl.auto">update </property>
	*/

	@Autowired
	private UsersDao usersDao;
	@Test
	@Transactional
	//JUnit��������ɺ�������Ĭ�� �ع��ġ�ֻ�ܲ�ѯ���ݣ�������ɾ�ġ�
	//�ڲ�������߲��Է����������ע�� @Rollback(false)  ��ʾ���ﲻ�ع����������ݾͿ����ύ�����ݿ����ˡ�
	@Rollback(false) 
	public void testInsertUsers(){
		Users users=new Users();
		users.setAge(10);
		users.setName("����");
		usersDao.insertUsers(users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateUsers(){
		Users users=new Users();
		users.setId(2);
		users.setAge(10);
		users.setName("����");
		usersDao.updateUsers(users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testDeleteUsers(){
		Users users=new Users();
		users.setId(2);
		usersDao.deleteUsers(users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testSelectUsersbyId(){
		Users user=this.usersDao.selectUserById(2);
		System.out.println(user);
	}
	
	@Test
	@Transactional
	public void testSelectUsersbyName(){
		List<Users> list = this.usersDao.selectUserByName("����");
		for(Users user:list){
			System.out.println(user.getId());
		}
	}
}