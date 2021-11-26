package com.example.tablayouttest02.unitchanger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public enum Temperature implements Unit{
  C("摄氏度","-273.15"),K("开尔文","0"),F("华氏度","-459.67");
    private String minimum;
    private String name;
    private static final Map<String,Temperature> TEMPERATURE_MAP = new HashMap<>();
    static{
        TEMPERATURE_MAP.put("摄氏度",C);
        TEMPERATURE_MAP.put("开尔文",K);
        TEMPERATURE_MAP.put("华氏度",F);

    }
    public static Temperature getTemperatureUnit(String name)
    {
        return Temperature.getTempertureMap().get(name);
    }
    public static Map<String,Temperature> getTempertureMap()
    {
        return TEMPERATURE_MAP;
    }
    private Temperature(String name,String minimum) {
        this.setName(name);
        this.setMinimum(minimum);
    }

    private void setMinimum(String minimum) {
        this.minimum = minimum;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public String toStandard(String name1, String value) {
        BigDecimal bigDecimal = new BigDecimal(value);
        switch (name1){
            case "摄氏度":
                break;
            case "华氏度":

                BigDecimal bigDecimal1 = new BigDecimal("-32");
                BigDecimal bigDecimal2 = new BigDecimal("1.8");
                bigDecimal = bigDecimal.add(bigDecimal1).divide(bigDecimal2, MathContext.DECIMAL32);
                value = bigDecimal.toString();
                break;
            case "开尔文":
                BigDecimal bigDecimal3 = new BigDecimal("-273.15");
                value = bigDecimal.add(bigDecimal3).toString();
                break;
        }

        return value;
    }
    private boolean isRightTem(String value)
    {
        if(Double.valueOf(value)<-273.15)
        {
            return false;
        }
        return true;
    }
    @Override
    public String getToRightDig(String name2) {
        return null;
    }

    @Override
    public String Transforming(String value, String name1, String name2) {
        if(name1.equals(name2)&&!name1.isEmpty())
        {
            return value;
        }
        value = toStandard(name1,value);
       BigDecimal bigDecimal = new BigDecimal(value);
        if (isRightTem(value))
        {
            switch (name2){
                case "摄氏度":
                    break;
                case "华氏度":
                    BigDecimal bigDecimal1 = new BigDecimal("32");
                    BigDecimal bigDecimal2 = new BigDecimal("1.8");
                    bigDecimal = (bigDecimal.multiply(bigDecimal2)).add(bigDecimal1);
                    value = bigDecimal.toString();
                    break;
                case "开尔文":
                    BigDecimal bigDecimal3 = new BigDecimal("273.15");
                    value = bigDecimal.add(bigDecimal3).toString();
                    break;
            }
            return value;
        }else{
            return "!!温度值低于绝对零度!!";
        }


    }
}
