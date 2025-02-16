<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.employeemanager.model.User" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/liste.css">
    <title>Liste des employés</title>
</head>
<body>
<header>
    <nav>
        <img src="" alt="">
        <div id="links">
            <form action="/AddUser" method="get">
                <button type="submit" class="btn btn-primary headerBtn">Ajouter</button>
            </form>
            <form action="/ReadUser" method="get">
                <button type="submit" class="btn btn-primary headerBtn">Liste</button>
            </form>
        </div>
    </nav>
</header>
<main>
    <section>
        <div id="list">
            <h1>Liste des employés</h1>
            <div>
                <table class="table">
                    <thead class="thead-dark">
                    <tr>
                        <th scope="col">ID</th>
                        <th scope="col">Nom</th>
                        <th scope="col">Prénom</th>
                        <th scope="col">Email</th>
                        <th scope="col">Numéro de téléphone</th>
                        <th scope="col">Poste</th>
                        <th scope="col">Salaire</th>
                        <th scope="col">Options</th>
                    </tr>
                    </thead>
                    <tbody>
                    <%
                        List<User> personList = (List<User>) request.getAttribute("personList");

                        for (User user : personList) {
                    %>
                    <tr>
                        <td><%= user.getId() %></td>
                        <td><%= user.getFamilyName() %></td>
                        <td><%= user.getFirstName() %></td>
                        <td><%= user.getEmail() %></td>
                        <td><%= user.getPhoneNumber() %></td>
                        <td><%= user.getPost() %></td>
                        <td><%= user.getSalaire() %></td>
                        <td>
                            <a href="UpdateUser?id=<%= user.getId() %>"><button type="submit" class="btn btn-primary editBtn">Edit</button></a>
                            <form action="DeleteUser" method="post" style="display:inline;">
                                <input type="hidden" name="id" value="<%= user.getId() %>" />
                                <input type="submit" value="Delete" class="btn btn-danger btn-sm"/>
                            </form>
<%--                            <a href="./DeleteUser?id=<%= user.getId() %>" onclick="return confirm('Are you sure you want to delete this user?');">--%>
<%--                                <button type="submit" class="btn btn-primary deleteBtn">Delete</button>--%>
<%--                            </a>--%>
                        </td>
                    </tr>
                    <%

                        }
                    %>
                    </tbody>
                </table>
            </div>
        </div>
    </section>
</main>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>