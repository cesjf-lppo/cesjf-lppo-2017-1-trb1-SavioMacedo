/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author aluno
 */
@WebServlet(urlPatterns = {"/Cadastrar"})
public class CadastrarServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        request.getRequestDispatcher("cadastrar.jsp").forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {   
        try
        {
            String serie = request.getParameter("serie");
        String local = request.getParameter("local");
        int estado = Integer.parseInt(request.getParameter("selecao"));
        String descricao = request.getParameter("descricao");
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            String sql = "INSERT INTO equipamento(serie,local,descricao,estado) values ('"+serie+"','"+local+"','"+descricao+"',"+estado+")";
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate(sql);
          response.sendRedirect("Inicio");
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(CadastrarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

}
