package dao;

import java.util.List;

public interface EntityDAO<T> {
    T getById(int id);

    T criar(T entity);

    T atualizar(T entity);

    void remover(T entity);

    void removerByID(int id);

    List<T> getAll();
}
