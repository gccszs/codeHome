package com.example.tablayouttest02.unitchanger.fraction;

public class FrationDealer {
    private Fraction f1;
    private Fraction f2;
    private FrationDealer(String numer1,String denum1,String numer2,String denum2)
    {
        this.f1 = new Fraction(numer1,denum1);
        this.f2 = new Fraction(numer2,denum2);
    }
    private FrationDealer(String numer1,String denum1)
    {
        this.f1 = new Fraction(numer1,denum1);

    }
    public long gcd(long a,long b)
    {
      return (a%b == 0) ? b:gcd(b%a,a);
    }
    public long GetgcdDouble()
    {

        return gcd(f1.getDenominator(),f2.getDenominator());
    }
    public long GetgcdSingle()
    {
        return gcd(f1.getNumeration(),f1.getDenominator());
    }

    public Fraction getF1() {
        return f1;
    }

    public Fraction getF2() {
        return f2;
    }
    //两个分数累加
    public static String FractionOper(String numer1, String denum1, String numer2, String denum2, String oper)
    {
        FrationDealer frationDealer = new FrationDealer(numer1,denum1,numer2,denum2);
        if(Long.valueOf(denum1) == 0 ||Long.valueOf(denum2) == 0)
        {
            return "错误,分母不能为零";
        }

        long maxmuti = frationDealer.GetgcdDouble();
        long mincommti = Long.valueOf(denum1)*Long.valueOf(denum2)/frationDealer.GetgcdDouble();
        long resnumera = 0;
        switch (oper){
            case "+":
                resnumera = frationDealer.getF1().getNumeration()*(mincommti/frationDealer.getF1().getDenominator())+frationDealer.getF2().getNumeration()*mincommti/frationDealer.getF2().getDenominator();
                break;
            case "-":
                resnumera = frationDealer.getF1().getNumeration()*(mincommti/frationDealer.getF1().getDenominator())-frationDealer.getF2().getNumeration()*(mincommti/frationDealer.getF2().getDenominator());
                break;
            case "*":
                resnumera = (frationDealer.getF1().getNumeration())*(frationDealer.getF2().getNumeration());
                mincommti = (frationDealer.getF1().getDenominator())*(frationDealer.getF2().getDenominator());
                break;
            case "/":
                if(frationDealer.getF2().getNumeration() == 0)
                {
                    return "ERROR";
                }
                resnumera = (frationDealer.getF1().getNumeration())*(frationDealer.getF2().getDenominator());
                mincommti = frationDealer.getF1().getDenominator()*frationDealer.getF2().getNumeration();
                break;
        }
       long resmincom  = frationDealer.gcd(resnumera,mincommti);
        resnumera /=resmincom;
        mincommti /= resmincom;
        if(mincommti == resnumera)
        {
            return "1";
        }
        if(mincommti!=1)
        {
            return ""+resnumera+"/"+""+mincommti;
        }
        return ""+resnumera;
    }
    //单个分数约分
    public static String FrationOper(String numer1,String denum1)
    {
        FrationDealer frationDealer = new FrationDealer(numer1,denum1);
        if(frationDealer.getF1().getDenominator() == 0)
        {
            return "ERROR";
        }
        long maxn = frationDealer.GetgcdSingle();
        long resnumera  = frationDealer.getF1().getNumeration()/maxn;
        long resdenomi  = frationDealer.getF1().getDenominator()/maxn;
        if(resnumera == resdenomi)
        {
            return "1";
        }
        if(resdenomi!=1)
        {
        return ""+resnumera+"/"+""+resdenomi;
        }
        return ""+resnumera;
    }
    //两个分数通分
    public static String[] FractionCommon(String numer1, String denum1, String numer2, String denum2)
    {
        if(Long.valueOf(denum1) == 0 ||Long.valueOf(denum2) == 0)
        {
            return null;
        }
        FrationDealer frationDealer = new FrationDealer(numer1,denum1,numer2,denum2);
        long commmin = frationDealer.GetgcdDouble();
        long commdenum = frationDealer.f1.getDenominator()*frationDealer.f2.getDenominator()/commmin;

        long numer1after = frationDealer.f1.getNumeration()*(commdenum/frationDealer.getF1().getDenominator());
        long numer2after  = frationDealer.f2.getNumeration()*(commdenum/frationDealer.getF2().getDenominator());
        String result[] = new String[4];
        //通分后的结果
        result[0] = String.valueOf(numer1after); //第一个分子
        result[2] = String.valueOf(numer2after);//第二个分子
        result[1] = String.valueOf(commdenum);  //分母
        result[3] = String.valueOf(commdenum);
        return result;
    }



}
