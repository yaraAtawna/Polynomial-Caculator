package src_class.polynomial;

import src_class.scalar_class.IntegerScalar;
import src_class.scalar_class.Rational;
import src_class.scalar_class.Scalar;

import java.util.HashMap;

public class Polynomial  {

    private HashMap<java.lang.Integer, Monomial> monomials = new HashMap<>();
    public Polynomial(HashMap<java.lang.Integer, Monomial> monomials){
        this.monomials=monomials ;
    }
    public static Polynomial build(String input){
        int exponent = 0;
        String noSpace = input.trim() ;
        HashMap<Integer, Monomial> h1= new HashMap<>();
        String[] parts = noSpace.split("\\s+");
        for (int i = 0; i < parts.length; i++) {
            String[] partsR = parts[i].split("/");
            int num = Integer.parseInt(partsR[0]);
            int denom = 1; // If no denominator is provided, assume it's 1
            if(partsR.length > 1){
                denom = Integer.parseInt(partsR[1]);
                h1.put(exponent, new Monomial(new Rational(num,denom), exponent));
                exponent++;
            }
            else if(partsR.length == 1){
                h1.put(exponent, new Monomial(new IntegerScalar(num), exponent));
                exponent++;
            }
        }
        return new Polynomial(h1) ;
    }


    public Polynomial add(Polynomial p){
        HashMap<java.lang.Integer, Monomial> h1= new HashMap<>();
        int sizeThis = this.monomials.size() ;
        int sizeOther = p.monomials.size() ;

        if(sizeThis > sizeOther){
            for (int i = 0; i < sizeThis; i++) {
                if(i < sizeOther){
                    h1.put(i,this.monomials.get(i).add(p.monomials.get(i))) ;}
                else
                    h1.put(i,this.monomials.get(i));
            }
        }
        else{
            for (int i = 0; i < sizeOther; i++) {
                if(i < sizeThis){
                    h1.put(i,this.monomials.get(i).add(p.monomials.get(i))) ;}
                else
                    h1.put(i,p.monomials.get(i));
            }
        }
        return new Polynomial(h1);
    }

    public Polynomial mul(Polynomial p){
        HashMap<java.lang.Integer, Monomial> h1= new HashMap<>();
        int sizeThis = this.monomials.size() ;
        int sizeOther = p.monomials.size() ;
        for (int i=0; i<sizeThis ;i++)
        { for( int k=0; k<sizeOther ;k++)
            {
                int n=k+i;
                Monomial m=this.monomials.get(i).mul(p.getMonomials().get(k));
                if (h1.containsKey(n))
                {  Monomial newValue=h1.get(n).add(m);
                    h1.put(n,newValue ) ;
                }
                else
                {
                    h1.put(n,m);
                }

            }
            }
        return new Polynomial(h1);
    }



    public boolean equals(Object obj)
    {
        if(obj instanceof Polynomial)
        {
            int sizeThis = this.monomials.size() ;
            int sizeOther = ((Polynomial)obj).getMonomials().size() ;
            if (sizeThis!=sizeOther)
            {
                return false;
            }
            for (int i=0;i<sizeOther;i++)
            {
                if (!(((Polynomial)obj).getMonomials().get(i).equals(this.monomials.get(i))))
                {
                    return false;
                }

            }
            return true;
        }
        return false;
    }
    public Polynomial derivative(){
        HashMap<java.lang.Integer, Monomial> deriv = new HashMap<>();
        for (int i = 1; i < monomials.size() ; i++) {
            deriv.put(i-1,monomials.get(i).derivative());
        }
        return new Polynomial(deriv);
    }
    public Scalar evaluate(Scalar s){
        Scalar s1 = new IntegerScalar(0);
        for (int i = 0; i < monomials.size(); i++) {
            s1 = s1.add(monomials.get(i).evaluate(s));
        }
        return s1 ;
    }
    public String toString()
    {
        boolean first=true;
        int sizeThis = this.monomials.size() ;
        if (sizeThis==0)
        {
            return "";
        }
        String str="";

        for (int i=0;i<sizeThis;i++)
        {
            Monomial m=this.monomials.get(i);
            if(m.sign()==(-1))
            {
                str=str+m.toString();
            }
            else if (m.sign()==1 && first)
            {
                first=false;
                str=m.toString();
            }
            else if(m.sign()==1)
            {
                str=str+"+"+m.toString();

            }
        }
        return str;
    }
    private HashMap<java.lang.Integer, Monomial> getMonomials()
    {

        return monomials;
    }
}

