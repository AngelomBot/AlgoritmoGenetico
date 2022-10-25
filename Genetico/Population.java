/**
 * Population
 */
import java.util.ArrayList;

public class Population {
    private Individual[]population;
    private int size;

    public Population(int tam){
        population = new Individual[tam];
    }

    public boolean isEmpty(){
        if(size==0){
            return true;
        }else{
            return false;
        }
    }

    public void addIndividual(Individual individual){
        int i;
        if(isEmpty()){
            population[0] = individual;
            size++;
        }else{
            for(i = 0;i<=population.length;i++){
                
            }
        }
    }

    public void deleteIndividual(Individual individual){
        population.remove(individual);
    }
}