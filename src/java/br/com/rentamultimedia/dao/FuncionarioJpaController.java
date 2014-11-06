package br.com.rentamultimedia.dao;

import br.com.rentamultimedia.dao.exception.NonexistentEntityException;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Funcionario;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

public class FuncionarioJpaController implements Serializable{
    private EntityManagerFactory emf=null;
    private EntityManager em;
    private Funcionario f;
    
    public FuncionarioJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Funcionario funcionario) throws RollbackFailureException, Exception{
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(funcionario);
            em.getTransaction().commit();
        }catch(Exception ex){
            try{
                em.getTransaction().rollback();
            }catch(Exception re){
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void edit(Funcionario funcionario) throws NonexistentEntityException, RollbackFailureException, Exception{
        try{
            em = getEntityManager();
            em.getTransaction().begin();
            funcionario = em.merge(funcionario);
            em.getTransaction().commit();
        }catch(Exception ex){
            try{
                em.getTransaction().rollback();
            }catch(Exception re){
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            String msg = ex.getLocalizedMessage();
            if(msg == null || msg.length() == 0){
                Integer id = funcionario.getCodFunc();
                if(findFuncionario(id) == null){
                    throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.");
                }
            }
            throw ex;
        }finally{
            if(em != null){
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException, RollbackFailureException, Exception{
         try{
            em = getEntityManager();
            em.getTransaction().begin();
            Funcionario funcionario;
            try{
                funcionario = em.getReference(Funcionario.class, id);
                funcionario.getCodFunc();
            }catch(EntityNotFoundException enfe){
                throw new NonexistentEntityException("The funcionario with id " + id + " no longer exists.", enfe);
            }
            em.remove(funcionario);
            em.getTransaction().commit();
        }catch(Exception ex){
            try{
                em.getTransaction().rollback();
            }catch(Exception re){
                throw new RollbackFailureException("An error occurred attempting to roll back the transaction.", re);
            }
            throw ex;
        }finally{
            if (em != null){
                em.close();
            }
        }
    }

    public List<Funcionario> findFuncionarioEntities(){
        return findFuncionarioEntities(true, -1, -1);
    }

    public List<Funcionario> findFuncionarioEntities(int maxResults, int firstResult){
        return findFuncionarioEntities(false, maxResults, firstResult);
    }

    private List<Funcionario> findFuncionarioEntities(boolean all, int maxResults, int firstResult){
        em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Funcionario.class));
            Query q = em.createQuery(cq);
            if(!all){
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        }finally{
            em.close();
        }
    }

    public Funcionario findFuncionario(Integer id){
        em = getEntityManager();
        try{
            return em.find(Funcionario.class, id);
        }finally{
            em.close();
        }
    }

    public int getFuncionarioCount(){
        em = getEntityManager();
        try{
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Funcionario> rt = cq.from(Funcionario.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        }finally{
            em.close();
        }
    }
    
    public Funcionario funcionarioExiste(Funcionario flogin) {
        em = getEntityManager();
        try{
            f=(Funcionario)em.createNamedQuery("Funcionario.findLogin")
                    .setParameter("loginFunc", flogin.getLoginFunc())
                    .setParameter("senhaFunc", flogin.getSenhaFunc())
                    .getSingleResult();
        }catch(NoResultException e){
            f=null;
        }
        em.close();
    return f;  
    }

}   
