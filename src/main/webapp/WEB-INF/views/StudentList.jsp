<%@ page contentType="text/html; charset=UTF-8"
			import = "java.util.*, model.*" %>

<%
	@SuppressWarnings("unchecked")
	ArrayList<StudentDO> list = (ArrayList<StudentDO>)session.getAttribute("list");
	@SuppressWarnings("unchecked")
	ArrayList<GradeDO> score = (ArrayList<GradeDO>)session.getAttribute("score");
	String result1 = "학생 정보 : </br>";
	String result2 = "점수 : </br>";
	for(StudentDO sDO : list){
		result1 += "<li>" + " id : " + sDO.getId()  + " passwd : " + sDO.getPasswd() + " gender : " + sDO.getGender() + "</li></hr>";	
	}
	for(GradeDO gDO : score){
		result2 += "<li> id : " + gDO.getId() + " 님의 점수 | " + " 국어 : " + gDO.getKO()  + " 영어 : " + gDO.getEN() + " 수학 : " + gDO.getMT() + " 과학 : " + gDO.getSI() + "</li></hr>";	
	}
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>StudentList.jsp</title>
</head>

<body>
	
	<h3>학생 정보 조회</h3>
	<ul>
		<%=result1 %> 
		<%=result2 %>
	</ul>

</body>
</html>