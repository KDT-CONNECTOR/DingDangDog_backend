package com.ddd.app.dogarchive.dao;

import org.apache.ibatis.session.SqlSession;

import com.ddd.app.dogarchive.dto.ArchiveReadDTO;
import com.ddd.config.MyBatisConfig;

// 상세 내역 조회
// 상세 페이지 정보 출력, 성향 점수 조회, 보호소 정보 조회.

public class ArchiveReadDAO {
	public SqlSession sqlSession;

	public ArchiveReadDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 이름, 품종, 성별, 점수 등 모든 상세 내역 조회
	public ArchiveReadDTO selectDetail(int dogNumber) {
		return sqlSession.selectOne("archiveRead.selectDetail", dogNumber);
	}
}