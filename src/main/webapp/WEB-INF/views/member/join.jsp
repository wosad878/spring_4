<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<script type="text/javascript">
$(function() {
	var check = false;
	
	$("#id").change(function(){
		check = false;
	});
	
	$("#id").blur(function(){
		var id = $(this).val();
		$.get("./idCheck?id="+id, function(result){
			result = result.trim();
			var msg = "사용 할 수 없는 ID";
			if(result != 0){
				msg = "사용 가능 한 ID";
				check = true;
			} 
			$("#result").html(msg);
		});
		
	});
	
	$("#btn").click(function(){
		if(check == true){
			$("#frm").submit();
		} else{
			alert("중복확인 하세요");
		}
	});
	var msg = '${msg}';
	if(msg != ""){
		alert(msg);
	}
});

</script>
</head>
<body>
	<h2>Member Join</h2>
	<form id="frm" action="./join" method="post">
		<p>ID : <input type="text" name="id" id="id"></p>
		<p id="result"></p>
		<p>PW : <input type="password" name="pw"></p>
		<p>NAME : <input type="text" name="name"></p>
		<p>EMAIL : <input type="email" name="email"></p>
		<p>PHONE : <input type="text" name="phone"></p>
		<p>ADDRESS : <input type="text" name="addr"></p>
		<input type="button" value="join" id="btn">
	</form>
</body>
</html>