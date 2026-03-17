package com.ddd.app.dogarchive.dao;

import org.apache.ibatis.session.SqlSession;

import com.ddd.app.dogarchive.dto.ArchiveDeleteDTO;
import com.ddd.config.MyBatisConfig;

// 정보 삭제
//adminNumber, userNumber(보호소)
// 상세 페이지의 삭제 버튼 클릭 시 권한 체크 후 삭제

public class ArchiveDeleteDAO {
	public SqlSession sqlSession;

	public ArchiveDeleteDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);
	}

	// adminNumber, userNumber(보호소)
	public void delete(ArchiveDeleteDTO deleteDTO) {
		sqlSession.delete("archiveDelete.delete", deleteDTO);
	}
}