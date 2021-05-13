package classes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Disciplina {
    private String codigo;
    private int creditos;
    private ArrayList<Matricula> matriculas = new ArrayList<Matricula>();

    public Disciplina(String codigo, int creditos) {
        this.codigo = codigo;
        this.creditos = creditos;

    }

    // Métodos acessores
    public int getCreditos() {
        return creditos;
    }

    public void setCreditos(int creditos) {
        this.creditos = creditos;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public ArrayList<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setMatriculas(ArrayList<Matricula> matriculas) {
        this.matriculas = matriculas;
    }


    // Métodos especiais da UML
    public void addMatricula(Matricula matricula) {
        matriculas.add(matricula);
    }

    public ArrayList<Estudante> getEstudantesMatriculados(){
        ArrayList<Estudante> estudantesMatriculados = new ArrayList<Estudante>();
        for(Matricula matricula: this.getMatriculas()){
            estudantesMatriculados.add(matricula.getEstudante());
        }
        return estudantesMatriculados;
    }
}
