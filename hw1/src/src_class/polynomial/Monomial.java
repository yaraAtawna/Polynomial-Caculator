package src_class.polynomial;

import src_class.scalar_class.IntegerScalar;
import src_class.scalar_class.Rational;
import src_class.scalar_class.Scalar;

public class Monomial
{
    private int exponent;
    private Scalar coefficient;
    public Monomial(Scalar coefficient, int exponent) {
        this.exponent = exponent;
        this.coefficient = coefficient;
    }
    public Scalar getCoefficient(){
        return coefficient;
}

    public Monomial add(Monomial m)
    {
        if (exponent!= m.exponent)
            return null;
        return new Monomial(m.coefficient.add(this.coefficient), this.exponent);
    }

    public  Monomial mul(Monomial m)
    {
        Scalar s = coefficient.mul(m.getCoefficient());
        return new Monomial(s,this.exponent+m.getExponent());
    }
    public Scalar evaluate(Scalar s)
    {
        Scalar s1=s.power(this.exponent);
        Scalar s2=s1.mul(this.coefficient);
        return s2;
    }
    public Monomial derivative()
    {  if (exponent==0)
        {
            return new Monomial(new IntegerScalar(0), 0);
        }
        IntegerScalar s = new IntegerScalar(exponent);
        return new Monomial(coefficient.mul(s),exponent-1);
    }

    public  int sign()
    {
        return coefficient.sign();
    }
    public boolean equals (Monomial o){
        if(o instanceof Monomial){
            if(this.coefficient.equals(((Monomial) o).coefficient) && this.exponent == ((Monomial) o).exponent){
                return true;
            }
            return false;
        }
        return false ;
    }

    public String toString()
    {
        if(exponent == 0){
            return this.coefficient.toString();
        }
        if(exponent == 1)
        {
            return this.coefficient.toString()+ "x";
        }
        if(coefficient.equals(new IntegerScalar(1)) || coefficient.equals(new Rational(1,1)))
        {
            return "x"+"^"+exponent;
        } else if ( coefficient.equals(new IntegerScalar(-1))|| coefficient.equals(new Rational(-1,1))) {
            return "-x"+"^"+exponent;

        }
        return this.coefficient.toString() + "x"+"^"+exponent ;

    }

    public int getExponent() {
        return exponent;
    }
}
