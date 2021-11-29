package bsu.rfe.java.group7.lab1.Grudoik.varB3;

public class Cheese extends Food{
    public Cheese() {
        super("Сыр");
    }
    public void consume() {
        System.out.println(this + " съеден");
    }
    public int calculateCalories() {
        return 402;
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) {
            return name.equals(((Cheese)arg0).name);
        }else
            return false;
    }
}
