<%-- 
    Document   : index
    Created on : 19 oct. 2016, 21:53:47
    Author     : Administrateur
--%>

<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    HttpSession sessiont = request.getSession(true); 
    String sessions = (String) sessiont.getAttribute("user");
    if(sessions == null){
        response.sendRedirect("login.jsp");
    }
    else {
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
                                <li class="active">
                                    <a href="index.html"> <i class="fa fa-home"></i> Accueil </a>
                                </li>
                                <li>
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
                                        
                                        <li> <a href="reinscription.jsp">
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
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                                                <article class="content dashboard-page">
                    <section class="section">
                        <div class="row sameheight-container">
                            <div class="col col-xs-12 col-sm-12 col-md-6 col-xl-5 stats-col">
                                <div class="card sameheight-item stats" data-exclude="xs">
                                    <div class="card-block">
                                        <div class="title-block">
                                            <h4 class="title">
            				Programmes Annee scolaire:
            			</h4>
                                            
                                        </div>
                                        <div class="row row-sm stats-container">
                                            <div class="col-xs-12 stat-col">
                                                <div class="stat-icon"> <i class="fa fa-graduation-cap"></i> </div>
                                                <div class="stat">
                                                    <div class="value"> Premier Semestre </div>
                                                    <div class="name"> 12-09-16 a 19-12-16 </div>
                                                </div> <progress class="progress stat-progress" value="75" max="100">
            					<div class="progress">
            						<span class="progress-bar" style="width: 100%;"></span>
            					</div>
            				</progress> </div> 
                                             <div class="col-xs-12 stat-col">
                                                <div class="stat-icon"> <i class="fa fa-graduation-cap"></i> </div>
                                                <div class="stat">
                                                    <div class="value"> Deuxieme Semestre </div>
                                                    <div class="name"> 17-01-17 a 20-04-17 </div>
                                                </div> <progress class="progress stat-progress" value="75" max="100">
            					<div class="progress">
            						<span class="progress-bar" style="width: 100%;"></span>
            					</div>
            				</progress> </div> 
                                             <div class="col-xs-12 stat-col">
                                                <div class="stat-icon"> <i class="fa fa-graduation-cap"></i> </div>
                                                <div class="stat">
                                                    <div class="value"> Troisieme Semestre </div>
                                                    <div class="name"> 14-05-17 a 19-06-17 </div>
                                                </div> <progress class="progress stat-progress" value="75" max="100">
            					<div class="progress">
            						<span class="progress-bar" style="width: 100%;"></span>
            					</div>
            				</progress> </div> 
                                           
                                           
                                           
                                            
                                          
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col col-xs-12 col-sm-12 col-md-6 col-xl-7 history-col">
                                <div class="card sameheight-item" data-exclude="xs">
                                    <div class="card-header card-header-sm bordered">
                                        <div class="header-block">
                                            <h3 class="title">Pointage</h3> </div>
                                        <ul class="nav nav-tabs pull-right" role="tablist">
                                            <li class="nav-item"> <a class="nav-link active" href="#visits" role="tab" data-toggle="tab">Presence</a> </li>
                                            <li class="nav-item"> <a class="nav-link" href="#downloads" role="tab" data-toggle="tab">Absence</a> </li>
                                        </ul>
                                    </div>
                                    <div class="card-block">
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane active fade in" id="visits">
                                                <p class="title-description">Chiffres</p>
                                                <div id="dashboard-visits-chart"></div>
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="downloads">
                                                <p class="title-description">Chiffres</p>
                                                <div id="dashboard-downloads-chart"></div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </section>
                    <section class="section">
                        <div class="row sameheight-container">
                            <div class="col-xl-8">
                                <div class="card sameheight-item items" data-exclude="xs,sm,lg">
                                    <div class="card-header bordered">
                                        <div class="header-block">
                                            <h3 class="title">
            				Listes Personnels
            			  </div>
                                        <div class="header-block pull-right"> <label class="search">
            				<input class="search-input" placeholder="search...">
            				<i class="fa fa-search search-icon"></i>
            			</label>
                                            <div class="pagination">
                                                <a href="" class="btn btn-primary btn-sm rounded"> <i class="fa fa-angle-up"></i> </a>
                                                <a href="" class="btn btn-primary btn-sm rounded"> <i class="fa fa-angle-down"></i> </a>
                                            </div>
                                        </div>
                                    </div>
                                    <ul class="item-list striped">
                                        <li class="item item-list-header hidden-sm-down">
                                            <div class="item-row">
                                                <div class="item-col item-col-header fixed item-col-img xs"></div>
                                                <div class="item-col item-col-header item-col-title">
                                                    <div> <span>Nom</span> </div>
                                                </div>
                                                <div class="item-col item-col-header item-col-sales">
                                                    <div> <span>Attribut</span> </div>
                                                </div>
                                                <div class="item-col item-col-header item-col-stats">
                                                    <div class="no-overflow"> <span>Presence</span> </div>
                                                </div>
                                                <div class="item-col item-col-header item-col-date">
                                                    <div> <span>Annee d'activite</span> </div>
                                                </div>
                                            </div>
                                        </li>
                                       
                                       
                                        
                                        <li class="item">
                                            <div class="item-row">
                                                <div class="item-col fixed item-col-img xs">
                                                    <a href="">
                                                        <div class="item-img xs rounded" style="background-image: url(https://s3.amazonaws.com/uifaces/faces/twitter/why_this/128.jpg)"></div>
                                                    </a>
                                                </div>
                                                <div class="item-col item-col-title no-overflow">
                                                    <div>
                                                        <a href="" class="">
                                                            <h4 class="item-title no-wrap">
            									Rakotoson Rabe
            								</h4> </a>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-sales">
                                                    <div class="item-heading">Sales</div>
                                                    <div> Directeur </div>
                                                </div>
                                                <div class="item-col item-col-stats">
                                                    <div class="item-heading">Stats</div>
                                                    <div class="no-overflow">
                                                        <div class="item-stats sparkline" data-type="bar"></div>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-date">
                                                    <div class="item-heading">Published</div>
                                                    <div> 2012 </div>
                                                </div>
                                            </div>
                                        </li>
                                        <li class="item">
                                            <div class="item-row">
                                                <div class="item-col fixed item-col-img xs">
                                                    <a href="">
                                                        <div class="item-img xs rounded" style="background-image: url(https://s3.amazonaws.com/uifaces/faces/twitter/why_this/128.jpg)"></div>
                                                    </a>
                                                </div>
                                                <div class="item-col item-col-title no-overflow">
                                                    <div>
                                                        <a href="" class="">
                                                            <h4 class="item-title no-wrap">
            									Randria Feno
            								</h4> </a>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-sales">
                                                    <div class="item-heading">Sales</div>
                                                    <div> Professeur d'art </div>
                                                </div>
                                                <div class="item-col item-col-stats">
                                                    <div class="item-heading">Stats</div>
                                                    <div class="no-overflow">
                                                        <div class="item-stats sparkline" data-type="bar"></div>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-date">
                                                    <div class="item-heading">Published</div>
                                                    <div> 2014 </div>
                                                </div>
                                            </div>
                                        </li>
										                                        <li class="item">
                                            <div class="item-row">
                                                <div class="item-col fixed item-col-img xs">
                                                    <a href="">
                                                        <div class="item-img xs rounded" style="background-image: url(https://s3.amazonaws.com/uifaces/faces/twitter/why_this/128.jpg)"></div>
                                                    </a>
                                                </div>
                                                <div class="item-col item-col-title no-overflow">
                                                    <div>
                                                        <a href="" class="">
                                                            <h4 class="item-title no-wrap">
            									Fenohasina Nadia
            								</h4> </a>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-sales">
                                                    <div class="item-heading">Sales</div>
                                                    <div> Professeur de musique </div>
                                                </div>
                                                <div class="item-col item-col-stats">
                                                    <div class="item-heading">Stats</div>
                                                    <div class="no-overflow">
                                                        <div class="item-stats sparkline" data-type="bar"></div>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-date">
                                                    <div class="item-heading">Published</div>
                                                    <div> 2013 </div>
                                                </div>
                                            </div>
                                        </li>
										                                        <li class="item">
                                            <div class="item-row">
                                                <div class="item-col fixed item-col-img xs">
                                                    <a href="">
                                                        <div class="item-img xs rounded" style="background-image: url(https://s3.amazonaws.com/uifaces/faces/twitter/why_this/128.jpg)"></div>
                                                    </a>
                                                </div>
                                                <div class="item-col item-col-title no-overflow">
                                                    <div>
                                                        <a href="" class="">
                                                            <h4 class="item-title no-wrap">
            									Rabe Noro
            								</h4> </a>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-sales">
                                                    <div class="item-heading">Sales</div>
                                                    <div> Cuisiniere </div>
                                                </div>
                                                <div class="item-col item-col-stats">
                                                    <div class="item-heading">Stats</div>
                                                    <div class="no-overflow">
                                                        <div class="item-stats sparkline" data-type="bar"></div>
                                                    </div>
                                                </div>
                                                <div class="item-col item-col-date">
                                                    <div class="item-heading">Published</div>
                                                    <div> 2012 </div>
                                                </div>
                                            </div>
                                        </li>
                                    </ul>
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
