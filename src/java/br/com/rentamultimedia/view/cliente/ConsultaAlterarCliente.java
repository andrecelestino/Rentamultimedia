package br.com.rentamultimedia.view.cliente;

import br.com.rentamultimedia.dao.ClienteJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultaAlterarCliente", urlPatterns = {"/ConsultaAlterarCliente.do"})
public class ConsultaAlterarCliente extends HttpServlet {
    private Factory factory;
    private ClienteJpaController cjc;
    private Cliente c;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta Alterar Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ConsultaAlterarCliente at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            cjc=new ClienteJpaController(factory.getFactory());
            c=cjc.findCliente(Integer.parseInt(request.getParameter("CodCliente")));
            if(c!=null){
            request.setAttribute("cliente", c);
            request.getRequestDispatcher("alterarcliente.jsp").forward(request, response);
            }else{
                out.println("<script>");
                out.println("alert(\"Cliente nao encontrado\");");
                out.println("window.location.href = \"alterarcliente.jsp\";");
                out.println("</script>");
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
