package Resources;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;


import tn.esprit.business.RendezVousBusiness;
import tn.esprit.entites.RendezVous;
@Path("rendezvous")
public class RendezVousRes {
	public static RendezVousBusiness rdv=new RendezVousBusiness();
	public static  List<RendezVous> list=new ArrayList<RendezVous>();
		@POST
	    @Consumes(MediaType.APPLICATION_JSON)
		
	public Response AjouterRdv(RendezVous rendez) {
		if(rdv.addRendezVous(rendez)) {
			return Response.status(Status.OK).build();
		}
		return Response.status(Status.NOT_FOUND).build();
	}
		

		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public  Response  displayRendezVous() {
			if(rdv.getListeRendezVous().size()!=0) {
				return Response.status(Status.FOUND).entity(rdv.getListeRendezVous()).build();
				 
			}
			else {
				return Response.status(Status.NO_CONTENT).build();
			}
		}
		@Path("{id}")
		@GET
		@Produces(MediaType.APPLICATION_JSON)
		public  Response  displayRendezVousparID(@PathParam(value="id")int id) {
			 
				return Response.status(Status.FOUND).entity(rdv.getRendezVousById(id)).build();
			 
			
		}
		
		/*@GET
		@Produces(MediaType.APPLICATION_JSON)
		public  Response  displayRendezVousparlog(@QueryParam(value="refLogement")int id) {
			 
				return Response.status(Status.FOUND).entity(rdv.getListeRendezVousByLogementReference(id)).build();		
		}*/
		@Path("{id}")
		@DELETE	
		public Response deleteRdv(@PathParam(value="id") int id){
			if(rdv.deleteRendezVous(id)) {
				 
				  return Response.status(Status.OK).build();
				
			}
			else {
				return Response.status(Status.NOT_FOUND).build();
				
			}
		
		}
		@Path("{id}")
		@PUT
	    @Consumes(MediaType.APPLICATION_JSON)
		
		public Response updateRdv(@PathParam(value="id") int id,RendezVous r) {
			//rdv.updateRendezVous(id, rdv.getRendezVousById(id));
			if(rdv.updateRendezVous(id, r)) {
				return Response.status(Status.OK).build();
			}
			else {
				
				
				return Response.status(Status.NOT_FOUND).build();
			}
		}
		///////////////////////////////////////////////////////////////////////////////////
	/*	@GET 
		@Produces(MediaType.APPLICATION_JSON)
		public Response GetAndById(@QueryParam(value="refLogement") int id) {
			if (id!=0) {
				list = rdv.getListeRendezVousByLogementReference(id) ; 
				
					return Response.status(Status.FOUND).entity(list).build(); 
				
				
				}
			else {
				list = rdv.getListeRendezVous() ; 
				
					return Response.status(Status.FOUND).entity(list).build(); 
				
			}
		}
		*/
	

}
