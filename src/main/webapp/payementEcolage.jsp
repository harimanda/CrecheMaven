<%-- 
    Document   : inscription
    Created on : 27 oct. 2016, 10:12:43
    Author     : itu
--%>

<%@page import="admin.Mois"%>
<%@page import="ecolage.Facture"%>
<%@page import="function.NewPayement"%>
<%@page import="peronne.Enfant"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.time.Month"%>
<%@page import="java.sql.Connection"%>
<%@page import="connexion.ConnectBase"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.io.PrintWriter"%>
 
 

<%
    HttpSession sessiont = request.getSession(true); 
    String sessions = (String) sessiont.getAttribute("user");
    Mois month = new Mois();
    Facture[] fact = null;
    if(sessions == null){
        response.sendRedirect("login.jsp");
    }
    else {
        
        String ideleves = "";
        String moisi = "";
        String annesi = "";
        NewPayement paye = new NewPayement();
        Enfant[] enf = null;
        if(request.getParameter("found")!=null){ 
            if(request.getParameter("ideleve")!=null){
                ideleves = request.getParameter("ideleve");
                moisi = request.getParameter("mois");
                annesi = request.getParameter("annee");
                System.out.println("mois"+moisi);
                System.out.println("annesi"+annesi);
                fact= paye.getUnpayedEcolgae(ideleves,moisi,annesi);
            }
        }
%>
<!doctype html>
<html class="no-js" lang="en">

    <head>
        <meta http-equiv="x-ua-compatible" content="ie=edge">
        <title> Payement Ecolage </title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="apple-touch-icon" href="apple-touch-icon.png">
        <link rel="stylesheet" href="css/semantic.min.css">
        
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
                                <li  >
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
                                <li class="active">
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
                                     <% if(request.getAttribute("message")!=null){%>
			<div class="ui warning message">
			  <i class="close icon"></i>
			  <div>
			    Erreur au niveau du formulaire
			  </div>
			 <% out.print(request.getAttribute("message")); %>
			</div>
		<% } %>
                         <div class="row sameheight-container">
                    
                    <div class="col-md-12">
                        <div class="card card-block sameheight-item">
                            <div class="title-block">
                                <h3 class="title">
						Facture:
					</h3> </div>
                           <form action="#"  method="GET" class="form-horizontal">
                               <div class="form-group row"> <label for="inputEmail3" class="col-sm-1 form-control-label">El&egrave;ve:</label>
                                    <div class="col-sm-2"> <select class="form-control" name="ideleve">
                                            <% 
                                                 
                                                enf = paye.getAllEleve();
                                                
                                                for(int i=0;i<enf.length;i++){
                                            %>
                                            <option value="<%=enf[i].getIDENFANT() %>"><%=enf[i].getREF_ELEVE() %></option>
                                            <% } %>
                                        </select> </div>
                                   <label for="inputPassword3" class="col-sm-1 form-control-label">Mois:</label>
                                    <div class="col-sm-2"> <select class="form-control" name="mois">
                                             <option value = "">Aucun</option>
                                            <% 
                                                for (Month c : Month.values()){
                                                %>
                                               
                                            <option value = <%=c.getValue()%>><%=c%></option>
                                             <% } %>
                                        </select> </div>
                                   <label for="inputPassword3" class="col-sm-1 form-control-label">Ann&eacute;e:</label>
                                   <div class="col-sm-2"> <input type="text" class="form-control" name="annee" placeholder="Ann&eacute;e"> </div>
                               <div class="col-sm-offset-2"> <button type="submit" class="btn btn-success" name="found">Rechercher</button> </div>
                               </div>
                                
                                                       
                               
                                 
                                 
                            </form>
                        </div>
                    </div>
                         </div>
                             <div class="row sameheight-container">
                    
                            <div class="col-md-12">
                                <div class="card card-block sameheight-item">
                                    <div class="title-block">
                                        <h3 class="title">
                                            Ecolage non-pay&eacute;:
                                                </h3> </div>
                                <form action="facture.jsp" method="post">
                                   <table class="table table-striped table-bordered table-hover">
                                                             <thead class="flip-header">
                                                        <tr>
                                                            <th>El&egrave;ve</th>
                                                            <th>Section</th>
                                                            <th>Ecolage</th>
                                                            <th>Mois</th>
                                                            <th>Ann&eacute;e</th>  
                                                            <th>Payer</th>  
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                           if(fact!=null){
                                                               for(int x=0;x<fact.length;x++){
                                                                    month = paye.getMoisActivites(fact[x].getMOIS());        
                                                                   
                                                            %>
                                                        <tr> 
                                                            <td><%=fact[x].getREF_ELEVE() %></td>
                                                            <td><%=fact[x].getIDBRANCHE() %></td>
                                                            <td><%=fact[x].getECOLAGE() %></td>
                                                            <td><%=month.getMonth() %></td>
                                                            <td><%=fact[x].getANNEE() %></td>
                                                            <td class="collapsing">
                                                                <div class="ui fitted slider checkbox">
									<input type="checkbox" name="engage" value = "<%=fact[x].getIDECOLAGE_AP()%>,<%=fact[x].getIDELEVE()%>" > <label></label>
								</div>
                                                            </td>
                                                            
                                                        </tr>
                                                        <% } }%>
                                                    </tbody>
                                                            </table>    
                                                     <div class="col-sm-offset-2"> <button type="submit" class="btn btn-success" name="found">Voir facture</button> </div>
                                </form>
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
