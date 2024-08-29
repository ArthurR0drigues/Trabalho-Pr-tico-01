package br.cefetmg.gestaoentregascontroller;

import java.util.List;

public interface EntidadeController<T> {
    void salvar(T entity);
    T consultar(Integer id);
    List<T> consultarTodos();
    void atualizar(T entity);
    void deletar(T entity);
}

