package Resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import tn.esprit.business.LogementBusiness;
import tn.esprit.entites.Logement.Type;
 

@Path("logements")
public class LogementRes {
	
	public static LogementBusiness log=new LogementBusiness();
	
	 
    @GET 
	@Produces(MediaType.APPLICATION_JSON)
  
	public Response displayLogParfelegationList(@QueryParam(value="delegation") String delegation,@QueryParam(value="gouvertnorat") 
	String gouvertnorat,@QueryParam(value="type") Type type,@QueryParam(value="prix") float prix,@QueryParam(value="reference") int reference) {
		 
    	
    	if(delegation!=null) {
			return Response.status(Status.OK).entity(log.getLogementsByDeleguation(delegation)).build();  	
		}
		 if (gouvertnorat!=null) {
			return Response.status(Status.OK).entity(log.getLogementsByGouvernorat(gouvertnorat)).build();
		}
		 if(type!=null) {
				return Response.status(Status.OK).entity(log.getLogementsByType(type)).build();  	
 
		 }
		 if(prix!=0) {
				return Response.status(Status.OK).entity(log.getLogementsByPrix(prix)).build();

		 }
		 if(reference!=0) {
				return Response.status(Status.OK).entity(log.getLogementsByReference(reference)).build();  	

		 }
		 else if(log.getLogementsByReference(reference)!=null)
			 return Response.status(Status.NOT_FOUND).entity(log.getLogementsByReference(reference)).build();
		return Response.status(Status.OK).entity(log.getLogements()).build(); 
	}
    
    
	 
}
 