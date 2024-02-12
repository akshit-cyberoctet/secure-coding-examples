public class Array {
    public static void main(String[] args) {
        String[] cars = {"Volvo", "BMW", "Ford"};

        System.out.println(cars[0]);

        cars[3] = "Jaguar";
    }
}

// OUTPUT:

// Volvo
// Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: Index 3 out of bounds for length 3
//         at Array.main(array.java:7)

// Java throws an exception when you try to write to an index that is out of bounds, unlike C