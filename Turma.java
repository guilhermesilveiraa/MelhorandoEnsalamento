import java.util.ArrayList;
import java.util.Random;

public class Turma {
    String nome;
    String professor;
    int numAlunos;
    boolean acessivel;
    ArrayList<Integer> horarios;

    Turma(){
        nome ="Algoritmos e Estrutura de Dados I";
        professor = "Edleno Silva";
        numAlunos = 60; acessivel = true;
        horarios = new ArrayList<Integer>();
        addHorario(1); addHorario(15); addHorario(29);
    }
    Turma(String nome, String professor, int numAlunos, boolean acessivel){
        this.nome = nome; this.professor = professor; this.numAlunos = numAlunos;
        this.acessivel = acessivel;  horarios = new ArrayList<Integer>();
    }

    

    void addHorario(int horario){
        horarios.add(horario);
    }
    String getAcessibilidade(){
        String z;
        if(acessivel == true){
            z = "sim";
        }
        else{z="não";}
        return z;
    }

    String getHorariosString(){
        String z ="";
        if(horarios != null){
            for(Integer hora:horarios){
                int horaCorreta = 8;
                if(hora<=7){
                    int i = 7;
                    while(horaCorreta-i!=hora){
                        horaCorreta +=2;
                        i++;
                    }
                    z += "segunda "+horaCorreta+"hs";
                }
                else if(hora<=14){
                    int i = 0;
                    while(horaCorreta-i!=hora){
                        horaCorreta += 2;
                        i++;
                    }
                    z += "terça "+horaCorreta+"hs";
                }
                else if(hora<=21){
                    int i = 7;
                    while(horaCorreta+i!=hora){
                        horaCorreta += 2;
                        i--;
                    }
                    z += "quarta "+horaCorreta+"hs";
                }
                else if(hora<=28){
                    int i = 14;
                    while(horaCorreta+i!=hora){
                        i--;
                        horaCorreta+=2;
                    }
                    z += "quinta "+horaCorreta+"hs";
                }
                else{
                    int i = 21;
                    while(horaCorreta+i!=hora){
                        i--;
                        horaCorreta+=2;
                    }
                    z += "sexta "+horaCorreta+"hs";
                }
                z+=", ";
            }
            z = z.substring(0, z.length() - 1);
            z = z.substring(0, z.length() - 1);
            return z;
        }
        else{return "nao ha nada";}
    }

    String getDescricao(){
        String s;
        s = "Turma: "+nome+"\n"+
        "Professor: "+professor+"\n"+
        "Número de Alunos: "+numAlunos+"\n"+
        "Horário: "+ getHorariosString()+"\n"+
        "Acessível: "+getAcessibilidade()+"\n";

        return s;
    }

    public static ArrayList<Turma> criaTurmas(int numeroDeTurmasACriar) {
        ArrayList<Turma> turmas = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numeroDeTurmasACriar; i++) {
            String nomeAleatorio = "Turma" + (i + 1);
            String professorAleatorio = "Professor" + (i + 1);
            int numAlunosAleatorio = random.nextInt(50) + 20; 
            boolean acessivelAleatorio = random.nextBoolean();

            Turma turma = new Turma(nomeAleatorio, professorAleatorio, numAlunosAleatorio, acessivelAleatorio);

            for (int j = 0; j < 3; j++) {
                turma.addHorario(random.nextInt(30) + 1);
            }

            turmas.add(turma);
        }

        return turmas;
    }
    

}

