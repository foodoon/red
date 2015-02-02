package guda.red.common.util;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * Created by foodoon on 2014/12/21.
 */
public class PriceHelper {

    public static String formatCNY(long cent){
        NumberFormat format = NumberFormat.getCurrencyInstance(Locale.CHINA);
        return format.format(cent/100.00);
    }

    public static long format(long cent){
        return cent/100;
    }

    public static void main(String[] args){
        System.out.println(PriceHelper.formatCNY(1203));
    }
}
