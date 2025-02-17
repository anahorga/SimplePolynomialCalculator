package polinom.model;

import java.util.List;
import java.util.Map;

public class CalcModel {
    private Polinom rezultat;
    private Polinom rezultat2;//il folosim la impartire, unde avem cat si rest


    public CalcModel()
    {
        reset();
    }
    public void reset()
    {
        rezultat=new Polinom();
        rezultat2=new Polinom();
    }
    public void aduna(Polinom p1,Polinom p2)
    {
        rezultat=OperatiiPolinom.addPolinoame(p1,p2);
    }
    public String getRezultat() {

        return rezultat.toString();
    }
    public String getRestDouble() {

        return rezultat2.toStringDouble();
    }
    public String getRezultatDouble() {

        return rezultat.toStringDouble();
    }
    public void scade(Polinom p1,Polinom p2)
    {
        rezultat=OperatiiPolinom.substractPolinoame(p1,p2);
    }
    public void inmulteste(Polinom p1,Polinom p2)
    {
        rezultat=OperatiiPolinom.inmultirePolinoame(p1,p2);
    }
    public void imparte(Polinom p1,Polinom p2)
    {
        List<Map< Integer,Double>> maps = OperatiiPolinom.impartirePolinoame(p1,p2);
        rezultat.setPolinom(maps.get(0));
        rezultat2.setPolinom(maps.get(1));
    }
    public void deriveaza(Polinom p1)
    {
        rezultat=OperatiiPolinom.derivarePolinom(p1);
    }
    public void integreaza(Polinom p1)
    {
        rezultat=OperatiiPolinom.integrarePolinom(p1);
    }
}
