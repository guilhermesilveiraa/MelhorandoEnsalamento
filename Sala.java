import java.util.HashSet;
import java.util.Random;
import java.util.Set;

class Sala{
    int bloco;
    int sala;
    int capacidade;
    boolean acessivel;

    Sala(){
        sala = 101; bloco = 6; capacidade = 50; acessivel = true; 
    }

    Sala(int bloco, int sala, int capacidade, boolean acessivel){
        this.bloco = bloco; this.sala = sala;
        this.capacidade = capacidade; this.acessivel = acessivel;
    }

    String getAcessibilidade(){
        String z;
        if(acessivel){
            z = "acessível";
        }
        else{
            z = "não acessível";
        }
        return z;
    }

    String getDescricao(){
        String z;
        z = "Bloco "+bloco+", Sala "+sala+" ("+capacidade+" lugares, "+getAcessibilidade()+")";
        return z;
    }

    public static Sala criarSalaAleatoria(int numeroSalas, int numeroBlocos, int[] capacidades) {
        Random random = new Random();

        Set<Integer> salasGeradas = new HashSet<>();
        Set<Integer> blocosGerados = new HashSet<>();

        int salaAleatoria;
        int blocoAleatorio;

        do {
            salaAleatoria = random.nextInt(numeroSalas) + 1;
        } while (!salasGeradas.add(salaAleatoria));

        do {
            blocoAleatorio = random.nextInt(numeroBlocos) + 1;
        } while (!blocosGerados.add(blocoAleatorio));

        int capacidadeAleatoria = capacidades[random.nextInt(capacidades.length)];
        boolean acessivelAleatoria = random.nextBoolean();

        return new Sala(blocoAleatorio, salaAleatoria, capacidadeAleatoria, acessivelAleatoria);
    }
}
