package com.example.cacular01.tools.unitchanger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public enum Merit implements Unit{
    J("焦耳","1"),Calorie("卡","4.19"),KJ("千焦","1000"),
    KWH("千瓦·时","3.6E+6"),DU("度","3.6E+6"),
    Pao("标准操场慢跑一圈","6035"),
    KCaloreie("千卡","4185.85"),Fat("脂肪·克","37672.67"),
    Thin("瘦一斤","3.767E+7");
    private String name;
    private String toRightDis;
    private static final Map<String,Merit> MeritMap = new HashMap<>();
    static{
        MeritMap.put("焦耳",J);
        MeritMap.put("卡路里",Calorie);
        MeritMap.put("千焦",KJ);
        MeritMap.put("千瓦·时",KWH);
        MeritMap.put("度",DU);
        MeritMap.put("标准操场慢跑一圈",Pao);
        MeritMap.put("千卡",KCaloreie);
        MeritMap.put("脂肪·克",Fat);
        MeritMap.put("瘦一斤",Thin);
    }
    public static Merit getMeritUnit(String name)
    {
        return getMeritMap().get(name);
    }
    public static Map<String,Merit> getMeritMap()
    {
        return MeritMap;
    }
    private Merit(String name,String toRightDis)
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
        return Merit.getMeritMap().get(name2).getToRightDis();
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
