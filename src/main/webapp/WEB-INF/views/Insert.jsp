<%@ page contentType="text/html; charset=UTF-8"
		import="model.*,java.util.*"%>

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
		<input type ="text" name ="passwd" id ="passwd"/>
		<label for ="gender">gender</label>
		<input type ="text" name ="gender" id ="gender"/>
	</fieldset>
	<fieldset>
		<legend>점수 입력</legend>
		<label for="KO">국어</label>
		<input type="number" name ="KO" id ="KO"/>
		<label for="EN">영어</label>
		<input type="number" name ="EN" id ="EN"/>
		<label for="MT">수학</label>
		<input type="number" name ="MT" id ="MT"/>
		<label for="SI">과학</label>
		<input type="number" name ="SI" id ="SI"/>
		
		<input type = "hidden" name="command" value="in"/>
		<input type ="submit" value ="입력"/>
		
	</fieldset>
	</form>
</body>
</html>