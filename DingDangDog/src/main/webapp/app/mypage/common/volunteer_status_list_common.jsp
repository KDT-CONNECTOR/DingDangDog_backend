<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>멍! 케어 신청확인</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/common/volunteer_status_list_common.css" />
  <script defer src="${pageContext.request.contextPath}/assets/js/mypage/common/volunteer_status_list_common.js"></script>
</head>

<body>
  <!-- header -->
  <div id="header-container"></div>
  <main class="volunteer_status_list_common">
    <div class="container">
      <aside class="sidebar">
        <nav class="side-menu">
          <a class="btn-side-link" href="${pageContext.request.contextPath}/profile_edit_common.html">내 정보 변경</a>
          <hr>
          <a class="btn-side-link" href="${pageContext.request.contextPath}/volunteer_status_list_common.html">멍! 케어 신청 확인</a>
          <hr>
          <a class="btn-side-link" href="${pageContext.request.contextPath}/review_list.html">내가 작성한 멍! 로그 목록</a>
          <hr>
          <a class="btn-side-link" href="${pageContext.request.contextPath}/app/mypage/common/support_list_common.jsp">1 : 1 문의</a>
        </nav>
      </aside>

      <section class="content">
        <div class="content-box">
          <div class="panel">
            <div class="panel-head">
              <h2 class="panel-title">멍! 케어 신청 확인</h2>
            </div>

            <div class="panel-body">
              <div class="volunteer-table">
                <div class="volunteer-table-head">
                  <div class="col-date">봉사 날짜</div>
                  <div class="col-title">제목</div>
                  <div class="col-name">보호소 명</div>
                  <div class="col-cancel">신청 취소</div>
                </div>

                <a href="#">
                <div id="volunteerTableBody"></div>
                </a>
              </div>

              <div class="panel-footer">
                <div class="pagination">
                  <ul class="page-list" id="pagination"></ul>
                </div>
              </div>
            </div>
          </div>
        </div>
      </section>
    </div>
  </main>
  <!-- footer -->
  <div id="footer-container"></div>
  <!-- js -->
  <script src="/assets/js/header-footer.js"></script>
</body>

</html>