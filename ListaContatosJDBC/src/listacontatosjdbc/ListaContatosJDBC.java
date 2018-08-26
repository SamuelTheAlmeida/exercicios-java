/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontatosjdbc;

import java.io.IOException;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author SAMUEL
 */
public class ListaContatosJDBC {
    static ContatoDAO contatoDAO = new ContatoDAO();
    
    public static void imprimeContatos() {
        List<Contato> contatos = contatoDAO.lista();
        for (Contato contato: contatos) {
            System.out.println("------------------");
            System.out.println("ID: " + contato.getId());
            System.out.println("Nome: " + contato.getNome());
            System.out.println("Email: " + contato.getEmail());
            System.out.println("Endereço: " + contato.getEndereco());
            System.out.println("Data Nascimento: " + contato.getDataNascimento());
        }       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {   
        imprimeContatos();
        Contato contato1 = new Contato();
        contato1.setNome("Joao da Silva");
        contato1.setEmail("joaodasilva@gmail.com");
        contato1.setEndereco("Rua dos Bobos 000");
        contato1.setDataNascimento("1980-04-26");
        System.out.println("Inserindo contato " + contato1.getNome());
        contatoDAO.insere(contato1);
        imprimeContatos();

        contato1.setId(1);
        System.out.println("Alterando contato id " + contato1.getId());
        contatoDAO.altera(contato1);
        imprimeContatos();
        
        System.out.println("Removendo contato id " + contato1.getId());
        contatoDAO.remove(contato1);
        imprimeContatos();
        
        
        
        
        
        
    }
    
}
