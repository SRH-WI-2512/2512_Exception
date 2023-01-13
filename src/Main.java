import java.util.Date;

public class Main {

    public static void killme() {
        killme();
    }

    public static void hierkannwasschiefgehen(int a) throws Exception {
        if (a < 0)
            throw new DenParameterWillIchNichtException("Keine negativen Werte!");
    }

    public static int finallySpezial() {
        try {
            System.out.println("Machwas");
            if (17 != 9)
                return 1;
            System.out.println("Machwas anderes");
        }
        finally {
            System.out.println("Finally von finallySpezial ausgeführt!");
        }
        return 0;
    }

    public static void main(String[] args)  throws Exception {
        finallySpezial();
        Date x = null;
        try {
            // Resource anfordern
            x = new Date();
            System.out.println("Resource angefordert");

            String eingabe = "21,33";
            //int x = 15 / 0;

            //killme();

            double i = Double.parseDouble(eingabe);
            System.out.println("Im nächsten Jahr bist du " + (i + 1));

            // Freigabe der Resource -> muss ins finally
            x.setTime(10);
            System.out.println("Freigabe erfolgreich");
        }
        catch (ArithmeticException e) {
            System.out.println("Oops, Rechenfehler");
        }
        catch (NumberFormatException e) {
            System.out.println("Oops, Konvertierungsfehler");
        }
        catch (RuntimeException e) {
            //System.out.println("Da gabs wohl einen Rechenfehler!");
            System.out.println("Da gabs wohl einen Laufzeitfehler");
        }
        catch (Exception e) {
            System.out.println("Oje, ein schwerer Fehler");
        }
        catch (Throwable e) {
            System.out.println("Das ist jetzt aber extrem schlimm");
        }
        finally {
            // Freigabe der Resource -> muss ins finally
            if (x != null) {
                x.setTime(10);
                System.out.println("Freigabe erfolgreich");
            }
        }
    }
}
