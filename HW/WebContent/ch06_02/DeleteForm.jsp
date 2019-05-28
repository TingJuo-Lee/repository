<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>刪除會員</title>
<link rel="stylesheet" href="st1.css">
<style>
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
	<form name="insertMemberFormA" action="Delete.do" method="POST">
		<table border="1">
			<thead>
				<tr bgcolor='#66ccff'>
					<th height="60" colspan="2" align="center">刪除會員資料</th>
				</tr>
			</thead>
			<tbody>
				<tr bgcolor='#66ccff'>
					<td width="120" height="40">ID:</td>
					<td width="600" height="40" align="left"><input id='num'
						style="text-align: left" name="mId" value="${param.mId}"
						type="text" size="14">
						<div style="color: #FF0000; font-size: 60%; display: inline">${ErrorMsg.id}</div>
					</td>
				</tr>
				<tr bgcolor='#66ccff'>
					<td height="50" colspan="2" align="center"><input
						type="submit" value="送出"></td>
				</tr>
			</tbody>
		</table>
		<div style="color:#FF0000; display: inline">${ErrorMsg.exception}</div>
	</form>

</body>
</html>