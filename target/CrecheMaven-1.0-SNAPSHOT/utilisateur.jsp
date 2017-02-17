<%-- 
    Document   : utilisateur
    Created on : 20 janv. 2017, 10:09:13
    Author     : itu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html class="no-js" lang="en">

    <head>
        <meta charset="utf-8">
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Inscription utilisateur </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <!-- Place favicon.ico in the root directory -->
        <link rel="stylesheet" href="css/vendor.css">
        <!-- Theme initialization -->
        <script>
            var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
            {};
            var themeName = themeSettings.themeName || '';
            if (themeName)
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
            }
            else
            {
                document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
            }
        </script>
    </head>

    <body>
        <div class="auth">
            <div class="auth-container">
                <div class="card">
                    <header class="auth-header">
                        <h1 class="auth-title">
        <div class="logo">
        	<span class="l l1"></span>
        	<span class="l l2"></span>
        	<span class="l l3"></span>
        	<span class="l l4"></span>
        	<span class="l l5"></span>
        </div>        Creche Admin
      </h1> </header>
                    <div class="auth-content">
                        <p class="text-xs-center">Inscription</p>
                        <form name="review" id="signup-form" action="/index.jsp" method="GET" novalidate="">
                            <div class="form-group"> <label for="firstname">Nom</label>
                                <div class="row">
                                    <div class="col-sm-6"> <input type="text" class="form-control underlined" name="firstname" id="firstname" placeholder="Entrer pr&eacute;nom" required=""> </div>
                                    <div class="col-sm-6"> <input type="text" class="form-control underlined" name="lastname" id="lastname" placeholder="Entrer nom" required=""> </div>
                                </div>
                            </div>
                            <div class="form-group"> <label for="email">Email</label> <input type="email" class="form-control underlined" name="email" id="email" placeholder="Entrer address email " required=""> </div>
                            <div class="form-group"> <label for="password">Mot de passe</label>
                                <div class="row">
                                    <div class="col-sm-6"> <input type="password" class="form-control underlined" name="password" id="password" placeholder="Entrer mot de passe" required=""> </div>
                                    <div class="col-sm-6"> <input type="password" class="form-control underlined" name="retype_password" id="retype_password" placeholder="Confirmer mot de passe" required=""> </div>
                                </div>
                            </div>
                            <div class="form-group"> <button type="submit" class="btn btn-block btn-primary">Sign Up</button> </div>
                                       </form>
                    </div>
                </div>
                <div class="text-xs-center">
                    <a href="index.jsp" class="btn btn-secondary rounded btn-sm"> <i class="fa fa-arrow-left"></i> Accueil </a>
                </div>
            </div>
        </div>
        <!-- Reference block for JS -->
        <div class="ref" id="ref">
            <div class="color-primary"></div>
            <div class="chart">
                <div class="color-primary"></div>
                <div class="color-secondary"></div>
            </div>
        </div>
        <script src="js/vendor.js"></script>
        <script src="js/app.js"></script>
    </body>
</html>
