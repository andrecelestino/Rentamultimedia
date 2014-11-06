package br.com.rentamultimedia.dao;

import br.com.rentamultimedia.dao.exception.NonexistentEntityException;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Itemnf;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ItemnfJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    private EntityManager em;
    
    public ItemnfJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemnf itemnf) throws RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemnf);
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

    public void edit(Itemnf itemnf) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemnf = em.merge(itemnf);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemnf.getCodItemNf();
                if (findItemnf(id) == null) {
                    throw new NonexistentEntityException("The itemnf with id " + id + " no longer exists.");
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
            Itemnf itemnf;
            try {
                itemnf = em.getReference(Itemnf.class, id);
                itemnf.getCodItemNf();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemnf with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemnf);
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

    public List<Itemnf> findItemnfEntities() {
        return findItemnfEntities(true, -1, -1);
    }

    public List<Itemnf> findItemnfEntities(int maxResults, int firstResult) {
        return findItemnfEntities(false, maxResults, firstResult);
    }

    private List<Itemnf> findItemnfEntities(boolean all, int maxResults, int firstResult) {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemnf.class));
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

    public Itemnf findItemnf(Integer id) {
        em = getEntityManager();
        try {
            return em.find(Itemnf.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemnfCount() {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemnf> rt = cq.from(Itemnf.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
