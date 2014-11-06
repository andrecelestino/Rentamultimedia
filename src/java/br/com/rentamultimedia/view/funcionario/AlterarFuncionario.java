package br.com.rentamultimedia.view.funcionario;

import br.com.rentamultimedia.dao.FuncionarioJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.dao.exception.RollbackFailureException;
import br.com.rentamultimedia.entidade.Funcionario;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "AlterarFuncionario", urlPatterns = {"/AlterarFuncionario.do"})
public class AlterarFuncionario extends HttpServlet {
    private Funcionario f;
    private Factory factory;
    private FuncionarioJpaController fjc;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Alterar Funcionario</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet AlterarFuncionario at " + request.getContextPath() + "</h1>");
            f=new Funcionario();
            f.setCodFunc(Integer.parseInt(request.getParameter("CodFunc")));
            f.setNomFunc(request.getParameter("NomFunc"));
            f.setCPFFuncionario(Long.parseLong(request.getParameter("CPFFuncionario")));
            f.setTelFuncionario(Long.parseLong(request.getParameter("TelFuncionario")));
            f.setRGFuncionario(request.getParameter("RGFuncionario"));
            f.setIdadeFunc(Integer.parseInt(request.getParameter("IdadeFunc")));
            f.setLoginFunc(request.getParameter("LoginFunc"));
            f.setSenhaFunc(request.getParameter("SenhaFunc"));
            f.setPerfilFunc(Integer.parseInt(request.getParameter("PerfilFunc")));
            
            factory = new Factory();
            FuncionarioJpaController fjc = new FuncionarioJpaController(factory.getFactory());
            try {
                fjc.edit(f);
            } catch (RollbackFailureException ex) {
                Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            } catch (Exception ex) {
                Logger.getLogger(AlterarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<script>");
            out.println("alert(\"Funcionario "+f.getCodFunc()+" Alterado\");");
            out.println("window.location.href = \"alterarfuncionario.jsp\";");
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
