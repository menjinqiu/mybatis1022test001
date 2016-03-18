package com.atguigu.mybatis.mapper;

import java.util.List;

import com.atguigu.mybatis.entities.Person;

public interface PersonMapper {
	public void add(Person person);
	public Person getPersonById(Integer id);
	public void update(Person person);
	public void delete(Integer id);
	public List<Person> getAll();

}
