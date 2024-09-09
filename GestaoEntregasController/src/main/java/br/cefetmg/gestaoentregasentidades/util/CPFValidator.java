package br.cefetmg.gestaoentregasentidades.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CPFValidator {
    
    private static final String CPF_PATTERN = "^\\d{11}$";

    public static boolean vef(String cpf) {
        Pattern pattern = Pattern.compile(CPF_PATTERN);
        Matcher matcher = pattern.matcher(cpf);
        return matcher.matches();
    }
}
