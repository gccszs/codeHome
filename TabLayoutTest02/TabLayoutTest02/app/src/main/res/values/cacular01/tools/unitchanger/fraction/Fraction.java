package com.example.cacular01.tools.unitchanger.fraction;


public class Fraction {
    private long numeration;
    private long denominator;
    private boolean isRight = true;
    public Fraction(String numeration, String denominator) {
        this.numeration = Long.valueOf(numeration);
        this.denominator = Long.valueOf(denominator);
        if(this.denominator == 0)
        {
            this.isRight = false;
        }
    }

    public long getNumeration() {
        return numeration;
    }

    public void setNumeration(long numeration) {
        this.numeration = numeration;
    }

    public long getDenominator() {
        return denominator;
    }

    public void setDenominator(long denominator) {
        this.denominator = denominator;
    }

    public boolean isRight() {
        return isRight;
    }
}
