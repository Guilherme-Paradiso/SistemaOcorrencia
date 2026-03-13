
package com.escola.ocorrencias.model;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Ocorrencia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate data;
    private String local;
    private String descricao;
    private String infoAdicional;

    @ManyToOne
    private Professor professor;

    @ManyToOne
    private Estudante estudante;

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public LocalDate getData(){return data;}
    public void setData(LocalDate data){this.data=data;}
    public String getLocal(){return local;}
    public void setLocal(String local){this.local=local;}
    public String getDescricao(){return descricao;}
    public void setDescricao(String d){this.descricao=d;}
    public String getInfoAdicional(){return infoAdicional;}
    public void setInfoAdicional(String i){this.infoAdicional=i;}
    public Professor getProfessor(){return professor;}
    public void setProfessor(Professor p){this.professor=p;}
    public Estudante getEstudante(){return estudante;}
    public void setEstudante(Estudante e){this.estudante=e;}
}
