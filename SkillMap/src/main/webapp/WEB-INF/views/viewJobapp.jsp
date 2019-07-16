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
<br/>

<c:if test="${jobapp.emailid==applicant.emailid}">
<div><b>Name:</b>${applicant.name}</div>
<div><b>ContactNo:</b>${applicant.phoneno}</div>
<div><b>EmailID:</b>${applicant.emailid}</div>
<div><b>Address:</b>${applicant.address}</div>
<div><b>Applied On:</b>${jobapp.appliedon}</div>
<div><b>Reason for rejecting:</b><textarea name="reason" rows="3" cols="5"></textarea>
<a href="hr?jobapp=${ja.jobappid}"><button name="rejectreasonbtn" type="submit">Reject</button></a></div>
</c:if>
</body>
</html>