<%@ page language="java" contentType="text/html; charset=ISO-8859-1"  isELIgnored="false"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



<table border="5">
<tr>

<td>ExamID</td>
<td>Question</td>
<td>Date</td>
<td>TotalMarks</td>
<td>Duration</td>
<td>ExamCode</td>
</tr>
<c:forEach items="${exam}" var="list">

<tr>
				<td>${list.examid}</td>
				<td><a>${list.title}</a></td>
				<td>${list.date}</td>
				<td>${list.totalmarks}</td>
				<td>${list.duration}</td>
				<td>${list.examcode}</td>
				
				
				
				
				
				
				
				<td>aaaaaaaaaaa</td>
				
</tr>				


</c:forEach>
</table>
<form action="question" method="get">
 <h1>EXAM CODE:-</h1>
 <select name="examcode">
 <option value="AAA">CORE JAVA</option>
 <option value="BBB">ADVANCE JAVA</option>
 <option value="CCC">C++</option>
</select> 
<input type="submit" value="submit">
</form>
</body>
</html>