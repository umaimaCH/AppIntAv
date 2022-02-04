package chtioui.zelleg.restapi.security;

import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import chtioui.zelleg.restapi.service.UserManager;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;


@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class AuthenticationFilter implements ContainerRequestFilter {

	Connection con;
    private static final String REALM = "example";
    private static final String AUTHENTICATION_SCHEME = "Bearer";
  
    public AuthenticationFilter() {
    	
    	try {
			String url =String.format("jdbc:mysql://localhost:3306/colloc");
			String uname ="root";
			String pwd = "";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,uname,pwd);
			
		} catch(Exception e) {
			System.out.println(e +"data insert unsuccess.");
		}
    }

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
    	
    	System.out.println("zeijfhcucerghuijo");

        // Get the Authorization header from the request
        String authorizationHeader =
                requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);

        // Validate the Authorization header
        if (!isTokenBasedAuthentication(authorizationHeader)) {
            abortWithUnauthorized(requestContext);
            return;
        }

        // Extract the token from the Authorization header
        String token = authorizationHeader
                            .substring(AUTHENTICATION_SCHEME.length()).trim();

        try {

            // Validate the token
        	
            validateToken(token);

        } catch (Exception e) {
            abortWithUnauthorized(requestContext);
        }
    }

    private boolean isTokenBasedAuthentication(String authorizationHeader) {

        // Check if the Authorization header is valid
        // It must not be null and must be prefixed with "Bearer" plus a whitespace
        // The authentication scheme comparison must be case-insensitive
    	System.out.println("je suis ici");
        return authorizationHeader != null && authorizationHeader.toLowerCase()
                    .startsWith(AUTHENTICATION_SCHEME.toLowerCase() + " ");
    }

    private void abortWithUnauthorized(ContainerRequestContext requestContext) {

        // Abort the filter chain with a 401 status code response
        // The WWW-Authenticate header is sent along with the response
        requestContext.abortWith(
                Response.status(Response.Status.UNAUTHORIZED)
                        .header(HttpHeaders.WWW_AUTHENTICATE, 
                                AUTHENTICATION_SCHEME + " realm=\"" + REALM + "\"")
                        .build());
    }
    public void validateToken(String token) throws Exception {
        // Check if the token was issued by the server and if it's not expired
        // Throw an Exception if the token is invalid
    	
    	String select = "select * from person where token='"+ token +"'";
    	PreparedStatement ps = con.prepareStatement(select);
    	ResultSet rs = ps.executeQuery();
    	if(rs.next()) {
    		long time =System.currentTimeMillis()/1000;
    		long created_at= rs.getLong("created_at");
    		
    			
    		}
    		else {
    			throw new TokenInvalidateException("token not validated");
    		
    	}
    		
    	}

    public class TokenInvalidateException extends Exception{
    	public TokenInvalidateException(String s){
    		super(s);
    	}
    	
    }

   
}