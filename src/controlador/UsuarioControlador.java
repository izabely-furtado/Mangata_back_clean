package controlador;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import modelo.Usuario;
import service.UsuarioService;

@Path("/usuario")
@WebServlet(description = "Administra as partiçoes para a tabela usuario", urlPatterns = { "/usuario/*" })
public class UsuarioControlador extends HttpServlet {
    private static final long serialVersionUID = 1L;
    
    @Inject
    private UsuarioService usuarioService = new UsuarioService();

    @DELETE
    @Path("/id/{id}")
    public void deletar(@PathParam("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	usuarioService.deletar(id);
    	response.getWriter().println("Usuário com ID " + id + " excluído com sucesso.");
    }

    @PUT
    public void atualizar(Usuario usuario, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	usuarioService.atualizar(usuario);
    	response.getWriter().println("Usuário com ID " + usuario.getId_usuario() + " atualizado com sucesso.");
    }

    @GET
    @Path("lista")
    @Produces("application/json")
    public List<Usuario> listar() {
    	usuarioService.atualizar(null);
        return usuarioService.listar();
    }
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	usuarioService.listar();
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
