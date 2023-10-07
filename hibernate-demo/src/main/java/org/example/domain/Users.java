package org.example.domain;

import lombok.Data;
import org.hibernate.annotations.GeneratorType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @description users
 * @author zhengkai.blog.csdn.net
 * @date 2023-09-28
 */
@Entity
@Data
@Table(name="users")
public class Users implements Serializable {

	 private static final long serialVersionUID = 1L;

	 @Column(name="id")
	 private Long id;
	 /**
	  * username
	  */
	 @Column(name="username")
	 private String username;

	 /**
	  * email
	  */
	 @Column(name="email")
	 private String email;

	 /**
	  * password
	  */
	 @Column(name="password")
	 private String password;

	 /**
	  * full_name
	  */
	 @Column(name="full_name")
	 private String fullName;

	 /**
	  * age
	  */
	 @Column(name="age")
	 private Integer age;

	 /**
	  * gender
	  */
	 @Column(name="gender")
	 private String gender;

	 /**
	  * avatar
	  */
	 @Column(name="avatar")
	 private String avatar;

	 /**
	  * create_time
	  */
	 @Column(name="create_time")
	 private Date createTime;

	 /**
	  * update_time
	  */
	 @Column(name="update_time")
	 private Date updateTime;



	 public Users() {
	 }



}