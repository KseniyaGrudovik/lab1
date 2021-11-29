package bsu.rfe.java.group7.lab1.Grudoik.varB3;
import java.util.Comparator;
import java.util.Arrays;

public class Main {
    // Главный метод главного класса
    public static void main(String[] args) throws Exception {
        // Определение ссылок на продукты завтрака
        Food[] breakfast = new Food[20];
        // Анализ аргументов командной строки и создание для них
        // экземпляров соответствующих классов для завтрака
        int itemsSoFar = 0;
        int numOfApplesB = 0;
        int numOfApplesS = 0;
        int numOfMilks1_5 = 0;
        int numOfMilks2_5 = 0;
        int numOfMilks5_0 = 0;
        int numOfCheeses = 0;
        boolean caloriesNeeded = false;
        boolean sortNeeded = false;

        for (String arg : args) {
            String[] parts = arg.split("/");
            if (arg.equals("-calories")) {
                caloriesNeeded = true;
            }
            if (arg.equals("-sort")) {
                sortNeeded = true;
            }
            if (parts[0].equals("Cheese")) {
// У сыра дополнительных параметров нет
                breakfast[itemsSoFar] = new Cheese();
                itemsSoFar++;
            } else if (parts[0].equals("Apple")) {
// У яблока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Apple(parts[1]);
                itemsSoFar++;
            } else if (parts[0].equals("Milk")) {
// У молока – 1 параметр, который находится в parts[1]
                breakfast[itemsSoFar] = new Milk(parts[1]);
                itemsSoFar++;
            }
        }

        if (sortNeeded) {
            Arrays.sort(breakfast, new Comparator() {
                public int compare(Object f1, Object f2) {
                    if (f1==null) return 1;
                    if (f2==null) return -1;
                    if((f1 instanceof  Apple && f2 instanceof Cheese || f1 instanceof  Milk && f2 instanceof Cheese)) {
                        return 1;
                    }
                    if((f2 instanceof  Apple && f1 instanceof Cheese || f2 instanceof  Milk && f1 instanceof Cheese)) {
                        return -1;
                    } else {
                        return 0;
                    }
                }
            });
        }
// Перебор всех элементов массива
        for (Food item : breakfast) {
            if (item != null)
// Если элемент не null – употребить продукт
                item.consume();
            else
// Если дошли до элемента null – значит достигли конца
// списка продуктов, ведь 20 элементов в массиве было
// выделено с запасом, и они могут быть не
// использованы все
                break;
        }

        Arrays.sort(breakfast, new Comparator() {
            public int compare(Object f1, Object f2) {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                if (((Food) f1).calculateCalories() == ((Food) f2).calculateCalories()) return 0;
                if (((Food) f1).calculateCalories() > ((Food) f2).calculateCalories()) return -1;
                return 1;
            }
        });

        if (caloriesNeeded) {
            int calories = 0;
            for (int i = 0; i < itemsSoFar; i++) {
                //if (breakfast[i]!=null)
                calories += breakfast[i].calculateCalories();
            }
            System.out.println("Калорийность завтрака равна: " + calories);
        }
        Food[] breakfast_diff = new Food[20];
        System.arraycopy(breakfast, 0, breakfast_diff, 0, 20);
        Arrays.sort(breakfast_diff, new Comparator() {
            public int compare(Object f1, Object f2) {
                if (f1 == null) return 1;
                if (f2 == null) return -1;
                if (((Food) f1).calculateCalories() == ((Food) f2).calculateCalories()) return 0;
                if (((Food) f1).calculateCalories() > ((Food) f2).calculateCalories()) return -1;
                return 1;
            }
        });
        int n = 1;
        Food[] food = new Food[20];
        food[0] = breakfast_diff[0];
        for (int i = 1; i < breakfast_diff.length; i++) {
            if (breakfast_diff[i]!=null && !breakfast_diff[i].equals(breakfast_diff[i-1])) food[n++] = breakfast_diff[i];
        }

        System.out.println("\nСколько чего съедено:");
        for(int i = 0; i < food.length; i++){
            if(food[i] == null) break;
            int count = 0;
            for(int j = 0; j < breakfast_diff.length; j++){
                if(food[i].equals(breakfast_diff[j])) count++;
            }
            System.out.println(food[i] + ": " + count);
        }
        System.out.println("Всего хорошего!");
    }
}

