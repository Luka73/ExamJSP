<%@page import="com.mcit.entities.Patient"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html>
<head>
 <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <script src="https://kit.fontawesome.com/96b701d251.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="style.css">
    <title>Exam JavaEE</title>
</head>
<body>
	<section>
	    <div class="container"  style="width: 70%; margin: 30px 0;">
	    	<h2>Patients</h2><br>
			<table class="table table-striped text-center">
			  	<thead>
				    <tr>
				      <th scope="col">Id</th>
				      <th scope="col">First Name</th>
				      <th scope="col">Last Name</th>
				      <th scope="col">Gender</th>
				      <th>Edit</th>
				      <th>Delete</th>
				    </tr>
			  	</thead>
			  	<tbody>
			
			<% 
				//Scriptlet
				List<Patient> list = null;
				list = (List<Patient>) request.getAttribute("list1");
				if(!list.isEmpty() && list != null) {
					for(Patient p : list) { %>
						<tr>
					      <th scope="row"><% out.print(p.getId()); %></th>
					      <td><%= p.getFirstName() %></td>
					      <td><%= p.getLastName() %></td>
					      <td><%= p.getGender() %></td>
					      <td><a href="/ExamJavaEE/patient-controller?action=edit&id=<%=p.getId()%>"><i class="fas fa-edit"></i></a></td>
					      <td><a href="/ExamJavaEE/patient-controller?action=delete&id=<%=p.getId()%>"><i class="fas fa-trash-alt"></i></a></td>
					    </tr>
					<% } 
				} else { %>
					<tr>
						<td colspan="6"> No patients were found! </td>
					</tr>
				<% } %>
				</tbody>
			</table>
			
			<div>
				<button type="button" class="btn btn-success"><a class="link" href="patient.jsp">New Patient</a></button>
			</div>
		</div>
	</section>
</body>
</html>