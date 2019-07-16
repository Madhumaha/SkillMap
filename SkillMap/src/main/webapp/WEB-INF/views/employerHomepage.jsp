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

<button onclick="toggleJobForm()">Post new Job</button>
<form action="employer"><button type="submit" name="listbtn" >List of Jobs</button></form>
<a href="logout"><button >Logout</button></a>

<div id="job">
<form id="jobform" action="employer" method="post">
<input type="hidden" name="jodid" />
<input type="hidden" name="compid" />
<table>
<tr><td>
    <label><b>JobTitle</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter Job Title" name="jobtitle" required>
</td></tr>

<tr><td>
    <label><b>Qualification</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter Qualification" name="qualification" required>
</td></tr>
<tr><td>
    <label><b>Experience</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter Experience" name="experience" required>
</td></tr>
<tr><td>
    <label><b>Location</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter Location" name="location" required>
</td></tr>
<tr><td>
    <label><b>CTC</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter CTC" name="ctc" required>
</td></tr>
<tr><td>
    <label><b>LastDate</b></label>
    </td>
    <td>
    <input type="date" placeholder="Enter LastDate" name="lastdate" required>
</td></tr>
<tr><td>
    <label><b>RequiredSkills</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter RequiredSkills" name="reqskills" required>
</td></tr>
<tr> <td></td>
     <td>  
    <button type="submit" name="addjob">Post Job</button></td>
    </tr>
</table>
</form>


<c:if test="${!empty companyJobs}">
<p id="joblist">List of jobs</p>
<table>
<tr>
<th>JobTitle</th>
<th>JobLocation</th>
<th>Experience</th>
<th>CTC</th>
<th>Qualification</th>
<th>Req. Skills</th>
<th>PostedOn</th>
<th>LastDate</th>

</tr>
<c:forEach items="${companyJobs}" var="j">
<tr>
<td>${j.jobtitle}</td>
<td>${j.location}</td>
<td>${j.experience}</td>
<td>${j.ctc}</td>
<td>${j.qualification}</td>
<td>${j.reqskills}</td>
<td>${j.postedon}</td>
<td>${j.lastdate}</td>
<td><a href="jobapp?jobid=${j.jobid}"><button>View Applications</button></a></td>
</tr>
</c:forEach>
</table>
</c:if>
</div>



<script>

	function toggleJobForm() {
		  var x = document.getElementById("jobform");
		  if (x.style.display === "none") {
		    x.style.display = "block";
		  } else {
		    x.style.display = "none";
		  }
		}
	
	/* function toggleJobList() {
		  var x = document.getElementById("joblist");
		  if (x.style.display === "none") {
		    x.style.display = "block";
		  } else {
		    x.style.display = "none";
		  }
		} */
	
	
toggleJobForm();
//toggleJobList();
</script>


</body>
</html>