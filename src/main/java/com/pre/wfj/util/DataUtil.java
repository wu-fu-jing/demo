package com.pre.wfj.util;

import cn.hutool.core.date.DatePattern;
import cn.hutool.core.date.DateTime;

public class DataUtil {
     public static String getData(String data) {
        String month2 = null;
        String day2 = null;
        DateTime dateTime = new DateTime( data, DatePattern.NORM_DATETIME_FORMAT);
        int year = dateTime.year();
        int month = dateTime.month() + 1;
        int day = dateTime.dayOfMonth();
        if (month < 10) {
            month2 = "0" + month;
        } else {
            month2 = month + "";
        }
        if (day < 10) {
            day2 = "0" + day;
        } else {
            day2 = day + "";
        }
        String riqi=year+"-"+month2+"-"+day2;
        return riqi;
    }
}
