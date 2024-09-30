package tests;

import org.junit.Before;
import org.junit.Test;
import src_class.polynomial.Monomial;
import src_class.scalar_class.IntegerScalar;
import src_class.scalar_class.Rational;

import static org.junit.Assert.*;

public class MonomialTest {
    Monomial m1;
    Monomial m2;
    Monomial m3;
    Monomial m4;
    Monomial m5;
    Monomial minusM6;
    @Before
    public void startMonomial() {
        m1 = new Monomial(new IntegerScalar(1), 2);
        m2 = new Monomial(new IntegerScalar(2), 3);
        m3 = new Monomial(new Rational(1,2), 4);
        m4 = new Monomial(new Rational(3,4), 5);
        m5 = new Monomial(new IntegerScalar(8),3);
        minusM6 = new Monomial(new IntegerScalar(-1), 2);

    }
    @Test
    public void add() {
        assertEquals(new Monomial(new IntegerScalar(2), 2).toString(), m1.add(m1).toString());
        assertTrue(m1.add(m2) == null);
        assertEquals(new Monomial(new IntegerScalar(10), 3).toString(), m2.add(m5).toString());
    }

    @Test
    public void mul() {
        assertEquals(new Monomial(new IntegerScalar(1), 4).toString(), m1.mul(m1).toString());
        assertEquals(new Monomial(new IntegerScalar(2), 5).toString(), m1.mul(m2).toString());
        assertEquals(new Monomial(new Rational(1,2), 6).toString(), m1.mul(m3).toString());
        assertEquals(new Monomial(new Rational(3,2), 8).toString(), m2.mul(m4).toString());
    }

    @Test
    public void evaluate() {
        assertEquals(new Rational(1,1).toString(), m1.evaluate(new Rational(1,1)).toString());
        assertEquals(new Rational(2,1).toString(), m2.evaluate(new Rational(1,1)).toString());
        assertEquals(new Rational(1,32).toString(), m3.evaluate(new Rational(1,2)).toString());
        assertEquals(new Rational(8,81).toString(), m4.evaluate(new Rational(2,3)).toString());
    }

    @Test
    public void derivative() {
        assertEquals(new Monomial(new IntegerScalar(2), 1).toString(), m1.derivative().toString());
        assertEquals(new Monomial(new IntegerScalar(6), 2).toString(), m2.derivative().toString());
        assertEquals(new Monomial(new Rational(2,1), 3).toString(), m3.derivative().toString());
        assertEquals(new Monomial(new Rational(15,4), 4).toString(), m4.derivative().toString());
    }

    @Test
    public void sign() {
        assertEquals(1, m1.sign());
        assertEquals(1, m2.sign());
        assertEquals(-1, minusM6.sign());
    }

    @Test
    public void testEquals() {
        assertTrue(m1.equals(m1));
        assertFalse(m1.equals(m2));
        assertFalse(m1.equals(m3));
        assertFalse(m1.equals(m4));
        assertFalse(m1.equals(m5));
        assertFalse(m1.equals(minusM6));
    }

    @Test
    public void testToString() {
        assertEquals("x^2", m1.toString());
        assertEquals("2x^3", m2.toString());
        assertEquals("1/2x^4", m3.toString());
        assertEquals("3/4x^5", m4.toString());
        assertEquals("8x^3", m5.toString());
        assertEquals("-x^2", minusM6.toString());
    }
}