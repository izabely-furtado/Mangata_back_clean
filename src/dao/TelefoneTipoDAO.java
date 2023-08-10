package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.TelefoneTipo;

public class TelefoneTipoDAO {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
    private EntityManager em;
	
    public TelefoneTipoDAO() {
    	em = emf.createEntityManager();
    }
    
    public TelefoneTipo getById(int id) {
        em.getTransaction().begin();
        TelefoneTipo telefoneTipo = em.find(TelefoneTipo.class, id);
        em.getTransaction().commit();
        return telefoneTipo;
    }
    
    public TelefoneTipo criar(TelefoneTipo telefoneTipo) {
        em.getTransaction().begin();
        em.persist(telefoneTipo);
        em.getTransaction().commit();
        return telefoneTipo;
    }
    
    public TelefoneTipo atualizar(TelefoneTipo telefoneTipo) {
        em.getTransaction().begin();
        telefoneTipo = em.merge(telefoneTipo);
        em.getTransaction().commit();
        return telefoneTipo;
    }


    public void remover(TelefoneTipo telefoneTipo) {
        em.getTransaction().begin();
        em.remove(telefoneTipo);
        em.getTransaction().commit();
    }

    @SuppressWarnings("unchecked")
	public List<TelefoneTipo> getAll(){
        List<TelefoneTipo> lista = em
                .createQuery("SELECT p FROM telefone_tipo p")
                .getResultList();
        return lista;
    }
    
    @SuppressWarnings("unchecked")
	public List<TelefoneTipo> getAllByID(int id_telefone_tipo){
        List<TelefoneTipo> lista = em
                .createQuery("SELECT p FROM telefone_tipo p WHERE id_telefone_tipo = :id_telefone_tipo")
                .setParameter("id_telefone_tipo", id_telefone_tipo)
                .getResultList();
        return lista;
    }
	
}
