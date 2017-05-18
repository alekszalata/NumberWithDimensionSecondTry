package Pack;



public class Main {
    public static void main(String[] args) throws DimensionException {
        NumberWithDimension numberWithDimension = new NumberWithDimension("30 сантиартем / тюшин^2");
        NumberWithDimension numberWithDimension1 = new NumberWithDimension("20 сантиартем / тюшин^2");
        System.out.println(numberWithDimension.summary(numberWithDimension1));
    }
}
