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


    public EstudantePos(int id, String nome, String email,String orientador, String tema) {
        super(id, nome, email);
        this.Orientador=orientador;
        this.Tema = tema;
    }

    public  int getTotalCreditos(){
       return super.getTotalCreditos();
    }
}
