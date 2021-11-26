package com.example.cacular01.tools.unitchanger;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.HashMap;
import java.util.Map;

public enum Length implements Unit{

    KM("千米","1000"),M("米","1"),DM("分米","0.1"),CM("厘米","0.01"),MM("毫米","0.001"),UM("微米","0.000001"),NM("纳米","0.000000001"),
    CUN("寸","0.033"),CI("尺","0.333");
    /*
    *
    * */
    private static final Map<String,Length> lengthMap = new HashMap<String,Length>();
    private String name;
    private String toRightDis;
    private Length(String name, String toRightDis)
    {
        this.setName(name);
        this.setToRightDis(toRightDis);

    }
    //静态代码块,可以帮助我们初始化Map中的值
    static{
        lengthMap.put("千米", KM);
        lengthMap.put("米", M);
        lengthMap.put("分米", DM);
        lengthMap.put("厘米", CM);
        lengthMap.put("毫米", MM);
        lengthMap.put("寸", CUN);
        lengthMap.put("纳米", NM);
        lengthMap.put("微米", UM);
        lengthMap.put("尺", CI);
    }

    public static Map<String, Length> getLengthMap() {
        return lengthMap;
    }

    private void setToRightDis(String toRightDis) {
        this.toRightDis = toRightDis;
    }

    private void setName(String name)
    {
        this.name = name;
    }

    @Override
    public String Transforming(String value, String name1, String name2) {
        BigDecimal v1 = new BigDecimal(toStandard(name1,value));
        BigDecimal digs = new BigDecimal(getToRightDig(name2));
        v1 = v1.divide(digs, MathContext.DECIMAL32);
        return v1.toString();
    }

    public String getToRightDig(String name2) {
        return Length.getLengthMap().get(name2).getToRightDis();
    }

    public String toStandard(String name1, String value) {
        ;
        BigDecimal digs  = new BigDecimal(getToRightDig(name1));
        BigDecimal v1 = new BigDecimal(value);
        v1 = v1.multiply(digs);
        return v1.toString();
    }

    public String getName() {
        return name;
    }

    public String getToRightDis()
    {
        return toRightDis;
    }


}
