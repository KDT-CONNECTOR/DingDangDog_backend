<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!doctype html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>멍! 매칭</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dogmatching/dogmatching.css" />
  <script defer src="${pageContext.request.contextPath}/assets/js/dogmatching/dogmatching.js"></script>
  
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/header.css" />
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/footer.css" />
</head>

<body>
  <div id="header-container">
  	 <c:choose>
	  <c:when test="${not empty sessionScope.userNumber}">
	    <jsp:include page="/app/header_login.jsp" />
	  </c:when>
	  <c:otherwise>
	    <jsp:include page="/app/header_logout.jsp" />
	 </c:otherwise>
  	</c:choose>
  </div>

  <main>
    <div class="dogmatching-main-container">
      <div class="main-header">
        <div class="main-header-title">멍! 매칭</div>
        <div class="page-notification">
          설문 종료를 누르지 않으면 내용이 저장되지 않습니다
        </div>
      </div>

      <div class="main-content">
        <form action="${pageContext.request.contextPath}/matching/matchingOk.ma" method="post" id="dogmatching-form">

          <!-- 최종 합산값 -->
          <input type="hidden" name="dogActivity" id="dogActivity">
          <input type="hidden" name="dogSociality" id="dogSociality">
          <input type="hidden" name="dogIndependence" id="dogIndependence">
          <input type="hidden" name="dogBarking" id="dogBarking">
          <input type="hidden" name="dogGrooming" id="dogGrooming">

          <!-- Q1 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q01. 나는 산책이나 야외활동을 자주 즐기는 편이다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q2 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q02. 집 안에만 있기보다 함께 움직이며 놀아주는 시간이 중요하다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q3 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q03. 활발하고 에너지 넘치는 반려견을 선호한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q4 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q04. 주말에 반려견과 외부 활동을 함께할 의향이 높다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q5 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q05. 사람이나 다른 동물과 잘 어울리는 성격을 중요하게 생각한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q6 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q06. 낯선 사람과도 비교적 쉽게 친해지는 반려견이 좋다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q7 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q07. 가족이나 방문객과 자연스럽게 어울릴 수 있는 반려견을 원한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q8 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q08. 다른 강아지와의 사회성이 좋은 편이면 더 선호한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q9 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q09. 혼자 있는 시간에도 비교적 안정적인 반려견이 좋다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q10 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q10. 계속 옆에 붙어 있기보다 어느 정도 독립적인 성향도 괜찮다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q11 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q11. 잠시 집을 비워도 스트레스가 적은 성향을 선호한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q12 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q12. 늘 관심을 요구하기보다 자기만의 시간을 가질 수 있는 반려견이 좋다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q13 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q13. 짖음이 너무 많은 반려견은 부담스럽게 느껴진다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q14 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q14. 이웃이나 공동주택 환경을 생각하면 조용한 성향이 좋다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q15 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q15. 낯선 자극에 과하게 반응하지 않는 성향을 선호한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q16 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q16. 생활 소음에 민감하지 않은 반려견이면 좋겠다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q17 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q17. 털 빠짐이나 그루밍 관리가 너무 많은 것은 부담스럽다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q18 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q18. 미용이나 털 관리에 너무 많은 시간을 쓰기 어렵다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q19 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q19. 일상적으로 손질이 비교적 쉬운 반려견을 선호한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <!-- Q20 -->
          <div class="survey-items">
            <div class="survey-items-header">
              <span>Q20. 털 관리에 대한 부담이 적은 생활을 원한다.</span>
            </div>
            <div class="survey-items-response">
              <div><span class="survey-text">그렇다</span></div>
              <div class="circles-container">
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
                <div class="circle"></div>
              </div>
              <div><span class="survey-text">그렇지 않다</span></div>
            </div>
            <div class="radio-container">
              <input type="radio" class="survey-radio" value="5" />
              <input type="radio" class="survey-radio" value="4" />
              <input type="radio" class="survey-radio" value="3" />
              <input type="radio" class="survey-radio" value="2" />
              <input type="radio" class="survey-radio" value="1" />
            </div>
          </div>

          <div class="submit-btn-container">
            <button id="dogmatching-submit" type="submit" class="dogmatching-submit-btn">
              멍! 매칭 완료
            </button>
          </div>
        </form>
      </div>
    </div>
  </main>

  <div id="footer-container"><jsp:include page="/app/footer.jsp" /></div>
</body>

</html>