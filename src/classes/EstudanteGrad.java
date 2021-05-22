package classes;

public class EstudanteGrad extends Estudante {
    private int horascomplementares;

    public int getHorascomplementares() {
        return horascomplementares;
    }

    public void setHorascomplementares(int horascomplementares) {
        this.horascomplementares = horascomplementares;
    }


    public EstudanteGrad(int id, String nome, String email, int hrsc) {
        super(id, nome, email);
        this.horascomplementares = hrsc;
    }

    @Override
    public  int getTotalCreditos(){
        return  super.getTotalCreditos()+getHorascomplementares();
    }

    @Override
    public String toString(){
        return super.toString()+ " Creditos: "+ super.getTotalCreditos() + " Horas complementares: "+getHorascomplementares() ;
    }


}
