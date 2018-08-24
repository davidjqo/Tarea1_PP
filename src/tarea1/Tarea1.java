package tarea1;

import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Tarea1 {

    public Tarea1() {
    }

    public static void muestraContenido(String archivo) throws FileNotFoundException, IOException {
        String ruta = "corregido.txt";
        File file = new File(ruta);
        file.delete();
        FileReader f = new FileReader(archivo);
        BufferedReader b = new BufferedReader(f);
        Throwable localThrowable3 = null;
        try {
            String cadena;
            while ((cadena = b.readLine()) != null) {
                escribirFichero(corregirHilera(cadena));
                if (verificaCadena(cadena) == true) {
                    System.out.println(cadena + "   aceptado");
                } else {
                    System.out.println(cadena + "   rechazado");
                }
            }
        } catch (IOException localThrowable1) {
            localThrowable3 = localThrowable1;
            throw localThrowable1;

        } finally {

            if (localThrowable3 != null) {
                try {
                    b.close();
                } catch (IOException localThrowable2) {
                    localThrowable3.addSuppressed(localThrowable2);
                }
            } else {
                b.close();
            }

        }
        Desktop.getDesktop().open(file);
    }

    public static char[] cadenaACaracteres(String cadena) {
        char[] caracteres = cadena.toCharArray();
        return caracteres;
    }

    public static boolean verificaCadena(String cadena) {
        if ((cadena.charAt(0) >= '0') && (cadena.charAt(0) <= '9')) {
            if ((cadena.charAt(1) == '-') && (cadena.charAt(6) == '-') && (cadena.length() == 11)) {
                if ((cadena.charAt(2) == '0') && (cadena.charAt(3) == '0') && (cadena.charAt(4) == '0') && (cadena.charAt(5) == '0')) {
                    return false;
                }
                if ((cadena.charAt(7) == '0') && (cadena.charAt(8) == '0') && (cadena.charAt(9) == '0') && (cadena.charAt(10) == '0')) {
                    return false;
                }
            }
            if ((cadena.charAt(1) == '-') && (cadena.charAt(5) == '-') && (cadena.length() == 10)) {
                if ((cadena.charAt(2) == '0') && (cadena.charAt(3) == '0') && (cadena.charAt(4) == '0')) {
                    return false;
                }
                if ((cadena.charAt(6) == '0') && (cadena.charAt(7) == '0') && (cadena.charAt(8) == '0') && (cadena.charAt(9) == '0')) {
                    return false;
                }
            }
            if ((cadena.charAt(1) == '-') && (cadena.charAt(6) == '-') && (cadena.length() == 10)) {
                if ((cadena.charAt(2) == '0') && (cadena.charAt(3) == '0') && (cadena.charAt(4) == '0') && (cadena.charAt(5) == '0')) {
                    return false;
                }
                if ((cadena.charAt(6) == '0') && (cadena.charAt(7) == '0') && (cadena.charAt(8) == '0')) {
                    return false;
                }
            }
            if ((cadena.charAt(1) == '-') && (cadena.charAt(5) == '-') && (cadena.length() == 9)) {
                if ((cadena.charAt(2) == '0') && (cadena.charAt(3) == '0') && (cadena.charAt(4) == '0')) {
                    return false;
                }
                if ((cadena.charAt(6) == '0') && (cadena.charAt(7) == '0') && (cadena.charAt(8) == '0')) {
                    return false;
                }
            }
            if (cadena.length() == 7) {
                if ((cadena.charAt(1) == '0') && (cadena.charAt(2) == '0') && (cadena.charAt(3) == '0')) {
                    return false;
                }
                if ((cadena.charAt(4) == '0') && (cadena.charAt(5) == '0') && (cadena.charAt(6) == '0')) {
                    return false;
                }
            }
            if (cadena.length() == 8) {
                if ((cadena.charAt(1) == '0') && (cadena.charAt(2) == '0') && (cadena.charAt(3) == '0')) {
                    return false;
                }
                if ((cadena.charAt(4) == '0') && (cadena.charAt(5) == '0') && (cadena.charAt(6) == '0') && (cadena.charAt(7) == '0')) {
                    return false;
                }
            }
            if (cadena.length() == 9) {
                if ((cadena.charAt(1) == '0') && (cadena.charAt(2) == '0') && (cadena.charAt(3) == '0') && (cadena.charAt(4) == '0')) {
                    return false;
                }
                if ((cadena.charAt(5) == '0') && (cadena.charAt(6) == '0') && (cadena.charAt(7) == '0') && (cadena.charAt(8) == '0')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static String corregirHilera(String cadena) {
        String nuevaCadena;
        String izquierda;
        String derecha;

        if ((cadena.charAt(0) >= '0') && (cadena.charAt(0) <= '9')) {
            if ((cadena.charAt(1) == '-') && (cadena.charAt(6) == '-') && (cadena.length() == 11)) {
                Pattern patron = Pattern.compile("-");
                Matcher encaja = patron.matcher(cadena);
                nuevaCadena = encaja.replaceAll("");
                return nuevaCadena;
            }
            if ((cadena.charAt(1) == '-') && (cadena.charAt(5) == '-') && (cadena.length() == 10)) {
                Pattern patron = Pattern.compile("-");
                Matcher encaja = patron.matcher(cadena);
                nuevaCadena = encaja.replaceAll("0");
                izquierda = nuevaCadena.substring(0, 5);
                derecha = nuevaCadena.substring(6, 10);
                nuevaCadena = izquierda.concat(derecha);
                return nuevaCadena;
            }
            if ((cadena.charAt(1) == '-') && (cadena.charAt(6) == '-') && (cadena.length() == 10)) {
                Pattern patron = Pattern.compile("-");
                Matcher encaja = patron.matcher(cadena);
                nuevaCadena = encaja.replaceAll("0");
                izquierda = nuevaCadena.substring(0, 1);
                derecha = nuevaCadena.substring(2, 10);
                nuevaCadena = izquierda.concat(derecha);
                return nuevaCadena;
            }
            if ((cadena.charAt(1) == '-') && (cadena.charAt(5) == '-') && (cadena.length() == 9)) {
                Pattern patron = Pattern.compile("-");
                Matcher encaja = patron.matcher(cadena);
                nuevaCadena = encaja.replaceAll("0");
                return nuevaCadena;
            }
            if (cadena.length() == 7) {
                izquierda = cadena.substring(0, 2);
                derecha = cadena.substring(2, 7);
                cadena = izquierda.concat("0").concat(derecha);
                izquierda = cadena.substring(0, 5);
                derecha = cadena.substring(5, 8);
                cadena = izquierda.concat("0").concat(derecha);
                return cadena;
            }
            if (cadena.length() == 8) {
                izquierda = cadena.substring(0, 1);
                derecha = cadena.substring(1, 8);
                cadena = izquierda.concat("0").concat(derecha);
                return cadena;
            }
            if (cadena.length() == 9) {
                return cadena;
            }
        }
        return "error";
    }

    public static void escribirFichero(String cadena) throws IOException {
        String ruta = "corregido.txt";
        File archivo = new File(ruta);
        BufferedWriter bw;
        if (archivo.exists()) {
            FileWriter fw = new FileWriter(archivo.getAbsoluteFile(), true);
            bw = new BufferedWriter(fw);
            bw.write(cadena);
            bw.newLine();
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write(cadena);
            bw.newLine();
        }
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        muestraContenido("Por aceptar.txt");
    }
}
