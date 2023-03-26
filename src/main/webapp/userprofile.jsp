<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome Page</title>
	  <link rel="stylesheet" type="text/css" href="userprofile.css">

<body>

<H1>WELCOME</H1>
	<P>Name:     <%= session.getAttribute("name") %></P>
	<pre></pre>
	<p>Email:    <%= session.getAttribute("email") %></p>
	<pre></pre>
	<p>Department:   <%= session.getAttribute("department") %></p>
	<pre></pre>
	<p>Address:   <%= session.getAttribute("adress") %></p>
	<pre></pre>
	<p>Contact:   <%= session.getAttribute("contact") %></p>
	
<pre></pre>	
	
	<button onclick="location.href='manage.jsp'">ADD OR DELETE INFO</button>
	<BR>
	
	<pre></pre>
	<BR>
	<button onclick="location.href='Login.jsp'">LOGOUT</button>
	
</body>
</html>
