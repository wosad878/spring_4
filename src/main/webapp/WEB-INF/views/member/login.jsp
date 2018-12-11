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
</script>
</head>
<body>
	<H1>Login Page</H1>
	<form action="./login" method="post">
		<p>id : <input type="text" name="id"></p>
		<p>pw : <input type="password" name="pw"></p>
		<button>확인</button>
	</form>
</body>
</html>