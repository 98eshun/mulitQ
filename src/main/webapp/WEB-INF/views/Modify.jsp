<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Modify.jsp</title>
</head>

<body>
	<h2>정보 수정</h2>
	<form method = "POST">
	<fieldset>
		<legend>학번 입력</legend>
		<label for="id">ID</label>
		<input type="text" name ="id" id ="id"/>
		<hr>
	</fieldset>
	<fieldset>
		<legend>점수 수정</legend>
		<label for="KO">국어</label>
		<input type="number" name ="KO" id ="KO"/>
		<label for="EN">영어</label>
		<input type="number" name ="EN" id ="EN"/>
		<label for="MT">수학</label>
		<input type="number" name ="MT" id ="MT"/>
		<label for="SI">과학</label>
		<input type="number" name ="SI" id ="SI"/>
		
		<input type ="submit" value ="수정"/>
		<input type = "hidden" name="command" value="M_in"/>
		
	</fieldset>
	</form>
</body>
</html>