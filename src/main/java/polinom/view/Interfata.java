package polinom.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class Interfata extends JFrame{
    private JTextField polinom1;
    private JTextField polinom2;
    private JButton clearPolinom1;
    private JButton clearPolinom2;
    private JButton addButton;
    private JButton substractButton;
    private JButton multiplyButton;
    private JButton divideButton;
    private JButton derivareButton;
    private JButton integrareButton;
    private JTextField polinomRezultat;
    private JTextField polinomRest;
    private JButton clearAll;

    private JPanel InterfataCalculator;
    private JLabel p1text;
    private JLabel p2text;
    private JLabel reztext;
    private JLabel rez2text;
    private JLabel titlutext;


    public Interfata()
    {
        p1text.setForeground(Color.WHITE);
        p2text.setForeground(Color.WHITE);
        rez2text.setForeground(Color.WHITE);
        reztext.setForeground(Color.WHITE);
        titlutext.setForeground(Color.WHITE);
       setTitle("Calculator Polinoame");
        setContentPane(InterfataCalculator);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(new Dimension(600,300));
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JTextField getPolinomRest() {
        return polinomRest;
    }


    public void resetP1() {
        polinomRezultat.setText("");
        polinomRest.setText("");
        polinom1.setText("");
    }
    public void resetP2() {
        polinomRezultat.setText("");
        polinomRest.setText("");
        polinom2.setText("");
    }
    public   void resetAll()
    {
        polinomRezultat.setText("");
        polinomRest.setText("");
        polinom2.setText("");
        polinom1.setText("");
    }
    public  String getUserInput1() {
        return polinom1.getText();
    }
    public  String getUserInput2() {
        return polinom2.getText();
    }

    public  void setTotal1(String newTotal) {
        polinomRezultat.setText(newTotal);
    }
    public  void setTotal2(String newTotal) {
        polinomRest.setText(newTotal);
    }
    public  void showError(String errMessage) {
        JOptionPane.showMessageDialog(this, errMessage);
    }

    public  void addMultiplyListener(ActionListener mal) {

        multiplyButton.addActionListener(mal);
    }
    public  void addAddListener(ActionListener mal) {

        addButton.addActionListener(mal);
    }
    public void addClearPolinom1Listener(ActionListener cal) {

        clearPolinom1.addActionListener(cal);
    }
    public  void addClearPolinom2Listener(ActionListener cal) {

        clearPolinom2.addActionListener(cal);
    }
    public  void addClearAllListener(ActionListener cal) {

        clearAll.addActionListener(cal);
    }
    public  void addSubstractListener(ActionListener cal) {

        substractButton.addActionListener(cal);
    }
    public  void addDivideListener(ActionListener cal) {

        divideButton.addActionListener(cal);
    }
    public void addIntegrareListener(ActionListener cal) {

        integrareButton.addActionListener(cal);
    }
    public  void addDerivareListener(ActionListener cal) {

        derivareButton.addActionListener(cal);
    }
}
