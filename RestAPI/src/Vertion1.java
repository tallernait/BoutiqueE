//import com.google.gson.Gson;
//import tn.co.UserEntity;
//
//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;
//import java.util.List;
//
//@Path("/v.1")
//public class Vertion1 {
//
//    @GET
//    @Path("/insert")
//    public String test(){
//
//        create("seb", "sebastian" , "123456" );
//        create("kat", "katherine" , "123" );
//        return "OK succes";
//    }
//
//    @GET
//    @Path("/userAlone")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String usersAll(){
//        List<UserEntity> Users = readAll();
//        String json =  new Gson().toJson(Users);
//
//        System.out.println(json);
//        return json;
//    }
//
//}
//
//
