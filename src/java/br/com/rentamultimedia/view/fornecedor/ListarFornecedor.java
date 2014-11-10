package br.com.rentamultimedia.view.fornecedor;

import br.com.rentamultimedia.dao.FornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ListarFornecedor", urlPatterns = {"/ListarFornecedor.do"})
public class ListarFornecedor extends HttpServlet {
    private Factory factory;
    private FornecedorJpaController fjc;
    private List<Fornecedor> listaf;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Listar Fornecedor</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ListarFornecedor at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            fjc=new FornecedorJpaController(factory.getFactory());
            listaf=fjc.findFornecedorEntities();
            if(listaf.isEmpty()){
                out.println("<script>");
                out.println("alert('nao ha fornecedor cadastrado')");
                out.println("window.location.href = \"listarfornecedor.jsp\";");
                out.println("</script>");
            }else{
                request.setAttribute("listaf", listaf);
                request.getRequestDispatcher("listarfornecedor.jsp").forward(request, response);
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
