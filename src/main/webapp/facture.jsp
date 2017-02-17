<%-- 
    Document   : index
    Created on : 19 oct. 2016, 21:53:47
    Author     : Administrateur
--%>

<%@page import="admin.Mois"%>
<%@page import="function.Fonction"%>
<%@page import="java.util.Date"%>
<%@page import="function.NewPayement"%>
<%@page import="peronne.Enfant"%>
<%@page import="ecolage.Facture"%>
<%@page import="java.io.PrintWriter"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<%
    HttpSession sessiont = request.getSession(true); 
    String sessions = (String) sessiont.getAttribute("user");
    Facture[] facture = null;
    Facture fac = new Facture();
    Facture fille = new Facture();
    Facture mere = new Facture();
    String table1="FATURE_MERE";
    String table2 = "FACTURE_FILLE";
    Fonction fonct = new Fonction();
    Date factDate = new Date();
    Date factDate1 = new Date();
    String daty = fonct.getconverDate(factDate);
    int mois1 = factDate.getMonth();
    mois1 = mois1 + 1;
    factDate1.setMonth(mois1);
    String daty2 = fonct.getconverDate(factDate1);
    NewPayement paye = new NewPayement();
    int insert=0;
    Enfant el = new Enfant();
    if(sessions == null){
        response.sendRedirect("login.jsp");
    }
    else {
        String[] factures = null;
            if(request.getParameter("engage")!=null){
                factures = request.getParameterValues("engage");
                facture = paye.splitFacture(factures);
                for(int i=0;i<facture.length;i++){
                    String h = String.valueOf(facture[i].getIDELEVE());
                    el = paye.getEleve(h);
                }
            }
            else{
		request.setAttribute("message", "Veuillez choisir au moins un ecolage");
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/payementEcolage.jsp");
		dispatcher.forward(request, response);
            }
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
                             <article class="content forms-page">
                                 <section class="section">
                                      <div class="row sameheight-container">
                    
                    <div class="col-md-12">
                        <div class="card card-block sameheight-item">
                             <form action="#"  method="GET" class="form-horizontal">
                            <div class="title-block">
                                <h3 class="title">
                                   
						Facture ecolage
					</h3> </div>
                          
                              <div class="col-md-6">
                               <div class="form-group row"> 
                                   
                                   <label  class="col-sm-4 form-control-label">Num&eacute;ro:</label>
                                    <p><%=el.getREF_ELEVE() %></p>  
                               </div>
                               <div class="form-group row"> 
                                   <label  class="col-sm-4 form-control-label">Nom:</label>
                                    <p><%=el.getNOM()%></p> 
                               </div>
                               <div class="form-group row"> 
                                   <label  class="col-sm-4 form-control-label">Pr&eacute;nom(s):</label>
                                  <p><%=el.getPRENOM() %></p> 
                               </div>
                                <div class="form-group row">
                                    <label  class="col-sm-4 form-control-label">Date de naissance:</label>
                                   <p><%=el.getDATENAISSANCE() %></p>  
                               </div> 
                               <div class="form-group row">
                                   <label  class="col-sm-4 form-control-label">Adresse:</label>
                                    <p><%=el.getADRESSE() %></p> 
                               </div> 
                               </div>
                               <div class="col-md-6">
                                    <div class="form-group row"> 
                                    <% 
                                    %>
                                   <label  class="col-sm-offset-4 col-sm-4 form-control-label">Facture du:</label>
                                    <p><%=daty %></p>  
                               </div>
                               <div class="form-group row"> 
                                   <label  class="col-sm-offset-4 col-sm-4 form-control-label">Reference facture:</label>
                                  <p><%=el.getPRENOM() %></p> 
                               </div>
                               <div class="form-group row"> 
                                   <label  class="col-sm-offset-4 col-sm-4 form-control-label">Payement avant:</label>
                                  <p><%=daty2 %></p> 
                               </div>
                                  
						 
                               </div>
                               <hr>
                         
                               
                                
                                 <table class="table table-striped table-bordered table-hover">
                                                             <thead class="flip-header">
                                                        <tr>
                                                           
                                                            <th>Section</th>                                                            
                                                            <th>Mois</th>
                                                            <th>Ann&eacute;e</th>  
                                                            <th>Ecolage</th>
                                                             
                                                           
                                                        </tr>
                                                    </thead>
                                                    <tbody>
                                                        <%
                                                            double total = 0.0;
                                                           if(facture!=null){
                                                               Mois month = new Mois();
                                                               for(int x=0;x<facture.length;x++){
                                                                           
                                                                   fac = paye.getFacture(facture[x].getIDECOLAGE_AP());
                                                                   month = paye.getMoisActivites(fac.getMOIS()); 
                                                                   total += fac.getECOLAGE();
                                                                   fille.setIDECOLAGE_AP(facture[x].getIDECOLAGE_AP());
                                                                   fille.setDATE_EDITION(factDate);
                                                                   
                                                            %>
                                                        <tr> 
                                                            <td><%=fac.getIDBRANCHE() %></td>                                                            
                                                            <td><%=month.getMonth() %></td>
                                                            <td><%=fac.getANNEE() %></td>
                                                            <td><%=fac.getECOLAGE() %></td>
                                                           
                                                            
                                                        </tr>
                                                        <% } 
                                                                 mere.setIDELEVE(el.getIDENFANT());
                                                                 mere.setECOLAGE(total);
                                                                 mere.setDATE_EDITION(factDate);
                                                                 mere.setDATE_EXPIRATION(factDate1);
                                                                 insert = fonct.insertToTable(mere, table1);
                                                                 insert = fonct.insertToTable(fille, table2);
                                                            }%>
                                                        <tr>                                                           
                                                            <td></td>
                                                            <td></td>
                                                             <td>Total</td>
                                                            <td><%=total%></td>
                                                        </tr>
                                                    </tbody>
                                                            </table> 
                               <div class="col-sm-offset-9"> <button type="submit" class="btn btn-success" name="payer">Payement</button> </div>
                               
                         
                              
                                                       
                               
                                 
                                 
                            </form>
                                                       
                        </div>
                    </div>
                         </div> 
                                 </section>
                             </article>
                <div class="sidebar-overlay" id="sidebar-overlay"></div>
                                              
                   
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
