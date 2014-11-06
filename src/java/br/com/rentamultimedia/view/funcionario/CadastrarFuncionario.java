package br.com.rentamultimedia.view.funcionario;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.com.rentamultimedia.entidade.Funcionario;
import br.com.rentamultimedia.dao.FuncionarioJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import java.util.logging.Level;
import java.util.logging.Logger;

@WebServlet(name = "CadastrarFuncionario", urlPatterns = {"/CadastrarFuncionario.do"})
public class CadastrarFuncionario extends HttpServlet{
    private Funcionario f;
    private Factory factory;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastrar Funcionario</title>");
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet CadastrarFuncionario at " + request.getContextPath() + "</h1>");
            f = new Funcionario();
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
                fjc.create(f);
            } catch (Exception ex) {
                Logger.getLogger(CadastrarFuncionario.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<script>");
            out.println("alert(\"Funcionario Cadastrado com o Numero "+f.getCodFunc()+"\");");
            out.println("window.location.href = \"cadastrarfuncionario.jsp\";");
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
