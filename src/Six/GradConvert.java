package Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

interface Converter {
    public double convert(double value);


    public static Converter getConverter(){
        Locale locale = Locale.getDefault();

        String[] countryList = {"US", "CA", "LR", "BS"};
        if (Arrays.asList(countryList).contains(locale.getCountry())){
            return new FarenhaitConvert();
        }
        else return new KalvinConvert();

    }


    public static void  printLocale(Locale locale){
        System.out.println("Locale language: " + locale.getLanguage());
        System.out.println("Locale country: " + locale.getCountry());
        System.out.println("Locale display country: " + locale.getDisplayCountry());
        System.out.println("Locale display language: " + locale.getDisplayLanguage());
        System.out.println("Locale display name: " + locale.getDisplayName());
        System.out.println("Locale ISO country: " + locale.getISO3Country());
    }
}

class Six{
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        Converter.printLocale(locale);
    }

}



class KalvinConvert implements Converter {
    @Override
    public double convert(double value) {
        return value + 273;
    }
}
class FarenhaitConvert implements Converter{
    @Override
    public double convert(double value) {
        return 9/5*value+32;
    }
}
