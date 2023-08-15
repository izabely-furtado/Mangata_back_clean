package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;

import modelo.Usuario;

public class UsuarioDAO implements EntityDAO<Usuario> {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
	private EntityManager em;

	public UsuarioDAO() {
		em = emf.createEntityManager();
	}

	@Override
	public Usuario getById(int id) {
		return em.find(Usuario.class, id);
	}

	@Override
	public Usuario criar(Usuario usuario) {
		em.getTransaction().begin();
		em.persist(usuario);
		em.getTransaction().commit();
		return usuario;
	}

	@Override
	public Usuario atualizar(Usuario usuario) {
		em.getTransaction().begin();
		usuario = em.merge(usuario);
		em.getTransaction().commit();
		return usuario;
	}

	@Override
	public void remover(Usuario usuario) {
		em.getTransaction().begin();
		em.remove(usuario);
		em.getTransaction().commit();
	}

	@Override
	public void removerByID(int id_usuario) {
		em.getTransaction().begin();
		int isSuccessful = em.createQuery("DELETE FROM Usuario p WHERE p.id_usuario = :id_usuario")
				.setParameter("id_usuario", id_usuario).executeUpdate();
		if (isSuccessful == 0) {
			throw new OptimisticLockException("User modified concurrently");
		}
		em.getTransaction().commit();
	}

	@Override
	public List<Usuario> getAll() {
		return em.createQuery("SELECT p FROM Usuario p", Usuario.class).getResultList();
	}

	public Usuario getAllByID(int id_usuario) {
		return em.createQuery("SELECT p FROM Usuario p WHERE p.id_usuario = :id_usuario", Usuario.class)
				.setParameter("id_usuario", id_usuario).getSingleResult();
	}

	public Usuario getByLogin(Usuario usuario) {
		return em.createQuery("SELECT u FROM Usuario u WHERE u.email = :email AND u.senha = :senha", Usuario.class)
				.setParameter("email", usuario.getEmail()).setParameter("senha", usuario.getSenha()).getSingleResult();
	}
}
