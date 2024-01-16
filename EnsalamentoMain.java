import java.util.*;

public class EnsalamentoMain {
    public static void main(String[] args) {
        for (int teste = 1; teste <= 10; teste++) {
            Ensalamento ensalamento = new Ensalamento();
            EnsalamentoMelhorias ensalamentoMelhorias = new EnsalamentoMelhorias();
            // Criar salas aleatórias e adicionar ao ensalamento
            int[] capacidades = {20, 30, 50, 60};
            for (int i = 0; i < 50; i++) {
                Sala salaAleatoria = Sala.criarSalaAleatoria(100, 4, capacidades);
                ensalamento.addSala(salaAleatoria);
                ensalamentoMelhorias.addSala(salaAleatoria);
               // System.out.println("Sala criada: " + salaAleatoria.getDescricao());
            }

            // Criar turmas aleatórias e adicionar ao ensalamento
            ArrayList<Turma> turmasCriadas = Turma.criaTurmas(50);
            for (Turma turma : turmasCriadas) {
                ensalamento.addTurma(turma);
                ensalamentoMelhorias.addTurma(turma);
                //System.out.println("Turma criada: \n" + turma.getDescricao() + "\n");
            }

            ensalamento.alocarTodas();
            ensalamentoMelhorias.alocarTodas();

            System.out.println("Relatório Resumo do Ensalamento para o Teste Sem melhorias " + teste + ":");
            System.out.println(ensalamento.relatorioResumoEnsalamento());
            

            System.out.println("\n---------------------------------------------\n");

            System.out.println("Relatório Resumo do Ensalamento para o Teste com melhorias " + teste + ":");
            System.out.println(ensalamentoMelhorias.relatorioResumoEnsalamento());

            System.out.println("\n---------------------------------------------\n");


            
        }




    }
}
