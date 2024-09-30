package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src_class.scalar_class.IntegerScalar;
import src_class.scalar_class.Rational;
import src_class.scalar_class.Scalar;

public class IntegerScalarTest {
    Scalar five ;
    Scalar zero ;

    Scalar minusFive;
    Scalar halfRat;
    Scalar one;
    Scalar rattional;
    Scalar ratOneAnHalf;
    @Before
    public void startIntScalar() {
         five = new IntegerScalar(5);
         zero = new IntegerScalar(0);
         minusFive = new IntegerScalar(-5);
         halfRat = new Rational(1,2);
         one = new IntegerScalar(1);
         rattional = new Rational(3,4);
            ratOneAnHalf = new Rational(3,2);
    }

    @Test
    public void testToString() {
        Assert.assertTrue(five.toString().equals("5"));
        Assert.assertTrue(zero.toString().equals("0"));
       Assert.assertEquals(minusFive.toString(),("-5"));
    }
    @Test
    public void testAdd() {
        Assert.assertTrue( five.add(minusFive).equals(zero));
        Assert.assertTrue(one.add(halfRat).equals(ratOneAnHalf));
        Assert.assertTrue(minusFive.add(ratOneAnHalf).equals(new Rational(-7,2)));
    }
    @Test
    public void multest() {
        Assert.assertTrue(five.mul(minusFive).equals(new IntegerScalar(-25)));
        Assert.assertTrue(one.mul(halfRat).equals(halfRat));
        Assert.assertTrue(minusFive.mul(halfRat).equals(new Rational(-5,2)));
    }
    @Test
    public void testNeg() {
        Assert.assertTrue(five.neg().equals(new IntegerScalar(-5)));
        Assert.assertTrue(minusFive.neg().equals(five));
        Assert.assertTrue(zero.neg().equals(zero));
    }
    @Test
    public void testPower() {
        Assert.assertTrue(five.power(2).equals(new IntegerScalar(25)));
        Assert.assertTrue(minusFive.power(2).equals(new IntegerScalar(25)));
    }
    @Test
    public void testSign() {
        Assert.assertTrue(five.sign() == 1);
        Assert.assertTrue(minusFive.sign() == -1);
    }

    @Test
    public void testEquals() {
       Assert.assertEquals("5-5 should be 0",five.add(minusFive),zero);
        Assert.assertTrue(five.add(minusFive).equals(minusFive.add(five)));
        Assert.assertTrue(five.add(minusFive).equals(zero));
        Assert.assertTrue(one.add(halfRat).equals(ratOneAnHalf));
    }
}