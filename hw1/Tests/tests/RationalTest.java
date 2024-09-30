package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src_class.scalar_class.IntegerScalar;
import src_class.scalar_class.Rational;
import src_class.scalar_class.Scalar;

public class RationalTest {
    Scalar five ;
    Rational zero ;
    Scalar minusFive;
    Rational halfRat;
    Scalar one;
    Rational rational;
    Rational ratOneAnHalf;
    Rational minusRatio;
    @Before
    public void startRatScalar() {
            five = new IntegerScalar(5);
            zero = new Rational(0,1);
            minusFive = new IntegerScalar(-5);
            halfRat = new Rational(1,2);
            one = new IntegerScalar(1);
            rational = new Rational(25,30);
            ratOneAnHalf = new Rational(-3,-2);
            minusRatio = new Rational(-87,54);
    }
    @Test
    public void add() {
        Assert.assertEquals(rational.add(minusFive),new Rational(-25,6));
        Assert.assertEquals(one.add(halfRat),ratOneAnHalf);
        Assert.assertEquals(rational.add(ratOneAnHalf),new Rational(35,15));
    }



    @Test
    public void mul() {
        Assert.assertEquals(rational.mul(minusFive),new Rational(-25,6));
        Assert.assertEquals(one.mul(halfRat),halfRat);
        Assert.assertEquals(rational.mul(ratOneAnHalf),new Rational(25,20));

    }



    @Test
    public void neg() {
        Assert.assertEquals(new Rational(-25,30),rational.neg());
        Assert.assertEquals(new Rational(-1,2),halfRat.neg());
        Assert.assertEquals(zero.neg(),zero);
    }

    @Test
    public void power() {
        Assert.assertEquals(rational.power(2),new Rational(625,900));
        Assert.assertEquals(halfRat.power(2),new Rational(1,4));
        Assert.assertEquals(rational.power(-2),new Rational(900,625));
        Assert.assertEquals(halfRat.power(-2),new Rational(4,1));
        Assert.assertEquals(halfRat.power(0),new Rational(1,1));
    }

    @Test
    public void sign() {
        Assert.assertEquals(rational.sign(),1);
        Assert.assertEquals(minusRatio.sign(),-1);
        Assert.assertEquals(ratOneAnHalf.sign(),1);
        Assert.assertEquals(zero.sign(),0);
    }

    @Test
    public void reduce() {
        Assert.assertEquals(rational.reduce(),new Rational(5,6));
        Assert.assertEquals(minusRatio.reduce(),new Rational(-29,18));
        Assert.assertEquals(ratOneAnHalf.reduce(),new Rational(3,2));
        Assert.assertEquals(zero.reduce(),new Rational(0,1));
    }

    @Test
    public void testToString() {
        Assert.assertTrue(halfRat.toString().equals("1/2"));
        Assert.assertEquals("-29/18",minusRatio.toString());

    }

    @Test
    public void testEquals() {
        Assert.assertTrue(rational.equals(new Rational(5,6)));
        Assert.assertTrue(halfRat.add(one).equals(ratOneAnHalf));
    }
}