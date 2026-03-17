package com.ddd.app.dogarchive.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ddd.app.dogarchive.dto.ArchiveListDTO;
import com.ddd.config.MyBatisConfig;

//전체 목록 & 검색
//메인 페이지의 이미지 카드 목록, 견종/보호소 검색, 페이지네이션 

public class ArchiveListDAO {
	public SqlSession sqlSession;

	public ArchiveListDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// 메인 이미지 카드 리스트
	// 정렬 조건(보호일순)
	public List<ArchiveListDTO> selectList(ArchiveListDTO listDTO) {
		return sqlSession.selectList("archiveList.selectList", listDTO);
	}

	// 페이징 - 페이지네이션 1~5를 구현하기 위한 전체 게시글 개수 조회
	public int getTotalCount(ArchiveListDTO listDTO) {
		return sqlSession.selectOne("archiveList.getTotalCount", listDTO);
	}
}