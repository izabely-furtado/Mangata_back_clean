package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.OptimisticLockException;
import javax.persistence.Persistence;

import modelo.TelefoneTipo;

public class TelefoneTipoDAO implements EntityDAO<TelefoneTipo> {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("configBD");
	private EntityManager em;

	public TelefoneTipoDAO() {
		em = emf.createEntityManager();
	}

	@Override
	public TelefoneTipo getById(int id) {
		return em.find(TelefoneTipo.class, id);
	}

	@Override
	public TelefoneTipo criar(TelefoneTipo telefoneTipo) {
		em.getTransaction().begin();
		em.persist(telefoneTipo);
		em.getTransaction().commit();
		return telefoneTipo;
	}

	@Override
	public TelefoneTipo atualizar(TelefoneTipo telefoneTipo) {
		em.getTransaction().begin();
		telefoneTipo = em.merge(telefoneTipo);
		em.getTransaction().commit();
		return telefoneTipo;
	}

	@Override
	public void remover(TelefoneTipo telefoneTipo) {
		em.getTransaction().begin();
		em.remove(telefoneTipo);
		em.getTransaction().commit();
	}

	@Override
	public void removerByID(int id_telefone_tipo) {
		em.getTransaction().begin();
		int isSuccessful = em.createQuery("DELETE FROM telefone_tipo p WHERE p.id_telefone_tipo = :id_telefone_tipo")
				.setParameter("id_telefone_tipo", id_telefone_tipo).executeUpdate();
		if (isSuccessful == 0) {
			throw new OptimisticLockException("User modified concurrently");
		}
		em.getTransaction().commit();
	}

	@Override
	public List<TelefoneTipo> getAll() {
		return em.createQuery("SELECT p FROM telefone_tipo p", TelefoneTipo.class).getResultList();
	}

	@SuppressWarnings("unchecked")
	public List<TelefoneTipo> getAllByID(int id_telefone_tipo) {
		return em.createQuery("SELECT p FROM telefone_tipo p WHERE id_telefone_tipo = :id_telefone_tipo")
				.setParameter("id_telefone_tipo", id_telefone_tipo).getResultList();
	}

}
