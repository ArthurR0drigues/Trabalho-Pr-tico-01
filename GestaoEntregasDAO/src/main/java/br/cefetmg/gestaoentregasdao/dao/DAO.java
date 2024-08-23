package br.cefetmg.gestaoentregasdao.dao;

import java.util.List;
import javax.persistence.*;
import br.cefetmg.gestaoentregasdao.dao.exceptions.DAOException;

public class DAO<T> {
    
    protected final Class<T> entidade;
    protected final EntityManagerFactory entityManagerFactory;
    protected final String nomeEntidade;
    protected final String nomeTabela;

    public DAO(Class<T> entidade, String persistenceUnitName) throws DAOException {
        try {
            this.entidade = entidade;
            this.entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitName);
            this.nomeEntidade = entidade.getSimpleName();
            this.nomeTabela = this.entidade.getAnnotation(javax.persistence.Table.class).name();
        } catch (Exception e) {
            throw new DAOException("Erro ao criar EntityManagerFactory", e);
        }
    }

    public void salvar(T entity) throws DAOException {
        EntityManager entityManager = null;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new DAOException("Erro ao salvar " + nomeEntidade, e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public T consultar(Integer id) throws DAOException {
        EntityManager entityManager = null;
        T result;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();
            result = entityManager.find(entidade, id);
        } catch (Exception e) {
            throw new DAOException("Erro ao consultar " + nomeEntidade, e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return result;
    }
    
    public List<T> consultarTodos() throws DAOException {
        EntityManager entityManager = null;
        List<T> result;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();
            result = entityManager.createQuery("FROM " + nomeEntidade + " t", entidade).getResultList();
        } catch (Exception e) {
            throw new DAOException("Erro ao consultar todos os " + nomeEntidade, e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
        return result;
    }

    public void atualizar(T entity) throws DAOException {
        EntityManager entityManager = null;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new DAOException("Erro ao atualizar " + nomeEntidade, e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }

    public void deletar(T entity) throws DAOException {
        EntityManager entityManager = null;
        try {
            entityManager = this.entityManagerFactory.createEntityManager();
            entityManager.getTransaction().begin();
            if (!entityManager.contains(entity)) {
                entity = entityManager.merge(entity);
            }
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            if (entityManager != null && entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw new DAOException("Erro ao deletar " + nomeEntidade, e);
        } finally {
            if (entityManager != null) {
                entityManager.close();
            }
        }
    }
}
