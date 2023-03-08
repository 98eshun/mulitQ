<%@ page contentType="text/html; charset=UTF-8"
			import="model.*"%>
<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
}
%>

<jsp:useBean id="gradeDO" class="model.GradeDO" scope = "page"/>
<jsp:useBean id="studentDO" class="model.StudentDO" scope = "page"/> <!-- scope = 페이지 마다 만들어라 -->
<jsp:useBean id="studentInfoDAO" class="model.StudentInfoDAO" scope = "session"/> <!-- scope = 세션 마다 만들어라 -->
<jsp:setProperty name = "gradeDO" property="*"/>
<jsp:setProperty name = "studentDO" property="*"/>

<%
	String viewPath = "/WEB-INF/views/";
	String command = request.getParameter("command");

	if(request.getMethod().equals("GET")){
		pageContext.forward(viewPath + "Main.jsp");
	}
	else if(request.getMethod().equals("POST")){
		StudentDO sDO = StudentInfoDAO.getLoginDO(loginDO);
		
		if(tDO != null){
			session.setAttribute("id", tDO.getId());
			session.setAttribute("name", tDO.getName());
			
			response.sendRedirect("controller.jsp");
			//session.setAttribute("list". twitterDAO.getAllTwitter());
			// pageContext.forward(viewPath + "twitterList.jsp")
		}
		if(command != null && command.equals("insert")){
			pageContext.forward(viewPath + "Insert.jsp");
		}
		else if(command != null && command.equals("list")){
			pageContext.forward(viewPath + "StudentList.jsp");
		}
		else if(command != null && command.equals("modify")){
			pageContext.forward(viewPath + "Insert.jsp");
		}
		else if(command != null && command.equals("delete")){
			pageContext.forward(viewPath + "Insert.jsp");
		}
		else if(command != null && command.equals("off")){
			pageContext.forward(viewPath + "Insert.jsp");
		}
}
%>
