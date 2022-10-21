import java.util.Random;

public class AlgoritmoGenetico {

    public Population buildfirstPopulation(int Quantity,double LimiteMin, double LimiteMax){
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
    
  

    public Individuo selectionTournament(Population population){
        Individuo individuo1, individuo2, individuo3, maiorIndividuo;
        Random random  = new Random();
        int tam = population.population.size();
        individuo1 = population.population.get(random.nextInt(tam));
        individuo2 = population.population.get(random.nextInt(tam));
        individuo3 = population.population.get(random.nextInt(tam));
        if(individuo1.getSolution()>=individuo2.getSolution()){
            maiorIndividuo = individuo1;
        }else{
            maiorIndividuo = individuo2;
        }
        if(maiorIndividuo.getSolution()<=individuo3.getSolution()){
            maiorIndividuo = individuo3;
        }
        return maiorIndividuo;
    }

    public Individuo mutationIndividuo(Individuo individuo,double LimiteMin, double LimiteMax){
        Random radom  = new Random();
        Object random;
        individuo.setX1(random.nextDouble(LimiteMin,LimiteMax));
        individuo.setX2(random.nextDouble(LimiteMin,LimiteMax));
        return individuo;
    }

}
