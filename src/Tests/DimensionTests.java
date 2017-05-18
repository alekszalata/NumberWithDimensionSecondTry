package Tests;
import Pack.DimensionException;
import Pack.NumberWithDimension;
import org.junit.Test;
import static org.junit.Assert.*;

public class DimensionTests {
    @Test
    public void sumWithExcption() throws DimensionException {
        NumberWithDimension firstNumber = new NumberWithDimension("3 сантиметр / килоджоуль");
        assertEquals(firstNumber.toString(), firstNumber.summary(new NumberWithDimension("2 гектафарад / гигапаскаль")).toString());
    }

    @Test
    public void sum() throws DimensionException {
        assertEquals(new NumberWithDimension("0.05 метр * джоуль^-1 ").toString(), new NumberWithDimension("3 сантиметр / джоуль")
                .summary(new NumberWithDimension("2 сантиметр / джоуль")).toString());
    }

    @Test
    public void subtractionWithExcption() throws DimensionException {
        NumberWithDimension firstNumber = new NumberWithDimension("3 сантиметр / килоджоуль");
        assertEquals(firstNumber.toString(), firstNumber.subtraction(new NumberWithDimension("2 гектафарад / гигапаскаль")).toString());
    }

    @Test
    public void subtraction() throws DimensionException {
        assertEquals(new NumberWithDimension("100 метр / джоуль").toString(), new NumberWithDimension("30 сантиметр / милиджоуль")
                .subtraction(new NumberWithDimension("20 сантиметр / милиджоуль")).toString());
    }

    @Test
    public void multiplication() {
        assertEquals(new NumberWithDimension("60.0 паскаль^-1 * метр * джоуль^-1 * фарад").toString(), new NumberWithDimension("3 сантиметр / джоуль")
                .multiplication(new NumberWithDimension("2 килофарад / паскаль")).toString());
    }

    @Test
    public void division() {
        assertEquals(new NumberWithDimension("50.0 метр * джоуль^-2").toString(), new NumberWithDimension("1 1 / джоуль")
                .division(new NumberWithDimension("2 сантиметр / джоуль")).toString());
    }

    @Test
    public void Infinitydivision() {
        assertEquals(new NumberWithDimension("Infinity стол * стул^-1 * джоуль^-1").toString(), new NumberWithDimension("1 1 / джоуль")
                .division(new NumberWithDimension("0 стол / стул")).toString());
    }

    @Test
    public void Compare() {
        assertEquals(1, new NumberWithDimension("1 стол / стул")
                .compareTo(new NumberWithDimension("0 стол / стул")));
    }
}

