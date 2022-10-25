import java.util.Random;

public class AlgoritmoGenetico {

    public static void main(String[] args) {
        System.out.println("Insira o va");
    }

    public Population buildfirstPopulation(int Quantity,int LimiteMin, int LimiteMax){
        int i,x1,x2;
        Random random = new Random();
        Population population = new Population();
        for(i = 0;i<=Quantity;i++){
            x1 = random.nextInt(LimiteMax - LimiteMin) + LimiteMin;
            x2 = random.nextInt(LimiteMax - LimiteMin) + LimiteMin;
            Individual individual = new Individual(x1, x2);
            population.addIndividual(individual);
        }
        return population;
    }
    
    
    public Individual selectionTournament(Population population){
        Individual individual1, individual2, individual3, bestIndividual;
        Random random  = new Random();
        int tam = population.population.size();
        individual1 = population.population.get(random.nextInt(tam));
        individual2 = population.population.get(random.nextInt(tam));
        individual3 = population.population.get(random.nextInt(tam));
        if(individual1.getSolution()>=individual2.getSolution()){
            bestIndividual = individual1;
        }else{
            bestIndividual = individual2;
        }
        if(bestIndividual.getSolution()<=individual3.getSolution()){
            bestIndividual = individual3;
        }
        return bestIndividual;
    }

    public Individual[] crossoverIndividuals(Individual individual_1, Individual individual_2){
        Individual son_1 = new Individual(individual_1.getX1(), individual_2.getX2());
        Individual son_2 = new Individual(individual_2.getX1(), individual_1.getX2());
        Individual[]individuals = {son_1,son_2};
        return individuals;
    }

    public Individual mutationIndividual(Individual individual,int LimiteMin, int LimiteMax){
        Random random  = new Random();
        individual.setX1(random.nextInt(LimiteMax - LimiteMin) + LimiteMin);
        individual.setX2(random.nextInt(LimiteMax - LimiteMin) + LimiteMin);
        return individual;
    }



}
