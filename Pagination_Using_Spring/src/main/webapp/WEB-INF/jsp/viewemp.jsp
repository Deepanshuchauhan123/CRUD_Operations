   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
   <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<body>
		<h1>Employee List</h1>
		<table border="2" width="70%" cellpadding="2">
			<tr><th>ID</th><th>Name</th><th>Salary</th> 
			<c:forEach var="emp" items="${msg}">
				<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.salary}</td>
				</tr>
			</c:forEach>	 
		</table>
		 <br/>  
      <a href="/spring/viewemp/1">1</a>     
   <a href="/spring/viewemp/2">2</a>     
   <a href="/spring/viewemp/3">3</a> 
</body>
</html>