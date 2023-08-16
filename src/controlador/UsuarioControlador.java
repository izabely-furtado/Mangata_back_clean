package controlador;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
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
    public void deletar(@PathParam("id") int id, HttpServletResponse response) throws IOException {
    	usuarioService.deletar(id);
    	response.getWriter().println("Usuário com ID " + id + " excluído com sucesso.");
    }

    @PUT
    public void atualizar(Usuario usuario, HttpServletResponse response) throws IOException {
    	usuarioService.atualizar(usuario);
    	response.getWriter().println("Usuário com ID " + usuario.getId_usuario() + " atualizado com sucesso.");
    }

    @GET
    @Path("")
    @Produces("application/json")
    public List<Usuario> listar() {
        return usuarioService.listar();
    }

    @GET
    @Path("/id/{id}")
    @Produces("application/json")
    public Usuario obterUsuarioPorId(@PathParam("id") int id) {
        return usuarioService.obterPorId(id);
    }

    @POST
    @Path("/criar")
    @Consumes("application/json")
    @Produces("application/json")
    public void criarUsuario(Usuario novoUsuario, HttpServletResponse response) throws IOException {
        try {
            Usuario usuarioCriado = usuarioService.criar(novoUsuario);
            response.getWriter().println("Usuário " + usuarioCriado.toString() + " criado com sucesso!");
        } catch (Exception e) {
        	response.getWriter().println("Erro ao criar usuário.");
        }
    }

    
}
