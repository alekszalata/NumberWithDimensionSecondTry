package Pack;


public class NumberWithDimension {
    private double number;
    private String dimension;
    private Dimension dim = new Dimension();


    public NumberWithDimension(String number) {
        this.number = Double.parseDouble(number.substring(0, number.indexOf(' '))) * Math.pow(10, Integer.parseInt(Dimension.Normalise(number.substring(number.indexOf(' ') + 1, number.length()))[0]));
        this.dimension = Dimension.Normalise(number.substring(number.indexOf(' ') + 1, number.length()))[1];
        if (this.dimension.charAt(0) == '1') this.dimension = this.dimension.substring(4,this.dimension.length()); // удаление 1
    }

    public NumberWithDimension summary(NumberWithDimension toSumNumber) throws DimensionException {
        if (this.dimension.equals(toSumNumber.dimension)) {
            this.number = this.number + toSumNumber.number;
        } else try {
            throw new DimensionException();
        } catch (DimensionException e) {
            return this;
        }
        return this;
    }

    public NumberWithDimension subtraction(NumberWithDimension toSubrtactNumber) {
        if (this.dimension.equals(toSubrtactNumber.dimension)) {
            this.number = this.number - toSubrtactNumber.number;
        } else try {
            throw new DimensionException();
        } catch (DimensionException e) {
            return this;
        }
        return this;
    }

    public NumberWithDimension multiplication(NumberWithDimension toMultiplicateNumber) {

        this.dimension = Dimension.Normalise(this.dimension + "*" + toMultiplicateNumber.dimension)[1];
        this.number = this.number * toMultiplicateNumber.number;
        return this;
    }


    public NumberWithDimension division(NumberWithDimension toDivisonNumber) {
        this.dimension = Dimension.Normalise(this.dimension + "*" + toDivisonNumber.dimension)[1];
        this.number = this.number / toDivisonNumber.number;
        return this;
    }


    public int compare(NumberWithDimension toComapreNumber) {
        return Double.compare(this.number, toComapreNumber.number);
    }


    @Override
    public String toString() {
        return this.number + " " + this.dimension;
    }
}
