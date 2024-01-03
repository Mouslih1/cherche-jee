<jsp:useBean id="userModel" scope="request" type="com.example.jeegc.Module.UserModel"/>
<%@ page import="com.example.jeegc.Module.User" %>
<%@ page import="com.example.jeegc.Module.UserModel" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    if(request.getAttribute("userModel") != null)
    {
        userModel = (UserModel) request.getAttribute("userModel");
    }else{
        userModel = new UserModel();
    }
%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <title>All users</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
</head>
<body>
<div class="container mt-3">
    <div class="card text-center">
        <div class="card-header">
            List users
        </div>
        <div class="card-body">
            <form method="GET" action="cherche.php" class="mb-3">
                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <label for="ville" class="col-form-label">Ville for searching</label>
                    </div>
                    <div class="col-auto">
                        <input type="text" id="ville" name="ville" value="${userModel.ville}" class="form-control">
                    </div>
                    <div class="col-auto">
                        <input type="submit" value="search" class="btn btn-primary">
                    </div>
                </div>
            </form>
            <table class="table">
                <tbody>
                <% List<User> users = userModel.getUsers(); %>
                <% if (users != null && !users.isEmpty()) { %>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">Ville</th>
                        <th scope="col">Age</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <% for (User user : users) { %>
                    <tr>
                        <th scope="row"><%= user.getId() %></th>
                        <td><%= user.getName() %></td>
                        <td><%= user.getVille() %></td>
                        <td><%= user.getAge() %></td>
                        <td>
                            <a href="supprimer.php?id=<%= user.getId() %>" class="btn btn-danger">Delete</a>
                            <a href="edit.php?id=<%= user.getId() %>" class="btn btn-warning">Edit</a>
                        </td>
                    </tr>
                    <% } %>
                    </tbody>
                </table>
                <% } else { %>
                    <p class="alert alert-danger">La liste des utilisateurs est vide.</p>
                <% } %>
        </div>
        <div class="card-footer text-muted">
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
</body>
</html>
