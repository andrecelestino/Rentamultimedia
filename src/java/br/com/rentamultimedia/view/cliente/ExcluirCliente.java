package br.com.rentamultimedia.view.cliente;

import br.com.rentamultimedia.dao.ClienteJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ExcluirCliente", urlPatterns = {"/ExcluirCliente.do"})
public class ExcluirCliente extends HttpServlet {
    private Factory factory;
    private ClienteJpaController cjc;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Excluir Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ExcluirCliente at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            cjc=new ClienteJpaController(factory.getFactory());
            try {
                cjc.destroy(Integer.parseInt(request.getParameter("CodCliente")));
                out.println("<script>");
                out.println("alert(\"cliente excluido\");");
                out.println("window.location.href = \"excluircliente.jsp\";");
                out.println("</script>");
            } catch (RollbackFailureException ex) {
                Logger.getLogger(ExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(ExcluirCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
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
