package com.example.tablayouttest02.unitchanger;

public class ScientistDemo {
    private static int HASTEN = 1;
    private static int HASE = 0;
    public static String StandardScienceDig(String Dig,int MODLE)
    {
        int Epos = Dig.indexOf("E");
        int mpos = Dig.indexOf("-");
        int apos = Dig.indexOf("+");
        if(Epos == -1)
        {
            return Dig;
        }
      StringBuilder digdealer = new StringBuilder(Dig);
      switch (MODLE)
      {
          case 1:
              if(mpos!=-1&&mpos>Epos)
                  digdealer.replace(Epos,Epos+2,"*10^-");
              else
                  digdealer.replace(Epos,Epos+2,"*10^");
              break;
          case 2:
              if(apos!=-1)
                  digdealer.delete(Epos+1,Epos+2);
              else
                  digdealer.delete(Epos+1,Epos+1);
              break;
      }

      return digdealer.toString();
    }

    public static void main(String[] args) {
        String s = "7.123345E+1231";
        System.out.printf(" " +ScientistDemo.StandardScienceDig(s, 2));
    }
}
