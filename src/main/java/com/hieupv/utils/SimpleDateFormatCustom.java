package com.hieupv.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class SimpleDateFormatCustom {
    public String formatDate(Timestamp timestamp){
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(timestamp);
    }
}
