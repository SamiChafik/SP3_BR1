<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.example.employeemanager.model.User" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="styles/header.css">
    <link rel="stylesheet" href="styles/ajouter.css">
    <title>Modifier Employé</title>
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
        <div id="form">
            <form action="UpdateUser" method="post" id="form1">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputNom">Nom</label>
                        <input type="text" class="form-control" id="inputNom" name="nom" value="${user.familyName}">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPrenom">Prénom</label>
                        <input type="text" class="form-control" id="inputPrenom" name="prenom" value="${user.firstName}">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputEmail">Email</label>
                    <input type="email" class="form-control" id="inputEmail" name="email" value="${user.email}">
                </div>
                <div class="form-group">
                    <label for="inputNumero">Numéro de téléphone</label>
                    <input type="text" class="form-control" id="inputNumero" name="numero" value="${user.phoneNumber}">
                </div>
                <div class="form-row">
                    <div class="form-group col-md-7">
                        <label for="inputPoste">Poste</label>
                        <input type="text" class="form-control" id="inputPoste" name="poste" value="${user.post}">
                    </div>
                    <div class="form-group col-md-5">
                        <label for="inlineFormInputGroup">Salaire</label>
                        <div class="input-group mb-2">
                            <input type="text" class="form-control" id="inlineFormInputGroup" name="salaire" value="${user.salaire}">
                            <div class="input-group-append">
                                <div class="input-group-text">DH</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div id="btn">
                    <button type="submit" class="btn btn-primary btn2">Modifier</button>
                </div>
            </form>
        </div>
    </section>
</main>
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>