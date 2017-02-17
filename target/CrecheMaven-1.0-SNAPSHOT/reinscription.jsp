<%-- 
    Document   : inscription
    Created on : 27 oct. 2016, 10:12:43
    Author     : itu
--%>

<%@page import="java.sql.Connection"%>
<%@page import="connexion.ConnectBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
 
 

<%
    HttpSession sessiont = request.getSession(true); 
    String sessions = (String) sessiont.getAttribute("user");
    if(sessions == null){
        response.sendRedirect("login.jsp");
    }
    else {
        String ideleves = "";
%>
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Creche Admin </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        
        <link rel="stylesheet" href="css/vendor.css">
        <script src= "js/angular.min.js"></script>
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
        <div class="main-wrapper">
            <div class="app" id="app">
                <header class="header">
                   
                    <div class="header-block header-block-search hidden-sm-down">
                        <form role="search">
                            <div class="input-container"> <i class="fa fa-search"></i> <input type="search" placeholder="Search">
                                <div class="underline"></div>
                            </div>
                        </form>
                    </div>
                    
                    <div class="header-block header-block-nav">
                        <ul class="nav-profile">
           
                            <li class="profile dropdown">
                                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                                    <div class="img" ><i class="fa fa-user"></i></div> <span class="name">
                                      <%=sessions%>
    			    </span> </a>
                                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">
                                    <a class="dropdown-item" href="#"> <i class="fa fa-user icon"></i> Profile </a>
                                    
                                    <div class="dropdown-divider"></div>
                                    <a class="dropdown-item" href="Logout"> <i class="fa fa-power-off icon"></i> Logout </a>
                                </div>
                            </li>
                        </ul>
                    </div>
                </header>
                <aside class="sidebar">
                    <div class="sidebar-container">
                        <div class="sidebar-header">
                            <div class="brand">
                                <div class="logo"> <span class="l l1"></span> <span class="l l2"></span> <span class="l l3"></span> <span class="l l4"></span> <span class="l l5"></span> </div> Creche Admin </div>
                        </div>
                        <nav class="menu">
                            <ul class="nav metismenu" id="sidebar-menu">
                                <li>
                                    <a href="index.jsp"> <i class="fa fa-home"></i> Accueil </a>
                                </li>
                                <li class="active">
                                    <a href=""> <i class="fa fa-sign-in"></i> Inscription Eleves <i class="fa arrow"></i> </a>
                                    <ul>
                                        
                                        <li> <a href="#">
    								Reinscription 
    							</a> </li>
                                        <li> <a href="inscription.jsp">
    								Inscription nouvel eleve
    							</a> </li>
								 
                                    </ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-graduation-cap"></i> Gestion Eleves <i class="fa arrow"></i> </a>
                                    <ul>
                                        
                                        <li> <a href="items-list.html">
    								Liste d'eleves
    							</a> </li>
                                      <li> <a href="payementEcolage.jsp">
    								Ecolage
    							</a> </li>
								 <li> <a href="item-editor.html">
    								Parents
    							</a> </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-th-large"></i> Gestion Personnels <i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="charts-flot.html">
    								Liste personnels 
    							</a> </li>
                                        <li> <a href="charts-morris.html">
    								Salaire
    							</a> </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-table"></i> Programmes <i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="static-tables.html">
    								Activites
    							</a> </li>
                                        <li> <a href="responsive-tables.html">
    								Programme Annee scolaire
    							</a> </li>
                                        <li> <a href="responsive-tables.html">
    								Emploi du temps
    							</a> </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-table"></i> Administration <i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="insertEcolage.jsp">
    								Insertion ecolage
    							</a> </li>
                                        <li> <a href="historiqueEcolage.jsp">
    								Historique ecolage
    							</a> </li>
                                        <li> <a href="historiquePayement.jsp">
    								Historique de payement ecolage
    							</a> </li>
                                    </ul>
                                </li>
                                <li>
                                    <a href=""> <i class="fa fa-book"></i> Pointage <i class="fa arrow"></i> </a>
                                    <ul>
                                        <li> <a href="buttons.html">
    								Eleves
    							</a> </li>
                                        <li> <a href="cards.html">
    								Personnel
    							</a> </li>
                                        
                                    </ul>
                                </li>
                                
                                 
                            </ul>
                        </nav>
                    </div>
                     
                    <footer class="sidebar-footer">
                        <ul class="nav metismenu" id="customize-menu">
                            <li>
                                <ul>
                                    <li class="customize">
                                         
                                        <div class="customize-item">
                                            <ul class="customize-colors">
                                                <li> <span class="color-item color-red" data-theme="red"></span> </li>
                                                <li> <span class="color-item color-orange" data-theme="orange"></span> </li>
                                                <li> <span class="color-item color-green" data-theme="green"></span> </li>
                                                <li> <span class="color-item color-seagreen" data-theme="seagreen"></span> </li>
                                                <li> <span class="color-item color-blue active" data-theme=""></span> </li>
                                                <li> <span class="color-item color-purple" data-theme="purple"></span> </li>
                                            </ul>
                                        </div>
                                    </li>
                                </ul>
                                <a href=""> <i class="fa fa-cog"></i> Reglages </a>
                            </li>
                        </ul>
                    </footer>
                </aside>
                            <article class="content forms-page">
                    
                                 <section class="section">
                        <div class="row">
                            <div class="col-md-12">
                                <div class="card">
                                    <div class="card-block">
                                        <div class="card-title-block">
                                            <h3 class="title">
							Recherche:
						</h3> </div>
                                        <section class="example">
                                            <div class="table-responsive">
                                                 
                                                        <div ng-app="myApp" ng-controller="customersCtrl"> 
                                                            <div class="form-inline">
                                                                <div class="form-group">
                                                                     <input  class="form-control" type="text" ng-model="test.nom" placeholder="par nom">
                                                                <br>
                                                                </div>
                                                                <div class="form-group">
                                                                    
                                                                     <input  class="form-control" type="text" ng-model="test.prenom" placeholder="par prenom">
                                                                <br>
                                                                </div>
                                                                <div class="form-group">
                                                                    <input  class="form-control" type="text" ng-model="test.naissance" placeholder="Date de naissance"> 
                                                                <br>
                                                                </div>
                                                                <div class="form-group">
                                                                     <input class="form-control"  type="text" ng-model="test.adresse" placeholder="adresse"> 
                                                                     <br>
                                                                </div>
                                                               
                                                               
                                                               
                                                               
                                                            </div>
                                                             <div class="card-title-block">
                                            <h3 class="title">
                                                <br>
							Resultats:
						</h3> </div>
                                                              <table class="table table-striped table-bordered table-hover">
                                                             <thead class="flip-header">
                                                        <tr>
                                                            <th>idEnfant</th>
                                                            <th>Nom</th>
                                                            <th>Prenoms</th>
                                                            <th>Date de naissance</th>
                                                            <th>Adresse</th>
                                                            <th>Modifier</th>
                                                            <th>Supprimer</th>
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                                    <tr ng-repeat="x in names | filter:test  ">
                                                                <td>{{ x.id }}</td>
                                                                <td>{{ x.nom}}</td>
                                                                 <td>{{ x.prenom}}</td>
                                                                     <td>{{ x.naissance}}</td>
                                                                         <td>{{ x.adresse}}</td>
                                                                         <td><a href="modifier.jsp?ideleve={{x.id}}">Modifier</a></td>
                                                                         
                                                                        <td><a href="delete.jsp?ideleve={{x.id}}">Supprimer</a></td>
                                                                             
                                                              </tr>
                                                    </tbody>
                                                            </table>
                                                           
                                                            </div>
                                            </div>
                                              
                                        </section>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    
                     </article>
        <footer class="footer">
                    <div class="footer-block buttons">  </div>
                    <div class="footer-block author">
                       <p><b>Copyrigth &copy; 2016</b></p>
                    </div>
                </footer>
                <div class="modal fade" id="modal-media">
                    <div class="modal-dialog modal-lg">
                        <div class="modal-content">
                            <div class="modal-header"> <button type="button" class="close" data-dismiss="modal" aria-label="Close">
    					<span aria-hidden="true">&times;</span>
    					<span class="sr-only">Close</span>
    				</button>
                                <h4 class="modal-title"></h4> </div>
                                <input id="idel" name ="idenf"></input>
                            <div class="modal-body modal-tab-container">
                                <ul class="nav nav-tabs modal-tabs" role="tablist">
                                     
                                    <li class="nav-item"> <a class="nav-link active" href="#upload" data-toggle="tab" role="tab">Confirmation</a> </li>
                                </ul>
                                <div class="tab-content modal-tab-content">
                                    <div class="tab-pane fade active in" id="upload" role="tabpanel">
                                        <div class="upload-container">
                                            <div id="dropzone">
                                                <form action="/" method="POST" enctype="multipart/form-data" class="dropzone needsclick dz-clickable" id="demo-upload">
                                                    <div class="dz-message-block">
                                                         
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="modal-footer"> <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button> <button type="button" class="btn btn-primary">Insert Selected</button> </div>
                        </div>
                        
                    </div>
                     
                </div>
                
                   
 
                </div>
                
            </div>
        
        
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
    <% } %>
</html>
<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("exo.jsp")
    .then(function (response) {
        $scope.names = response.data;
        
    });
});
</script>