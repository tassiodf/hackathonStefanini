package com.stefanini.hackaton.rest.config;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {
	@Override
	public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext cres)
			throws IOException {
		cres.getHeaders().add("Access-Control-Allow-Origin", "http://localhost:8000");
		cres.getHeaders().add("Access-Control-Allow-Headers",
				"Origin, JSESSIONID, Set-Cookie, Cookie, Content-Type, Accept, Authorization, X-Requested-With");
		cres.getHeaders().add("Access-Control-Expose-Headers",
				"Origin, JSESSIONID, Set-Cookie, Cookie, Content-Type, Accept, Authorization, X-Requested-With");
		cres.getHeaders().add("Access-Control-Allow-Credentials", "true");
		cres.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
		cres.getHeaders().add("Access-Control-Max-Age", "1209600");
	}
}
