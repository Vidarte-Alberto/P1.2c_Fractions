import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
public class Fraccion {
    public Integer numerador;
    public Integer denominador;

    public Map<String, Integer> Fraccionario = new LinkedHashMap<String, Integer>();
    public Map<String, Integer> Nsingular = new LinkedHashMap<String, Integer>();
    public Map<String, Integer> Decenas = new LinkedHashMap<String, Integer>();
    public Map<String, Integer> Centenas = new LinkedHashMap<String, Integer>();
    public Map<String, Integer> Miles = new LinkedHashMap<String, Integer>();

    //Constructor
    public Fraccion() {
        //Fraccionarios
        Fraccionario.put("ceravo", 0);
        Fraccionario.put("entero", 1);
        Fraccionario.put("medio", 2);
        Fraccionario.put("tercio", 3);
        Fraccionario.put("cuarto", 4);
        Fraccionario.put("quinto", 5);
        Fraccionario.put("sexto", 6);
        Fraccionario.put("septimo", 7);
        Fraccionario.put("octavo", 8);
        Fraccionario.put("noveno", 9);
        Fraccionario.put("decimo", 10);

        Nsingular.put("cero", 0);
        Nsingular.put("un", 1);
        Nsingular.put("dos", 2);
        Nsingular.put("tres", 3);
        Nsingular.put("cuatro", 4);
        Nsingular.put("cinco", 5);
        Nsingular.put("seis", 6);
        Nsingular.put("siete", 7);
        Nsingular.put("ocho", 8);
        Nsingular.put("nueve", 9);
        Nsingular.put("diez", 10);
        Nsingular.put("once", 11);
        Nsingular.put("doce", 12);
        Nsingular.put("trece", 13);
        Nsingular.put("catorce", 14);
        Nsingular.put("quince", 15);
        Nsingular.put("dieciseis", 16);
        Nsingular.put("diecisiete", 17);
        Nsingular.put("dieciocho", 18);
        Nsingular.put("diecinueve", 19);
        Nsingular.put("veinte", 20);
        Nsingular.put("veintiuno", 21);
        Nsingular.put("veintidos", 22);
        Nsingular.put("veintitres", 23);
        Nsingular.put("veinticuatro", 24);
        Nsingular.put("veinticinco", 25);
        Nsingular.put("veintiseis", 26);
        Nsingular.put("veintisiete", 27);
        Nsingular.put("veintiocho", 28);
        Nsingular.put("veintinueve", 29);
        //Decenas
        Decenas.put("treinta", 30);
        Decenas.put("cuarenta", 40);
        Decenas.put("cincuenta", 50);
        Decenas.put("sesenta", 60);
        Decenas.put("setenta", 70);
        Decenas.put("ochenta", 80);
        Decenas.put("noventa", 90);
        //Centenas
        Centenas.put("cien", 100);
        Centenas.put("doscientos", 200);
        Centenas.put("trescientos", 300);
        Centenas.put("cuatrocientos", 400);
        Centenas.put("quinientos", 500);
        Centenas.put("seiscientos", 600);
        Centenas.put("setecientos", 700);
        Centenas.put("ochocientos", 800);
        Centenas.put("novecientos", 900);
        //Miles
        Miles.put("mil", 1000);
        Miles.put("dos mil", 2000);
        Miles.put("tres mil", 3000);
        Miles.put("cuatro mil", 4000);
        Miles.put("cinco mil", 5000);
        Miles.put("seis mil", 6000);
        Miles.put("siete mil", 7000);
        Miles.put("ocho mil", 8000);
        Miles.put("nueve mil", 9000);

    }

    public Integer GetNumerator(String numerador) {
        Integer numero = 0;
        String[] palabras_numerador = numerador.split(" ");

        for (int i = 0; i < palabras_numerador.length; i++) {
            if (!"y".equals(palabras_numerador[i])){
                if (Nsingular.containsKey(palabras_numerador[i])){
                    numero = numero + Nsingular.get(palabras_numerador[i]);
                }if (Decenas.containsKey(palabras_numerador[i])) {
                    numero = numero + Decenas.get(palabras_numerador[i]);
                }
            }
        }
        return numero;
    }

