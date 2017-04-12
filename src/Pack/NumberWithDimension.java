package Pack;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.*;
import java.util.StringJoiner;


public class NumberWithDimension {
    private double number;
    private String dimension;
    private Dimension dim = new Dimension();


    public NumberWithDimension(String number) {
        this.number = Double.parseDouble(number.substring(0, number.indexOf(' '))) * Math.pow(10, Integer.parseInt(Dimension.Normalise(number.substring(number.indexOf(' ') + 1, number.length()))[0]));
        this.dimension = Dimension.Normalise(number.substring(number.indexOf(' ') + 1, number.length()))[1];
    }

    public NumberWithDimension summary(NumberWithDimension toSumNumber) {
        if (this.dimension.equals(toSumNumber.dimension)) {
            this.number = this.number + toSumNumber.number;
        }
        return this;
    }

    public NumberWithDimension subtraction(NumberWithDimension toSubrtactNumber) {
        if (this.dimension.equals(toSubrtactNumber.dimension)) {
            this.number = this.number - toSubrtactNumber.number;
        }
        return this;
    }

    public NumberWithDimension multiplication(NumberWithDimension toMultiplicateNumber) {
        return this;
    }


    public NumberWithDimension division(NumberWithDimension toDivisonNumber) {
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
