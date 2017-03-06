package org.animesh.PDFReading.Serivice;

import java.util.Date;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.animesh.PDFReading.Model.ToDo;




@Path("/hello")
public class HelloWorldService {

	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") String msg) {

		//String output = "Jersey say : " + msg;
        ToDo toDo = new ToDo();
        toDo.setDescription(msg);
        toDo.setSummary(new Date().toString());
		return Response.status(200).entity(toDo).build();

	}
	
	

}