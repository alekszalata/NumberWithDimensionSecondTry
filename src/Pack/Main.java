package Pack;



public class Main {
    public static void main(String[] args) throws DimensionException {
        NumberWithDimension numberWithDimension = new NumberWithDimension("3 сантиметрасанти");
        NumberWithDimension numberWithDimension1 = new NumberWithDimension("2 метра");
        System.out.println(numberWithDimension.division(numberWithDimension1));
    }
}