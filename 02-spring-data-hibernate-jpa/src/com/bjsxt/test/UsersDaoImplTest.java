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
	/*数据库中没有该表的时候要修改applicationContext.xml中的关于hibernate中SeesionFactory的配置
	<property name="hibernate.hbm2ddl.auto">create</property>
	表创建好以后才能选择update
	<property name="hibernate.hbm2ddl.auto">update </property>
	*/

	@Autowired
	private UsersDao usersDao;
	@Test
	@Transactional
	//JUnit测试类完成后事务是默认 回滚的。只能查询数据，不能增删改。
	//在测试类或者测试方法上面加上注解 @Rollback(false)  表示事物不回滚，这样数据就可以提交到数据库中了。
	@Rollback(false) 
	public void testInsertUsers(){
		Users users=new Users();
		users.setAge(10);
		users.setName("张三");
		usersDao.insertUsers(users);
	}
	
	@Test
	@Transactional
	@Rollback(false)
	public void testUpdateUsers(){
		Users users=new Users();
		users.setId(2);
		users.setAge(10);
		users.setName("李四");
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
		List<Users> list = this.usersDao.selectUserByName("李四");
		for(Users user:list){
			System.out.println(user.getId());
		}
	}
}