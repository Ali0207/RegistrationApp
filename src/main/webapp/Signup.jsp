<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SIGNUP</title> 
    <link rel="stylesheet" type="text/css" href="Signup.css">
</head>

<body>


<div  class="output-box">
    <h1>SIGNUP PAGE</h1>
    <form action="SignupForm" method="post" onsubmit="return validateForm()">
        <input type="text" name="name" placeholder="NAME" required><br><br>
        <input type="text" name="email" id="email" placeholder="EMAIL" required><br><br>
        
        <input type="text" name="adress" placeholder="ADRESS" required><br><br>
        <input type="text" name="contact" id="contact" placeholder="CONTACT" required><br><br>
        <input type="password" name="password" id="password" placeholder="PASSWORD" required><br><br>
        
        <PRE></PRE>
        <select name="department" required>
            <option value="">Select Department</option>
            <option value="IT">IT</option>
            <option value="CSE">CSE</option>
            <option value="ACCOUNTS">ACCOUNTS</option>
            <option value="TESTING">TESTING</option>
            <option value="DEVELOPMENT">DEVELOPMENT</option>
        </select>
        <PRE></PRE>
        <button type="submit">SUBMIT</button>
        <h3>An existing user?</h3>
			<button  onclick="location.href='Login.jsp';">LOGIN</button>
    </form>
</div>
