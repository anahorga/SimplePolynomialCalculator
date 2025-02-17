package polinom.controller;

import polinom.model.Polinom;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Rejex {
    public Rejex() {
    }
    public Polinom citirePolinom(String date_intrare) throws Invalid_Input {
        String part1 = "([+-]?[\\d\\.]*[x]?\\^?\\d*)";
        String part2 = "([+-]?[\\d\\.]*)([x]?)\\^?(\\d*)";//a-zA-Z
        Pattern pattern1 = Pattern.compile(part1);
        Matcher matcher1 = pattern1.matcher(date_intrare);
        Polinom polinom_rez = new Polinom();
        boolean condition=true;
        int exp = 0;
        Double coef = 0.0;
        while (!matcher1.hitEnd()) {
            matcher1.find();
            Pattern pattern2 = Pattern.compile(part2);
            Matcher matcher2 = pattern2.matcher(matcher1.group());
            if (matcher2.find()) {
                String coef1 = matcher2.group(1);
                String exp1 = matcher2.group(3);
                String x = matcher2.group(2);
                if (isNumeric(coef1) && isNumeric(exp1) && (!x.equals(""))) {
                    coef = Double.valueOf(coef1);
                    exp = Integer.valueOf(exp1);
                } else if (isNumeric(coef1) && !isNumeric(exp1) && (!x.equals(""))) {
                    coef = Double.valueOf(coef1);
                    exp = 1;
                } else if (isNumeric(coef1) && !isNumeric(exp1) && x.equals("")) {
                    coef = Double.valueOf(coef1);
                    exp = 0;
                } else if (!isNumeric(coef1) && isNumeric(exp1) && (!x.equals(""))) {
                    if (coef1.equals("-")) {
                        coef = -1.0;
                        exp = Integer.valueOf(exp1);
                    } else {
                        coef = 1.0;
                        exp = Integer.valueOf(exp1);
                    }
                } else if (!isNumeric(coef1) && !isNumeric(exp1) && (!x.equals(""))) {
                    if (coef1.equals("-"))
                        coef = -1.0;
                    else
                        coef = 1.0;
                    exp = 1;
                }
                else
                {
                    condition=false;
                }
            }
            polinom_rez.addMonom(exp, coef);
        }
        if(condition==false)
            throw new Invalid_Input("Inputul nu este bun");
        else {

            return polinom_rez;
        }
    }
    public static boolean isNumeric(String str)
    {
        return str.matches("[+-]*\\d*\\.?\\d+");
    }
}
