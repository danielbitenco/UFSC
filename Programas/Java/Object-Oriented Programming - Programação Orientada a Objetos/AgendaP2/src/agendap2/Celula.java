/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agendap2;

/**
 *
 * @author Daniel
 */
public class Celula {
    
    private String nome;
    //private String telefone;
   // private String endereco;
    private int id;
    private Celula proximaCelula;
    
    public Celula(int id, Celula proxC, String nome){
        setId(id);
        setNome(nome);
        setProximaCelula(proxC);
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

//    /**
//     * @return the telefone
//     */
//    public String getTelefone() {
//        return telefone;
//    }

//    /**
//     * @param telefone the telefone to set
//     */
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    /**
//     * @return the endereco
//     */
//    public String getEndereco() {
//        return endereco;
//    }
//
//    /**
//     * @param endereco the endereco to set
//     */
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the proximaCelula
     */
    public Celula getProximaCelula() {
        return proximaCelula;
    }

    /**
     * @param proximaCelula the proximaCelula to set
     */
    public void setProximaCelula(Celula proximaCelula) {
        this.proximaCelula = proximaCelula;
    }
    
    


}
