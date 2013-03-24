package com.valdemar.storytail.util;

import java.math.BigDecimal;
import java.text.DecimalFormat;

/**
 * Created with IntelliJ IDEA.
 * User: valdemar
 * Date: 23-03-2013
 * Time: 22:04
 * To change this template use File | Settings | File Templates.
 */
public class Utils {

    public static double roundLocationWith2DecimalPlaces(double d) {
        BigDecimal bd = new BigDecimal(d);
        BigDecimal rounded = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return rounded.doubleValue();
    }
}
