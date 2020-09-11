<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <title>Exam JavaEE</title>
</head>
<body>
<section>
	    <div class="container"  style="width: 30%; margin: 30px 0;">
	        <h2>New Patient </h2>
	        <form action="patient-controller" method="POST" style="margin-top: 35px;">
	        <div class="form-group">
	                <label for="id">Patient Id: </label>
	                <input type="text" class="form-control" name="txtid" id="id" required>
	            </div>
	            <div class="form-group">
	                <label for="first-name">First Name: </label>
	                <input type="text" class="form-control" name="txtfirst-name" id="first-name" required>
	            </div>
	            <div class="form-group">
	                <label for="last-name">Last Name: </label>
	                <input type="text" class="form-control" name="txtlast-name" id="last-name">
	            </div>
	            <div class="form-inline">
	                <label>Gender: </label>&nbsp;
	                <input type="radio" class="form-control" name="txtgender" value="M">&nbsp; M &nbsp;
	                <input type="radio" class="form-control" name="txtgender" value="F">&nbsp; F
	            </div>
	            <input type="submit" value="Submit" class="btn btn-success" style="margin-top: 10px;">
	        </form>
	    </div>
	</section>
</body>
</html>