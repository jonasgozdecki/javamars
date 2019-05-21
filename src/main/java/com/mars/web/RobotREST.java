package com.mars.web;

import com.mars.business.RobotAction;
import com.mars.model.Robot;

import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.POST;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import static javax.ws.rs.core.MediaType.APPLICATION_JSON;
import javax.ws.rs.core.Response;

@Path("/mars")
@Produces(APPLICATION_JSON)
public class RobotREST { 

    public static final Logger logger = Logger.getLogger(RobotREST.class.getCanonicalName());

    @Inject
    private RobotAction robotOperator;

    @POST
    @Path("{instructions}")
    public Response instructions(@PathParam("instructions") String instructions) {
        logger.info("Instrucao recebida: " + instructions);
        Robot robotOuput = robotOperator.action(instructions);
        return Response.ok(robotOuput, MediaType.TEXT_PLAIN_TYPE).build();
    }

}
