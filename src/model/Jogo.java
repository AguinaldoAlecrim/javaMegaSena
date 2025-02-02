package model;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Jogo {    
    private Integer luckNumber;  
    private int qtdApostas;             
    private Set<List<Integer>> apostas = new LinkedHashSet<>();
    
    public int getQtdApostas() {
        return qtdApostas;
    }
    public Set<List<Integer>> getApostas() {
        return apostas;
    }


    public Integer getLuckNumber() {
        return luckNumber;
    }


    public Jogo(Integer luckNum, int qtdapostas) {
        if (luckNum == null) {
            throw new IllegalArgumentException("luckNum não pode ser nulo.");
        }
        if (luckNum <= 1) {
            throw new IllegalArgumentException("luckNum deve ser maior que 1.");
        }
        if (qtdapostas < 1) {
            throw new IllegalArgumentException("A quantidade de apostas deve ser maior que 1.");
        }
        this.luckNumber = luckNum;
        this.qtdApostas = qtdapostas;
        
        while (apostas.size() < this.qtdApostas){
            Set<List<Integer>> tempList = addUniqueSequences(apostas, luckNum);
            this.apostas.addAll(tempList);                  
        }
        

        List<List<Integer>> tempListAsList = new ArrayList<>(this.apostas);
        List<List<Integer>> slice = tempListAsList.subList(0, qtdapostas);
        System.out.println(slice.size());

        this.apostas.clear();
        this.apostas.addAll(slice);

    }

    
    /**
     * Generates and adds unique sequences of random numbers to the provided set.
     * Each sequence consists of 6 unique numbers ranging from 1 to 60.
     * The method ensures that no duplicate sequences are added to the set.
     *
     * @param unSet the set to which unique sequences will be added
     * @return the updated set containing the newly added unique sequences
     */
    public static Set<List<Integer>> addUniqueSequences(Set<List<Integer>> unSet, int luckN) {
        int luck = luckN;
        Random random; 

        while (true) {  
            random = new Random(luck);          
            List<Integer> randomNumbers = IntStream.rangeClosed(1, 60)
                                                   .boxed()
                                                   .collect(Collectors.toList());
            Collections.shuffle(randomNumbers, random);
            
            List<List<Integer>> sequences = IntStream.range(0, 10) // 60/6 = 10 grupos
                                                     .mapToObj(i -> randomNumbers.subList(i * 6, (i + 1) * 6))
                                                     .map(subList -> {                                                        
                                                        List<Integer> sortedSubList = new ArrayList<>(subList); 
                                                        Collections.sort(sortedSubList);
                                                        return sortedSubList;
                                                    })
                                                     .collect(Collectors.toList());

            boolean exists = sequences.stream().anyMatch(unSet::contains);

            if (!exists) {
                unSet.addAll(sequences);                
                return unSet;
            }
            luck++;
        }
    }
}
