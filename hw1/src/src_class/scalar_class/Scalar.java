package src_class.scalar_class;

public interface Scalar {
    Scalar add(Scalar s);
    Scalar addRational(Rational s);
    Scalar addInteger(IntegerScalar s);

    Scalar mul(Scalar s);
    Scalar mulInteger(IntegerScalar s);
    Scalar mulRational(Rational s);


    Scalar neg();
    Scalar power(int exponent);
    int sign();
    boolean equals(Object o);


}