    public Integer GetDenominator2(String denominador){
        Integer numero = 0;
        String numerocompuesto = "";
        for (int i = 0; i < denominador.length(); i++) {
            numerocompuesto = numerocompuesto.concat(String.valueOf(denominador.charAt(i)));
            if (numerocompuesto.charAt(0) == 'i'){
                numerocompuesto = numerocompuesto.replaceAll(numerocompuesto, "");
            }if (Nsingular.containsKey(numerocompuesto)){
                numero = numero + Nsingular.get(numerocompuesto);
                numerocompuesto = numerocompuesto.replaceAll(numerocompuesto, "");
            }if (Decenas.containsKey(numerocompuesto)){
                numero = numero + Decenas.get(numerocompuesto);
                numerocompuesto = numerocompuesto.replaceAll(numerocompuesto, "");
            }if (Fraccionario.containsKey(numerocompuesto)){
                numero = numero + Fraccionario.get(numerocompuesto);
                //Se elimina el numero al encontrar una coincidencia para poder encontrar el siguiente
                numerocompuesto = numerocompuesto.replaceAll(numerocompuesto, "");
            }
        }
        return numero;
    }

    public String Resultado_num_dem(Integer numerador, Integer denominador) throws Exception {
        String resultado = "";
        boolean Nnegative = false;
        if (numerador < 0) {
            Nnegative = true;
            numerador = numerador * -1;
        }
        String den = "";
        List<String> singular = new ArrayList<String>(Nsingular.keySet());
        List<String> fraccionario = new ArrayList<String>(Fraccionario.keySet());
        List<String> decena = new ArrayList<String>(Decenas.keySet());
        List<String> centena = new ArrayList<String>(Centenas.keySet());
        List<String> mil = new ArrayList<String>(Miles.keySet());

        if (numerador.toString().length() >= 2) {
            for (int j = 10; j <= 29; j++) {
                if (Integer.parseInt(numerador.toString().substring(numerador.toString().length() - 2, numerador.toString().length())) == j) {
                    resultado = resultado.concat(singular.get(j));
                }
            }
        }

        if (resultado.equals("") && Character.getNumericValue(numerador.toString().charAt(numerador.toString().length() - 1)) != 0) {
            for (int i = 0; i <= 10; i++) {
                if (Integer.parseInt(numerador.toString().substring(numerador.toString().length() - 1, numerador.toString().length())) == i) {
                    resultado = resultado.concat(singular.get(i));
                }
            }
        }
        if (resultado.equals("")){ resultado = resultado.concat(singular.get(0));};
        if (numerador.toString().length() >= 2) {
            Integer decenaN = Integer.parseInt(numerador.toString().substring(numerador.toString().length() - 2, numerador.toString().length() - 1));
            for (int i = 3; i < 10; i++) {
                if (decenaN == i && Character.getNumericValue(numerador.toString().charAt(numerador.toString().length() - 1)) == 0) {
                    resultado = decena.get(i - 3).concat(resultado);
                } else {
                    if (decenaN == i) {
                        resultado = decena.get(i - 3).concat(" y ".concat(resultado));
                    }
                }
            }
        }

        if (numerador.toString().length() >= 3) {
            Integer CentenaN = Integer.parseInt(numerador.toString().substring(numerador.toString().length() - 3, numerador.toString().length() - 2));
            for (int i = 0; i <= 9; i++) {
                if (CentenaN == i) {
                    if (numerador.toString().substring(numerador.toString().length() - 2, numerador.toString().length()).equals("00")) {
                        resultado = centena.get(i - 1).concat(" ".concat(resultado));
                    } else {
                        if (centena.get(i - 1).equals("cien")) {
                            resultado = centena.get(i - 1).concat("to ".concat(resultado));
                        } else {
                            resultado = centena.get(i - 1).concat(" ".concat(resultado));
                        }
                    }
                }
            }
        }

        if (numerador.toString().length() >= 4) {
            Integer MilN = Integer.parseInt(numerador.toString().substring(numerador.toString().length() - 4, numerador.toString().length() - 3));
            for (int i = 0; i < 10; i++) {
                if (MilN.equals(i)) {
                    resultado = mil.get(i - 1).concat(" ".concat(resultado));
                }
            }
        }

        //Denominador //

        boolean taken = false;
        if (denominador.toString().length() >= 2) {
            for (int j = 11; j <= 29; j++) {
                if (Integer.parseInt(denominador.toString().substring(denominador.toString().length() - 2, denominador.toString().length())) == j) {
                    den = den.concat(singular.get(j));
                }
            }
        }

        if (denominador.toString().length() == 1 || denominador == 10) {
            for (int i = 0; i <= 10; i++) {
                if (denominador == i) {
                    den = den.concat(fraccionario.get(i));
                    taken = true;
                }
            }
        }
        singular.get(0);

        if (!taken && den.equals("") && Character.getNumericValue(denominador.toString().charAt(denominador.toString().length() - 1)) != 0) {
            for (int i = 0; i <= 10; i++) {
                if (Integer.parseInt(denominador.toString().substring(denominador.toString().length() - 1, denominador.toString().length())) == i) {
                    den = den.concat(singular.get(i));
                }
            }
        }

        if (denominador.toString().length() >= 2) {
            Integer decenaN = Integer.parseInt(denominador.toString().substring(denominador.toString().length() - 2, denominador.toString().length() - 1));
            for (int i = 3; i < 10; i++) {
                if (decenaN == i && Character.getNumericValue(denominador.toString().charAt(denominador.toString().length() - 1)) == 0) {
                    den = decena.get(i - 3).concat(den);
                } else {
                    if (decenaN == i) {
                        den = decena.get(i - 3).concat("i".concat(den));
                    }
                }
            }
        }

        if (denominador.toString().length() >= 3) {
            Integer CentenaN = Integer.parseInt(denominador.toString().substring(denominador.toString().length() - 3, denominador.toString().length() - 2));
            for (int i = 0; i <= 9; i++) {
                if (CentenaN == i) {
                    if (denominador.toString().substring(denominador.toString().length() - 2, denominador.toString().length()).equals("00")) {
                        den = centena.get(i - 1).concat("".concat(den));
                    } else {
                        if (centena.get(i - 1).equals("cien")) {
                            den = centena.get(i - 1).concat("to".concat(den));
                        } else {
                            den = centena.get(i - 1).concat("".concat(den));
                        }
                    }
                }
            }
        }

        if (denominador.toString().length() >= 4) {
            Integer MilN = Integer.parseInt(denominador.toString().substring(denominador.toString().length() - 4, denominador.toString().length() - 3));
            for (int i = 0; i < 10; i++) {
                if (MilN.equals(i)) {
                    den = mil.get(i - 1).concat("".concat(den));
                }
            }
        }

        den = den.replace(" ", "");
        if (denominador > 10) {
            if (den.charAt(den.length() - 1) == 'a') {
                den = den.concat("vo");
            } else {
                den = den.concat("avo");
            }
        }
        if (numerador > 1 || numerador == 0) {
            den = den.concat("s");
        }

        if (Nnegative == true) {
            resultado = "menos ".concat(resultado);
        }

        resultado = resultado.concat(" ".concat(den));

        if (resultado.contains("ceravos")){
            throw new Exception("La operacion es invalida contiene ceravos");
        }

        return resultado;
    }

    //Operaciones
    public Fraccion suma(Fraccion obj2) {
        Fraccion result = new Fraccion();
        result.denominador = denominador * obj2.denominador;
        result.numerador = numerador * obj2.denominador + obj2.numerador * denominador;
        return result;
    }

    public Fraccion resta(Fraccion obj2) {
        Fraccion result = new Fraccion();
        result.denominador = denominador * obj2.denominador;
        result.numerador = numerador * obj2.denominador - obj2.numerador * denominador;
        return result;
    }

    public Fraccion multiplicacion(Fraccion obj2) {
        Fraccion result = new Fraccion();
        result.numerador = numerador * obj2.numerador;
        result.denominador = denominador * obj2.denominador;
        return result;
    }

    public Fraccion division(Fraccion obj2) {
        Fraccion result = new Fraccion();
        result.numerador = numerador * obj2.denominador;
        result.denominador = obj2.numerador * denominador;
        return result;
    }
}
