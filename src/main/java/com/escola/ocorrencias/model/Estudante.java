
package com.escola.ocorrencias.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Estudante {

    @Id
    private String matricula;

    private String nome;
    private String curso;
    private int anoEntrada;

    @OneToMany(mappedBy="estudante", cascade=CascadeType.REMOVE)
    private List<Ocorrencia> ocorrencias;

    public String getMatricula(){return matricula;}
    public void setMatricula(String m){this.matricula=m;}
    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}
    public String getCurso(){return curso;}
    public void setCurso(String curso){this.curso=curso;}
    public int getAnoEntrada(){return anoEntrada;}
    public void setAnoEntrada(int ano){this.anoEntrada=ano;}
}
