package net.uselesscode.yuruweb202210.bean;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class UserBean {

	private Integer id;
	@NotBlank
	private String name;
	@NotBlank
	private String mail;
	@NotBlank
	private String password;
}
