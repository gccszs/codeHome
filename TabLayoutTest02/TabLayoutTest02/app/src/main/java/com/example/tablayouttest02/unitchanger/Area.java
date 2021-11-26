package com.example.tablayouttest02.unitchanger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public enum Area implements Unit{

    KM2("平方千米","1000000"),GonQin("公顷","10000"),Mu("亩","666.667"),M2("平方米","1"),
    DM2("平方分米","0.01"),CM2("平方厘米","0.00001");
    private String name;
    private String toRightDis;
    private static final Map<String,Area> areaMap = new HashMap<>();
    private Area(String name, String toRightDis) {
        this.setName(name);
        this.setToRightDis(toRightDis);
    }
    static {
        areaMap.put("平方千米", KM2);
        areaMap.put("公顷", GonQin);
        areaMap.put("亩", Mu);
        areaMap.put("平方米", M2);
        areaMap.put("平方分米", DM2);
        areaMap.put("平方厘米", CM2);
    }
    public static Area getAreaUnit(String name)
    {
        return getAreaMap().get(name);
    }

   private void setName(String name) {
        this.name = name;
    }

    private void setToRightDis(String toRightDis) {
        this.toRightDis = toRightDis;
    }

    public String getName() {
        return name;
    }

    public String getToRightDis() {
        return toRightDis;
    }

    public static Map<String, Area> getAreaMap() {
        return areaMap;
    }


    @Override
    public String toStandard(String name1, String value) {
        BigDecimal digs  = new BigDecimal(getToRightDig(name1));
        BigDecimal v1 = new BigDecimal(value);
        v1 = v1.multiply(digs, MathContext.DECIMAL32);
        return v1.toString();
    }
    @Override
    public String Transforming(String value, String name1, String name2) {
        if(name1.equals(name2)&&!name1.isEmpty())
        {
            return value;
        }
        BigDecimal v1 = new BigDecimal(toStandard(name1,value));
        BigDecimal digs = new BigDecimal(getToRightDig(name2));
        v1 = v1.divide(digs,MathContext.DECIMAL32);
        return v1.toString();
    }
    @Override
    public String getToRightDig(String name2) {
        return areaMap.get(name2).getToRightDis();
    }


}
