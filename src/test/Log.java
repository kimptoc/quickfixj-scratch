package test;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by kimptoc on 16/01/2014.
 */
public class Log {

    public static void debug(Object thing)
    {
        Date d = new Date();
        DateFormat df = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.MEDIUM);
        System.out.println(df.format(d)+":"+thing.toString());
    }

}
