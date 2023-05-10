<%--
  Created by IntelliJ IDEA.
  User: studentdev05
  Date: 08-05-23
  Time: 13:56
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="styles/style.css">
    <link rel="stylesheet" href="../styles/style.css">
    <title>Title</title>
</head>
<body>

<h1>Login</h1>
<form method="post" action="login">
    <label for="login">Login : </label>
    <input id="text" id="login" name="login" value="${login}">
    <label for="password">Password :</label>
    <input type="password" id="password" name="password">
    <button type="submit">Connect</button>
    <span style="color: red">${error}</span>
</form>

</body>
</html>