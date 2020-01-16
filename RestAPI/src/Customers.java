import com.google.gson.Gson;
import tn.co.DAO.DAOClient;
import tn.co.DAO.DAOProduct;
import tn.co.UserEntity;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/customer")
public class Customers {

    DAOClient DAO = new DAOClient();

    @POST
    @Path("/userok")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response find(String customer){

            String ResJson = null;
            System.out.println(customer);
            UserEntity c = new Gson().fromJson(customer, UserEntity.class);
            UserEntity cServer = DAO.findByUser(c.getUser());

            if (c.getPassword().equals(cServer.getPassword())){
                cServer.setPassword("***************");
                ResJson =  new Gson().toJson(cServer);
            }

            return Response
                    .status(200)
                    .entity(ResJson)
                    .build();
    }

    @GET
    @Path("/userAlone")
    @Produces(MediaType.APPLICATION_JSON)
    public Response usersAll(){
        List<UserEntity> Users = DAO.readAll();
        String json =  new Gson().toJson(Users);

        if (Users == null)
            return Response.status(404).build();

        return Response
                .status(200)
                .entity(json)
                .build();
    }


    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productsAll(){
        DAOProduct DAO = new DAOProduct();
        List Products = DAO.readAll();
        String json =  new Gson().toJson(Products);

        if (Products == null)
            return Response.status(404).build();

        return Response
                .status(200)
                .entity(json)
                .build();
    }

}


