import com.google.gson.Gson;
import tn.co.DAO.DAOInvoice;
import tn.co.InvoiceEntity;


import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Path("/invoice")
public class Invoice {

    DAOInvoice DAO = new DAOInvoice();


    @GET
    @Path("/{_id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response productsAll(
            @PathParam("_id") int id){

        List Invoice = DAO.findByIdClient(id);
        String json =  new Gson().toJson(Invoice);

        if (Invoice == null)
            return Response.status(404).build();

        return Response
                .status(200)
                .entity(json)
                .build();
    }


    @POST
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addInvoice(String Sinv ){

        try{
            InvoiceEntity invoice =  new Gson().fromJson(Sinv, InvoiceEntity.class);
            DAO.create(newInvoice(invoice));

            List Invoices = DAO.findByIdClient(invoice.getIdCustomerInv());
            String json =  new Gson().toJson(Invoices);

            return Response
                    .status(201)
                    .entity(json)
                    .build();

        }catch(Exception ex){
            System.out.println("Error de conversion " + ex.getLocalizedMessage());

            return Response
                    .status(404).build();
        }

    }



    private InvoiceEntity newInvoice(InvoiceEntity invoice) {

        InvoiceEntity newInvoice = new InvoiceEntity();

        newInvoice.setIdCustomerInv(invoice.getIdCustomerInv());
        newInvoice.setProductsInv(invoice.getProductsInv());
        newInvoice.setPaidInv(invoice.getPaidInv());

        Date date= new Date();
        long time = date.getTime();

        newInvoice.setDate(new Timestamp(time));
        return newInvoice;

    }


}