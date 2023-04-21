 <%@ page import="student.dto.Admin"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    body
    {
    height:80vh;
    width:100vw;
    display:flex;
    flex-direction:column;
    align-items:center;
    justify-content:center;
       
    }
    a{
    padding:.5em  le,;
    font-size:1.3rem;
    border: 2px solid #565656;
    border-radius:50px;
    text-decoration:none;
    color: #303030;
    margin:.5rem;
    
    }
    h1{
    font-size:7rem;
    color:#565656;}
    
</style>

<body>
<% Admin admin=(Admin) session.getAttribute("admin");
if(admin!=null)
{
%>
<h1> Welcome admin</h1>
<h3> u can manage student data here</h3>

<div>
     <a  href="saveStudent.jsp">Save_Student</a>
      <a href="viewstudent">View_Student</a>
</div>
<%}else{
response.sendRedirect("AdminLogin.jsp");
}%>

 <div class="logout"><a  href="logout">Logout</a></div>

</body>
</html>