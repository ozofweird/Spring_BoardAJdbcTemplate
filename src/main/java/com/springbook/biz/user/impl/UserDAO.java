package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL ��ɾ�
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD ����� �޼��� ����
	// �α���
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC�� getUser() ��� ó��");
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(
				USER_GET, args, new UserRowMapper());

	}
	
}
