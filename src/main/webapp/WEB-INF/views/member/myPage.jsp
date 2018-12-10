<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var msg = '${msg}';
	if(msg != ""){
	alert(msg);
	}

	function cancle(){
		history.back();
	}
</script>
</head>
<body>
	<form action="./myPage" method="post">
		id : <input type="text" readonly="readonly" name="id" value="${member.id}"><br>
		pw : <input type="text" name="pw" value="${member.pw }"><br>
		email : <input type="text" name="email" value="${member.email}"><br>
		phone : <input type="text" name="phone" value="${member.phone}"><br>
		addr : <input type="text" name="addr" value="${member.addr}">
		<button>확인</button>
		<input type="button" value="취소" onclick="cancle()">
	</form>
</body>
</html>