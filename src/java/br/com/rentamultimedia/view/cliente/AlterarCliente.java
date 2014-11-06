package br.com.rentamultimedia.view.cliente;

import br.com.rentamultimedia.dao.ClienteJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Cliente;
import br.com.rentamultimedia.entidade.Tipocliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarCliente", urlPatterns = {"/AlterarCliente.do"})
public class AlterarCliente extends HttpServlet {
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
            out.println("<title>Alterar Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AlterarCliente at " + request.getContextPath() + "</h1>");
            c=new Cliente();
            c.setCodCliente(Integer.parseInt(request.getParameter("CodCliente")));
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
            cjc.editar(c);
            
            out.println("<script>");
            out.println("alert(\"Cliente "+c.getCodCliente()+" Alterado\");");
            out.println("window.location.href = \"alterarcliente.jsp\";");
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
