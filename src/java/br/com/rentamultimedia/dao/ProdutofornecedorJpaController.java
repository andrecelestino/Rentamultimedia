package br.com.rentamultimedia.dao;

import br.com.rentamultimedia.dao.exception.NonexistentEntityException;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Produtofornecedor;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class ProdutofornecedorJpaController implements Serializable {
    private EntityManagerFactory emf = null;
    private EntityManager em;
    
    public ProdutofornecedorJpaController(EntityManagerFactory emf){
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtofornecedor produtofornecedor) throws RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produtofornecedor);
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

    public void edit(Produtofornecedor produtofornecedor) throws NonexistentEntityException, RollbackFailureException, Exception {
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produtofornecedor = em.merge(produtofornecedor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            try {
                em.getTransaction().rollback();
            } catch (Exception re) {
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = produtofornecedor.getCodPrdForn();
                if (findProdutofornecedor(id) == null) {
                    throw new NonexistentEntityException("The produtofornecedor with id " + id + " no longer exists.");
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
            Produtofornecedor produtofornecedor;
            try {
                produtofornecedor = em.getReference(Produtofornecedor.class, id);
                produtofornecedor.getCodPrdForn();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtofornecedor with id " + id + " no longer exists.", enfe);
            }
            em.remove(produtofornecedor);
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

    public List<Produtofornecedor> findProdutofornecedorEntities() {
        return findProdutofornecedorEntities(true, -1, -1);
    }

    public List<Produtofornecedor> findProdutofornecedorEntities(int maxResults, int firstResult) {
        return findProdutofornecedorEntities(false, maxResults, firstResult);
    }

    private List<Produtofornecedor> findProdutofornecedorEntities(boolean all, int maxResults, int firstResult) {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Produtofornecedor.class));
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

    public Produtofornecedor findProdutofornecedor(Integer id) {
        em = getEntityManager();
        try {
            return em.find(Produtofornecedor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutofornecedorCount() {
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Produtofornecedor> rt = cq.from(Produtofornecedor.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
    public void editar(Produtofornecedor pf){
        em = getEntityManager();
        em.getTransaction().begin();
        Produtofornecedor pfaltera=em.find(Produtofornecedor.class, pf.getCodPrdForn());
        pfaltera.setCodFornFK(pf.getCodFornFK());
        pfaltera.setQuantidadePrd(pf.getQuantidadePrd());
        pfaltera.getProduto().setDataCompra(pf.getProduto().getDataCompra());
        pfaltera.getProduto().setMarcaProduto(pf.getProduto().getMarcaProduto());
        pfaltera.getProduto().setNFCompra(pf.getProduto().getNFCompra());
        pfaltera.getProduto().setNomeProduto(pf.getProduto().getNomeProduto());
        pfaltera.getProduto().setTipoProduto(pf.getProduto().getTipoProduto());
        em.merge(pfaltera);
        em.getTransaction().commit();
        em.close();
    }
    
}
