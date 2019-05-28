<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:useBean id="MemberService" class="ch06_02.MemberService" />
<c:set var="subTitle" value="查詢會員資料(Lab07_02)" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>查詢會員資料</title>
<link rel="stylesheet" href="st1.css">
<style>
table{
margin: 0 auto;
}
form {
	margin: 0 auto;
	width: 600px;
}
</style>
</head>
<body onload="javascript:document.insertMemberFormA.mId.focus();">
	<div class="allpage">
		<header>
			<nav>
				<ul class="menu">
					<li><a href="InsertMemberForm.jsp">新增</a></li>
					<li><a href="UpdateForm.jsp">修改</a></li>
					<li><a href="SearchForm.jsp">查詢</a></li>
					<li><a href="DeleteForm.jsp">刪除</a></li>
					<li><a href="SelectAll.jsp">查詢全部</a></li>
				</ul>
			</nav>
			<img src="logo.jpg" alt="logo" title="logo" width="1024">
		</header>
	</div>
		<c:choose>
		<c:when test="${empty MemberService.allinfo}">
   			目前尚未有任何會員資料<br>
		</c:when>
		<c:otherwise>
         
			<table border='1'>
				<tr>
					<th width='120'>Id</th>
					<th width='120'>area</th>
					<th width='140'>country</th>
					<th width='360'>name</th>
					<th width='130'>address</th>
					<th width='150'>tel</th>
				</tr>
				<c:forEach var="MemberBean" items="${MemberService.allinfo}">
					<tr>
						<td>${MemberBean.memberId}</td>
						<td>${MemberBean.area}</td>
						<td>${MemberBean.country}</td>
						<td>${MemberBean.name}</td>
						<td>${MemberBean.address}</td>
						<td>${MemberBean.tel}</td>
					</tr>
				</c:forEach>
			</table>

		</c:otherwise>
	</c:choose>
</body>
</html>