package br.com.rentamultimedia.dao;

import br.com.rentamultimedia.dao.exception.NonexistentEntityException;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Pedidolocacao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class PedidolocacaoJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    private EntityManager em;
    
    public PedidolocacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Pedidolocacao pedidolocacao) throws RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(pedidolocacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Pedidolocacao pedidolocacao) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            pedidolocacao = em.merge(pedidolocacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = pedidolocacao.getCodPedido();
                if (findPedidolocacao(id) == null) {
                    throw new NonexistentEntityException("The pedidolocacao with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Pedidolocacao pedidolocacao;
            try {
                pedidolocacao = em.getReference(Pedidolocacao.class, id);
                pedidolocacao.getCodPedido();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The pedidolocacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(pedidolocacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Pedidolocacao> findPedidolocacaoEntities() {
        return findPedidolocacaoEntities(true, -1, -1);
    }

    public List<Pedidolocacao> findPedidolocacaoEntities(int maxResults, int firstResult) {
        return findPedidolocacaoEntities(false, maxResults, firstResult);
    }

    private List<Pedidolocacao> findPedidolocacaoEntities(boolean all, int maxResults, int firstResult) {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Pedidolocacao.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Pedidolocacao findPedidolocacao(Integer id) {
        em = getEntityManager();
        try {
            return em.find(Pedidolocacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getPedidolocacaoCount() {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Pedidolocacao> rt = cq.from(Pedidolocacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
