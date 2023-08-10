package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import modelo.Usuario;

public class UsuarioDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
    private EntityManager em;
	
    public UsuarioDAO() {
    	em = emf.createEntityManager();
    }
    
    public Usuario obter(int id) {
        em.getTransaction().begin();
        Usuario usuario = em.find(Usuario.class, id);
        em.getTransaction().commit();
        return usuario;
    }
    
    public Usuario criar(Usuario usuario) {
        em.getTransaction().begin();
        em.persist(usuario);
        em.getTransaction().commit();
        return usuario;
    }
    
    public Usuario atualizar(Usuario usuario) {
        em.getTransaction().begin();
        usuario = em.merge(usuario);
        em.getTransaction().commit();
        return usuario;
    }


    public void remover(Usuario usuario) {
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }
    
    @Transactional
    public void removerByID(int id_usuario) {
       int isSuccessful = em
    		    .createQuery("delete from usuario p where p.id_usuario=:id_usuario")
                .setParameter("id_usuario", id_usuario)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new OptimisticLockException(" product modified concurrently");
        }
    }

    @SuppressWarnings("unchecked")
	public List<Usuario> getAll(){
        List<Usuario> lista = em
                .createQuery("SELECT p FROM usuario p")
                .getResultList();
        return lista;
    }
    
    public Usuario getAllByID(int id_usuario){
        Usuario retorno = (Usuario) em
                .createQuery("SELECT p FROM usuario p WHERE id_usuario = :id_usuario")
                .setParameter("id_usuario", id_usuario)
                .getSingleResult();
        return retorno;
    }
    
    public Usuario getByLogin(Usuario usuario){
    	Usuario retorno = (Usuario) em
                .createQuery("SELECT * FROM usuario WHERE email = :email AND senha = :senha")
                .setParameter("email", usuario.getEmail())
                .setParameter("senha", usuario.getSenha())
                .getSingleResult();
        return retorno;
    }
	
}
