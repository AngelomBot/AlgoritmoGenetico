public class Population {

    private Individual[] population;
    private int size;

    public Population(int tam) {
        population = new Individual[tam];
    }

    public boolean isEmpty() {
        if (size == 0) {
            return true;
        } else {
            return false;
        }
    }

    public void addIndividual(Individual individual) {
        int i, j;
        if (isEmpty()) {
            population[0] = individual;
            size++;
        } else {
            population[size] = individual;
            size++;
            for (i = population.length; i >= 1; i--) {
                for (j = 1; j < i; j++) {
                    if (population[j - 1].getSolution() > population[j].getSolution()) {
                        Individual aux = population[j];
                        population[j] = population[j - 1];
                        population[j - 1] = aux;
                    }
                }
            }

        }
    }

    public Individual findIndividual(int index) {
        return population[index];
    }

    public int getSize() {
        return this.size;
    }

}