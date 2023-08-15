package controlador;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

import modelo.Usuario;
import service.UsuarioService;

@Path("/usuario")
@WebServlet("/usuario/*")
public class UsuarioControlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioService usuarioService;

    @DELETE
    @Path("/id/{id}")
    public Response deletar(@PathParam("id") int id) {
    	usuarioService.deletar(id);
        return MessageResponse.okResponse("Usuário com ID " + id + " excluído com sucesso.");
    }

    @PUT
    public Response atualizar(Usuario usuario) {
    	usuarioService.atualizar(usuario);
        return MessageResponse.okResponse("Usuário com ID " + usuario.getId_usuario() + " atualizado com sucesso.");
    }

    @GET
    @Path("/listar")
    @Produces("application/json")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GET
    @Path("/id/{id}")
    @Produces("application/json")
    public Response obterUsuarioPorId(@PathParam("id") int id) {
        Usuario usuario = usuarioService.obterPorId(id);
        return MessageResponse.okResponse(usuario);
    }

    @POST
    @Path("/criar")
    @Consumes("application/json")
    @Produces("application/json")
    public Response criarUsuario(Usuario novoUsuario) {
        try {
            Usuario usuarioCriado = usuarioService.criar(novoUsuario);
            return MessageResponse.createdResponse("Usuário " + usuarioCriado.toString() + " criado com sucesso!");
        } catch (Exception e) {
            return MessageResponse.errorResponse("Erro ao criar usuário.");
        }
    }

    
}
