package br.com.cassi.helper;

public class StringHelper {
    public static boolean isNullOrBlank(String param) {
        return param == null || param.trim().length() == 0;
    }
}
