package com.oulim.app.community.dao;

import org.apache.ibatis.session.SqlSession;

import com.oulim.app.config.MyBatisConfig;

public class CommunityDAO {
	public SqlSession sqlSession;
	
	public CommunityDAO() {
		// 이미지 테이블 삽입 등의 이유로 transaction 활용
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(false);
	}
}
