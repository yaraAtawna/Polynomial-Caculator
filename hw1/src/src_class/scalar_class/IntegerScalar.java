package src_class.scalar_class;

public class IntegerScalar implements Scalar {
    private int number;


    public IntegerScalar(int num) {
        this.number = num ;
    }
    public int getNumber(){
        return this.number;
    }

    public String toString(){
        return Integer.toString(number);
    }

    @Override
    public Scalar add(Scalar s) {
        return s.addInteger(this);
    }
    @Override
    public Scalar addRational(Rational r) {
        int numer1 = (this.number * r.getDenominator()) + r.getNumerator();
        return new Rational(numer1,r.getDenominator());
    }

    @Override
    public Scalar addInteger(IntegerScalar num) {
        return new IntegerScalar(this.number + num.getNumber());
    }


    @Override
    public Scalar mulInteger(IntegerScalar num) {
        return new IntegerScalar(this.number * num.number);
    }

    @Override
    public Scalar mulRational(Rational r) {
        return new Rational(this.number * r.getNumerator() ,r.getDenominator());
    }


    @Override
    public Scalar mul(Scalar s) {
        return s.mulInteger(this);
    }

    @Override
    public Scalar neg() {
        return new IntegerScalar(-this.number);
    }

    @Override
    public Scalar power(int exponent) {
        return new IntegerScalar((int) Math.pow(this.number,exponent));
    }

    @Override
    public int sign() {
        if(this.number>0){
            return 1;
        }
        if(this.number<0){
            return -1 ;
        }
        return 0 ;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof IntegerScalar){
            if(this.number == ((IntegerScalar) obj).number){
                return true;
            }
            return false ;
        }
        return false ;
    }
}
