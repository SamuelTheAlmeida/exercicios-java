/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontatosjdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMUEL
 */
public class ContatoDAO {
    // altera o contato com base nos valores recebidos pelo id do contato
    public void altera(Contato contato) {
        Connection con = ConnectionFactory.getConnectionFactory().getConnection();
        String query = "UPDATE contatos SET nome = ?, email = ?, endereco = ?, dataNascimento = ? WHERE id = ?";
        
        PreparedStatement st;
        try {
            st = con.prepareStatement(query);
            st.setString(1, contato.getNome());
            st.setString(2, contato.getEmail());
            st.setString(3, contato.getEndereco());
            st.setString(4, contato.getDataNascimento());
            st.setInt(5, contato.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    // remove o contato com base no id recebido do contato
    public void remove(Contato contato) {
        Connection con = ConnectionFactory.getConnectionFactory().getConnection();
        String query = "DELETE FROM contatos WHERE id = ?";
        
        PreparedStatement st;
        try {
            st = con.prepareStatement(query);
            st.setInt(1, contato.getId());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }        
    }
    
    // retorna a lista de contatos
    public List<Contato> lista() {
        Connection con = ConnectionFactory.getConnectionFactory().getConnection();
        List<Contato> contatos = new ArrayList<Contato>();
        String query = "SELECT * FROM contatos";
        try {
            PreparedStatement st = con.prepareStatement(query);
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt(1);
                String nome = rs.getString(2);
                String email = rs.getString(3);
                String endereco = rs.getString(4);
                String dataNasc = rs.getString(5);
                Contato contato = new Contato(id, nome, email, endereco, dataNasc);
                contatos.add(contato);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return contatos;
    }
    
    // insere um contato com base no id recebido do contato
    public void insere(Contato contato) {

        Connection con = ConnectionFactory.getConnectionFactory().getConnection();
        String query = "INSERT INTO contatos(nome, email, endereco, dataNascimento) VALUES (?, ?, ?, ?)";
        PreparedStatement st;
        try {
            st = con.prepareStatement(query);
            st.setString(1, contato.getNome());
            st.setString(2, contato.getEmail());
            st.setString(3, contato.getEndereco());
            st.setString(4, contato.getDataNascimento());
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ContatoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
}
