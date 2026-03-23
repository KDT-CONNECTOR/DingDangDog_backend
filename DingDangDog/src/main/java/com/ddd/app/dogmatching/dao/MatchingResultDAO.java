package com.ddd.app.dogmatching.dao;

// ===== 멍! 매칭 DAO =====
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.ddd.app.dogarchive.dto.ArchiveListDTO;
import com.ddd.app.dogmatching.dto.ArchiveScoreDTO;
import com.ddd.app.dogmatching.dto.MatchingResultDTO;
import com.ddd.config.MyBatisConfig;

public class MatchingResultDAO {
	public SqlSession sqlSession;

	public MatchingResultDAO() {
		sqlSession = MyBatisConfig.getSqlSessionFactory().openSession(true);

	}
	//result_number 미리 조회
	public int getNextResultNumber() {
		return sqlSession.selectOne("matching.getNextResultNumber");
	}
	
	// 멍 매칭 결과 저장
	public void insertResult(MatchingResultDTO matchingResultDTO) {
		sqlSession.insert("matching.insertResult", matchingResultDTO);
	}
	
	// 매칭 결과에 추천된 강아지 저장
	public void insertResultDog(MatchingResultDTO matchingResultDTO) {
		sqlSession.insert("matching.insertResultDog", matchingResultDTO);
	}

	// 저장 건수 확인 - 5건 제한 확인용
	public int countSavedResults(int userNumber) {
		return sqlSession.selectOne("matching.countSavedResults", userNumber);
	}

	// 가장 오래된 결과 삭제 - 5건 초과시 호출
	public void deleteOldestResult(int userNumber) {
		sqlSession.delete("matching.deleteOldestResult", userNumber);
	}

	// 결과 조회 - 마이페이지 목록
	public List<MatchingResultDTO> selectMyResults(int userNumber) {
		return sqlSession.selectList("matching.selectMyResults", userNumber);
	}

	// 결과 조회 - 저장된 결과 1건
	public MatchingResultDTO selectResultByResultNumber(int resultNumber) {
		return sqlSession.selectOne("matching.selectResultByResultNumber", resultNumber);
	}

	// 결과 조회 - 저장된 결과에 연결된 강아지 번호 목록
	public List<Integer> selectResultDogNumbers(int resultNumber) {
		return sqlSession.selectList("matching.selectResultDogNumbers", resultNumber);
	}
	
	
	// 전체 유기견 점수별 조회
	public List<ArchiveScoreDTO>  selectAllDogScore(){
		return sqlSession.selectList("matching.selectAllDogScore");
	}
	
	// 유기견 카드 정보 조회
	public ArchiveListDTO selectDogCardByDogNumber(int dogNumber) {
		return sqlSession.selectOne("matching.selectDogCardByDogNumber", dogNumber);
	}
	

}
