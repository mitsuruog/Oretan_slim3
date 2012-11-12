package com.mitsuruog.gae.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     *
     * @param start
     * @param end
     * @param targer
     * @return
     */
    public boolean isActiveTime(Date start, Date end, Date target) {
        return ((start.equals(target) || start.before(target))
                    && (end.equals(target) || end.after(target))) ? true : false;
    }

    public Date getJSTDate(String text, String pattern){
        return org.slim3.util.DateUtil.toDate(text, pattern);
    }

    public Date getJSTDate(Date date){
        String pattern = "yyyy/MM/dd HH:mm:ss";
        SimpleDateFormat f = new SimpleDateFormat(pattern);
        return org.slim3.util.DateUtil.toDate(f.format(date), pattern);
    }
    public String getJSTDate(Date date, String pattern){
        return org.slim3.util.DateUtil.toString(date, pattern);
    }
}
