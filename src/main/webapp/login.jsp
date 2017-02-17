<%-- 
    Document   : login
    Created on : 19 oct. 2016, 21:57:01
    Author     : Administrateur
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title>Creche Admin</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        
        <link rel="stylesheet" href="css/vendor.css">
        
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
                        <p class="text-xs-center">LOGIN TO CONTINUE</p>
                        <form id="login-form" action="Authentification" method="POST">
                            <div class="form-group"> <label for="username">Username</label> <input type="email" class="form-control underlined" name="username" id="username" placeholder="Your email address" required> </div>
                            <div class="form-group"> <label for="password">Password</label> <input type="password" class="form-control underlined" name="password" id="password" placeholder="Your password" required> </div>
                           
                            <div class="form-group"> <button type="submit" class="btn btn-block btn-primary">Login</button> </div>
                            <div class="form-group">
                                <p class="text-muted text-xs-center">S'incrire? <a href="utilisateur.jsp">Sign Up!</a></p>
                            </div>
                        </form>
                    </div>
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
