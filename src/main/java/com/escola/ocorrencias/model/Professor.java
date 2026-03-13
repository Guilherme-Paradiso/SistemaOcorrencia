
package com.escola.ocorrencias.model;
import jakarta.persistence.*;
import java.util.List;

@Entity
public class Professor {

    @Id
    private String codigo;

    private String nome;
    private String curso;
    private String materiaLecionada;

    @OneToMany(mappedBy="professor", cascade=CascadeType.REMOVE)
    private List<Ocorrencia> ocorrencias;

    public String getCodigo(){return codigo;}
    public void setCodigo(String codigo){this.codigo=codigo;}

    public String getNome(){return nome;}
    public void setNome(String nome){this.nome=nome;}

    public String getCurso(){return curso;}
    public void setCurso(String curso){this.curso=curso;}

    public String getMateriaLecionada(){return materiaLecionada;}
    public void setMateriaLecionada(String materia){this.materiaLecionada=materia;}
}
