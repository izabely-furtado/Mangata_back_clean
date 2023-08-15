package controlador;

import javax.ws.rs.core.Response;

public class MessageResponse {
	public static Response okResponse(Object entity) {
        return Response.ok(entity).build();
    }

	public static Response createdResponse(String message) {
        return Response.status(Response.Status.CREATED).entity(message).build();
    }

	public static Response errorResponse(String message) {
        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(message).build();
    }
}
