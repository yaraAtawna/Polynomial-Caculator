package src_class.scalar_class;

import java.math.BigInteger;

public class Rational implements Scalar
{
    private  int numerator;
    private  int denominator;
    public Rational( int numerator,int denominator)
    {
        this.numerator=numerator;
        this.denominator=denominator;

    }

    @Override
    public Scalar add(Scalar s) {
        return s.addRational(this);
    }

    @Override
    public Scalar addRational(Rational s) {
        int num1=numerator*s.getDenominator()+denominator*s.getNumerator();
        int num2=denominator*s.getDenominator();
        return new Rational(num1,num2);
    }

    @Override
    public Scalar addInteger(IntegerScalar s) {
        int num1=numerator+denominator*s.getNumber();
        return new Rational(num1,denominator);
    }

    @Override
    public Scalar mul(Scalar s) {
        return s.mulRational(this);
    }

    @Override
    public Scalar mulInteger(IntegerScalar s) {
        int num1=numerator*s.getNumber();
        return new Rational(num1,denominator);
    }

    @Override
    public Scalar mulRational(Rational s) {
        int num1=numerator*s.getNumerator();
        int num2=denominator*s.getDenominator();
        return new Rational(num1,num2);
    }

    @Override
    public Scalar neg() {

            return new Rational(-numerator,denominator);

    }


    @Override
    public Scalar power(int exponent) {
        if(exponent<0)
        {
            return new Rational((int) Math.pow(denominator, -exponent), (int) Math.pow(numerator, -exponent));
        }
        return new Rational((int) Math.pow(numerator, exponent), (int) Math.pow(denominator, exponent));

    }

    @Override
    public int sign()
    {
        if(numerator==0)
             return 0;
        else if ((numerator<0 && denominator>0) || (numerator>0 && denominator<0)) {
            return -1;
        }
        else
        {
            return 1;
        }
    }
    public Rational reduce()
    {
        int gcd=gcd(numerator,denominator);
        if(this.numerator < 0 && this.denominator < 0){
            this.numerator = Math.abs(this.numerator);
            this.denominator = Math.abs(this.denominator);
        }
        this.numerator=this.numerator/gcd;
        this.denominator=this.denominator/gcd;
        return new Rational(numerator,denominator);
    }
    public String toString()
    {
        Rational nRS = this.reduce();
        if(nRS.denominator == 1){
            return String.valueOf(nRS.numerator) ;
        }
        else {
            return nRS.numerator + "/" + nRS.denominator;
        }

    }
    //new methods
    public int getNumerator()
    {
        return numerator;
    }
    public int getDenominator()
    {
        return denominator;
    }
    private  int  gcd(int n1, int n2)
    {
        BigInteger b1 = BigInteger.valueOf(n1);
        BigInteger b2 = BigInteger.valueOf(n2);
        BigInteger gcd = b1.gcd(b2);
        return gcd.intValue();

    }
    public boolean equals(Object o){
        if(o instanceof Rational){
            Rational rS1 = this.reduce();
            Rational rS2 = ((Rational) o).reduce();
            if(rS1.numerator == rS2.numerator && rS1.denominator == rS2.denominator){
                return true ;
            }
            return false;
        }
        return false;
    }
}
