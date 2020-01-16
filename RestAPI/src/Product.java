import com.google.gson.Gson;
import tn.co.DAO.DAOProduct;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/product")
public class Product {

    DAOProduct DAO = new DAOProduct();

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public Response productsAll(){
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