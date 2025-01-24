<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Castle</title>
</head>
<body>
    <h1>Welcome to the Castle</h1>
    <img src="assets/images/castle.jpg" alt="Castle" width="400">
    <p>Here are the creatures that live in the castle:</p>
    <ul>
        <li><a href="http://localhost:8080/castle-1.0/castle?livingThing=cat">Cat</a></li>
        <li><a href="http://localhost:8080/castle-1.0/castle?livingThing=dog">Dog</a></li>
        <li><a href="http://localhost:8080/castle-1.0/castle?livingThing=dragon">Dragon</a></li>
    </ul>

    <h2>Added Animals:</h2>
       <!-- Форма для добавления нового животного -->
        <form action="/castle-1.0/castle" method="POST">
            <label for="animal">Add a new animal:</label>
            <input type="text" id="animal" name="animal" required>
            <input type="submit" value="Add Animal">
        </form>
    <a href="index.jsp">Back to Main Page</a>
</body>
</html>
