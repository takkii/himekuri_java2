/**
 * himekuri JDK8 version.
 */

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

// Ruco is SubClass.
class Ruco extends Thread {

    final Date date = new Date();
    final SimpleDateFormat sdf_koyomi = new SimpleDateFormat("yyyy年MM月dd日HH時mm分ss秒：EEEE");
    final static String reiwa_kanji = "令和";
	// Delete when "0" becomes "10". 
    final static String reiwa_alpha = "R0";
    final Calendar cal = Calendar.getInstance();
    final String reiwa_beta = (reiwa_kanji + (cal.get(cal.YEAR)-2018) + "年" + (cal.get(cal.MONTH)+1)+ "月" + cal.get(cal.DAY_OF_MONTH)+"日");
    final String reiwa_delta = (reiwa_alpha + (cal.get(cal.YEAR) - 2018) + "." + (cal.get(cal.MONTH)+1) + "." + cal.get(cal.DAY_OF_MONTH));
    final int nichi = cal.get(cal.DAY_OF_YEAR);
    final int getsu = cal.getActualMaximum(cal.DAY_OF_YEAR);

    public void himekuri() {
        try {

            // thread start
            final Ruco thread = new Ruco();
            thread.setDaemon(true);
            thread.start();

            // himekuri function
            System.out.println(sdf_koyomi.format(cal.getTime()));
            System.out.println("来年の1月1日まであと : " + (getsu - nichi) + "日です");
            cal.setTime(date);
            System.out.println(reiwa_beta + " : " + reiwa_delta);

            // thread join
            thread.join();

        } catch (Exception e) {
            System.err.println("Exceptionエラーを捕捉しました...");
            e.printStackTrace(System.out);
        }
    }
}

// Seel is SubClass
class Seel extends Thread {
    String version = "1.0.0";
    String himekuriVersion = "日めくり(JDK8)の数え番号 ： " + version;

    public void himekuri() {
        try {
            // thread start
            final Seel thread = new Seel();
            thread.start();

            // System out println call
            System.out.println(himekuriVersion);

            // thread join
            thread.join();

        } catch (Exception ex) {
            System.err.println("Exceptionエラーを捕捉しました...");
            ex.printStackTrace(System.out);
        }
    }
}

/**
 * @author takkii(Takayuki Kamiyama) himekuri_java2 is SuperClass.
 */
public class himekuri_java2 {
    public static void main(final String[] args) {

		try
		{
		    // SubClass call
		    final Ruco c = new Ruco();
		    c.himekuri();

		    // SubClass call
		    final Seel objc = new Seel();
		    objc.himekuri();
		}

		catch (Exception exe)
		{
		    System.err.println("Exception catch  ...");
		    exe.printStackTrace(System.out);
		}
    }
}
