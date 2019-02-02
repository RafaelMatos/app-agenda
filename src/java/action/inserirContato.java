
package action;

import dao.FabricaConexao;
import dao.JDBCContatoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Contato;


@WebServlet(name = "inserirContato", urlPatterns = {"/inserirContato"})
public class inserirContato extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
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
        
        System.out.println("Servelt doPost funcionando!");
        
        String nome = request.getParameter("nome");
        String telefone = request.getParameter("tel");
        String celular = request.getParameter("cel");
        String email = request.getParameter("email");
        
        Contato novoContato = new Contato();
        novoContato.setNome(nome);
        novoContato.setTelefone(telefone);
        novoContato.setCelular(celular);
        novoContato.setEmail(email);
        
        FabricaConexao fabrica = new FabricaConexao();
        Connection conexao = fabrica.criarConexao();
        JDBCContatoDAO dao = new JDBCContatoDAO(conexao);
        
        dao.inserir(novoContato);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
