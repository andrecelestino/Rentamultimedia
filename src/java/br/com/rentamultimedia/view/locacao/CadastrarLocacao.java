package br.com.rentamultimedia.view.locacao;

import br.com.rentamultimedia.dao.PedidolocacaoJpaController;
import br.com.rentamultimedia.dao.emf.Factory;
import br.com.rentamultimedia.entidade.Entrega;
import br.com.rentamultimedia.entidade.Nf;
import br.com.rentamultimedia.entidade.Pedidolocacao;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CadastrarLocacao", urlPatterns = {"/CadastrarLocacao.do"})
public class CadastrarLocacao extends HttpServlet {
    private Pedidolocacao pedidolocacao;
    private Nf nf;
    private Entrega entrega;
    private Factory factory;
    private PedidolocacaoJpaController pljc;
    private Date d;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Cadastrar Locacao</title>");            
            out.println("</head>");
            out.println("<body>");
            //out.println("<h1>Servlet CadastrarLocacao at " + request.getContextPath() + "</h1>");
            factory=new Factory();
            pljc=new PedidolocacaoJpaController(factory.getFactory());
            pedidolocacao=new Pedidolocacao();
            Date hoje = new Date();
            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
            pedidolocacao.setDataPedido(hoje);
            pedidolocacao.setCodClienteFK(Integer.parseInt(request.getParameter("CodClienteFK")));
            try {
                d=new SimpleDateFormat("yyyy-MM-dd").parse(request.getParameter("DataDevolucao"));                
            } catch (ParseException ex) {
                Logger.getLogger(CadastrarLocacao.class.getName()).log(Level.SEVERE, null, ex);
            }
            pedidolocacao.getDevolucao().setDataDevolucao(hoje);
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
