public class Main2 {
    public static void main(String[] args) {
        try {
            int d = 5; // Присваиваем ненулевое значение переменной d
            double catchedRes1 = intArray[8] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exception: " + e);
        }        
    }
}
