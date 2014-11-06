package br.com.rentamultimedia.view.cliente;

import br.com.rentamultimedia.dao.ClienteJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarCliente", urlPatterns = {"/ListarCliente.do"})
public class ListarCliente extends HttpServlet {
    private Factory factory;
    private ClienteJpaController cjc;
    private List<Cliente> listac;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Cliente</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ListarCliente at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            cjc=new ClienteJpaController(factory.getFactory());
            listac=cjc.findClienteEntities();
            if(listac.isEmpty()){
                out.println("<script>");
                out.println("alert(\"nao ha cliente cadastrado\");");
                out.println("window.location.href = \"listarcliente.jsp\";");
                out.println("</script>");
            }else{
            request.setAttribute("listac", listac);
            request.getRequestDispatcher("listarcliente.jsp").forward(request, response);
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
