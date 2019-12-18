package br.com.maccommerce.paymentservice.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public enum DateFormat {

    CREDIT_CARD_EXPIRATION_DATE("MM/AAAA");

    DateFormat(String dateFormat) {
        this.dateFormatter = new SimpleDateFormat(dateFormat);
    }

    private final SimpleDateFormat dateFormatter;

    public String format(Date date) {
        return dateFormatter.format(date);
    }

    public Date parse(String date) {
        try {
            return dateFormatter.parse(date);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

}
