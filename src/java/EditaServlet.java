/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(urlPatterns = {"/Editar"})
public class EditaServlet extends HttpServlet
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            equipamento equipamento = new equipamento();
            Long id = Long.parseLong(request.getParameter("id"));
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            ResultSet resultado = operacao.executeQuery("select * from equipamento where id = "+id);
            
            while(resultado.next())
            {
                equipamento.setId(resultado.getInt("id"));
                equipamento.setSerie(resultado.getString("serie"));
                equipamento.setEstado(resultado.getInt("estado"));
                equipamento.setLocal(resultado.getString("local"));
            }
            
            request.setAttribute("equipamentos", equipamento);
            request.getRequestDispatcher("editar.jsp").forward(request, response);
        }
        catch (ClassNotFoundException | SQLException ex)
        {
            Logger.getLogger(IniciarServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        Long id = Long.parseLong(request.getParameter("id"));

        try
        {
            
 
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection conexao = DriverManager.getConnection("jdbc:derby://localhost:1527/lppo-2017-1", "usuario", "senha");
            Statement operacao = conexao.createStatement();
            operacao.executeUpdate("UPDATE equipamento SET local='"+request.getParameter("local")+"',estado="+Integer.parseInt(request.getParameter("selecao"))+" WHERE id=" + id);

        }
        catch (SQLException | ClassNotFoundException ex)
        {
            Logger.getLogger(ExcluirServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        response.sendRedirect("Inicio");
    }
}
