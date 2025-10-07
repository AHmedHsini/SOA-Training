package webservices;

import entities.UniteEnseignement;
import metiers.UniteEnseignementBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/ue")
public class UEResources {
    static UniteEnseignementBusiness helper = new UniteEnseignementBusiness();
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
    //addUE
    @Path("/add")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addUE(UniteEnseignement ue) {
        if(this.helper.addUniteEnseignement(ue)){
            return Response
                    .status(201)
                    .entity("added UE")
                    .build();
        }
        return Response
                .status(409)
                .entity("alredy exist")
                .build();
    }
}
