package polinom.model;

import java.util.*;

public class OperatiiPolinom {


    public static Polinom addPolinoame(Polinom p1,Polinom p2)
    {
        Polinom res = new Polinom(); // Creează un nou obiect pentru rezultat
        res.getPolinom().putAll(p1.getPolinom());
        for(Map.Entry<Integer,Double> entry2: p2.getPolinom().entrySet())
            if(res.getPolinom().get(entry2.getKey())==null)
                res.addMonom(entry2.getKey(), entry2.getValue());
           else
                res.addMonom(entry2.getKey(), entry2.getValue()+res.getPolinom().get(entry2.getKey()));

        return res;
    }


    public static Polinom substractPolinoame(Polinom p1,Polinom p2)
    {
        Polinom res = new Polinom(); // Creează un nou obiect pentru rezultat
        res.getPolinom().putAll(p1.getPolinom());
        for(Map.Entry<Integer,Double> entry2: p2.getPolinom().entrySet())
            if(res.getPolinom().get(entry2.getKey())==null)
                res.addMonom(entry2.getKey(), -entry2.getValue());
            else
                res.addMonom(entry2.getKey(), res.getPolinom().get(entry2.getKey())-entry2.getValue());

        return res;
    }
    public static Polinom inmultirePolinoame(Polinom p1,Polinom p2)
    {
        Polinom res=new Polinom();
        for(Map.Entry<Integer,Double> entry2: p2.getPolinom().entrySet())
            for(Map.Entry<Integer,Double> entry: p1.getPolinom().entrySet())
                if(res.getPolinom().get(entry.getKey()+entry2.getKey())==null)
               res.addMonom(entry.getKey()+entry2.getKey(),entry2.getValue()*entry.getValue());
               else res.addMonom(entry.getKey()+entry2.getKey(),res.getPolinom().get(entry.getKey()+entry2.getKey())+entry2.getValue()*entry.getValue());
        return res;
    }
    public static Polinom derivarePolinom(Polinom p1)
    {
        Polinom res=new Polinom();
        for(Map.Entry<Integer,Double> entry: p1.getPolinom().entrySet())
            if(entry.getKey()==0)
                res.addMonom(entry.getKey(),0.0);
           else
                res.addMonom(entry.getKey()-1,entry.getValue()*entry.getKey());
        return res;
    }
    public static Polinom integrarePolinom(Polinom p1)
    {
        Polinom res=new Polinom();
        for(Map.Entry<Integer,Double> entry: p1.getPolinom().entrySet())
                res.addMonom(entry.getKey()+1,entry.getValue()/(entry.getKey()+1));
        return res;
    }
    public static List<Map<Integer, Double>> impartirePolinoame(Polinom p1, Polinom p2)
    {
        TreeMap<Integer, Double> deimpartit;
        TreeMap<Integer, Double> impartitor;
        if(p1.getGrad()>p2.getGrad()) {
             deimpartit = new TreeMap<>(Collections.reverseOrder());
            deimpartit.putAll(p1.getPolinom());
            impartitor = new TreeMap<>(Collections.reverseOrder());
            impartitor.putAll(p2.getPolinom());
        }
        else{
            deimpartit = new TreeMap<>(Collections.reverseOrder());
            deimpartit.putAll(p2.getPolinom());
            impartitor = new TreeMap<>(Collections.reverseOrder());
            impartitor.putAll(p1.getPolinom());
        }
        TreeMap<Integer, Double> rezultat= new TreeMap<>(Collections.reverseOrder());
        TreeMap<Integer, Double> rest= new TreeMap<>(deimpartit);

        while(!rest.isEmpty() && rest.firstKey()>= impartitor.firstKey()  )
        {

            int putereTermenDividend = rest.keySet().iterator().next();
            Double coeficientTermenDividend = rest.get(putereTermenDividend);
            int putereTermenImpartitor = impartitor.keySet().iterator().next();
            Double coeficientTermenImpartitor = impartitor.get(putereTermenImpartitor);

            int putereNoua = putereTermenDividend - putereTermenImpartitor;
            Double coeficientNou = coeficientTermenDividend / coeficientTermenImpartitor;

            rezultat.put(putereNoua, coeficientNou);


            // Actualizarea restului
            for (Map.Entry<Integer, Double> entry : impartitor.entrySet()) {
                int putereImpartitor = entry.getKey();
                Double coeficientImpartitor = entry.getValue();
                Double coeficientDeScazut = coeficientNou * coeficientImpartitor;
                int putereDeScazut = putereNoua + putereImpartitor;
                if (rest.containsKey(putereDeScazut)) {
                    Double coeficientVechi = rest.get(putereDeScazut);
                    Double coeficientNouRest = coeficientVechi - coeficientDeScazut;
                    int coeficientNouRest2 = coeficientVechi.intValue() - coeficientDeScazut.intValue();

                    if (coeficientNouRest2 == 0) {
                       rest.remove(putereDeScazut);
                    } else {
                        rest.put(putereDeScazut, coeficientNouRest);
                    }
                }
                else {
                    rest.put(putereDeScazut, -coeficientDeScazut);
                }

            }
        }

        TreeMap<Integer, Double> rezultat2= new TreeMap<>(Comparator.naturalOrder());
        rezultat2.putAll(rezultat);
        TreeMap<Integer, Double> rest2= new TreeMap<>(Comparator.naturalOrder());
        if(!rest.isEmpty())
           rest2.putAll(rest);
        else rest2.put(0,0.0);
        List<Map<Integer, Double>> maps = new ArrayList<>();
        maps.add(rezultat2);
        maps.add(rest2);
        return maps;
    }

}
