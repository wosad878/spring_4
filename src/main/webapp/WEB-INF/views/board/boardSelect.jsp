<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	$(function(){
		$("#del").click(function(){
			$("#frm").submit();
		});
		var msg = '${msg}';
		if(msg != ''){
		alert(msg);
		}
	});
</script>
</head>
<body>
	<h1>${board} Select</h1><hr>
	
	<h3>Num : ${boardDTO.num}</h3>
	<h3>Title : ${boardDTO.title}</h3>
	<h3>Writer : ${boardDTO.writer}</h3>
	<h3>Contents : ${boardDTO.contents}</h3>
	
	<a href="./${board}List">List</a>
	<a href="./${board}Update?num=${boardDTO.num}">Update</a>
	<span id="del">Delete</span>
	<form id="frm" action="./${board}Delete" method="post">
		<input type="hidden" name="num" value="${boardDTO.num}">
	</form>
	<c:if test="${board ne 'notice'}">
		<a href="./${board}Reply?num=${boardDTO.num}">Reply</a>
	</c:if>
</body>
</html>