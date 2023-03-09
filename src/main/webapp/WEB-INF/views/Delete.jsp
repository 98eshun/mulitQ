<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Delete.jsp</title>
</head>

<body>
	<h2>정보 삭제</h2>
	
	<form method = "POST">
	<fieldset>
		<legend>삭제를 위한 학번 입력</legend>
		<label for="id">ID</label>
		<input type="text" name ="id" id ="id"/>
		<hr>
		<input type ="submit" value ="삭제"/>
		<input type = "hidden" name="command" value="D_in"/>
	</fieldset>
	</form>
</body>
</html>