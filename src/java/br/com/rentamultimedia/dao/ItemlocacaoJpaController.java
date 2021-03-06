package br.com.rentamultimedia.dao;

import br.com.rentamultimedia.dao.exception.NonexistentEntityException;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Itemlocacao;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ItemlocacaoJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    private EntityManager em;
    
    public ItemlocacaoJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Itemlocacao itemlocacao) throws RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(itemlocacao);
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

    public void edit(Itemlocacao itemlocacao) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            itemlocacao = em.merge(itemlocacao);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = itemlocacao.getCodItemLocacao();
                if (findItemlocacao(id) == null) {
                    throw new NonexistentEntityException("The itemlocacao with id " + id + " no longer exists.");
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
            Itemlocacao itemlocacao;
            try {
                itemlocacao = em.getReference(Itemlocacao.class, id);
                itemlocacao.getCodItemLocacao();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The itemlocacao with id " + id + " no longer exists.", enfe);
            }
            em.remove(itemlocacao);
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

    public List<Itemlocacao> findItemlocacaoEntities() {
        return findItemlocacaoEntities(true, -1, -1);
    }

    public List<Itemlocacao> findItemlocacaoEntities(int maxResults, int firstResult) {
        return findItemlocacaoEntities(false, maxResults, firstResult);
    }

    private List<Itemlocacao> findItemlocacaoEntities(boolean all, int maxResults, int firstResult) {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Itemlocacao.class));
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

    public Itemlocacao findItemlocacao(Integer id) {
        em = getEntityManager();
        try {
            return em.find(Itemlocacao.class, id);
        } finally {
            em.close();
        }
    }

    public int getItemlocacaoCount() {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Itemlocacao> rt = cq.from(Itemlocacao.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
