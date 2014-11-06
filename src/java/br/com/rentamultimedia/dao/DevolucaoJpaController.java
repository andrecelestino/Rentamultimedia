package br.com.rentamultimedia.dao;

import br.com.rentamultimedia.dao.exception.NonexistentEntityException;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Devolucao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class DevolucaoJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    private EntityManager em;
    
    public DevolucaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Devolucao devolucao) throws RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(devolucao);
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

    public void edit(Devolucao devolucao) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            devolucao = em.merge(devolucao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = devolucao.getCodDevolucao();
                if (findDevolucao(id) == null) {
                    throw new NonexistentEntityException("The devolucao with id " + id + " no longer exists.");
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
            Devolucao devolucao;
            try {
                devolucao = em.getReference(Devolucao.class, id);
                devolucao.getCodDevolucao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The devolucao with id " + id + " no longer exists.", enfe);
            }
            em.remove(devolucao);
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

    public List<Devolucao> findDevolucaoEntities() {
        return findDevolucaoEntities(true, -1, -1);
    }

    public List<Devolucao> findDevolucaoEntities(int maxResults, int firstResult) {
        return findDevolucaoEntities(false, maxResults, firstResult);
    }

    private List<Devolucao> findDevolucaoEntities(boolean all, int maxResults, int firstResult) {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Devolucao.class));
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

    public Devolucao findDevolucao(Integer id) {
        em = getEntityManager();
        try {
            return em.find(Devolucao.class, id);
        } finally {
            em.close();
        }
    }

    public int getDevolucaoCount() {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Devolucao> rt = cq.from(Devolucao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
