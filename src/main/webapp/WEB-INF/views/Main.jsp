<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Main.jsp</title>
</head>

<body>
	<h2>학생 성적 관리 프로그램</h2>
	<hr>
		<fieldset>
		<form method="POST">
			<label for="insert">1.학생 정보 입력</label><br/>
			<input type="submit" value="이동"/>
			<input type = "hidden" name="command" value="insert"/>
			<hr/>
		</form>
		
		<form method="POST">
			<label for="list">2.학생 정보 조회</label><br/>
			<input type="submit" value="이동"/>
			<input type = "hidden" name="command" value="list"/>
			<hr/>
		</form>
		
		<form method="POST">
			<label for="modify">3.성적 변경</label><br/>
			<input type="submit" value="이동"/>
			<input type = "hidden" name="command" value="modify"/>
			<hr/>
		</form>
		
		<form method="POST">
			<label for="delete">4.학생 정보 삭제</label><br/>
			<input type="submit" value="이동"/>
			<input type = "hidden" name="command" value="delete"/>
			<hr/>
		</form>
		
		</fieldset>
</body>
</html>