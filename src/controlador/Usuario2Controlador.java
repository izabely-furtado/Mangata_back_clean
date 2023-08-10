package controlador;

import java.io.IOException;
import java.util.List;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.ws.rs.*;

import dao.UsuarioDAO;
import dao.UsuarioTelefoneDAO;
import modelo.Usuario;

@WebServlet("/usuario/*")
public class Usuario2Controlador extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public Usuario2Controlador() {
        super();
    }
      
    @Path("/id")
    @DELETE
    public void deletar(@PathParam("id") String id, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("Deletando usuário...");
        
    	UsuarioTelefoneDAO usuarioTelefoneDAO = new UsuarioTelefoneDAO();
		int id_usuario = Integer.parseInt(id);
		usuarioTelefoneDAO.removerByIDUsuario(id_usuario);
		
		response.getWriter().println("Usuário com ID " + id_usuario + " excluído com sucesso.");
    }
    
    @Path("")
    @PUT
    public void atualizar(Usuario usuario, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("Atualizando usuário...");
        
    	UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuarioDAO.atualizar(usuario);
		
        response.getWriter().println("Usuário com ID " + usuario.getId_usuario() + " atualizado com sucesso.");
    }
    
    @Path("/listar")
    @GET
    @Produces("application/json")
    public List<Usuario> listar(HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("Listando usuários...");
    	
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        List<Usuario> usuarios = usuarioDAO.getAll();

        return usuarios;
    }
    
    @Path("/{id}")
    @GET
    @Produces("application/json")
    public Usuario obterUsuarioPorId(@PathParam("id") int id, HttpServletRequest request, HttpServletResponse response) throws IOException {
    	response.getWriter().println("Recurando usuário com ID " + id + ".");
    	
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Usuario usuario = usuarioDAO.getById(id);

        return usuario;
    }
    
    @Path("/criar")
    @POST
    @Consumes("application/json")
    @Produces("application/json")
    public void criarUsuario(Usuario novoUsuario, HttpServletRequest request, HttpServletResponse response) throws IOException {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        
        try {
            Usuario usuarioCriado = usuarioDAO.criar(novoUsuario);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.getWriter().println("Usuário " + usuarioCriado.toString() + " criado com sucesso!");
        } catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
            response.getWriter().println("Erro ao criar usuário.");
            e.printStackTrace();
        }
    }

    
}
