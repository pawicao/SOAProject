package pl.edu.agh.soa.auth;

import com.auth0.jwt.exceptions.JWTVerificationException;

import javax.annotation.Priority;
import javax.inject.Inject;
import javax.ws.rs.NotAuthorizedException;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

@Provider
@RequiresAuthentication
@Priority(Priorities.AUTHENTICATION)
public class JWTFilter implements ContainerRequestFilter {

    @Inject
    private AuthenticationService authenticationService;

    @Override
    public void filter(ContainerRequestContext requestContext) {
        String authHeaderValue = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
        if (authHeaderValue == null || !authHeaderValue.startsWith("Bearer ")) {
            throw new NotAuthorizedException("No authorization header provided.");
        }

        String token = authHeaderValue.substring("Bearer".length()).trim();
        try {
            authenticationService.verifyToken(token);
            System.out.println("Successful authorization.");
        } catch (JWTVerificationException e){
            System.out.println("Authorization failed.");
            requestContext.abortWith(Response.status(Response.Status.UNAUTHORIZED).build());
        }
    }

}
