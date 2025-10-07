package webservices;

import entities.Module;
import metiers.ModuleBusiness;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/rs")
public class ModuleResources {
    static ModuleBusiness helperModule = new ModuleBusiness();
    @Path("/list")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAllModules() {
        return Response
                .status(200)
                .entity(this.helperModule.getAllModules())
                .build();
    }
    @Path("/add")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addModule(Module mr) {
        if(this.helperModule.addModule(mr)){
            return Response
                    .status(201)
                    .entity("added mr")
                    .build();
        }
        return Response
                .status(409)
                .entity("alredy exist")
                .build();
    }
    //deleteUE
    @Path("/delete/{matricule}")
    @DELETE
    @Produces(MediaType.TEXT_PLAIN)
    public Response deleteModule(@PathParam("matricule") String matricule) {
        if (this.helperModule.deleteModule(matricule)) {
            return Response
                    .status(200)
                    .entity("deleted")
                    .build();
        }
        return Response
                .status(404)
                .entity("not found")
                .build();
    }
    //search by Matricule
    @Path("/search")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response searchModule(@QueryParam("m") String matricule) {
        return Response.status(200).entity(this.helperModule.getModuleByMatricule(matricule)).build();
    }

}
