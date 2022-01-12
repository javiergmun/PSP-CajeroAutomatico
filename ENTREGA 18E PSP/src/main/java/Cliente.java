import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.UUID;

    public class Cliente {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                // CONEXION SERVIDOR
                Socket servidor = new Socket("localhost",6666 );
                System.out.println("Se ha establecido conexion con servidor" + servidor);
                /* == MENU ==
                1. SACAR
                2. DEPOSITAR
                3. CONSULTAR SALDO
                4. CONSULTAR MOVIMIENTOS
                5. SALIR (CERRAR CLIENTE)
                 */
            /*
            Scanner sc = new Scanner(System.in);

            //mini validacion
            CuentaBancaria CCC1 = new CuentaBancaria();
            System.out.println("Introduce el email del titular: ");
            CCC1.setEmail(sc.nextLine());
            System.out.println("Introduce el PIN del titular: ");
            CCC1.setPin(sc.nextLine());

            for (int j=0; j<655; j++){
                System.out.println("¿Que quieres hacer?\n1-Sacar dinero\n2-Depositar dinero\n3-Consultar saldo\n4-Consultar movimientos\n5-Salir");
                switch(sc.nextInt()){
                    case (1):
                        System.out.println("Redirigiendo a hilo de sacar dinero.");
                        break;
                    case (2):
                        System.out.println("Redirigiendo a hilo de depositar dinero");
                        break;

                    case (3):
                        System.out.println("Redirigiendo a hilo de consultar saldo");
                        break;

                    case(4):
                        System.out.println("Redirigiendo a hilo de consultar movimientos");
                        break;

                    case (5):
                        System.out.println("Estas siendo desconectado del servidor, adios!");
                        System.exit(0);
                        break;

                }

            }

             */
            //los .1 son del cliente y los .2 del servidor
            // 1- SACAR DINERO
            System.out.println("1.1 - Sacar dinero enviando a servidor...");
            ObjectOutputStream salidaSacarDinero = new ObjectOutputStream(servidor.getOutputStream());
            salidaSacarDinero.writeUTF("1.1 - EL CLIENTE QUIERE SACAR DINERO");

            ObjectInputStream entradaSacarDinero = new ObjectInputStream(servidor.getInputStream());
            entradaSacarDinero.readUTF();


            //2- DEPOSITAR DINERO
            System.out.println("2.1 - Depositar dinero enviando a servidor");
            ObjectOutputStream salidaDepositarDinero = new ObjectOutputStream(servidor.getOutputStream());
            salidaDepositarDinero.writeUTF("2.1 - EL CLIENTE QUIERE DEPOSITAR DINERO");

            ObjectInputStream entradaDepositarDinero = new ObjectInputStream(servidor.getInputStream());
            entradaDepositarDinero.readUTF();

            //3- CONSULTAR SALDO
            System.out.println("3.1 - Consultar saldo enviando a servidor");
            ObjectOutputStream salidaConsultarSaldo = new ObjectOutputStream(servidor.getOutputStream());
            salidaConsultarSaldo.writeUTF("3.1 - EL CLIENTE QUIERE CONSULTAR SALDO");

            ObjectInputStream entradaConsultarSaldo = new ObjectInputStream(servidor.getInputStream());
            entradaConsultarSaldo.readUTF();

            //4- CONSULTAR MOVIMIENTOS
            System.out.println("4.1 - Consultar movimientos enviando a servidor");
            ObjectOutputStream salidaConsultarMovimientos = new ObjectOutputStream(servidor.getOutputStream());
            salidaConsultarMovimientos.writeUTF("4.1 - EL CLIENTE QUIERE CONSULTAR MOVIMIENTOS");

            ObjectInputStream entradaConsultarMovimientos = new ObjectInputStream(servidor.getInputStream());
            entradaConsultarMovimientos.readUTF();
            //5- SALIR
            System.out.println("5.1 Diciendo al servidor que me desconecte");
            ObjectOutputStream salidaDesconexion = new ObjectOutputStream(servidor.getOutputStream());
            salidaDesconexion.writeUTF("5.1 ME QUIERO DESCONECTAR");
            ObjectInputStream entradaDesconexion = new ObjectInputStream(servidor.getInputStream());
            entradaDesconexion.readUTF();

            servidor.close();

        }
    }

