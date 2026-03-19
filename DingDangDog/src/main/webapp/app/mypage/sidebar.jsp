<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
 <link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/mypage/sidebar.css" />
<aside class="sidebar">
	<nav class="side-menu">
		<a class="btn-side-link"
			href="${pageContext.request.contextPath}/app/mypage/common/profile_edit_common.jsp">내
			정보 변경</a>
		<hr>
		<a class="btn-side-link"
			href="${pageContext.request.contextPath}/app/mypage/common/volunteer_status_list_common.jsp">멍!
			케어 신청 확인</a>
		<hr>
		<a class="btn-side-link"
			href="${pageContext.request.contextPath}/app/mypage/common/review_list.jsp">내가
			작성한 멍! 로그 목록</a>
		<hr>
		<a class="btn-side-link"
			href="${pageContext.request.contextPath}/app/mypage/common/support_list_common.jsp">1
			: 1 문의</a>
	</nav>
</aside>