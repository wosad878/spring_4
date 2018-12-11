<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js" ></script>
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
	<h1>${board} Write</h1>
	<form action="./${board}Write" method="post" enctype="multipart/form-data">
		<input type="text" name="title">
		<input type="text" name="writer">
		<textarea rows="" cols="" name="contents"></textarea>
		<input type="button" value="add" id="button">
		<div id="files">
			<div id="file">
				<input type="file" name="f1"><span id="xbutton" style="cursor: pointer;">X</span>
				<input type="file" name="f1"><span id="xbutton" style="cursor: pointer;">X</span>
			</div>
		</div>
		<button>Write</button>
	</form>
</body>
</html>