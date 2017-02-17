/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function supprimer(dd,ideleve) {
	 
         var retVal = confirm("Vous voulez vraiment supprimer ?");
               if( retVal == true ){
                  document.location.href="deleteP.jsp?idP="+dd+"&&ide="+ideleve;
               }
               else{
                  document.location.href="modifier.jsp?ideleve="+ideleve;
               }
}


