package classes;

import java.util.ArrayList;
import java.util.Scanner;

public class GestaoAcademicaAppV2 {
    public static void main(String[] args) {
        menu();
    }
    // Interface Principal
    public static void menu(){
        Faculdade faculdade = new Faculdade("FIT - Impacta");
        faculdade.carregarDadosArquivo("disciplinas.txt","estudantes.txt","matriculas.txt");
        while(true) {
            System.out.println("\n==============MENU PRINCIPAL===============");
            Scanner input = new Scanner(System.in);
            System.out.println("Digite a opção desejada:\n" +
                    "[1] Listar os números e nomes de todos os estudantes.\n" +
                    "[2] Listar os códigos de todas as disciplinas.\n" +
                    "[3] Listar todas as informações dos estudantes matriculados em uma determinada disciplina.\n" +
                    "[4] Listar todas as informações das disciplinas em que um determinado estudante está matriculado.\n" +
                    "[0] Sair.\n");

            int escolha = input.nextInt();
            switch (escolha) {
                case 0:
                    System.out.println("==========PROGRAMA FINALIZADO===============");
                    System.exit(-1);
                case 1:
                    //Listar os números e nomes de todos os estudantes.
                    listaNomeEstudantes(faculdade.getEstudantes());
                    break;
                case 2:
                    //Listar os códigos de todas as disciplinas.
                    listaCodigosDiscip(faculdade.getDisciplinas());
                    break;
                case 3:
                    //Listar todas as informações dos estudantes matriculados em uma determinada disciplina.
                    listaEstudanteDisciplina(faculdade.getDisciplinas());
                    break;
                case 4:
                    listaInfoDisciplinas(faculdade.getEstudantes());
                    //Listar todas as informações das disciplinas em que um determinado estudante está
                    //matriculado.
                    break;
            }
        }
    }

    //Listar os números = id () e nomes(ok) de todos os estudantes.
    public static void listaNomeEstudantes(ArrayList<Estudante> Estudantes){
        System.out.println("==========LISTA DE ALUNOS==============");
        for (Estudante aluno : Estudantes){

            System.out.println(aluno.toString());//imprimir id tbm (getId)
        }
    }

    // Listar os códigos de todas as disciplinas.
    public static void listaCodigosDiscip(ArrayList<Disciplina> disciplinas){
        System.out.println("==========LISTA DE CÓDIGOS DE DISCIPLINAS==========");
        for (Disciplina codigo : disciplinas) {
            System.out.println(codigo.getCodigo());
        }
    }

    /*  Listar todas as informações dos estudantes matriculados em uma determinada disciplina.
     *   Nesta opção, o usuário deverá fornecer o código da disciplina e a aplicação deverá
     *   apresentar uma -lista dos estudantes matriculados nesta disciplina (com o número
     *   identificado, o nome e o e-mail do aluno) e o -número total de alunos matriculados nesta
     *   disciplina.
     */

    public static void listaEstudanteDisciplina(ArrayList<Disciplina> Disciplinas){
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o código da disciplina: ");
        String codigo = in.nextLine();
        Disciplina disciplinescolhida = new Disciplina(null,0);
        for(Disciplina disciplina : Disciplinas){
            if(disciplina.getCodigo().equals(codigo)){
                disciplinescolhida = disciplina;
            }
        }
        ArrayList<Estudante> estudantes = disciplinescolhida.getEstudantesMatriculados();
        //identificar de qual disc é o cód digitado, a partir disso get estudantes(all info) matriculados(numa lista)
        System.out.println("\n==========LISTA DE ALUNOS MATRICULADOS NESSA DISCIPLINA==============");
        for(Estudante estudante : estudantes){
            if(estudante instanceof EstudantePos) {
                System.out.println("ID: " + estudante.getId() + "\tNome: " + estudante.getNome() + "\te-mail: " + estudante.getEmail()+ " tema: "+((EstudantePos) estudante).getTema()+" Orientador: "+((EstudantePos) estudante).getOrientador()+
                        " total de creditos: "+estudante.getTotalCreditos());
            }
            else if(estudante instanceof EstudanteGrad){
                System.out.println("ID: " + estudante.getId() + "\tNome: " + estudante.getNome() + "\te-mail: " + estudante.getEmail()+ " horas complementares: "+((EstudanteGrad) estudante).getHorascomplementares() +
                        " total de creditos: "+((EstudanteGrad) estudante).getTotalCreditos() );
            }
        }
        System.out.println("==========TOTAL DE ALUNOS MATRICULADOS NESSA DISCIPLINA==============");
        System.out.println("Quantidade: " + estudantes.size());
    }

        /*
        Listar todas as informações das disciplinas em que um determinado estudante está
        matriculado. Nesta opção, o usuário deverá fornecer o número identificador do estudante
        e a aplicação deverá apresentar uma uma lista das disciplinas em que ele está matriculado (com
        o código e número de créditos da disciplina) e o total de créditos das matrículas do aluno.
        */

    public static void listaInfoDisciplinas(ArrayList<Estudante> Estudantes){
        Scanner in = new Scanner(System.in);
        System.out.print("Digite o ID do Aluno: ");
        String verificar = in.nextLine();
        while(!verificar(verificar)) {
            System.out.print("Digite o ID do Aluno: ");
            verificar = in.nextLine();
            verificar(verificar);
        }
        long codigo = Long.parseLong(verificar);
        Estudante find = null;
        System.out.print("\n==========LISTA DE DISCIPLINAS==========");
        for ( Estudante aluno : Estudantes) {
            if (aluno.getId() == codigo) {
                if(aluno instanceof EstudanteGrad) {
                    find = new EstudanteGrad(0, null, null, 0);
                    find = aluno;
                }
                else if(aluno instanceof EstudantePos){
                    find = new EstudantePos(0,null,null,null,null);
                    find = aluno;
                }

            }
        }
        // lista das disciplinas em que ele está matriculado
        ArrayList<Disciplina> listaDisc = find.getDisciplinasMatriculadas();
        for ( Disciplina disciplina : listaDisc) {
            // o código
            System.out.print("\nCodigo disciplina: " + disciplina.getCodigo()+", Creditos em horas da disciplinas: "+ disciplina.getCreditos());
            // número de créditos da disciplina
        }
        // total de créditos das matrículas do aluno.
        int total = 0;
        for ( Disciplina creditos  : listaDisc ) {
            total += creditos.getCreditos();
        }
        System.out.println("\nTotal da soma dos créditos: " + total);
    }


    public static boolean verificar(String entrada){
        boolean saida;
        try {
            Long.parseLong(entrada);
            saida = true;
        } catch (Exception e) {
            System.out.println("\nID Invalido, tente novamente.");
            saida = false;
        }
        return saida;
    }
}
