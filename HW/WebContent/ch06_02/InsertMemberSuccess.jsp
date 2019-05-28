﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lab06_02</title>
<link rel="stylesheet" href="st1.css">
<style>
h1 {
	margin: 0 auto;
	width: 1000px;
}

h2 {
	margin: 0 auto;
	width: 1000px;
}
</style>
</head>
<body>
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
	<h1>會員 ${ memberBean.memberId } 的資料新增成功</h1>
	<h2>地區: ${ memberBean.area }<br></h2>
	<h2>城市: ${ memberBean.country }<br></h2>
	<h2>名稱: ${ memberBean.name }<br></h2>
	<h2>地址: ${ memberBean.address }<br></h2>
	<h2>電話: ${ memberBean.tel }<br></h2>
</body>
</html>