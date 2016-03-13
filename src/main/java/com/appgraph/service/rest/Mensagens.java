package com.appgraph.service.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;
 
@Path("/info")
public class Mensagens {

	@GET
	@Path("/")
	public Response HelloWorldService() {
 
		String output = "Nao esta logado";
 
		return Response.status(200).entity(output).build();
 
	}
	
	@GET
	@Path("/{param}")
	public Response getMsg(@PathParam("param") String msg) {
 
		String output = "Jersey say : " + msg;
 
		return Response.status(200).entity(output).build();
 
	}
	
}
