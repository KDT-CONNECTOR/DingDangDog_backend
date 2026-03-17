package com.ddd.app.dogarchive.dao;

import org.apache.ibatis.session.SqlSession;

import com.ddd.app.dogarchive.dto.ArchiveWriteDTO;
import com.ddd.config.MyBatisConfig;

// 정보 등록
// 작성 페이지의 모든 입력값 저장 - 기본정보 + 점수 + 이미지

public class ArchiveWriteDAO {
	public SqlSession sqlSession;

	public ArchiveWriteDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	public void insert(ArchiveWriteDTO writeDTO) {
		// 1. 기본 정보 등록
		sqlSession.insert("archiveWrite.insertArchive", writeDTO);
		// 2. 성향 점수 등록
		sqlSession.insert("archiveWrite.insertScore", writeDTO);
		// 3. 이미지 정보 등록
		sqlSession.insert("archiveWrite.insertImg", writeDTO);
	}
}