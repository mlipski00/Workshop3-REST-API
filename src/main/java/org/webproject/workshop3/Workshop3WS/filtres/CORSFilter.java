package org.webproject.workshop3.Workshop3WS.filtres;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.Provider;

/**
 * Servlet Filter implementation class CORSFilter
 */
@Provider
public class CORSFilter implements ContainerResponseFilter  {

    /**
     * Default constructor. 
     */
    public CORSFilter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */

	   @Override
	   public void filter(final ContainerRequestContext requestContext,
	                      final ContainerResponseContext cres) throws IOException {
		   
//	      cres.getHeaders().add("Access-Control-Allow-Origin", "*");
//	      cres.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization");
//	      cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
//	      cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
//	      cres.getHeaders().add("Access-Control-Max-Age", "1209600");
		   
			MultivaluedMap<String, Object> headers = cres.getHeaders();
//
			headers.add("Access-Control-Allow-Origin", "*");	
			headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");			
			headers.add("Access-Control-Allow-Headers", "X-Requested-With, Content-Type");
	   }

}

