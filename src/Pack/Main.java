package Pack;



public class Main {
    public static void main(String[] args) {
        NumberWithDimension numberWithDimension = new NumberWithDimension("3 1 / asd");
        NumberWithDimension numberWithDimension1 = new NumberWithDimension("2 1 / lel");
        System.out.println(numberWithDimension.division(numberWithDimension1));
    }
}
