package br.com.cassi.helper;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class CassiJsonHelper {
    public static ObjectMapper getObjectMapper() {
        ObjectMapper mapper = new ObjectMapper();
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        mapper.setDateFormat(df);

        return mapper;
    }
}
