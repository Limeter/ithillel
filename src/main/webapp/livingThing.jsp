<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Description of the animal</title>
</head>
<body>
    <%
        String livingThing = (String) request.getAttribute("livingThing");
        String description;
        String imageUrl;

        switch (livingThing) {
            case "cat":
                description = "The cat likes to sleep and purr.";
                imageUrl = "https://i.imgur.com/mtbl1cr.jpeg";
                break;
            case "dog":
                description = "The dog likes to play and defend the castle.";
                imageUrl = "https://i.imgur.com/XgbZdeA.jpeg";
                break;
            case "dragon":
                description = "A dragon guards the castle from the sky.";
                imageUrl = "https://i.imgur.com/Uc4x1Y6.jpeg";
                break;
            default:
                description = "This animal has not been added yet.";
                imageUrl = "https://i.imgur.com/Uc4x1Y6.jpeg/200?text=Unknown";
        }
    %>
    <h1><%= livingThing.substring(0, 1).toUpperCase() + livingThing.substring(1) %></h1>
    <img src="<%= imageUrl %>" alt="<%= livingThing %>" width="640" height="640">
    <p><%= description %></p>
    <a href="/castle-1.0/castle">Back to the castle</a>
</body>
</html>
