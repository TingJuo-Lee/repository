<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>首頁</title>
<link rel="stylesheet" href="st1.css">
<style>
form {
	margin: 0 auto;
	width: 1020px;
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
	<form name="insert" action="#" method="POST">
		<span
			style="font-size: 1em; text-align: center; display: -moz-inline-box; display: inline-block; width: 1020px;">${SearchInfo}</span>
		<br>
		<div style="color: #FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>
</body>
</html>