<%@page import="oracle.jdbc.OracleConnection.CommitOption"%>
<%@ page contentType="text/html; charset=UTF-8"
			import="model.*"%>
<%
	if(request.getMethod().equals("POST")) {
		request.setCharacterEncoding("UTF-8");
}
%>

<jsp:useBean id="gradeDO" class="model.GradeDO" scope = "page"/>
<jsp:useBean id="studentDO" class="model.StudentDO" scope = "page"/>
<jsp:useBean id="studentInfoDAO" class="model.StudentInfoDAO" scope = "session"/>
<jsp:setProperty name = "gradeDO" property="*"/>
<jsp:setProperty name = "studentDO" property="*"/>

<%
	String viewPath = "/WEB-INF/views/";
	String command = request.getParameter("command");

	if(request.getMethod().equals("GET")){
		pageContext.forward(viewPath + "Main.jsp");
	}
	else if(request.getMethod().equals("POST")){
		
		if(command != null && command.equals("insert")){
			pageContext.forward(viewPath + "Insert.jsp");
		}
		else if(command != null && command.equals("list")){
			session.setAttribute("list",studentInfoDAO.getAllStudent());
			session.setAttribute("score",studentInfoDAO.getAllGrade());
			pageContext.forward(viewPath + "StudentList.jsp");
		}
		else if(command != null && command.equals("in")){
			studentInfoDAO.insertInfo(studentDO);
			studentInfoDAO.insertScore(gradeDO);
			response.sendRedirect("controller.jsp");
		}
		else if(command != null && command.equals("modify")){
			pageContext.forward(viewPath + "Modify.jsp");
		}
		else if(command != null && command.equals("M_in")){
			String id = request.getParameter("id");
			studentInfoDAO.modifyScore(id,gradeDO);
			response.sendRedirect("controller.jsp");
		}
		else if(command != null && command.equals("delete")){
			pageContext.forward(viewPath + "Delete.jsp");
		}
		else if(command != null && command.equals("D_in")){
			String id = request.getParameter("id");
			studentInfoDAO.delete(studentDO);
			response.sendRedirect("controller.jsp");
		}
}
%>
