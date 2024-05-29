package Modelos.Sistema;

import Modelos.Entidades.Monstruo;
import Modelos.Entidades.Personaje;
import Modelos.Escenarios.Escenario;
import Modelos.Items.Item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Ejecucion {
    public static void Ejecucion() {

        //Pasar objetos de los archivos de inventario, armas y armaduras a arrays
        Archivo archivo = new Archivo();

        ArrayList<Item> ListaItems = new ArrayList<>(archivo.leerArchivoItems(NombreArchivos.Items.getNombre()));
        //Pasar info de partida

        //Pasar info de monstruo
        //Pasar info de personaje
        //pasar info de escenarios
        archivo.grabarArchivo(ListaItems, NombreArchivos.Items.getNombre());

        Scanner scanner = new Scanner(System.in);

        Partida partida = new Partida(new Personaje());




        //if escenario es una pelea
        Monstruo monstruo = new Monstruo();//reemplazar por el monstruo del escenario con monstruo
        int chequeoBatalla = 0;
        while (partida.getJugador().estaVivo()) {
            /*desc escenario
            nombre monstruo
            vida de monstruo
            datos del jugador
            todo lo de arriba habria que ponerlo lindo */

            int eleccion = -1;
            System.out.println("Que desea hacer?");
            System.out.println("1. Ataque basico");
            System.out.println("2. Ataque especial");
            System.out.println("3. Abrir inventario");
            System.out.println("No se que mas puede ser");

            eleccion = scanner.nextInt();
            switch (eleccion) {

                case 1:
                    System.out.println("El jugador inflige" + partida.ataqueJugador(monstruo) + "puntos de danio");//El danio que inflige el jugador

                    if (partida.ataqueMonstruo(monstruo) != -1) {
                        System.out.println("El monstruo inflige" + partida.ataqueMonstruo(monstruo) + "puntos de danio");//el danio que inflige el monstruo
                    }

                    chequeoBatalla = partida.chequeoFinDeAtaque(monstruo);//El resultado de la batalla
                    switch (chequeoBatalla) {
                        case 1:
                            System.out.println("Ha ganado la batalla.");

                            break;

                        case 0:
                            System.out.println("La batalla continua"); //Esto se puede dejar vacio tambien

                            break;

                        case -1:
                            System.out.println("Ha perdido la batalla");
                            break;

                        default:
                            System.out.println("Error: Resultado de batalla invalido");
                            break;


                    }

                    break;

                case 2:
                    System.out.println("El jugador inflige" + partida.ataqueEspecialJugador(monstruo) + "puntos de danio");

                    if (partida.ataqueMonstruo(monstruo) != -1) {
                        System.out.println("El monstruo inflige" + partida.ataqueMonstruo(monstruo) + "puntos de danio");
                    }

                    chequeoBatalla = partida.chequeoFinDeAtaque(monstruo);
                    switch (chequeoBatalla) {
                        case 1:
                            System.out.println("Ha ganado la batalla.");

                            break;

                        case 0:
                            System.out.println("La batalla continua"); //Esto se puede dejar vacio tambien

                            break;

                        case -1:
                            System.out.println("Ha perdido la batalla");
                            break;

                        default:
                            System.out.println("Error: Resultado de batalla invalido ");
                            break;

                    }
                    break;

                case 3:

                    break;

                default:
                    System.out.println("Decision invalida");
                    break;


            }

        }


    }
}
