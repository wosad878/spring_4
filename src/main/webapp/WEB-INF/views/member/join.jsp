<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function check(){
		var id = $("#id").val();
		window.open("./idCheck?id="+id,"","height=300,width=300");
	}
	function cancle(){
		history.back();
	}
	var msg = '${msg}';
	if(msg != ""){
	alert(msg);
	}
</script>
</head>
<body>
	<h2>Member Join</h2>
	<form action="./join" method="post">
		<table>
			<tr>
				<td>
					<label>id</label>
					<input type="text" id="id" name="id">
					<input type="button" value="중복확인" onclick="check()">
				</td>
			</tr>
			<tr>
				<td>
					<label>pw</label>
					<input type="text" name="pw">
				</td>
			</tr>
			<tr>
				<td>
					<label>pw2</label>
					<input type="text">
				</td>
			</tr>
			<tr>
				<td>
					<label>name</label>
					<input type="text" name="name">
				</td>
			</tr>
				<tr>
				<td>
					<label>email</label>
					<input type="email" name="email">
				</td>
			</tr>
			<tr>
				<td>
					<label>phone</label>
					<input type="text" name="phone">
				</td>
			</tr>
			<tr>
				<td>
					<label>addr</label>
					<input type="text" name="addr">
				</td>
			</tr>
		</table>
			<button>확인</button>
			<input type="button" value="취소" onclick="cancle()">
	</form>
</body>
</html>