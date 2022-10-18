package Genetico;

import java.util.Random;

public class AlgoritmoGenetico {

    public Population buildPopulation(int Quantity,double LimiteMin, double LimiteMax){
        double i,x1,x2;
        Random random = new Random();
        Population population = new Population();
        for(i = 0;i<=Quantity;i++){
            x1 = random.nextDouble(LimiteMin,LimiteMax);
            x2 = random.nextDouble(LimiteMin,LimiteMax);
            Individuo individuo = new Individuo(x1, x2);
            population.addIndividuo(individuo);
        }
        return population;
    }
    
    public Individuo mutationIndividuo(Individuo individuo,double LimiteMin, double LimiteMax){
        Random radom  = new Random();
        individuo.setX1(random.nextDouble(LimiteMin,LimiteMax));
        individuo.setX2(random.nextDouble(LimiteMin,LimiteMax));
        return individuo;
    }

    public Individuo selectionTournament(Population population){
        Individuo individuo1, individuo2, maiorIndividuo;
        Random random  = new Random();
        int tam = population.population.size();
        individuo1 = population.population.get(random.nextInt(tam));
        individuo2 = population.population.get(random.nextInt(tam));
        if(individuo1.getSolution()>=individuo2.getSolution()){
            maiorIndividuo = individuo1;
        }else{
            maiorIndividuo = individuo2;
        }

        return maiorIndividuo;
    }

}
