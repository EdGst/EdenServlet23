<%@ page import="java.util.Comparator" %>
<%@ page import="technifutur.be.technifutur.models.entities.Client" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: studentdev05
  Date: 10-05-23
  Time: 09:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <!--  BOOTSTRAP  -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">

    <!--  Font Awesome  -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" integrity="sha512-iecdLmaskl7CVkqkXNQ/ZH/XLlvWZOJyj7Yy7tcenmpD1ypASozpmT/E0iPtmFIB46ZmdtAc9eNBvH0H/ZpiBw==" crossorigin="anonymous" referrerpolicy="no-referrer" />


    <title>Title</title>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark static-top">
    <div class="container">
        <a class="navbar-brand" href="#">
            <img src="ressource/javalogo.png" alt="..." height="36">
        </a>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav ms-auto">
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="index.jsp">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="addClient">Add Client</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

    <% List<Client> clients = (List<Client>) request.getAttribute("clients");%>
<%--    <header>--%>
<%--        <h1>Bienvenue sur la liste des clients</h1>--%>
<%--        <ul class="nav justify-content-end">--%>
<%--            <li class="nav-item active">--%>
<%--                <a class="nav-link active" href="login">Client</a>--%>
<%--            </li>--%>
<%--            <li class="nav-item">--%>
<%--                <a class="nav-link" href="addClient">Add Client</a>--%>
<%--            </li>--%>
<%--        </ul>--%>
<%--    </header>--%>

    <section class="form-div">
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>ID</th>
                <th>Client FirstName</th>
                <th>Client LastName</th>
                <th>Client Email</th>
                <th>Client PhoneNumber</th>
            </tr>
            </thead>

            <tbody>
            <%
                clients.sort(Comparator.comparing(Client::getId));
                for (Client c : clients){ %>
            <tr>
                <td><%= c.getId()%></td>
                <td><%= c.getFirstName()%></td>
                <td><%= c.getLastName()%></td>
                <td><%= c.getEmail()%></td>
                <td><%= c.getPhoneNumber()%></td>


                <td>
                    <form action="updateClient" method="get">
                        <button type="submit" class="btn btn-info" name="upd" id="button-update">Update</button>
                        <input type="text" name="id" value="<%= c.getId()%>" hidden="hidden">
                    </form>
                </td>
                <td>
                    <form action="clientList" method="get">
                        <button type="submit" class="btn btn-info" name="del" id="button-delete">Delete</button>
                        <input type="text" name="id" value="<%= c.getId()%>" hidden="hidden">
                    </form>
                </td>
            </tr>
            <% } %>
            </tbody>
        </table>
    </section>


<%--  BOOTSTRAP  --%>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
</body>
</html>