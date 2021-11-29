package bsu.rfe.java.group7.lab1.Grudoik.varB3;

public  class Food implements Consumable, Nutritious {
    String name = null;
    public Food(String name) {
        this.name = name;
    }
    public boolean equals(Object arg0) {
        if (!(arg0 instanceof Food)) return false; // Шаг 1
        if (name==null || ((Food)arg0).name==null) return false; // Шаг 2
        return name.equals(((Food)arg0).name); // Шаг 3
    }
    public String toString() {
        return name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void consume() {

    }

    @Override
    public int calculateCalories() {
        return 0;
    }

// Реализация метода consume() удалена из базового класса Food
// Это можно сделать, потому что сам Food - абстрактный
}

