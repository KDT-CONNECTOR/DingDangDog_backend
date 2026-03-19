<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!doctype html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>멍! 케어 리스트(일반회원)</title>

  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/dogcare/dogcare_list.css" />
  <script defer src="${pageContext.request.contextPath}/assets/js/dogcare/dogcare_list.js"></script>
</head>

<body>

<!-- header -->

<main>
  <div class="dogcare-main-container">

    <div class="main-container-header">
      <div class="main-header-title">멍! 케어</div>
    </div>

    <div class="dogcare-list-container">

      <div class="dogcare-list-title">멍! 케어 목록</div>

      <!-- 리스트 헤더 -->
      <div class="dogcare-list-header">
        <div class="dogcare-number">게시글 번호</div>
        <div class="dogcare-title">제목</div>
        <div class="dogcare-date">봉사 날짜</div>
        <div class="dogcare-nickname">닉네임</div>
        <div class="dogcare-registdate">작성 날짜</div>
      </div>

      <!-- 게시글 목록 -->
      <c:forEach var="care" items="${careList}">
        <div class="dogcare-list-row">
          <div class="dogcare-number">
            ${care.careNumber}
          </div>
          <div class="dogcare-title">
            <a href="${pageContext.request.contextPath}/care/detail?careNumber=${care.careNumber}">
              ${care.careTitle}
            </a>
          </div>
          <div class="dogcare-date">
            ${care.careDate}
          </div>
          <div class="dogcare-nickname">
            ${care.userNickname}
          </div>
          <div class="dogcare-registdate">
            ${care.careWriteDate}
          </div>
        </div>
      </c:forEach>

      <!-- 검색 -->
      <form action="${pageContext.request.contextPath}/care/list" method="get">
        <div class="search-box">
          <select name="type" class="search-select box-shadow">
            <option value="shelter">보호소명</option>
            <option value="title">제목</option>
          </select>
          <input type="text" name="keyword" class="search-input box-shadow" />
          <button class="btn-search box-shadow">
            검색
          </button>
        </div>
      </form>

      <!-- 페이지네이션 -->
      <div class="main-container-footer">
        <div class="pagination">
          <ul class="page-list">
            <li>
              <button class="prev-btn">&lt;</button>
            </li>
            <c:forEach var="page" begin="1" end="${totalPage}">
              <li>
                <button class="page-item
                <c:if test='${page == currentPage}'>current-page</c:if>'">
                  ${page}
                </button>
              </li>
            </c:forEach>
            <li>
              <button class="next-btn">&gt;</button>
            </li>
          </ul>
        </div>
      </div>
    </div>
  </div>
</main>


<!-- footer -->

</body>
</html>