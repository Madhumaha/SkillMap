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

<form action="register" method="post">
<table>

<tr><td>
    <label><b>Name</b></label>
    </td>
    <td>
    <input type="text" placeholder="Enter name" name="name" required>
</td></tr>

<tr><td>
<label ><b>Address</b></label></td>
<td>
    <input type="text" placeholder="Enter Address" name="address" required>
   </td></tr>
   
   <tr><td>
    <label ><b>phoneno</b></label></td>
    <td>
    <input type="text" placeholder="Enter Phone No." name="phno" required>
    </td></tr>
    
    <tr><td>
    <label ><b>EmailID</b></label></td>
    <td>
    <input type="text" placeholder="Enter Email" name="email" required>
    </td></tr>
    
    <tr><td>
    <label for="psw"><b>Password</b></label></td>
    <td>
    <input type="password" placeholder="Enter Password" name="psw" required>
    </td></tr>
    
    <tr>
    <td><label ><b>Role</b></label></td>
    <td>
    <select name="role" onchange="yesnoCheck(this);"><option value="Employee">Employee</option>
    <option value="Employer">Employer</option>
    </select>
    </td></tr>
    
   <tr >
    <td><label ></label></td>
    <td>
    <select id="companyid" name="companyid" style="display:none;">
    <c:forEach items="${companylist}" var="comp">
    <option value="${comp.compid}">${comp.compname}</option>
    </c:forEach>
    </select>
    </td></tr>
    <br/>
     <tr> <td></td>
     <td>  
    <button type="submit">Register</button></td>
    </tr>
  

  </table>
</form>
<script>
function yesnoCheck(that) {
    if (that.value == "Employer") {
  alert("check");
        document.getElementById("companyid").style.display = "inline";
    } else {
        document.getElementById("companyid").style.display = "none";
    }
}
</script>
</body>
</html>