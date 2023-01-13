import java.util.Date;
/*
Exceptions sind in Klassen hierarchisch angelegt.
Werden über einen Try/Catch überprüft.
Es können mehrere Catchblöcke hintereinander „gestellt“ werden. Dabei müssen sie vom spezifischen zum unspezifischen angereit werden.
Arten: Checked und Unchecked Exception:
- Checked Exception werden während dem Kompilieren vom Compiler überprüft.
- Unchecked Exception werden vom Compiler ignoriert und die Java Virtueller
Stichwort "throws" ändert die Methodensignatur. Dadurch hat man ein Problem bei der Überschreibung und Überladung.

Try Blöcke allein können zum einen mit Catch- und/oder Finally-Block ausgeführt werden.
- Try:      Eine Anweisung "probiert".
- Catch:    Falls die Anweisung im Try-Block nicht ausgeführt werden kann, wird ein Fehler aufgerufen.
- Finally:  Egal was im Try oder Catch Block passiert, der Finally Block wird immer ausgeführt.
            Wenn im Try Block eine Returnanweisung aufgerufen wird und dadurch der Try-Block beendet wird,
            wird der Finally-Block dennoch ausgeführt

 */
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
