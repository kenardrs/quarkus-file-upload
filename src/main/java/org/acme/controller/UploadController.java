package org.acme.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.acme.entity.FormData;
import org.acme.service.UploadService;
import org.jboss.resteasy.reactive.MultipartForm;

@Path("upload")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.MULTIPART_FORM_DATA)
public class UploadController {
    @Inject
    UploadService service;

    @POST
    public Response sendFile(@MultipartForm FormData data) {
        try {
            String sendStatus = service.sendFile(data);

            return Response.ok(sendStatus).status(Status.CREATED).build();
        } catch (IOException e) {
            return Response.ok(e.getMessage(), MediaType.TEXT_PLAIN).status(Status.BAD_REQUEST).build();
        }
    }

}
