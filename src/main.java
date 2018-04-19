import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *  
 * @author aline
 */
public class main {
    public static Scanner input = new Scanner(System.in);;
    public static List<Processo> listaProcessos = new ArrayList<Processo>();
    
    public static void main(String[] args) {
        String txt = FileManager.readFromFile("entrada.txt");
        String[] split = txt.split("\n");
        String linha;
        int duracaoProcesso, tempoChegada;
        int id=0;
        for(int count = 0 ; count<split.length; count++){
            linha = (String) split[count];
            
            tempoChegada = Integer.parseInt(linha.split(" ")[0]);
            duracaoProcesso = Integer.parseInt(linha.split(" ")[1]);
            listaProcessos.add(new Processo(++id, (tempoChegada), (duracaoProcesso)));
        }
		
        FCFS fcfs = new FCFS(listaProcessos);
        SJF sjf = new SJF(listaProcessos);
        RR rr = new RR(listaProcessos);
        fcfs.printMetricas();
        sjf.printMetricas();
        rr.printMetricas();
	}

}