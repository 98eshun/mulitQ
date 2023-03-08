<%@ page contentType="text/html; charset=UTF-8"
			import = "java.util.*, model.*" %>

<%
	@SuppressWarnings("unchecked")
	ArrayList<StudentDO> list = (ArrayList<StudentDO>)session.getAttribute("lsit"); // getAttribute는 오브젝트로 넘어오기 때문에 형변환
	String result = "";
	
	for(StudentDO sDO : list){
		result += "<li>" + sDO.getId() + ":::" + sDO.getName() + ":::" + sDO.getGender() + "</li>";	
	}
%>

<!DOCTYPE html>

<html>
<head>
	<meta charset="UTF-8">
	<title>twitterList.jsp</title>
</head>

<body>

	<h2>My Simple Twitter!!</h2>
	<hr />
	
	<h3>트위터 리스트</h3>
	<ul>
		<%= result %>
	</ul>

</body>
</html>