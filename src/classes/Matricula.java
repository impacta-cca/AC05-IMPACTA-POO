package classes;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Matricula {

    private Estudante estudante;
    private Disciplina disciplina;


    public Matricula(Estudante estudante, Disciplina disciplina) {
        this.estudante = estudante;
        this.disciplina = disciplina;
    }

    public Estudante getEstudante() {
        return estudante;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setEstudante(Estudante estudante) {
        this.estudante = estudante;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
    }


    @Override
    public String toString(){
        return "Codigo Estudante: "+estudante.getNome()+" Codigo disciplina: " + disciplina.getCodigo();
    }
}
