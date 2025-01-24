<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <%
        String user = (session != null) ? (String) session.getAttribute("user") : null;
    %>
    <h1>Welcome to the Castle!</h1>
    <% if (user != null) { %>
        <p>Welcome, <%= user %>!</p>
        <a href="addAnimal">Add a New Animal</a>
        <form method="post" action="logout" style="margin-top: 10px;">
            <button type="submit">Logout</button>
        </form>
    <% } else { %>
        <p>You are not logged in.</p>
        <a href="login">Login</a>
    <% } %>
    <a href="castle" style="display: block; margin-top: 20px;">Go to the Castle</a>
</body>
</html>
