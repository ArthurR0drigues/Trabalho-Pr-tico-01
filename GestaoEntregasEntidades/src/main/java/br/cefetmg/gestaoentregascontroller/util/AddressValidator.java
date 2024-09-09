package br.cefetmg.gestaoentregascontroller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AddressValidator {
    
    private static final String ADDRESS_PATTERN = "^[a-zA-Z0-9\\s,.-]+$";

    public boolean vef(String address) {
        Pattern pattern = Pattern.compile(ADDRESS_PATTERN);
        Matcher matcher = pattern.matcher(address);
        return matcher.matches();
    }
}