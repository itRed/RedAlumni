package com.red.alumni.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

    /**
     * 返回unix时间戳
     * @return
     */
    public static long getUnixTimestamp() {
        return (long) (System.currentTimeMillis() / 1000l);
    }

    /**
     * 将unix时间戳转换至指定格式的时间字符串
     * @param time 时间戳 1431314422
     * @param format 日期格式，如yyyy-MM-dd HH:mm
     * @return
     */
    public static String fromUnixtime(int time, String format) {
        SimpleDateFormat sdf = new SimpleDateFormat(format);
        Date date = new Date(time * 1000l);
        return sdf.format(date);
    }
}
