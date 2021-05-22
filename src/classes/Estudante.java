package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.IDN;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Estudante {
    private long id;
    private String nome;
    private String email;
    private ArrayList<Matricula> matricula = new ArrayList<Matricula>();

    // Métodos acessores e construtor

    public Estudante(int id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;

    }

    public long getId() {
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

    public ArrayList<Matricula> getMatriculas() {
        return this.matricula;
    }

    public void setMatricula(ArrayList<Matricula> matricula) {
        this.matricula = matricula;
    }

    // Métodos especiais
    public void addMatricula(Matricula matriculaadd){
        matricula.add(matriculaadd);
    }


    public ArrayList<Disciplina> getDisciplinasMatriculadas(){
        ArrayList<Disciplina> disciplinas = new ArrayList<Disciplina>();
        for(Matricula matricula: this.getMatriculas()){
            disciplinas.add(matricula.getDisciplina());
        }
        return disciplinas;

    }

    public  int getTotalCreditos(){
        int credhrs=0;
        for(Matricula matricula: getMatriculas()){
            credhrs+=matricula.getDisciplina().getCreditos();
        }
        return  credhrs;
    }



    @Override
    public String toString(){
        return "ID: "+getId()+" Nome: "+getNome() ;
    }
}
