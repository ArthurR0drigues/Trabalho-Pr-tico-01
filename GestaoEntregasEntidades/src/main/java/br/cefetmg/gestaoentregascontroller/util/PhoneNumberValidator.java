package br.cefetmg.gestaoentregascontroller.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {
    
    private static final String PHONE_NUMBER_PATTERN = "^\\d{10}$";

    public boolean vef(String phoneNumber) {
        Pattern pattern = Pattern.compile(PHONE_NUMBER_PATTERN);
        Matcher matcher = pattern.matcher(phoneNumber);
        return matcher.matches();
    }
}
