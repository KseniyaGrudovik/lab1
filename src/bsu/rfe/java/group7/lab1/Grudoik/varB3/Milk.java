package bsu.rfe.java.group7.lab1.Grudoik.varB3;

public class Milk extends Food{
    private String fat;
    public Milk(String fat){
       super ("Молоко");
       this.fat = fat;
    }
    public void consume() {
        System.out.println(this + "выпито");
    }
    public String getFat() {
        return fat;
    }
    public void setFat(String fat) {
        this.fat = fat;
    }
    public boolean equals(Object arg0) {
        if (super.equals(arg0)) { // Шаг 1
            if (!(arg0 instanceof Milk)) return false; // Шаг 2
            return fat.equals(((Milk)arg0).fat); // Шаг 3
        } else
            return false;
    }
    public String toString() {
        return super.toString() + " жирности '" + fat.toUpperCase() + "' ";
    }

    public int calculateCalories()
    {
        if (fat.equals("1.5%")) {
            return 45;
        }else
        if (fat.equals("2.5%")) {
            return 54;
        }else
        if (fat.equals("5.0%")) {
            return 75;
        }
        return 0;
    }
}
