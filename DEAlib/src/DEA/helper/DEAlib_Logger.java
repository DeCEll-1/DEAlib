package DEA.helper;

import com.fs.starfarer.api.Global;

public class DEAlib_Logger {

    /**
     * logs stuff. <br/>
     * returns true if logged, othervise false
     */
    public static boolean log(Class myClass, String val1, String val2, String val3) {
        try {
            Global.getLogger(myClass).info(val1 + val2 + val3);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * logs stuff. <br/>
     * returns true if logged, othervise false
     */
    public static boolean log(Class myClass, String val1, String val2) {
        try {
            Global.getLogger(myClass).info(val1+val2);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

    /**
     * logs stuff. <br/>
     * returns true if logged, othervise false
     */
    public static boolean log(Class myClass, String val1) {
        try {
            Global.getLogger(myClass).info(val1);
            return true;
        } catch (Exception ex) {
            return false;
        }
    }

}
