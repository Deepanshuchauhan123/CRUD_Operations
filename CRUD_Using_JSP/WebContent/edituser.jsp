<%@page import="com.deepanshu.UserDao" %>
	
	<jsp:useBean id="u" class="com.deepanshu.User"></jsp:useBean>
	<jsp:setProperty property="*" name="u"/> 
	
	<%
		int i=UserDao.update(u);
		response.sendRedirect("viewusers.jsp"); 
	%>
	
