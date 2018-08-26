/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package listacontatosjdbc;

import java.sql.Date;

/**
 *
 * @author SAMUEL
 */
public class Contato {
    private int id;
    private String nome;
    private String email;
    private String endereco;
    private String dataNascimento;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    
    
    public Contato() {
    
    }

    public Contato(int id, String nome, String email, String endereco, String dataNascimento) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
        this.dataNascimento = dataNascimento;
    }
    
    
}
