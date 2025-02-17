package polinom.model;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Polinom {
    private Map<Integer, Double> polinom;
    public Polinom()
    {
        polinom=new HashMap<>();

    }
   public void addMonom(Integer grad, Double coeficient)
   {
       polinom.put(grad,coeficient);
   }


    public Map<Integer, Double> getPolinom() {
        return polinom;
    }
    public Integer getGrad()
    {
        Integer max=0;
        for(Map.Entry<Integer,Double> entry: polinom.entrySet())
            if(entry.getKey()>max)
                max=entry.getKey();
        return max;
    }

    public void setPolinom(Map<Integer, Double> polinom) {
        this.polinom = polinom;
    }
    @Override
    public boolean equals(Object o)
    {
        Polinom p=(Polinom)o;
        for (Map.Entry<Integer, Double> entry : p.polinom.entrySet()) {
            if (this.polinom.get(entry.getKey())!=null&&this.polinom.get(entry.getKey()).equals(entry.getValue()) ==false)
                return false;
        }
        return true;
    }

    @Override
    public String toString() {

           String StringDeAfisat="";
            Iterator<Map.Entry<Integer,Double>> iterator=polinom.entrySet().iterator();
            Map.Entry<Integer,Double>entry=iterator.next();
            int primul=1;
            if(entry.getValue()!=0) {
                primul=0;
                if (entry.getKey() == 0)

                    StringDeAfisat=StringDeAfisat.concat(String.valueOf(entry.getValue().intValue()));
                else if (entry.getKey() == 1) {
                    if (entry.getValue() == 1)

                        StringDeAfisat=StringDeAfisat.concat("x");
                    else if (entry.getValue() == -1)

                        StringDeAfisat=StringDeAfisat.concat("-x");
                    else
                        StringDeAfisat=StringDeAfisat.concat(String.valueOf(entry.getValue().intValue())+"x");
                } else {

                    if (entry.getValue() == 1)

                        StringDeAfisat=StringDeAfisat.concat("x");
                    else if (entry.getValue() == -1)

                        StringDeAfisat=StringDeAfisat.concat("-x");
                    else
                        StringDeAfisat=StringDeAfisat.concat(String.valueOf(entry.getValue().intValue())+"x");
                    if (entry.getKey() > 1)

                        StringDeAfisat=StringDeAfisat.concat("^"+String.valueOf(entry.getKey()));
                }


            }
            while(iterator.hasNext())
            {
                entry=iterator.next();
                if(entry.getValue()!=0) {
                    if (entry.getValue() > 0) {
                        if(primul==0) {

                            if (entry.getValue() == 1)

                                StringDeAfisat=StringDeAfisat.concat("+x");

                            else
                                StringDeAfisat=StringDeAfisat.concat("+"+String.valueOf(entry.getValue().intValue())+"x");

                        }
                        else {
                            primul=0;
                            if (entry.getValue() == 1)

                                StringDeAfisat=StringDeAfisat.concat("x");
                            else
                                StringDeAfisat=StringDeAfisat.concat(String.valueOf(entry.getValue().intValue())+"x");

                        }

                        if (entry.getKey() > 1)

                            StringDeAfisat=StringDeAfisat.concat("^"+String.valueOf(entry.getKey()));


                    } else {
                        primul=0;
                        if (entry.getValue() == -1)

                            StringDeAfisat=StringDeAfisat.concat("-x");

                        else
                            StringDeAfisat=StringDeAfisat.concat(String.valueOf(entry.getValue().intValue())+"x");


                        if (entry.getKey() > 1)

                            StringDeAfisat=StringDeAfisat.concat("^"+String.valueOf(entry.getKey()));

                    }

                }
            }
            if(primul==1)

                StringDeAfisat=StringDeAfisat.concat("0");


        return StringDeAfisat;
    }
    public String toStringDouble() {

        String StringDeAfisat="";
        Iterator<Map.Entry<Integer,Double>> iterator=polinom.entrySet().iterator();
        Map.Entry<Integer,Double>entry=iterator.next();
        int primul=1;
        if(entry.getValue()!=0) {
            Double valoare=entry.getValue();
            DecimalFormat df = new DecimalFormat("#.##");
            String valoareFormata = df.format(valoare);
            primul=0;
            if (entry.getKey() == 0)

                StringDeAfisat=StringDeAfisat.concat(String.valueOf(valoareFormata));
            else if (entry.getKey() == 1) {
                if (entry.getValue() == 1)

                    StringDeAfisat=StringDeAfisat.concat("x");
                else if (entry.getValue() == -1)

                    StringDeAfisat=StringDeAfisat.concat("-x");
                else
                    StringDeAfisat=StringDeAfisat.concat(String.valueOf(valoareFormata)+"x");
            } else {

                if (entry.getValue() == 1)

                    StringDeAfisat=StringDeAfisat.concat("x");
                else if (entry.getValue() == -1)

                    StringDeAfisat=StringDeAfisat.concat("-x");
                else
                    StringDeAfisat=StringDeAfisat.concat(String.valueOf(valoareFormata)+"x");
                if (entry.getKey() > 1)

                    StringDeAfisat=StringDeAfisat.concat("^"+String.valueOf(entry.getKey()));
            }


        }
        while(iterator.hasNext())
        {
            entry=iterator.next();
            Double valoare=entry.getValue();
            DecimalFormat df = new DecimalFormat("#.##");
            String valoareFormata = df.format(valoare);
            if(entry.getValue()!=0) {
                if (entry.getValue() > 0) {
                    if(primul==0) {

                        if (entry.getValue() == 1)

                            StringDeAfisat=StringDeAfisat.concat("+x");

                        else
                            StringDeAfisat=StringDeAfisat.concat("+"+String.valueOf(valoareFormata)+"x");

                    }
                    else {
                        primul=0;
                        if (entry.getValue() == 1)

                            StringDeAfisat=StringDeAfisat.concat("x");
                        else
                            StringDeAfisat=StringDeAfisat.concat(String.valueOf(valoareFormata)+"x");

                    }

                    if (entry.getKey() > 1)

                        StringDeAfisat=StringDeAfisat.concat("^"+String.valueOf(entry.getKey()));


                } else {
                    primul=0;
                    if (entry.getValue() == -1)

                        StringDeAfisat=StringDeAfisat.concat("-x");

                    else
                        StringDeAfisat=StringDeAfisat.concat(String.valueOf(valoareFormata)+"x");


                    if (entry.getKey() > 1)

                        StringDeAfisat=StringDeAfisat.concat("^"+String.valueOf(entry.getKey()));

                }

            }
        }
        if(primul==1)

            StringDeAfisat=StringDeAfisat.concat("0");


        return StringDeAfisat;
    }
}
