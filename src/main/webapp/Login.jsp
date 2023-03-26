<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<link rel="stylesheet" type="text/css" href="login.css">

</head>
 
<body>
	<div class="output-box"> 
		<h1>LOGIN PAGE</h1>
		<form action="LoginServlet" method="post">
			<label for="email">Email:</label>
			<input type="text" name="email" id="email" required><br><br>
			<label for="password">Password:</label>
			<input type="password" name="password" id="password" required><br><br>
			<button type="submit">Login</button>
			<h3>Not an existing user?</h3>
			<button onclick="location.href='Signup.jsp'">SIGNUP</button>
		</form>
	</div>
</body>
</html>
