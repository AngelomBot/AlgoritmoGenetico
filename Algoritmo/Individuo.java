package Genetico;

/**
 * Individuo
 */
public class Individuo {

    private double x1;
    private double x2;
    private double solution;
    
    public Individuo(double x1, double x2){
        this.x1 = x1;
        this.x2 = x2;
        this.solution = this.x1 - this.x2;
    }

    public double getSolution(){
        return this.solution;
    }

    public double getX1(){
        return this.x1;
    }

    public void setX1(double x){
        this.x1 = x;
    }

    public double getX2(){
        return this.x2;
    }

    public void setX2(double x){
        this.x2 = x;
    }

    
}