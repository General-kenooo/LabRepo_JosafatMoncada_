
package labp1repo_josafatmoncada_;

import java.util.Scanner;
import java.util.Random;

public class LabP1Repo_JosafatMoncada_ {

   
    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 3) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Ejercicio 1||Dungeons and Dragons||");
            System.out.println("2. Ejercicio 2||Laberinto||");
            System.out.println("3. salir 3");

            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();
            
            switch (opcion){
                
                case 1:
                    class Heroe {

                        char tipo;
                        int puntosVida;
                        int energia;

                        Heroe(char tipo, int puntosVida, int energia) {
                            this.tipo = tipo;
                            this.puntosVida = puntosVida;
                            this.energia = energia;
                        }

                        void mostrarEstado() {
                            System.out.println("Estado del héroe:");
                            System.out.println("Tipo: " + tipo);
                            System.out.println("Puntos de Vida: " + puntosVida);
                            System.out.println("Energía: " + energia);
                        }
                    }

                    class Juego {

                        static final int LADO_TABLERO = 4;
                        static final int MAX_DRAGONES = 5;

                        public static void main(String[] args) {
                            Scanner scanner = new Scanner(System.in);

                            System.out.println("¡Bienvenido al juego!");

                            System.out.println("Elige tu héroe:");
                            System.out.println("1. Caballero");
                            System.out.println("2. Mago");

                            int eleccion = scanner.nextInt();
                            Heroe heroe;

                            if (eleccion == 1) {
                                heroe = new Heroe('C', 250, 50);
                            } else {
                                heroe = new Heroe('M', 150, 230);
                            }

                            System.out.println("Has elegido ser un " + (heroe.tipo == 'C' ? "Caballero" : "Mago"));
                            heroe.mostrarEstado();

                            System.out.println("¡Comienza la fase del calabozo!");

                            Random random = new Random();

                            int posicion = 0;

                            while (posicion < LADO_TABLERO * LADO_TABLERO) {
                                int dado = random.nextInt(16) + 1; // Dado de 16 caras
                                System.out.println("Tiraste el dado y obtuviste " + dado);

                                // Actualizar posición en el tablero
                                posicion += dado;
                                if (posicion >= LADO_TABLERO * LADO_TABLERO) {
                                    System.out.println("¡Has completado el calabozo!");
                                    break;
                                }

                                // Verificar si hay dragones
                                if (dado % 2 == 1) {
                                    int dragones = random.nextInt(MAX_DRAGONES) + 1;
                                    System.out.println("Te encuentras con " + dragones + " dragones.");

                                    // Probabilidad de ganar o huir
                                    int probabilidad = random.nextInt(100) + 1;

                                    if (probabilidad <= 50) { // 50% de probabilidad de huir
                                        int dano = 25 * dragones;
                                        heroe.puntosVida -= dano;
                                        System.out.println("¡Huyiste de los dragones pero perdiste " + dano + " puntos de vida!");
                                    } else {
                                        int dano = 5 * dragones;
                                        heroe.energia -= dano;
                                        System.out.println("¡Ganaste contra los dragones pero perdiste " + dano + " puntos de energía!");
                                    }

                                    heroe.mostrarEstado();

                                    if (heroe.puntosVida <= 0) {
                                        System.out.println("¡Tu héroe ha perdido toda su vida! Fin del juego.");
                                        break;
                                    }
                                }

                                // Verificar bono en la casilla actual
                                if (posicion % LADO_TABLERO == 0) {
                                    int bono = random.nextInt(50) + 1; // Bono aleatorio hasta 50
                                    System.out.println("Encontraste un cofre con un bono de " + bono + " puntos.");
                                    if (posicion % (LADO_TABLERO * 2) == 0) { // Bonificación de energía
                                        heroe.energia += bono;
                                        System.out.println("¡Bonificación añadida a la energía!");
                                    } else { // Bonificación de vida
                                        heroe.puntosVida += bono;
                                        System.out.println("¡Bonificación añadida a los puntos de vida!");
                                    }
                                    heroe.mostrarEstado();
                                }
                            }

                            System.out.println("¡El juego ha terminado!");
                            heroe.mostrarEstado();
                        }
                    }
            
                
                
            
                
                case 2:
                   
        char[][] laberinto = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', ' ', ' ', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', '#', '#', ' ', '#'},
            {'#', ' ', '#', ' ', '#', ' ', ' ', ' ', ' ', '#'},
            {'#', ' ', '#', ' ', '#', '#', '#', '#', ' ', '#'},
            {'#', ' ', ' ', ' ', ' ', ' ', ' ', '#', ' ', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
        };

        imprimirLaberinto(laberinto);
        boolean salir = false;

        while (!salir) {
            System.out.println("Ingresa la dirección para moverte (arriba, abajo, izquierda, derecha):");
            
            String direccion = scanner.nextLine().toLowerCase();

            switch (direccion) {
                case "arriba":
                    moverArriba(laberinto);
                    break;
                case "abajo":
                    moverAbajo(laberinto);
                    break;
                case "izquierda":
                    moverIzquierda(laberinto);
                    break;
                case "derecha":
                    moverDerecha(laberinto);
                    break;
                case "salir":
                    salir = true;
                    break;
                default:
                    System.out.println("Dirección no válida. Intenta de nuevo.");
            }

            imprimirLaberinto(laberinto);

            if (laberinto[6][8] == ' ') {
                System.out.println("¡Felicidades! Has llegado a la salida.");
                salir = true;
            }
        }
            }
        }
    }

    private static void imprimirLaberinto(char[][] laberinto) {
        for (int i = 0; i < laberinto.length; i++) {
            for (int j = 0; j < laberinto[i].length; j++) {
                System.out.print(laberinto[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void moverArriba(char[][] laberinto) {
        // Implementa la lógica para mover hacia arriba
    }

    private static void moverAbajo(char[][] laberinto) {
        // Implementa la lógica para mover hacia abajo
    }

    private static void moverIzquierda(char[][] laberinto) {
        // Implementa la lógica para mover hacia la izquierda
    }

    private static void moverDerecha(char[][] laberinto) {
        // Implementa la lógica para mover hacia la derecha
    }
            }



    

