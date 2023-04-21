   <%@ page import="student.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <% Student student =(Student) request.getAttribute("student"); %>
  <form action="saveUpdatedStudent" method="get">
        <input name ="studentId" value="<%= student.getStudentId()%>" 
        readonly="readonly" type="text"><br><br>
  
       <input name ="studentName" value="<%=student.getStudentName()%>" 
        type="text"><br><br>
      <input name="studentPhoneNumber" value="<%=student.getStudentPhoneNumber()%>" 
      type="text"><br><br>
       <input name="studentEmail" value="<%=student.getStudentEmail()%>"
        type="text"><br><br>
       <input name="studentFee" value="<%=student.getStudentFee()%>" 
       type="text" readonly="readonly">
       <input type="submit" value="save">
       
    
    
    </form>
</body>
</html>