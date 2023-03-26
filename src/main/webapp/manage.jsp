<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update/Delete Information</title>
    <link rel="stylesheet" type="text/css" href="manage.css">
</head>

<body>
    <h1>Update/Delete Information</h1>

    <%
        String name = (String) session.getAttribute("name");
        String email = (String) session.getAttribute("email");
        String department = (String) session.getAttribute("department");
        String adress = (String) session.getAttribute("adress");
        String contact = (String) session.getAttribute("contact");
        String password = (String) session.getAttribute("password");
    %>

    <h2>Update Information</h2>
    <form method="post" action="UserManagementServlet">
        <input type="text" name="name" placeholder="Name" value="<%= name %>"><br><br>
        <input type="text" name="email" placeholder="Email" value="<%= email %>"><br><br>
        <input type="text" name="department" placeholder="Department" value="<%= department %>"><br><br>
        <input type="text" name="adress" placeholder="Adress" value="<%=adress%>"><br><br>
        <input type="text" name="contact" placeholder="Contact" value="<%= contact %>"><br><br>
         <input type="text" name="password" placeholder="Password" value="<%= password %>"><br><br>
        <button type="submit">Update</button>
    </form>

    <h2>Delete Information</h2>
    <form method="post" action="UserDeletionServlet">
        <p>Are you sure you want to delete your information?</p>
        <button type="Submit">Delete</button>
    </form>

    <button onclick="location.href='userprofile.jsp'">Go Back to Profile</button>

</body>
</html>