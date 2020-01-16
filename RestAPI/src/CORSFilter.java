import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class CORSFilter implements ContainerResponseFilter {

    @Override
    public void filter(final ContainerRequestContext requestContext,
                       final ContainerResponseContext cres) throws IOException {
        cres.getHeaders().add("Access-Control-Allow-Origin", "*");
        cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
        cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
        cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        cres.getHeaders().add("Access-Control-Max-Age", "1209600");
        //cres.getHeaders().add("Content-Type", "application/json; charset=utf-8");
        //cres.getHeaders().add("Accept", "application/json");


//        requestContext.getHeaders().add("Access-Control-Allow-Origin", "*");
//        requestContext.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type = application/json, accept, authorization");
//        requestContext.getHeaders().add("Access-Control-Allow-Credentials", "true");
//        requestContext.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
//        requestContext.getHeaders().add("Access-Control-Max-Age", "1209600");
    }

}