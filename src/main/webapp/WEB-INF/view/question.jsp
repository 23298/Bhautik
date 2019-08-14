<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	isELIgnored="false" pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="examscore" method="get">
	<table border="5">
		<tr>
		<td>QuestionId</td>
		<td>option</td>
		<td>opetion1</td>
       		<td>opetion2</td>
			<td>opetion3</td>
			<td>opetion4</td>
			<td>EXAM ID</td>
			
		
	</tr>

<c:forEach items="${question}" var="list1">
<c:set var="i" value="${i+1}"></c:set>

			<tr>
		          <td><input type="text" name="questionid${i}" value="${list1.questionid}"></td>   
				<td>${list1.question}</td>
				<td><input type="radio" name="option${i}" value="${list1.o1}"> ${list1.o1}</td> 
				<td><input type="radio" name="option${i}" value="${list1.o2}">${list1.o2}</td>
				<td><input type="radio" name="option${i}" value="${list1.o3}">${list1.o3}</td>
				<td><input type="radio" name="option${i}" value="${list1.o4}">${list1.o4}</td>
	           	<td><input type="text" name="examid" value="${exam.examid}"></td>	
	           		
				<td></td>
            </tr>				


		</c:forEach>
	</table>
		
		<table>
		<tr>
		<td colspan="5" rowspan="6"><input type="submit" value="submit"></td>
		</tr>
		</table>
		
	</form>
</html>