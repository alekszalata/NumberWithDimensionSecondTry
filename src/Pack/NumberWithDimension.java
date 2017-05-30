package Pack;


import java.util.DoubleSummaryStatistics;

public class NumberWithDimension implements Comparable{
    private double number;
    private Dimension dim = null;


    public NumberWithDimension(String number) {
        String dimension = number.substring(number.indexOf(' ') + 1, number.length());
        this.dim = new Dimension(dimension);
        this.number = Double.parseDouble(number.substring(0, number.indexOf(' '))) * Math.pow(10, Integer.parseInt(dim.getDimenstion()[0]));
        //if (this.dimension.charAt(0) == '1') this.dimension = this.dimension.substring(4,this.dimension.length());
    }

    public NumberWithDimension summary(NumberWithDimension toSumNumber) throws DimensionException {
        if (this.dim.equals(toSumNumber.dim)) {
            this.number = this.number + toSumNumber.number;
        } else throw new DimensionException();
        return this;
    }

    public NumberWithDimension subtraction(NumberWithDimension toSubrtactNumber) throws DimensionException {
        if (this.dim.equals(toSubrtactNumber.dim)) {
            this.number = this.number - toSubrtactNumber.number;
        } else throw new DimensionException();
        return this;
    }

    public NumberWithDimension multiplication(NumberWithDimension toMultiplicateNumber) {
        //this.dimension = Dimension.Normalise(this.dimension + "*" + toMultiplicateNumber.dimension)[1];
        this.dim = new Dimension(this.dim.getDimenstion()[1] + "*" + toMultiplicateNumber.dim.getDimenstion()[1]);
        this.number = this.number * toMultiplicateNumber.number * Math.pow(10, Integer.parseInt(this.dim.getDimenstion()[0]));
        return this;
    }


    public NumberWithDimension division(NumberWithDimension toDivisonNumber) {
        this.dim = new Dimension(this.dim.getDimenstion()[1] + "/" + toDivisonNumber.dim.getDimenstion()[1]);
        this.number = this.number / toDivisonNumber.number * Math.pow(10, Integer.parseInt(this.dim.getDimenstion()[0]));;
        return this;
    }


    @Override
    public String toString() {
        return this.number + " " + this.dim.getDimenstion()[1];
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof NumberWithDimension && this.dim.equals(((NumberWithDimension) obj).dim)
                && this.number == (((NumberWithDimension) obj).number);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public int compareTo(Object o) {
        return Double.compare(this.number, ((NumberWithDimension) o).number);
    }
}
