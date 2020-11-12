/*
 * himekuri JDK8 version.
 */

import java.util.Calendar;
import java.util.Date;
import java.time.DateTimeException;
import java.text.SimpleDateFormat;

// Ruco is SubClass.
class Ruco extends Thread {

    final static String reiwa_kanji = "令和";
    // Delete when "0" becomes "10".
    final static String reiwa_alpha = "R0";
    final Date date = new Date();
    final SimpleDateFormat sdf_koyomi = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒 ： EEEE");
    final Calendar cal = Calendar.getInstance();
    final String reiwa_beta = (reiwa_kanji + (cal.get(Calendar.YEAR) - 2018) + "年" + (cal.get(Calendar.MONTH) + 1) + "月" + cal.get(Calendar.DAY_OF_MONTH) + "日");
    final String reiwa_delta = (reiwa_alpha + (cal.get(Calendar.YEAR) - 2018) + "." + (cal.get(Calendar.MONTH) + 1) + "." + cal.get(Calendar.DAY_OF_MONTH));
    final String comma = " : ";
    final String reiwa = reiwa_beta + comma + reiwa_delta;
    final int nen_nichi = cal.get(Calendar.DAY_OF_YEAR);
    final int nen_getsu = cal.getActualMaximum(Calendar.DAY_OF_YEAR);
    final String koyomi = sdf_koyomi.format(cal.getTime());
    final int one_year = (nen_getsu - nen_nichi);
    Integer int_year = one_year;
    final String string_year = int_year.toString();

    public void himekuri() {
        try {

            // thread start
            final Ruco thread = new Ruco();
            thread.setDaemon(true);
            thread.start();

            // himekuri function
            System.out.println(this.koyomi);
            System.out.println("来年の1月1日まであと" + this.comma + this.string_year + "日です");
            cal.setTime(this.date);
            System.out.println(this.reiwa);

            // thread join
            thread.join();

        } catch (InterruptedException | SecurityException e) {
            System.err.println("例外を捕捉しました ... ");
            e.printStackTrace(System.out);
        }
    }
}

// Seel is SubClass
class Seel extends Thread {
    final String comma = " : ";

    // major version number set.
    final double TopNumber = 1.0;
    // use, fix change update version number.
    final int lastNumber = 3;
    // use number layout control.
    final String zero_comma = ".";

    // version number set.
    double Number = TopNumber;
    final String string_number = String.valueOf(Number);
    Integer string_lastNumber = lastNumber;
    final String version_lastnumber  = string_lastNumber.toString();
    final String version_number = string_number + zero_comma + version_lastnumber;

    final String himekuriVersion = "日めくりの数え番号";
    final String version = this.himekuriVersion + this.comma + this.version_number;

    public void himekuri() {
        try {
            // thread start
            final Seel thread = new Seel();
            thread.start();

            // System out println call
            System.out.println(this.version);

            // thread join
            thread.join();

        } catch (SecurityException | InterruptedException ex) {
            System.err.println("例外を捕捉しました ... ");
            ex.printStackTrace(System.out);
        }
    }
}

/**
 * @author takkii(Takayuki Kamiyama) himekuri_java2 is SuperClass.
 */
public class himekuri_java2 {
    public static void main(final String[] args) {

        try {
            // SubClass call
            final Ruco c = new Ruco();
            c.himekuri();

            // SubClass call
            final Seel objc = new Seel();
            objc.himekuri();
        } catch (DateTimeException exe) {
            System.err.println("例外を捕捉しました ... ");
            exe.printStackTrace(System.out);
        }
    }
}
