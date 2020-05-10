package pl.edu.agh.soa.auth;

import com.auth0.jwt.exceptions.JWTCreationException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/")
@Api( value = "Authentication Controller")
public class AuthenticationController {

    @Inject
    AuthenticationService authenticationService;

    private void authorize(String username, String password) throws NotAuthorizedException{
        if(!(username.equals("admin1") && password.equals("password")))
            throw new NotAuthorizedException("Invalid credentials");
    }

    @GET
    @Path("/auth")
    @ApiOperation(
            value = "Returns a token required for POST, PUT, DELETE methods of Student Controller",
            response = String.class
    )
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "Missing credentials."),
            @ApiResponse(code = 401, message = "Authorization failed. Wrong username or password."),
            @ApiResponse(code = 200, message = "Returns a token."),
            @ApiResponse(code = 500, message = "Unexpected internal server error")
    })
    public Response createToken(@QueryParam("username") String username, @QueryParam("password") String password) {
        if (username == null || password == null)
            return Response.status(Response.Status.BAD_REQUEST)
                    .header("WWW-Authenticate", "Missing credentials").build();

        try {
            authorize(username, password);
            String token = authenticationService.generateToken();
            return Response.status(Response.Status.OK).entity(token).build();
        } catch (NotAuthorizedException e) {
            e.printStackTrace();
            return Response.status(Response.Status.UNAUTHORIZED)
                    .header("WWW-Authenticate", "Bearer realm=\"DefaultRealm\"")
                    .build();
        } catch (JWTCreationException e) {
            e.printStackTrace();
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }
}
