public class Tomar_numeros {
    public static Fraccion num_y_dem(String sentencia) {
        boolean negative = false;
        Fraccion obj = new Fraccion();

        if (sentencia.contains("menos")) {
            negative = true;
            sentencia = sentencia.replace("menos ", "");
        }

        String fraccion[] = sentencia.split(" ");
        String numerador = "";
        String denominador = "";

        if (fraccion.length == 4) {
            numerador = sentencia.substring(0, sentencia.indexOf(" ", sentencia.indexOf(" ") + 4));
            denominador = sentencia.substring(sentencia.lastIndexOf(" ") + 1);
            obj.numerador = obj.GetNumerator(numerador);
            obj.denominador = obj.GetDenominator2(denominador);
        }

        if (fraccion.length == 2) {
            numerador = fraccion[0];
            denominador = fraccion[1];
            obj.numerador = obj.GetNumerator(numerador);
            obj.denominador = obj.GetDenominator2(denominador);
        }

        if (negative == true) {
            obj.numerador = obj.numerador * -1;
        }

        return obj;
    }
}
