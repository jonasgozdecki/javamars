package com.mars.web;

import com.mars.model.ErrorMessage;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;


@Provider
public class RobotExceptionHandler implements
        ExceptionMapper<RobotBadRequestException> { 

    private static final String ERROR_CODE = "400";
    private static final String ERROR_BAD_REQUEST = "Bad Request";

    @Override
    public Response toResponse(final RobotBadRequestException exception) {
        ErrorMessage defaultErrorMessage = new ErrorMessage(ERROR_CODE, ERROR_BAD_REQUEST);
        return Response.status(Status.BAD_REQUEST).entity(defaultErrorMessage).type(MediaType.TEXT_PLAIN).build();
    }
}
