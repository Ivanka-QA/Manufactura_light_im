package io.testomat.manufactura_light_im.utils;

public class StringParsers {

    public static Integer parseIntegerFromString(String textWithDigits) {

        String digitText = textWithDigits.replaceAll("\\D+", "");
        return Integer.parseInt(digitText);

    }

}
