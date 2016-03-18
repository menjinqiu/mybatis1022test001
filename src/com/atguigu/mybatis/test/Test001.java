package com.atguigu.mybatis.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.atguigu.mybatis.entities.Person;
import com.atguigu.mybatis.mapper.PersonMapper;

public class Test001 {
	private SqlSessionFactory sqlSessionFactory = null;

	@Before
	public void init() throws Throwable {
		String resource = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@Test
	public void insert() {
		SqlSession sqlSession = null;
		try {
			sqlSession = sqlSessionFactory.openSession();

			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

			Person person = new Person();
			person.setAge(18);
			person.setName("nick");
			person.setSalary(22.2);

			mapper.add(person);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}

	@Test
	public void getById() {
		SqlSession sqlSession = null;

		try {
			sqlSession = sqlSessionFactory.openSession();
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);

			Person person = mapper.getPersonById(2);
			System.out.println(person.toString());
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	@Test
	public void delete() {
		SqlSession sqlSession = null;

		try {
			sqlSession = sqlSessionFactory.openSession();
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			mapper.delete(3);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}

		}

	}

	@Test
	public void update() {
		SqlSession sqlSession = null;

		try {
			sqlSession = sqlSessionFactory.openSession();
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			Person person = new Person();
			person.setAge(19);
			person.setBirth(new Date(1991 - 8 - 15));
			person.setRegisterTime(new Date(1991 / 8 / 14));
			person.setSalary(13000);
			person.setId(2);
			person.setName("lucy");
			mapper.update(person);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}

	}

	@Test
	public void getAll() {
		SqlSession sqlSession = null;

		try {
			sqlSession = sqlSessionFactory.openSession();
			PersonMapper mapper = sqlSession.getMapper(PersonMapper.class);
			List<Person> list = mapper.getAll();
			for (Person person : list) {
				System.out.println("");
				System.out.println("hello github");
				System.out.println("hello github");
				System.out.println("hello github");
				System.out.println("hello github");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
