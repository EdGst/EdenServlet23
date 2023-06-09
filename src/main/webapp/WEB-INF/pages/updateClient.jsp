<%--
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
                    <a class="nav-link active" aria-current="page" href="clientList">Client List</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active" aria-current="page" href="logout">Logout</a>
                </li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="text-center mb-4">
        <h3>Update Client</h3>
        <p class="text-muted">Complete the form below to update a client</p>
    </div>


    <div class="container d-flex justify-content-center">
        <form action="updateClient" method="post" style="width:50vw; min-width: 300px;">
            <div class="row mb-3">
                <div class="col">
                    <label class="form-label">First Name:</label>
                    <input type="text" class="form-control" name="firstName" placeholder="Zirka" value="${firstName}" id="firstname">
                </div>

                <div class="col">
                    <label class="form-label">Last Name:</label>
                    <input type="text" class="form-control" name="lastName" placeholder="Ryan" id="lastname" value="${lastName}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Email:</label>
                    <input type="email" class="form-control" name="email" placeholder="zirka@ryan.com" id="email" value="${email}">
                </div>

                <div class="mb-3">
                    <label class="form-label">Phone Number:</label>
                    <input type="tel" class="form-control" name="phoneNumber" placeholder="0123456789" id="phonenumber" value="${phoneNumber}">
                </div>

                <div>
                    <button type="submit" class="btn btn-success" name="submit">Save</button>
                    <a href="clientList" class="btn btn-danger">Cancel</a>
                </div>

            </div>
        </form>
    </div>
</div>

</body>
</html>