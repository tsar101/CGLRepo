package org.animesh.PDFReading.Serivice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.animesh.PDFReading.Model.ToDo;
import org.animesh.PDFReading.dao.CandidateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/tier2result")
public class CandidateResultService {
	
	@Autowired
	CandidateDAO candidateDAO;
	
	@GET
	@Path("/{param}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getMsg(@PathParam("param") Long rollNumber) {
    System.out.println(candidateDAO + "is null?");
		
		return Response.status(200).
				entity(candidateDAO.getCandidateResultForRollNumber(rollNumber))
				.build();

	}

	
	
	

}
