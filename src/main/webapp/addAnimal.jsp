<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Animal</title>
</head>
<body>
    <h1>Add a New Animal</h1>
    <form method="post" action="addAnimal">
        <label for="animal">Animal Name:</label>
        <input type="text" name="animal" id="animal" required>
        <button type="submit">Add Animal</button>
    </form>
    <h2>Existing Animals:</h2>
    <ul>
        <%
            List<String> animals = (List<String>) request.getAttribute("animals");
            if (animals != null) {
                for (String animal : animals) {
        %>
                    <li><%= animal %></li>
        <%
                }
            } else {
        %>
                <li>No animals have been added yet.</li>
        <%
            }
        %>
    </ul>
    <a href="index.jsp">Back to Main Page</a>
</body>
</html>
