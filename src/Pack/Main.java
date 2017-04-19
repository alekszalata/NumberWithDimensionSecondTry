package Pack;



public class Main {
    public static void main(String[] args) throws DimensionException {
        NumberWithDimension numberWithDimension = new NumberWithDimension("1 1 / джоуль");
        NumberWithDimension numberWithDimension1 = new NumberWithDimension("0 стол / стул");
        System.out.println(numberWithDimension.division(numberWithDimension1));
    }
}
