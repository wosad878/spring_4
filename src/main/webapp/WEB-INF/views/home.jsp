<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="true" %>
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<title>Home</title>
<script type="text/javascript">
	var msg = '${msg}';
	if(msg != ""){
	alert(msg);
	}
	
</script>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>
	<a href="./qna/qnaList">QnaList</a>
	<a href="./notice/noticeList">NoticeList</a>
	<c:choose>
		<c:when test="${not empty member}">
			<p>
				<a href="./member/myPage">MyPage</a>
				<a href="./member/logout">logOut</a>
			</p>
		</c:when>
		<c:otherwise>
			<p>
				<a href="./member/join">join</a>
				<a href="./member/login">login</a>
			</p>
		</c:otherwise>
	</c:choose>
</body>
</html>
