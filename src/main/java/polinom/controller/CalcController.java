package polinom.controller;

import polinom.model.CalcModel;
import polinom.model.Polinom;
import polinom.view.Interfata;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalcController {
    private CalcModel m_model;
    private Interfata m_view;

    //========================================================== constructor
    /** Constructor */
    public CalcController(CalcModel model, Interfata view) {
        m_model = model;
        m_view  = view;

        //... Add listeners to the view.
        view.addMultiplyListener(new MultiplyListener());
        view.addClearAllListener(new ClearListener());
        view.addAddListener(new AddListener());
        view.addClearPolinom1Listener(new ClearP1Listener());
        view.addClearPolinom2Listener(new ClearP2Listener());
        view.addSubstractListener(new SubstractListener());
        view.addDerivareListener(new DerivareListener());
        view.addIntegrareListener(new IntegrareListener());
        view.addDivideListener(new DivideListener());
    }
    class DerivareListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput1="";

            try
            {
                userInput1=m_view.getUserInput1();
                Polinom p1=new Polinom();
                Rejex r=new Rejex();
                p1=r.citirePolinom(userInput1);
                m_model.deriveaza(p1);
                m_view.setTotal1(m_model.getRezultat());
                m_view.getPolinomRest().setText("");
            }
            catch(Invalid_Input i)
            {
                m_view.showError("Bad input ");
                m_view.resetAll();
            }
        }
    }
    class IntegrareListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String userInput1="";

            try
            {
                userInput1=m_view.getUserInput1();
                Polinom p1=new Polinom();
                Rejex r=new Rejex();
                p1=r.citirePolinom(userInput1);
                m_model.integreaza(p1);
                m_view.setTotal1(m_model.getRezultatDouble());
                m_view.getPolinomRest().setText("");
            }
            catch(Invalid_Input i)
            {
                m_view.showError("Bad input ");
                m_view.resetAll();
            }
        }
    }
    class ClearP1Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.resetP1();
        }
    }
    class ClearP2Listener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.resetP2();
        }
    }
    class DivideListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1="";
            String userInput2="";
            try
            {
                userInput1=m_view.getUserInput1();
                userInput2=m_view.getUserInput2();
                if(userInput1.equals("0")||userInput2.equals("0"))
                {
                    m_view.showError("Bad input ");
                    m_view.resetAll();
                }
                else {
                    Polinom p1 = new Polinom();
                    Rejex r = new Rejex();
                    p1 = r.citirePolinom(userInput1);
                    Polinom p2 = new Polinom();
                    Rejex r2 = new Rejex();
                    p2 = r2.citirePolinom(userInput2);
                    m_model.imparte(p1, p2);
                    m_view.setTotal1(m_model.getRezultatDouble());
                    m_view.setTotal2(m_model.getRestDouble());
                }

            }
            catch(Invalid_Input i)
            {
                m_view.showError("Bad input ");
                m_view.resetAll();
            }

        }
    }
    class MultiplyListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1="";
            String userInput2="";
            try
            {
                userInput1=m_view.getUserInput1();
                userInput2=m_view.getUserInput2();
                Polinom p1=new Polinom();
                Rejex r=new Rejex();
                p1=r.citirePolinom(userInput1);
                Polinom p2=new Polinom();
                Rejex r2=new Rejex();
                p2=r2.citirePolinom(userInput2);
                m_model.inmulteste(p1,p2);
                m_view.setTotal1(m_model.getRezultat());
                m_view.getPolinomRest().setText("");
            }
            catch(Invalid_Input i)
            {
                m_view.showError("Bad input ");
                m_view.resetAll();
            }

        }
    }

    class AddListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1="";
            String userInput2="";
            try
            {
                userInput1=m_view.getUserInput1();
                userInput2=m_view.getUserInput2();
                Polinom p1=new Polinom();
                Rejex r=new Rejex();
                p1=r.citirePolinom(userInput1);
                Polinom p2=new Polinom();
                Rejex r2=new Rejex();
                p2=r2.citirePolinom(userInput2);
                m_model.aduna(p1,p2);
                m_view.setTotal1(m_model.getRezultat());
                m_view.getPolinomRest().setText("");
            }
            catch(Invalid_Input i)
            {
                m_view.showError("Bad input ");
                m_view.resetAll();
            }

        }
    }
    class SubstractListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String userInput1="";
            String userInput2="";
            try
            {
                userInput1=m_view.getUserInput1();
                userInput2=m_view.getUserInput2();
                Polinom p1=new Polinom();
                Rejex r=new Rejex();
                p1=r.citirePolinom(userInput1);
                Polinom p2=new Polinom();
                Rejex r2=new Rejex();
                p2=r2.citirePolinom(userInput2);
                m_model.scade(p1,p2);
                m_view.setTotal1(m_model.getRezultat());
                m_view.getPolinomRest().setText("");
            }
            catch(Invalid_Input i)
            {
                m_view.showError("Bad input ");
                m_view.resetAll();
            }

        }
    }
    class ClearListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            m_model.reset();
            m_view.resetAll();
        }
    }
}
