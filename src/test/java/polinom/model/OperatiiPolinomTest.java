package polinom.model;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class OperatiiPolinomTest {

    @Test
    void aduna1()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        p2.addMonom(2,3.0);
        p2.addMonom(1,-1.0);
        p1.addMonom(2,7.0);
        p1.addMonom(0,-1.0);
        p3.addMonom(2,10.0);
        p3.addMonom(1,-1.0);
        p3.addMonom(0,-1.0);
        assertEquals(p3,OperatiiPolinom.addPolinoame(p1,p2));
    }
    @Test
    void aduna2()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        p1.addMonom(2,3.0);
        p1.addMonom(1,-1.0);
        p2.addMonom(0,0.0);
        p3.addMonom(2,3.0);
        p3.addMonom(1,-1.0);
        assertEquals(p3,OperatiiPolinom.addPolinoame(p1,p2));
    }

    @Test
    void aduna3()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();

        p2.addMonom(0,0.0);
        p1.addMonom(0,0.0);
        p3.addMonom(0,0.0);

        assertEquals(p3,OperatiiPolinom.addPolinoame(p1,p2));
    }
    @Test
    void aduna4()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();

        p2.addMonom(0,1.0);
        p1.addMonom(0,1.0);
        p3.addMonom(0,2.0);

        assertEquals(p3,OperatiiPolinom.addPolinoame(p1,p2));
    }
    @Test
    void scade1()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();

        p2.addMonom(0,1.0);
        p1.addMonom(0,1.0);
        p3.addMonom(0,0.0);

        assertEquals(p3,OperatiiPolinom.substractPolinoame(p1,p2));
    }
    @Test
    void scade2()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();

        p2.addMonom(0,1.0);
        p2.addMonom(2,1.0);
        p1.addMonom(0,1.0);
        p1.addMonom(2,1.0);
        p3.addMonom(0,0.0);
        assertEquals(p3,OperatiiPolinom.substractPolinoame(p1,p2));
    }
    @Test
    void scade3()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        p2.addMonom(0,1.0);
        p2.addMonom(2,1.0);
        p2.addMonom(3,1.0);
        p1.addMonom(0,1.0);
        p1.addMonom(2,1.0);
        p3.addMonom(3,-1.0);
        assertEquals(p3,OperatiiPolinom.substractPolinoame(p1,p2));
    }
    @Test
    void inmulteste1()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        p2.addMonom(0,0.0);
        p1.addMonom(0,1.0);
        p1.addMonom(2,1.0);
        p3.addMonom(0,0.0);
        assertEquals(p3,OperatiiPolinom.inmultirePolinoame(p1,p2));
    }
    @Test
    void inmulteste2()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        p2.addMonom(0,1.0);
        p1.addMonom(0,1.0);
        p1.addMonom(2,1.0);
        p3.addMonom(0,1.0);
        p3.addMonom(2,1.0);
        assertEquals(p3,OperatiiPolinom.inmultirePolinoame(p1,p2));
    }
    @Test
    void inmulteste3()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        p2.addMonom(0,-1.0);
        p2.addMonom(1,1.0);
        p1.addMonom(0,1.0);
        p1.addMonom(1,1.0);
        p3.addMonom(0,-1.0);
        p3.addMonom(2,1.0);
        assertEquals(p3,OperatiiPolinom.inmultirePolinoame(p1,p2));
    }
    @Test
    void imparte1()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        var p4=new Polinom();
        p2.addMonom(2,3.0);
        p2.addMonom(1,-1.0);
        p1.addMonom(2,3.0);
        p1.addMonom(1,-1.0);
        p3.addMonom(0,0.0);
        p4.addMonom(0,1.0);

        List<Map< Integer,Double>> maps = OperatiiPolinom.impartirePolinoame(p1,p2);
        Polinom cat=new Polinom();
        cat.setPolinom(maps.get(0));
        Polinom rest=new Polinom();
        rest.setPolinom(maps.get(1));
        assertEquals(p3,rest);
        assertEquals(p4,cat);
    }

    @Test
    void imparte2()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        var p4=new Polinom();
        p2.addMonom(2,3.0);
        p2.addMonom(1,-1.0);
        p1.addMonom(0,0.0);
        p3.addMonom(0,0.0);
        p4.addMonom(0,0.0);

        List<Map< Integer,Double>> maps = OperatiiPolinom.impartirePolinoame(p1,p2);
        Polinom cat=new Polinom();
        cat.setPolinom(maps.get(0));
        Polinom rest=new Polinom();
        rest.setPolinom(maps.get(1));
        assertEquals(p3,rest);
        assertEquals(p4,cat);
    }


    @Test
    void imparte3()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        var p3=new Polinom();
        var p4=new Polinom();
        p2.addMonom(3,1.0);
        p2.addMonom(2,-2.0);
        p2.addMonom(1,6.0);
        p2.addMonom(0,-5.0);
        p1.addMonom(2,1.0);
        p1.addMonom(0,-1.0);
        p3.addMonom(1,7.0);
        p3.addMonom(0,-7.0);
        p4.addMonom(1,1.0);
        p4.addMonom(0,-2.0);

        List<Map< Integer,Double>> maps = OperatiiPolinom.impartirePolinoame(p1,p2);
        Polinom cat=new Polinom();
        cat.setPolinom(maps.get(0));
        Polinom rest=new Polinom();
        rest.setPolinom(maps.get(1));
        assertEquals(p3,rest);
        assertEquals(p4,cat);
    }
    @Test
    void deriveaza()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        p2.addMonom(1,2.0);
        p1.addMonom(2,1.0);
        p1.addMonom(0,-1.0);
        assertEquals(p2,OperatiiPolinom.derivarePolinom(p1));
    }
    @Test
    void integreaza()
    {
        var p1=new Polinom();
        var p2=new Polinom();
        p2.addMonom(2,1.0);
        p1.addMonom(2,3.0);
        p1.addMonom(0,-1.0);
        assertEquals(p2,OperatiiPolinom.integrarePolinom(p1));
    }
}