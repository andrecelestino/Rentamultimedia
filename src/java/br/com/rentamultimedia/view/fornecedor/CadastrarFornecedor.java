package br.com.rentamultimedia.view.fornecedor;

import br.com.rentamultimedia.dao.FornecedorJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Fornecedor;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarFornecedor", urlPatterns = {"/CadastrarFornecedor.do"})
public class CadastrarFornecedor extends HttpServlet {
    private Fornecedor f;
    private Factory factory;
    private FornecedorJpaController fjc;
    private BigInteger inscriestadforn = BigInteger.valueOf(0);
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastrar Fornecedor</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet CadastrarFornecedor at " + request.getContextPath() + "</h1>");
            f=new Fornecedor();
            f.setRazaoForn(request.getParameter("RazaoForn"));
            f.setCNPJForn(request.getParameter("CNPJForn"));
            f.setTelForn(Long.parseLong(request.getParameter("TelForn")));
            f.setEndForn(request.getParameter("EndForn"));
            inscriestadforn = inscriestadforn.add(new BigInteger(request.getParameter("InscriEstadForn")));
            f.setInscriEstadForn(inscriestadforn);
            factory=new Factory();
            fjc=new FornecedorJpaController(factory.getFactory());
            try {
                fjc.create(f);
            } catch (Exception ex) {
                Logger.getLogger(CadastrarFornecedor.class.getName()).log(Level.SEVERE, null, ex);
            }
            out.println("<script>");
            out.println("alert(\"Fornecedor Cadastrado com o Numero "+f.getCodForn()+"\");");
            out.println("window.location.href = \"cadastrarfornecedor.jsp\";");
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
