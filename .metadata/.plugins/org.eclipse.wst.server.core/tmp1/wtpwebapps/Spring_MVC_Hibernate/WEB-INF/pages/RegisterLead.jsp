<%-- <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"> --%>
<html>
<!-- <head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title> 
</head> -->
<body>
	<h1>Lead Registration</h1>

	<form action="/Spring_MVC_Hibernate/controller/RegisterUser"
		method="post">
		<p>
			Batch ID : <input type="text" name="batchID" />
		</p>

		<p>
			Lead Name : <input type="text" name="leadName" />
		</p>

		<p>
			Lead MID : <input type="text" name="leadMID" />
		</p>

		<p>
			Campus Mind MID : <input type="text" name="campusMindMID" />
		</p>

		<p>
			Campus Mind Name : <input type="text" name="campusMindName" />
		</p>

		<p>
			Track : <input type="text" name="Track" />
		</p>

		<input type="submit" value="submit this form by clicking here" />
	</form>
	
	<h1>recieve registered user</h1>
	<!-- second form is here -->
	<form action="/Spring_MVC_Hibernate/controller/fetchALLOnBatchId/{batchID}"
		method="GET">
		<p>
			Batch ID : <input type="text" name="batchID" />
		</p>

		<input type="submit" value="submit this form" />
	</form>
	
	
	<h1>delete registered user</h1>
	<!-- second form is here -->
	<form action="/Spring_MVC_Hibernate/controller/deleteUserBatchId/{batchID}"
		method="DELETE">
		<p>
			Batch ID : <input type="text" name="batchID" />
		</p>

		<input type="submit" value="submit this form" />
	</form>
	
	
	
</body>
</html>