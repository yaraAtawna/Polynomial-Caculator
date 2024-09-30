package tests;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import src_class.polynomial.Monomial;
import src_class.polynomial.Polynomial;
import src_class.scalar_class.IntegerScalar;
import src_class.scalar_class.Rational;

import java.util.HashMap;

import static org.junit.Assert.*;

public class PolynomialTest {
    Polynomial a;
    Polynomial b;
    Polynomial c;
    Polynomial d;
    Polynomial e;

    @Before
    public void startPolynomial()
    {
        String str1="0 0 0 0 0 7";
        a=Polynomial.build(str1);

        String str2="0";
        b=Polynomial.build(str2);

        String str3="0 1/2 3 -5/3";
        c=Polynomial.build(str3);

        String str4="5";
        d=Polynomial.build(str4);

        String str5="1 -2 3";
        e=Polynomial.build(str5);
    }

    @Test
    public void build() {
        HashMap<Integer, Monomial> monomials = new HashMap<>();
        monomials.put(0,new Monomial(new IntegerScalar(0),0));
        monomials.put(1,new Monomial(new IntegerScalar(0),1));
        monomials.put(2,new Monomial(new IntegerScalar(0),2));
        monomials.put(3,new Monomial(new IntegerScalar(0),3));
        monomials.put(4,new Monomial(new IntegerScalar(0),4));
        monomials.put(5,new Monomial(new IntegerScalar(7),5));
        assertEquals(new Polynomial(monomials),a);
        HashMap<Integer,Monomial> monomials1 = new HashMap<>();
        monomials1.put(0,new Monomial(new IntegerScalar(0),0));
        monomials1.put(1,new Monomial(new Rational(1,2),1));
        monomials1.put(2,new Monomial(new IntegerScalar(3),2));
        monomials1.put(3,new Monomial(new Rational(-5,3),3));
        assertEquals(new Polynomial(monomials1),c);
        HashMap<Integer,Monomial> monomials2 = new HashMap<>();
        monomials2.put(0,new Monomial(new IntegerScalar(1),0));
        monomials2.put(1,new Monomial(new IntegerScalar(-2),1));
        monomials2.put(2,new Monomial(new IntegerScalar(3),2));
        assertEquals(new Polynomial(monomials2),e);
    }

    @Test
    public void add() {

        assertEquals(Polynomial.build("5"),b.add(d));
        assertEquals(Polynomial.build("0 1/2 3 -5/3 0 7"),a.add(c));
        assertEquals(Polynomial.build("1 -3/2 6 -5/3"),e.add(c));
        assertEquals(Polynomial.build("6 -2 3"),e.add(d));

    }

    @Test
    public void mul() {
        assertEquals(Polynomial.build("5 -10 15").toString(),d.mul(e).toString());
        assertEquals(Polynomial.build("0").toString(),b.mul(c).toString());
        assertEquals(Polynomial.build("0 0 0 0 0 7 -14 21").toString(),e.mul(a).toString());
        assertEquals(Polynomial.build("0 0 0 0 0 0 7/2 21 -35/3").toString(),a.mul(c).toString());
    }

    @Test
    public void testEquals() {
        assertTrue(a.equals(a));
        assertTrue(c.equals(c));
        assertTrue(b.equals(b));

        assertFalse(a.equals(b));
        assertFalse(b.equals(c));
        assertFalse(d.equals(a));

    }

    @Test
    public void derivative() {
        Assert.assertEquals(Polynomial.build("1/2 6 -15/3").toString(),c.derivative().toString());
        Assert.assertEquals(Polynomial.build("-2 6").toString().toString(),e.derivative().toString().toString());
        Assert.assertEquals(Polynomial.build("0").toString(),d.derivative().toString());
        Assert.assertEquals(Polynomial.build("0").toString(),b.derivative().toString());

    }

    @Test
    public void evaluate() {
        Assert.assertEquals(new IntegerScalar (5),d.evaluate(new IntegerScalar(10)));
        Assert.assertEquals(new Rational (-1,3),c.evaluate(new IntegerScalar(2)));
        Assert.assertEquals(new Rational (7,1),a.evaluate(new Rational (1,1)));
        Assert.assertEquals(new IntegerScalar (0),b.evaluate(new IntegerScalar(10)));

    }

    @Test
    public void testToString() {
        Assert.assertEquals("7x^5",a.toString());
        Assert.assertEquals("",b.toString());
        Assert.assertEquals("1/2x+3x^2-5/3x^3",c.toString());
        Assert.assertEquals("5",d.toString());
        Assert.assertEquals("1-2x+3x^2",e.toString());
    }
}