package classes;

public class EstudantePos extends Estudante{



    private String Tema;
    private  String Orientador;


    public String getTema() {
        return Tema;
    }

    public void setTema(String tema) {
        Tema = tema;
    }

    public String getOrientador() {
        return Orientador;
    }

    public void setOrientador(String orientador) {
        Orientador = orientador;
    }



    public EstudantePos(int id, String nome, String email,String tema, String orientador) {
        super(id, nome, email);
        this.Tema = tema;
        this.Orientador=orientador;

    }

    public  int getTotalCreditos(){
        return super.getTotalCreditos();
    }

    public String toString(){
        return super.toString()+" tema: "+getTema()+" orientador: "+getOrientador();
    }

}
