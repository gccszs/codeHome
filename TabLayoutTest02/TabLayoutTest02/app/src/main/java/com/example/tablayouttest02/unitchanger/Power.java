package com.example.tablayouttest02.unitchanger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public enum Power implements Unit{

    W("瓦","1"),KW("千瓦","1000"),MALI("马力","735.5");
    private String name;
    private String toRightDis;
    private static final Map<String,Power> powerMap = new HashMap<>();
    static{
        powerMap.put("瓦",W);
        powerMap.put("千瓦",KW);
        powerMap.put("马力",MALI);
    }
    public static Power getPowerUnit(String name)
    {
        return getPowerMap().get(name);
    }
    public static Map<String,Power> getPowerMap()
    {
        return powerMap;
    }
    private Power(String name,String toRightDis)
    {
        this.setName(name);
        this.setToRightDis(toRightDis);
    }

    private String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public String getToRightDis() {
        return toRightDis;
    }

    public void setToRightDis(String toRightDis) {
        this.toRightDis = toRightDis;
    }

    @Override
    public String toStandard(String name1, String value) {
        BigDecimal digs  = new BigDecimal(getToRightDig(name1));
        BigDecimal v1 = new BigDecimal(value);
        v1 = v1.multiply(digs);
        return v1.toString();
    }

    @Override
    public String getToRightDig(String name2) {
        return Power.getPowerMap().get(name2).getToRightDis();
    }

    @Override
    public String Transforming(String value, String name1, String name2) {
        if(name1.equals(name2)&&!name1.isEmpty())
        {
            return value;
        }
        BigDecimal v1 = new BigDecimal(toStandard(name1,value));
        BigDecimal digs = new BigDecimal(getToRightDig(name2));
        v1 = v1.divide(digs, MathContext.DECIMAL32);
        return v1.toString();
    }
}
