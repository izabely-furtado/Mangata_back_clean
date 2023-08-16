package service;


import java.util.List;

import javax.inject.Inject;

import dao.UsuarioDAO;
import dao.UsuarioTelefoneDAO;
import modelo.Usuario;

public class UsuarioService implements EntityService<Usuario> {

    @Inject
    private UsuarioDAO usuarioDAO = new UsuarioDAO();

    @Inject
    private UsuarioTelefoneDAO usuarioTelefoneDAO = new UsuarioTelefoneDAO();

    @Override
	public void deletar(int id) {
        usuarioTelefoneDAO.removerByIDUsuario(id);
    }

    @Override
	public void atualizar(Usuario usuario) {
        usuarioDAO.atualizar(usuario);
    }

    @Override
	public List<Usuario> listar() {
    	return usuarioDAO.getAll();
    }

    @Override
	public Usuario obterPorId(int id) {
        return usuarioDAO.getById(id);
    }

    @Override
	public Usuario criar(Usuario novoUsuario) {
        return usuarioDAO.criar(novoUsuario);
    }
}