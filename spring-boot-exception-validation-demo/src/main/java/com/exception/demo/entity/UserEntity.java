package com.exception.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="TBL_USER_ENTITY")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserEntity {
	
	@Id
	@GeneratedValue
	private Integer id;
	private Integer age;
	private String name;
	private String email;
	private String mobileNumber;
	private String nationality;
}
