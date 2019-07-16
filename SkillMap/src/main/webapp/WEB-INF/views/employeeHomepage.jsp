<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<c:if test="${ empty loggedInUser}">
<% response.sendRedirect("/WEB-INF/views/login.jsp"); %>
</c:if>

Welcome ${loggedInUser}

<a href="logout"><button >Logout</button></a>

<c:if test="${!empty alljobs}">
<p id="joblist">List of jobs</p>
<div>
<c:forEach items="${alljobs}" var="j">

<div><b>JobTitle:</b>${j.jobtitle}</div>
<div><b>JobLocation:</b>${j.location}</div>
<div><b>Experience:</b>${j.experience}</div>
<div><b>CTC:</b>${j.ctc}</div>
<div><b>Qualification:</b>${j.qualification}</div>
<div><b>Req. Skills:</b>${j.reqskills}</div>
<div><b>PostedOn:</b>${j.postedon}</div>
<div><b>LastDate:</b> ${j.lastdate}
<br/>
<form action="jobapp?jobid=${j.jobid}" method="post"><button type="submit">Apply for job</button></form>
</div>

</c:forEach>
</div>
</c:if>


</body>
</html>