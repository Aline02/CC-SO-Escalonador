

import java.util.ArrayList;
import java.util.List;


/**
 *  Escalonamento FCFS (First-Come, First Served)
 * 
 * ESCALONADOR NÃO-PREEMPTIVO
 *
 * A forma de escalonamento mais elementar consiste em simplesmente atender as
 * tarefas em sequência, à medida em que elas se tornam prontas (ou seja, conforme sua
 * ordem de chegada na fila de tarefas prontas)
 *
 * @author aline
 */
public class FCFS extends Escalonador {

    private static List<Processo> listaProntos;

    /**
     * - Tempo de retorno: quantidade necessária de tempo para executar um processo 
     * - Tempo de resposta: quantidade de tempo entre a requisição de execução de um programa e a produção da primeira resposta
     * - Tempo de espera: quantidade de tempo que um processo aguardou na fila de prontos
     * @param processos Lista contendo os processos
     */
    
    public FCFS(List<Processo> processos) {
        try {
            listaProntos = new ArrayList<Processo>(processos);
            int tempoRetorno = 0, tempoResposta = 0, tempoEspera = 0;
            int totalProcessos = processos.size();
            //tempo de entrada dos processos
            int retorno = tempoChegadaMinimo(processos);
 
            // loop enquanto existir processos na fila de prontos
            while (!listaProntos.isEmpty()) {
                Processo p = listaProntos.remove(0); // obtem o primeiro processo da fila e remove
                retorno += p.getDuracao();
                tempoRetorno += (retorno - p.getTempoChegada());
                tempoEspera += (retorno - p.getTempoChegada() - p.getDuracao()); // TEP = (REP - CHP - TAM)
            }
            tempoResposta = tempoEspera; // Para o FCFS o tempo de resposta é igual ao tempo de espera

            // seta os tempos médios
            super.setRetornoMedio((double) tempoRetorno / totalProcessos);
            super.setRespostaMedio((double) tempoResposta / totalProcessos);
            super.setEsperaMedio((double) tempoEspera / totalProcessos);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    /**
     * Imprime as métricas
     */
    public void printMetricas() {
        super.printMetricas("FCFS");
    }
}