package Genetico;

import java.util.Random;

public class AlgoritmoGenetico {

    public Population buildPopulation(){
        
    }
    
    public Individuo MutacaoIndividuo(Individuo individuo){
        Random radom  = new Random();
        individuo.setX1(radom.nextDouble(10001));
        individuo.setX2(radom.nextDouble(10001));
        return individuo;
    } 

}
