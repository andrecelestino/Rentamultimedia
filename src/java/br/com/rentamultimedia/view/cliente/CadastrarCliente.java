package br.com.rentamultimedia.view.cliente;

import br.com.rentamultimedia.dao.ClienteJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Cliente;
import br.com.rentamultimedia.entidade.Tipocliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//testee git
@WebServlet(name = "CadastrarCliente", urlPatterns = {"/CadastrarCliente.do"})
public class CadastrarCliente extends HttpServlet {
    private Cliente c;
    private Tipocliente t;
    private Factory factory;
    private ClienteJpaController cjc;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastrar Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet CadastrarCliente at " + request.getContextPath() + "</h1>");
            System.out.println("[NomeCliente]="+request.getParameter("NomeCliente"));
            System.out.println("[TelCliente]="+request.getParameter("TelCliente"));
            System.out.println("[EndCliente]="+request.getParameter("EndCliente"));
            System.out.println("[CPFCliente]="+request.getParameter("CPFCliente"));
            System.out.println("[RGCliente]="+request.getParameter("RGCliente"));
            System.out.println("[TipoCliente]="+request.getParameter("TipoCliente"));
            System.out.println("[CNPJCliente]="+request.getParameter("CNPJCliente"));
            
                c=new Cliente();
                c.setNomeCliente(request.getParameter("NomeCliente"));
                c.setTelCliente(Long.parseLong(request.getParameter("TelCliente")));
                c.setEndCliente(request.getParameter("EndCliente"));
                if(request.getParameter("TipoCliente").contentEquals("fisica")){
                    c.setCPFCliente(Long.parseLong(request.getParameter("CPFCliente")));
                    c.setRGCliente(request.getParameter("RGCliente"));
                }
                t=new Tipocliente();
                c.setTipocliente(t);
                c.getTipocliente().setTipoCliente(request.getParameter("TipoCliente"));
                if(request.getParameter("TipoCliente").contentEquals("juridica")){
                    c.getTipocliente().setCNPJCliente(request.getParameter("CNPJCliente"));
                }
                factory=new Factory();
                cjc=new ClienteJpaController(factory.getFactory());
                try {
                    cjc.create(c);
                } catch (Exception ex) {
                    Logger.getLogger(CadastrarCliente.class.getName()).log(Level.SEVERE, null, ex);
                }
                out.println("<script>");
                out.println("alert(\"Cliente Cadastrado com o Numero "+c.getCodCliente()+"\");");
                out.println("window.location.href = \"cadastrarcliente.jsp\";");
                out.println("</script>");
                out.println("</body>");
                out.println("</html>");      
        }       
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
