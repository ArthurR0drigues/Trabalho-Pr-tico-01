package br.cefetmg.gestaoentregascontroller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPFValidator {
    
    private static final String CPF_PATTERN = "^\\d{11}$";

    public boolean vef(String cpf) {
        Pattern pattern = Pattern.compile(CPF_PATTERN);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }
}
