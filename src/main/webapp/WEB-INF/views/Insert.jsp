<%@ page contentType="text/html; charset=UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert.jsp</title>
</head>

<body>
	<h1>학생 정보 입력</h1>
	<hr/>
	
	<form method = "POST">
	<fieldset>
		<legend>정보 입력</legend>
		<label for="id">ID</label>
		<input type="text" name ="id" id ="id"/>
		<label for ="passwd">Passwd</label>
		<input type ="password" name ="passwd" id ="passwd"/>
		<hr>
		<label for="gender">Gender</label><br/>
		<label for ="man">남</label>
		<input type="radio" name ="gender" id ="man" value="남"/>
		<label for ="woman">여</label>
		<input type="radio" name ="gender" id ="woman" value="여"/>
	</fieldset>
	<fieldset>
		<legend>점수 입력</legend>
		<label for="KO">KO</label>
		<input type="number" name ="grade" id ="KO"/>
		<label for="EN">EN</label>
		<input type="number" name ="grade" id ="EN"/>
		<label for="MT">MT</label>
		<input type="number" name ="grade" id ="MT"/>
		<label for="SI">SI</label>
		<input type="number" name ="grade" id ="SI"/>
		
		<input type ="submit" value ="insert"/>
	</fieldset>
	</form>
</body>
</html>