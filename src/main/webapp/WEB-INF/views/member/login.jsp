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
	<form action="./login" method="post">
		id : <input type="text" name="id">
		pw : <input type="text" name="pw">
		<button>확인</button>
	</form>
</body>
</html>