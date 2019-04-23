package com.bjsxt.pojo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_users")
public class Users implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)//id×ÔÔö³¤
	@Column(name="userid")
	private Integer id;
	@Column(name="username")
	private String name;
	@Column(name="userage")
	private Integer age;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
