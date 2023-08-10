package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

import modelo.UsuarioTelefone;

public class UsuarioTelefoneDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
    private EntityManager em;
	
    public UsuarioTelefoneDAO() {
    	em = emf.createEntityManager();
    }
    
    public UsuarioTelefone obter(int id) {
        em.getTransaction().begin();
        UsuarioTelefone usuario_teletone = em.find(UsuarioTelefone.class, id);
        em.getTransaction().commit();
        return usuario_teletone;
    }
    
    public UsuarioTelefone criar(UsuarioTelefone usuario_teletone) {
        em.getTransaction().begin();
        em.persist(usuario_teletone);
        em.getTransaction().commit();
        return usuario_teletone;
    }
    
    public UsuarioTelefone atualizar(UsuarioTelefone usuario_teletone) {
        em.getTransaction().begin();
        usuario_teletone = em.merge(usuario_teletone);
        em.getTransaction().commit();
        return usuario_teletone;
    }


    public void remover(UsuarioTelefone usuario_teletone) {
        em.getTransaction().begin();
        em.remove(usuario_teletone);
        em.getTransaction().commit();
    }
    
    @Transactional
    public void removerByIDUsuario(int id_usuario) {
       int isSuccessful = em
    		    .createQuery("delete from usuario_telefone p where p.id_usuario=:id_usuario")
                .setParameter("id_usuario", id_usuario)
                .executeUpdate();
        if (isSuccessful == 0) {
            throw new OptimisticLockException("modified concurrently");
        }
    }

    @SuppressWarnings("unchecked")
	public List<UsuarioTelefone> getAll(){
        List<UsuarioTelefone> lista = em
                .createQuery("SELECT p FROM usuario_telefone p")
                .getResultList();
        return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<UsuarioTelefone> getAllByUsuario(int id_usuario){
        List<UsuarioTelefone> lista = em
                .createQuery("SELECT p FROM usuario_telefone p WHERE id_usuario = :id_usuario")
                .setParameter("id_usuario", id_usuario)
                .getResultList();
        return lista;
    }
    
    public UsuarioTelefone getAllByID(int id_usuario){
        UsuarioTelefone retorno = (UsuarioTelefone) em
                .createQuery("SELECT p FROM usuario_telefone p WHERE id_usuario = :id_usuario")
                .setParameter("id_usuario", id_usuario)
                .getSingleResult();
        return retorno;
    }	

}
