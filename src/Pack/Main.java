package Pack;



public class Main {
    public static void main(String[] args) throws DimensionException {
        NumberWithDimension numberWithDimension = new NumberWithDimension("1 стул^2 / джоуль");
        NumberWithDimension numberWithDimension1 = new NumberWithDimension("4 стол / стул");
        System.out.println(numberWithDimension.multiplication(numberWithDimension1));
    }
}
