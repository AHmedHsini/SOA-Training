package webservices;

import metiers.UniteEnseignementBusiness;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UEResources {
    UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
    //getallUE
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllUE() {
        return Response
                .status(200)
                .entity(this.helper.getListeUE())
                .build();
    }
}
