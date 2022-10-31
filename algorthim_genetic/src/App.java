import java.util.Random;
import java.util.Scanner;

public class App {
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Population currentGeneration;
        int x, y, limiteMin, limiteMax, SizePopulation, QtdGerations,ProbabilityMutation;

        System.out.println("Insira o valor minimo que o parametro da função pode possuir: ");
        limiteMin = in.nextInt();
        System.out.println("Insira o valor maximo que o parametro da função pode possuir: ");
        limiteMax = in.nextInt();
        System.out.println("Insira a quantidade par de individuos da população: ");
        SizePopulation = in.nextInt();
        while (SizePopulation % 2 != 0) {
            System.out.println("Insira uma quantidade par de individuos da população: ");
            SizePopulation = in.nextInt();
        }
        System.out.println("Insira a quantidade de gerações que serão criadas: ");
        QtdGerations = in.nextInt();
        System.out.println("Insira a o valor da probabilidade de ocorrer uma mutação: ");
        ProbabilityMutation = in.nextInt();
        
        //Criação da primeira geração de individuos
        currentGeneration = buildfirstPopulation(SizePopulation, limiteMin, limiteMax);

        System.out.print("Geração Nº 1 - ");
        Individual bestSolutionIndividual1 = currentGeneration.findIndividual(0);
        System.out.print("Melhor Solução: "+bestSolutionIndividual1.getSolution());
        System.out.println();
        
        for (x = 1; x < QtdGerations; x++) {
            Population NewGeneration = new Population(SizePopulation);

            // Elitismo: Os dois melhores individuos são os primeiros da nova população
            Individual firstIndividual = currentGeneration.findIndividual(0);
            Individual secondIndividual = currentGeneration.findIndividual(1);
            NewGeneration.addIndividual(firstIndividual);
            NewGeneration.addIndividual(secondIndividual);

            for (y = 2; y < SizePopulation; y = y + 2) {

                Individual parent_1 = selectionTournament(currentGeneration);
                Individual parent_2 = selectionTournament(currentGeneration);
    
                Individual[] sonsIndividuals = crossoverIndividuals(parent_1, parent_2);

                Individual son_1 = sonsIndividuals[0];
                Individual son_2 = sonsIndividuals[1];

                Random probability = new Random();
            
                if(probability.nextInt(101)<=ProbabilityMutation){
                    son_1 = mutationIndividual(son_1, limiteMin, limiteMax);
                    son_2 = mutationIndividual(son_2, limiteMin, limiteMax);
                }

                NewGeneration.addIndividual(son_1);
                NewGeneration.addIndividual(son_2);
            }

            currentGeneration = NewGeneration;

            System.out.print("Geração Nº "+(x+1)+" - ");
            Individual bestSolutionIndividual2 = currentGeneration.findIndividual(0);
            System.out.print("Melhor Solução: "+bestSolutionIndividual2.getSolution());
            System.out.println();
        }

    }

    public static Population buildfirstPopulation(int Quantity, int LimiteMin, int LimiteMax) {
        int i, x1, x2;
        Random random = new Random();
        Population population = new Population(Quantity);
        for (i = 0; i < Quantity; i++) {
            x1 = random.nextInt(LimiteMax - LimiteMin) + LimiteMin;
            x2 = random.nextInt(LimiteMax - LimiteMin) + LimiteMin;
            Individual individual = new Individual(x1, x2);
            population.addIndividual(individual);
        }
        return population;
    }

    public static Individual selectionTournament(Population population) {
        Individual individual1, individual2, individual3, bestIndividual;
        Random random = new Random();
        int tam = population.getSize();
        individual1 = population.findIndividual(random.nextInt(tam));
        individual2 = population.findIndividual(random.nextInt(tam));
        individual3 = population.findIndividual(random.nextInt(tam));
        if (individual1.getSolution() >= individual2.getSolution()) {
            bestIndividual = individual1;
        } else {
            bestIndividual = individual2;
        }
        if (bestIndividual.getSolution() <= individual3.getSolution()) {
            bestIndividual = individual3;
        }
        return bestIndividual;
    }

    public static Individual[] crossoverIndividuals(Individual individual_1, Individual individual_2) {
        Individual son_1 = new Individual(individual_1.getX1(), individual_2.getX2());
        Individual son_2 = new Individual(individual_2.getX1(), individual_1.getX2());
        Individual[] individuals = { son_1, son_2 };
        return individuals;
    }

    public static Individual mutationIndividual(Individual individual, int LimiteMin, int LimiteMax) {
        Random random = new Random();
        individual.setX1(random.nextInt(LimiteMax - LimiteMin) + LimiteMin);
        individual.setX2(random.nextInt(LimiteMax - LimiteMin) + LimiteMin);
        return individual;
    }

}
