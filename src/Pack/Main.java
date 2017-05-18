package Pack;



public class Main {
    public static void main(String[] args) throws DimensionException {
        NumberWithDimension numberWithDimension = new NumberWithDimension("30 сантиартем / милитюшин^2");
        NumberWithDimension numberWithDimension1 = new NumberWithDimension("20 килоденис / микрографов");
        System.out.println(numberWithDimension.multiplication(numberWithDimension1));
    }
}
