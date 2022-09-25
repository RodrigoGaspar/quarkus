package dev.rodgaspar.adapters.exception;

import javax.ws.rs.WebApplicationException;

import org.jboss.resteasy.reactive.RestResponse;
import org.jboss.resteasy.reactive.RestResponse.Status;
import org.jboss.resteasy.reactive.server.ServerExceptionMapper;

import dev.rodgaspar.adapters.dto.ExceptionDto;
import io.quarkus.logging.Log;

public class ExceptionHandler {

    @ServerExceptionMapper
    public RestResponse<ExceptionDto> mapException(Exception e) {
        Log.error(e.getMessage(),e);

        if (e instanceof WebApplicationException) {
            return RestResponse.status(Status.NOT_FOUND, handleException(
                    ((WebApplicationException) e).getResponse().getStatus(), e.getMessage()));
        } else {
            return RestResponse.status(Status.NOT_FOUND, handleException(500, e.getMessage()));
        }
    }

    private ExceptionDto handleException(int status, String message) {
        return ExceptionDto.builder()
                .status(status)
                .message(message)
                .build();
    }
}
