package br.com.rentamultimedia.dao.teste;

import br.com.rentamultimedia.dao.ClienteJpaController;
import br.com.rentamultimedia.dao.ProdutoJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Cliente;
import br.com.rentamultimedia.entidade.Produto;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class main {

    public static void main(String[] args) {
        
        alterarProduto();
        
    }
    
    public static void atualizarCliente(){
        Factory factory = new Factory();
        EntityManagerFactory emf = factory.getFactory();
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Cliente cliente = em.find(Cliente.class, 3);
        cliente.getTipocliente().setTipoCliente("juridica");
        cliente.getTipocliente().setCNPJCliente("10445854000110");
        em.merge(cliente);
        em.getTransaction().commit();
        emf.close(); 
    }
    
    public static void excluirCliente(){
        Factory factory = new Factory();
        ClienteJpaController cjc=new ClienteJpaController(factory.getFactory());
        
        try {
            cjc.destroy(32);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }    
    }
    
    public static void alterarProduto(){
        Factory factory=new Factory();
        ProdutoJpaController pjc=new ProdutoJpaController(factory.getFactory());
        Produto p=new Produto();
        p.setCodProduto(8);
        p.setTipoProduto("Monitor");
        try {
            pjc.edit(p);
        } catch (RollbackFailureException ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(main.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    
}
