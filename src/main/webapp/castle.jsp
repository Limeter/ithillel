<%@ page import="java.util.List" %>
<%@ page import="com.example.Animal" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Castle</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f9;
            color: #333;
        }

        header {
            background-color: #6c5ce7;
            color: white;
            padding: 20px;
            text-align: center;
        }

        main {
            padding: 20px;
            max-width: 800px;
            margin: 0 auto;
        }

        h1, h2 {
            text-align: center;
        }

        ul {
            list-style: none;
            padding: 0;
        }

        li {
            background: #fff;
            margin: 10px 0;
            padding: 10px;
            border-radius: 8px;
            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);
            display: flex;
            align-items: center;
            justify-content: space-between;
        }

        li img {
            border-radius: 8px;
            margin-right: 20px;
            max-width: 150px;
        }

        li h3 {
            margin: 0 0 5px 0;
        }

        li p {
            margin: 0;
            font-size: 0.9em;
            color: #666;
        }

        form {
            margin: 20px 0;
            text-align: center;
        }

        form label {
            font-weight: bold;
        }

        input[type="text"] {
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 8px;
            width: 60%;
        }

        button {
            background-color: #6c5ce7;
            color: white;
            border: none;
            padding: 10px 15px;
            border-radius: 8px;
            cursor: pointer;
            font-size: 1em;
        }

        button:hover {
            background-color: #5a4dbf;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            color: #6c5ce7;
            text-decoration: none;
        }

        a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <header>
        <h1>Welcome to the Castle</h1>
     <img src="https://i.imgur.com/FJnR2oH.jpeg" alt="Castle" width="400">
    </header>
    <main>
        <h2>Default Creatures:</h2>
        <ul>
            <%
                List<Animal> defaultAnimals = (List<Animal>) request.getAttribute("defaultAnimals");
                if (defaultAnimals != null && !defaultAnimals.isEmpty()) {
                    for (Animal animal : defaultAnimals) {
            %>
                        <li>
                            <div>
                                <h3><%= animal.getName().substring(0, 1).toUpperCase() + animal.getName().substring(1) %></h3>
                                <p><%= animal.getDescription() %></p>
                            </div>
                            <img src="<%= animal.getImageUrl() %>" alt="<%= animal.getName() %>">
                        </li>
            <%
                    }
                } else {
            %>
                    <li>No default creatures available.</li>
            <%
                }
            %>
        </ul>

        <h2>Creatures in the Castle:</h2>
        <ul>
            <%
                List<String> animals = (List<String>) request.getAttribute("animals");
                if (animals != null && !animals.isEmpty()) {
                    for (String animal : animals) {
            %>
                        <li>
                            <%= animal %>

                            <form method="post" action="castle" style="display:inline;">
                                <input type="hidden" name="animal" value="<%= animal %>">
                                <input type="hidden" name="action" value="remove">
                                <button type="submit">Remove</button>
                            </form>
                        </li>
            <%
                    }
                } else {
            %>
                    <li>No animals in the castle yet.</li>
            <%
                }
            %>
        </ul>
    <%
         String user = (String) session.getAttribute("user");
         if (user != null) {
    %>
        <h2>Add a New Animal:</h2>
        <form method="post" action="castle">
            <label for="animal">Animal Name:</label>
            <input type="text" name="animal" id="animal" required>
            <input type="hidden" name="action" value="add">
            <button type="submit">Add Animal</button>
        </form>
    <%
        } else {
    %>
        <p>You need to <a href="login">login</a> to add animals.</p>
    <%
        }
    %>
        <a href="index.jsp">Back to Main Page</a>
    </main>
</body>
</html>
