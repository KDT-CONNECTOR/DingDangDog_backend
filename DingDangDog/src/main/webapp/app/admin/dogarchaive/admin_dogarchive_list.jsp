<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>멍! 카이브 리스트</title>
  <link rel="stylesheet" href="${contextPath}/assets/css/admin/admin.css">
  <link rel="stylesheet" href="${contextPath}/assets/css/admin/dogarchive/admin_dogarchive_list.css">
  <script defer src="${contextPath}assets/js/admin/admin_dogarchive_list.js"></script>
</head>

   	<!-- 서버 데이터(임시) -->
	<script>
	  const contextPath = "${contextPath}";
	  const reviewData = [
	    <c:forEach var="log" items="${logList}" varStatus="status">
	      {
	        id: ${empty archive.dogarchiveNumber ? 0 : archive.dogarchiveNumber},
	        dogName: "<c:out value='${log.dogName}'/>",
	        dogAge: "<c:out value='${log.dogAge}'/>",
	        dogWeight: "<c:out value='${log.dogWeight}'/>",
	        dogType:	"<c:out value='${log.dogType}'/>",
	        userNickName:	"<c:out value='${log.userNickName}'/>",
	        dogDate:"${log.logDate}"
	      }<c:if test="${!status.last}">,</c:if>
	    </c:forEach>
	  ];
	</script>
	
	


<body>
  <!-- 전체화면 -->
  <main class="admin-main-container">
    <!-- 사이드바 -->
    <aside class="admin-sidebar"></aside>
    <!-- 메인 화면 -->
    <section class="admin-main-section">
      <!-- 페이지 상단 (제목, 버튼) -->
      <div class="admin-main-section-header">
        <div class="admin-title">멍! 카이브 리스트</div>
      </div>
      <!-- 페이지 컨텐츠 -->
      <div class="admin-main-content">
        <!-- 테이블등 정보 -->
        <div class="admin-dogarchive-list-header">
          <div class="dogarchive-number">등록 번호</div>
          <div class="dogarchive-name">이름</div>
          <div class="dogarchive-age">나이</div>
          <div class="dogarchive-weight">몸무게</div>
          <div class="dogarchive-type">견종</div>
          <div class="dogarchive-shelter">등록 보호소</div>
          <div class="dogarchive-date">보호 날짜</div>
        </div>
        
		<div id="archiveTableBody"></div>
 

      </div>
      <!-- 페이지 하단 (검색, 페이지네이션) -->
      <div class="admin-main-section-footer">

        <!-- 검색 -->
        <div class="search-box">
          <select class="search-select">
            <option>이름</option>
            <option>견종</option>
            <option>보호소명</option>
          </select>
          <input type="text" class="search-input">
          <button class="btn-search">검색</button>
        </div>

        <!-- 페이지네이션 -->
        <div class="pagination">
          <ul class="page-list">
            <li>
              <button class="prev-btn">
                <span>&lt;</span>
              </button>
            </li>
            <li>
              <button class="next-btn"><span>&gt;</span></button>
            </li>
          </ul>
        </div>
      </div>
    </section>
  </main>
</body>
</html>