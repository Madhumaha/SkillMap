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

<c:if test="${!empty newjobapps}">
<p id="joblist">List of jobs</p>
<div>
<c:forEach items="${newjobapps}" var="ja">
<c:forEach items="${userList}" var="u">
<c:if test="${ja.emailid==u.emailid}">
<div><b>Name:</b>${u.name}</div>
<div><b>ContactNo:</b>${u.phoneno}</div>
<div><b>EmailID:</b>${u.emailid}</div>
<div><b>Address:</b>${u.address}</div>
<div><b>Applied On:</b>${ja.appliedon}</div>
<div><a href="hr?jobappid=${ja.jobappid}"><button name="btn" value="approve" type="submit">Approve</button></a>
<a href="hr?jobappid=${ja.jobappid}&email=${u.emailid}"><button name="btn" value="reject" type="submit">Reject</button></a></div>
</c:if>
</c:forEach>
</c:forEach>
</div>
</c:if>

</body>
</html>