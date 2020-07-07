package academy.learnprogramming.rest;


import academy.learnprogramming.entity.Salesman;
import academy.learnprogramming.service.SalesmanService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("salesman")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class SalesmanRest {

    @Inject
    SalesmanService salesmanService;

    @Path("new")
    @POST
    public Response createSalesman(Salesman sm){
        salesmanService.createSM(sm);
        return Response.ok(sm).build();
    }

    @Path("update")
    @PUT
    public Response updateSalesman(Salesman sm){
        salesmanService.updateSm(sm);
        return Response.ok(sm).build();
    }

    @Path("{id}")
    @GET
    public Salesman findSalesman(@PathParam("id")int id){
        return  salesmanService.findSalsmanById(id);

    }

    @Path("list")
    @GET
    public List<Salesman> salesmenList(){
        return salesmanService.salesmenList();
    }

    @Path("managers")
    @GET
    public List<Salesman> managersList(){
        return salesmanService.listOfManagers();
    }


    //auto create salesman
    @Path("auto")
    @GET
    public Response autoCreate(){
        String msg =salesmanService.autoCreateSalesman();
        return Response.ok(msg).build();
    }
}
