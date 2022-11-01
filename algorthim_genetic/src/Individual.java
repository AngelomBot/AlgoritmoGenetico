public class Individual {

    private int x1;
    private int x2;
    private int solution;

    public Individual(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
        this.solution = (3*((this.x1)^2) - 4*((this.x2)^3))
        +(((this.x1)^5)+((this.x2)^6));
    }

    public int getSolution() {
        return this.solution;
    }

    public int getX1() {
        return this.x1;
    }

    public void setX1(int x) {
        this.x1 = x;
        this.updateSolution();
    }

    public int getX2() {
        return this.x2;
    }

    public void setX2(int x) {
        this.x2 = x;
        this.updateSolution();
    }

    private void updateSolution(){
        this.solution = (3*((this.x1)^2) - 4*((this.x2)^3))
        +(((this.x1)^5)+((this.x2)^6));
    }
}