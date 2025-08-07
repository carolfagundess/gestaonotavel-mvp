package br.com.gestao.notavel.mvp.dao;

import br.com.udemyjava.gestao.notavel.mvp.util.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author carol
 */
public abstract class GenericDAOImpl<T, K> implements GenericDAO<T, K> {

    private final Class<T> tipoEntidade;

    // O construtor recebe o .class da entidade que será manipulada.
    public GenericDAOImpl(Class<T> tipoEntidade) {
        this.tipoEntidade = tipoEntidade;
    }

    @Override
    public void salvar(T entidade) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            em.close();
        }
    }

    @Override
    public Optional<T> buscarPorId(K id) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            T entidade = em.find(tipoEntidade, id);
            return Optional.ofNullable(entidade);
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public List<T> buscarTodos() {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            // Cria uma consulta JPQL para buscar todos os objetos da entidade
            String jpql = "SELECT e FROM " + tipoEntidade.getSimpleName() + " e";
            TypedQuery<T> query = em.createQuery(jpql, tipoEntidade);
            return query.getResultList();
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    @Override
    public void atualizar(T entidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void excluir(K id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
