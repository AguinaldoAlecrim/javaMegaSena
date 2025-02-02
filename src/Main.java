import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

import model.Jogo;

public class Main {
    public static void main(String[] args) throws IOException {
        int numeroDaSorte;
        int quantidadeApostas;
        if (args.length > 0){            
            numeroDaSorte = Integer.valueOf(args[0]);
            quantidadeApostas = Integer.valueOf(args[1]);             
        } else {
            numeroDaSorte = 120;
            quantidadeApostas = 100;        
        }
        
        Jogo jg = new Jogo(numeroDaSorte, quantidadeApostas);
        
        Set<List<Integer>> asApostas = jg.getApostas();            
        
        File arquivo = new File("apostas.txt");
        BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo));
       
        writer.write("["); 
        writer.newLine();            

        List<List<Integer>> convert = new ArrayList<>(asApostas);
        for (int i = 0; i < convert.size(); i++) {
            List<Integer> atual = convert.get(i);
            if (i == convert.size() - 1){
                writer.write("    " + atual.toString());
                writer.newLine();
            } else {
                writer.write("    " + atual.toString() + ",");
                writer.newLine();
            }
            
        }        
        writer.write("]");
        writer.close();


    }
}
