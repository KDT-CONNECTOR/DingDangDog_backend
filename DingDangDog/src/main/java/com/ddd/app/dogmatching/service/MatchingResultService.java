package com.ddd.app.dogmatching.service;

import java.util.ArrayList;
import java.util.HashMap;
// ===== 멍! 매칭 서비스 ===== 
// ===== 멍! 매칭 서비스 5건 제한 제어, 매칭 알고리즘 실행 및 결과 반환 =====
import java.util.List;
import java.util.Map;

import com.ddd.app.dogarchive.dto.ArchiveListDTO;
import com.ddd.app.dogmatching.dao.MatchingResultDAO;
import com.ddd.app.dogmatching.dto.ArchiveScoreDTO;
import com.ddd.app.dogmatching.dto.MatchingResultDTO;

public class MatchingResultService {

	private final MatchingResultDAO matchingResultDAO;

	// ===== 생성자 =====
	public MatchingResultService(MatchingResultDAO matchingResultDAO) {
		this.matchingResultDAO = matchingResultDAO;
	}

	public List<ArchiveListDTO> getMatchingRecommendation(MatchingResultDTO userScore){

		List<ArchiveScoreDTO> allDog = matchingResultDAO.selectAllDogScore();

		System.out.println("allDog = " + allDog);
		System.out.println("allDog size = " + (allDog == null ? "null" : allDog.size()));

		Map<Integer, Double> scoreMap = new HashMap<>();

		if (allDog == null) {
			System.out.println("selectAllDogScore() 결과가 null입니다.");
			return new ArrayList<>();
		}

		for(ArchiveScoreDTO dogScore : allDog) {
			System.out.println("dogScore = " + dogScore);

			if(dogScore == null) {
				System.out.println("dogScore가 null입니다.");
				continue;
			}

			double score = calculateScore(userScore, dogScore);
			scoreMap.put(dogScore.getDogNumber(), score);
		}

		List<Map.Entry<Integer, Double>> sortedList = new ArrayList<>(scoreMap.entrySet());
		sortedList.sort((a, b) -> Double.compare(b.getValue(), a.getValue()));

		List<Integer> topDogNumbers = new ArrayList<>();
		int limit = Math.min(8, sortedList.size());

		for(int i = 0; i < limit; i++) {
			topDogNumbers.add(sortedList.get(i).getKey());
		}

		System.out.println("topDogNumbers = " + topDogNumbers);

		List<ArchiveListDTO> recommendedDogs = new ArrayList<>();

		for(Integer dogNumber : topDogNumbers) {
			ArchiveListDTO dog = matchingResultDAO.selectDogCardByDogNumber(dogNumber);
			System.out.println("card dog = " + dog);

			if(dog != null) {
				recommendedDogs.add(dog);
			}
		}

		return recommendedDogs;
	}
	
	//편차 계산용
	private double calculateScore(MatchingResultDTO user, ArchiveScoreDTO dog) {
		if (dog == null) {
			throw new IllegalArgumentException("calculateScore로 들어온 dog가 null입니다.");
		}

	    double result = 0;

	    result += 5 - Math.abs(((double) user.getDogActivity() / 4) - dog.getDogActivity());
	    result += 5 - Math.abs(((double) user.getDogSociality() / 4) - dog.getDogSociality());
	    result += 5 - Math.abs(((double) user.getDogIndependence() / 4) - dog.getDogIndependence());
	    result += 5 - Math.abs(((double) user.getDogBarking() / 4) - dog.getDogBarking());
	    result += 5 - Math.abs(((double) user.getDogGrooming() / 4) - dog.getDogGrooming());

	    return result;
	}
}