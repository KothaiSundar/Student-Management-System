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
html{
overflow:hidden;

}

body
{display:flex;
justify-content:center;
align-items:center;
width:100vw;
height:90vh;
font-family:'Poppins', sans-serif;

}
form
{width:40%;
height:max-content;
border:3px solid #565656;
border-radius:20px;
padding: lrem;
}

input
{

width:90%;
padding: .5em lem;
font-size: 1.3rem;
font-weight:500;
border:0;
border-bottom: 3px solid #565656;
}

.btn{
width:30%;
border: 3px solid #565656;
border-radius:50px;
text-decoration:none;
color: #303030;
margin-top: 2rem;
font-weight:600;
}

.btn:hover
{background-color:salmon;
border:3px solid salmon;
color: #fff;
}

h2
{
font-size: 2rem;}


</style>
<body>
<% Admin admin=(Admin) session.getAttribute("admin");
if(admin!=null)
{
%>
    <form action="save" method="post">
       <input name ="studentName" placeholder="enter student name"  type="text"><br><br>
      <input name="studentPhoneNumber" placeholder="enter student phonenumber" type="text"><br><br>
       <input name="studentEmail" placeholder="enter student email" type="text"><br><br>
       <input type="submit" value="save">
       
    <%}else{
response.sendRedirect("AdminLogin.jsp");
}%>   
    
    
    </form>
</body>
</html>