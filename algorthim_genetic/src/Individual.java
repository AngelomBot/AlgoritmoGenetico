public class Individual {

    private int x1;
    private int x2;

    public Individual(int x1, int x2) {
        this.x1 = x1;
        this.x2 = x2;
    }

    public int getSolution() {
        return this.x1 - this.x2;
    }

    public int getX1() {
        return this.x1;
    }

    public void setX1(int x) {
        this.x1 = x;
    }

    public int getX2() {
        return this.x2;
    }

    public void setX2(int x) {
        this.x2 = x;
    }
}