package com.exception.demo.dto;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserRequest {
	
	private String id;
	@NotNull
	@Pattern(regexp="^\\d{10}$",message="invalid mobile number")
	private String mobileNumber;
	private String name;
	@Email
	private String email;
	@Min(18)
	@Max(60)
	private Integer age;
	private String nationality;
}
