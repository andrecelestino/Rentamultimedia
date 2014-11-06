package br.com.rentamultimedia.view.fornecedor;

import br.com.rentamultimedia.dao.FornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ConsultaFornecedor", urlPatterns = {"/ConsultaFornecedor.do"})
public class ConsultaFornecedor extends HttpServlet {
    private Factory factory;
    private FornecedorJpaController fjc;
    private Fornecedor f;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Consulta Fornecedor</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet ConsultaFornecedor at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            fjc=new FornecedorJpaController(factory.getFactory());
            f=fjc.findFornecedor(Integer.parseInt(request.getParameter("CodForn")));
            if(f!=null){
                request.setAttribute("fornecedor", f);
                request.getRequestDispatcher("consultarfornecedor.jsp").forward(request, response);
            }else{
                out.println("<script>");
                out.println("alert(\"Fornecedor nao encontrado\");");
                out.println("window.location.href = \"consultarfornecedor.jsp\";");
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
