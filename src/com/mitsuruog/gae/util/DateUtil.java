package com.mitsuruog.gae.util;

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
}
