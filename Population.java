package Genetico;

import java.util.ArrayList;

public class Population {
    ArrayList<Individuo> population;

    public Population(){
        population = new ArrayList<Individuo>();
    }

    public void AddIndividuo(Individuo individuo){
        population.add(individuo);
    }

    public void deleteIndividuo(){
        
    }
}
