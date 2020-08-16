package com.springbook.biz.user.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.springbook.biz.user.UserVO;

@Repository("userDAO")
public class UserDAO {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	// SQL 명령어
	private final String USER_GET = "select * from users where id=? and password=?";
	
	// CRUD 기능의 메서드 구현
	// 로그인
	public UserVO getUser(UserVO vo) {
		System.out.println("===> JDBC로 getUser() 기능 처리");
		Object[] args = {vo.getId(), vo.getPassword()};
		return jdbcTemplate.queryForObject(
				USER_GET, args, new UserRowMapper());

	}
	
}
