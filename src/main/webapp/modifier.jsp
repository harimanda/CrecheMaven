<%-- 
    Document   : inscription
    Created on : 27 oct. 2016, 10:12:43
    Author     : itu
--%>

<%@page import="peronne.Parents"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page import="function.Fonction"%>
<%@page import="peronne.Enfant"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
 <%
    HttpSession sessiont = request.getSession(true); 
    String sessionsi = (String) sessiont.getAttribute("user");
    if(sessionsi == null){
        response.sendRedirect("login.jsp");
    }
    else {
    String sessions = (String) sessiont.getAttribute("akiz");
    String ideleves = request.getParameter("ideleve");
    
%>
<%
    Fonction fonc = new Fonction();
    Enfant enf = new Enfant(); 
%>
 

 
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Profil </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <script src= "js/angular.min.js"></script>
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
                                   <%=sessionsi%>   
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
                                    <a href="index.html"> <i class="fa fa-home"></i> Accueil </a>
                                </li>
                                <li  class="active">
                                    <a href=""> <i class="fa fa-sign-in"></i> Inscription Eleves <i class="fa arrow"></i> </a>
                                    <ul>
                                        
                                        <li> <a href="reinscription.jsp">
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
                             <div class="sidebar-overlay" id="sidebar-overlay"></div>
                              <article class="content dashboard-page">
              <section class="section">
                 
                                      <div class="col-md-12" >
                        <div class="card card-block sameheight-item" >
                            <div class="title-block">
                                <h3 class="title">
						Modification:
					</h3> </div>
                            <% 
                                String col = "IDELEVE";
                                   String val = ideleves;
                                   enf = fonc.selecte(col, val);
                            %>
                             <form action="Update"  method="POST" class="form-horizontal">
                                 <div class="form-group row"> <label for="inputEmail3" class="col-sm-2 form-control-label">IdEleve</label>
                                    <div class="col-sm-3"> 
                                        <input type="text" class="form-control" name ="id" value = "<%=ideleves%>"></div> 
                   
                                     </div>
                                <div class="form-group row"> <label for="inputEmail3" class="col-sm-2 form-control-label">Nom</label>
                                    <div class="col-sm-3"> 
                                        <input type="text" class="form-control" name ="nomA"value = "<%=enf.getNOM()%>"></div> 
                                        
                                     </div>
                                <div class="form-group row"> <label for="inputPassword3" class="col-sm-2 form-control-label">Prénoms</label>
                                    <div class="col-sm-3"> 
                                        <input type="text" class="form-control" name="prenomA" value="<%=enf.getPRENOM()%>"> </div>
                                       
                                </div>
                                <div class="form-group row"> <label for="inputPassword3" class="col-sm-2 form-control-label">Date de naissance</label>
                                    <div class="col-sm-3"> 
                                        <input type="date" class="form-control" name="naissanceA" value="<%=enf.getDATENAISSANCE()%>">  </div>
                                        
                                         
                                </div>
                                <div class="form-group row"> <label for="inputPassword3" class="col-sm-2 form-control-label">Sexe</label>
                                    <div class="col-sm-3"> 
                                        <input type="texte" class="form-control" name="sexeeA" value="<%=enf.getSEXE()%>">  </div>
                                    
                                </div>
                                 <div class="form-group row"> <label for="inputPassword3" class="col-sm-2 form-control-label">Adresse</label>
                                    <div class="col-sm-3">  
                                        <input type="texte" class="form-control" name="adresseA" value="<%=enf.getADRESSE()%>"> </div>
                                    
                                      </div>
                                     
                                
                                 
                                <div class="form-group row">
                                    <div class="col-sm-offset-5 col-sm-2"> <button type="submit" class="btn btn-success">Modifier</button> </div>
                                </div>
                            </form>
                           
                               
                                
                    </div>
                </div>
                                           <div class="col-md-12" >
                        <div class="card card-block sameheight-item" >
                            <div class="title-block">
                                <h3 class="title">
						Informations sur les parents:
					</h3> </div>
                            
                             
                            <br>
                                           <table class="table table-striped table-bordered table-hover">
                                                             <thead class="flip-header">
                                                        <tr>
                                                            
                                                            <th>Nom</th>
                                                            <th>Prenoms</th>
                                                            <th>Profession</th>
                                                            <th>Adresse</th>
                                                            <th>Contact</th>
                                                            <th>Modification</th>
                                                            <th>Suppression</th>
                                                             
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                                   
                                                                            <% 
                                ArrayList list = new ArrayList();
                                 
                                String coll = "IDELEVE";
                                   String vall = ideleves;
                                   list = fonc.foundParent(coll, vall);
                                    Iterator iter = list.iterator();
                                        while (iter.hasNext())
                                       {
                                          Parents  par = (Parents)iter.next();
                                          int idp = par.getIDPARENT();
                                          %>
                                           <tr>
                                                                <td><%=par.getNOM()%></td>
                                                                 <td><%=par.getPRENOM()%></td>
                                                                 <td><%=par.getPROFESSION()%></td>
                                                                 <td><%=par.getADRESSE()%></td>
                                                                 <td><%=par.getCONTACT()%></td>
                                                                   <td><a href="modifierP.jsp?idparent=<%=idp%>&&ide=<%=ideleves%>">Modifier</a></td>
                                                                      <td><a href="javascript: supprimer (<%=idp%>,<%=ideleves%>);">Supprimer</a></td>    
                                                                        
                                                                  </tr>
                                                                <%
                                        }
                                        
                                    %>        
                                                                 
                                                             
                                                    </tbody>
                                                            </table>
                                    
                                        
                                    
                                    
                                    
                                       
                                
                                  
                                 
                            
                            
                               
                                
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
        <script src="js/code.js"></script>
    </body>
    <% } %>
</html>
 