<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
            text-align: center;
        }

        header {
            background-color: #6c5ce7;
            color: white;
            padding: 20px;
        }

        main {
            padding: 20px;
            max-width: 600px;
            margin: 0 auto;
        }

        button, a {
            display: inline-block;
            background-color: #6c5ce7;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1em;
            text-decoration: none;
        }

        button:hover, a:hover {
            background-color: #5a4dbf;
        }

        a {
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Castle!</h1>
    </header>
    <main>
        <%
            String user = (session != null) ? (String) session.getAttribute("user") : null;
        %>
        <% if (user != null) { %>
            <p>Welcome, <strong><%= user %></strong>!</p>
            <form method="post" action="logout" style="margin-top: 20px;">
                <button type="submit">Logout</button>
            </form>
        <% } else { %>
            <p>You are not logged in.</p>
            <a href="login">Login</a>
        <% } %>
        <a href="castle" style="margin-top: 20px;">Go to the Castle</a>
    </main>
</body>
</html>
