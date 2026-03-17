package com.ddd.app.dogarchive.dao;

import org.apache.ibatis.session.SqlSession;

import com.ddd.app.dogarchive.dto.ArchiveUpdateDTO;
import com.ddd.config.MyBatisConfig;

// 정보 수정
// 수정 페이지의 기존 값 변경 (취소 시 이전 값 유지 로직은 Service/JS 담당)

public class ArchiveUpdateDAO {
	public SqlSession sqlSession;

	public ArchiveUpdateDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void update(ArchiveUpdateDTO updateDTO) {
		// 1. 기본 정보 수정
		sqlSession.update("archiveUpdate.updateArchive", updateDTO);
		// 2. 성향 점수 수정
		sqlSession.update("archiveUpdate.updateScore", updateDTO);
	}
}