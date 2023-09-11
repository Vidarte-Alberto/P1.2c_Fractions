/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.Scanner;
public class Main {

    public static void main(String[] args) throws Exception {

        System.out.print("Escribe tu operacion: ");
        Scanner sc = new Scanner(System.in);
        String sentencia = sc.nextLine();
        String operacion = "";

        String fracciones[] = sentencia.split(" por | mas | menos | entre ");

        Fraccion fraccion1 = new Fraccion();
        Fraccion fraccion2 = new Fraccion();

        fraccion1 = Tomar_numeros.num_y_dem(fracciones[0]);
        fraccion2 = Tomar_numeros.num_y_dem(fracciones[1]);

        Fraccion resultado = new Fraccion();

        //Suma
        if (sentencia.contains(" mas ")) {
            resultado = fraccion1.suma(fraccion2);
        }
        //Resta
        if (sentencia.contains(" menos ")) {
            resultado = fraccion1.resta(fraccion2);
        }
        //Multiplicacion
        if (sentencia.contains(" por ")) {
            resultado = fraccion1.multiplicacion(fraccion2);
        }
        //Division
        if (sentencia.contains(" entre ")) {
            resultado = fraccion1.division(fraccion2);
        }
        try {
            resultado.Resultado_num_dem(resultado.numerador, resultado.denominador);
            System.out.println("El resultado es: " + resultado.Resultado_num_dem(resultado.numerador, resultado.denominador));

        } catch (Exception e)
        {
            throw new Exception(e.getMessage());
        }


    }

}

    

