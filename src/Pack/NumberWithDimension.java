package Pack;


public class NumberWithDimension {
    private double number;
    private String dimension;

    public NumberWithDimension(String number) {
        this.number = Double.parseDouble(number.substring(0, number.indexOf(' '))) * Math.pow(10, Integer.parseInt(Dimension.Normalise(number.substring(number.indexOf(' ') + 1, number.length()))[0]));     // вместо того , что после  10 надо сделать getMainPow
        this.dimension = Dimension.Normalise(number.substring(number.indexOf(' ') + 1, number.length()))[1];
        if (this.dimension.charAt(0) == '1') this.dimension = this.dimension.substring(4,this.dimension.length());  //
    }

    public NumberWithDimension summary(NumberWithDimension toSumNumber) throws DimensionException {
        if (this.dimension.equals(toSumNumber.dimension)) {
            this.number = this.number + toSumNumber.number;
        } else
            throw new DimensionException();
        return this;
    }

    public NumberWithDimension subtraction(NumberWithDimension toSubrtactNumber) throws DimensionException {
        if (this.dimension.equals(toSubrtactNumber.dimension)) {
            this.number = this.number - toSubrtactNumber.number;
        } else
            throw new DimensionException();
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


    public int compareTo (NumberWithDimension toComapreNumber) {
        return Double.compare(this.number, toComapreNumber.number);
    }


    @Override
    public String toString() {
        return this.number + " " + this.dimension;
    }


    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(number);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + dimension.hashCode();
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        NumberWithDimension other = (NumberWithDimension) obj;
        if (this.number != other.number)
            return false;
        if (this.dimension != other.dimension)
            return false;
        return true;

    }


}
