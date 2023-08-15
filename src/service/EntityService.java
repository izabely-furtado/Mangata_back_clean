package service;

import java.util.List;

public interface EntityService<T> {
	
	void deletar(int id);

    void atualizar(T entity);

    List<T> listar();

    public T obterPorId(int id);

    T criar(T novoEntity);
}
