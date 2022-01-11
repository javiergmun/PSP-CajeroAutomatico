import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.time.Instant;
import java.util.ArrayDeque;
import java.util.UUID;

    public class Cliente {
        public static void main(String[] args) throws IOException, ClassNotFoundException {
                // SE CREA UNA PILA DE ALMACENAJE PARA ALGUNOS DATOS :)
                ArrayDeque<String> almacen = new ArrayDeque<>();
                //SE LE PONE NOMBRE AL PRINCIPIO
                almacen.add("PILA DE PAQUETES ENVIADOS = ");
                //cliente se conecta al servidor
                Socket servidor = new Socket("localhost",6666 );
                // CLIENTE ENVIA COSAS DE UNA CLASE
                Paquete paqueteSalida = new Paquete("","paquete", UUID.randomUUID(),UUID.randomUUID(), Instant.now(),2);
                ObjectOutputStream bufferSalida = new ObjectOutputStream(servidor.getOutputStream());
                bufferSalida.writeObject(paqueteSalida);
                System.out.println("Se ha enviado un paquete: " + paqueteSalida.toString()); // creado en paquete
                // CLIENTE TERMINA DE ENVIAR COSAS DE CLASE Y MUESTRA7

            //CLIENTE ESPERA

                //CLIENTE RECIBE COSAS DE CLASE
                ObjectInputStream bufferEntrada = new ObjectInputStream(servidor.getInputStream());
                Paquete paqueteEntrada = (Paquete) bufferEntrada.readObject();
                System.out.println("El señor Spock nos da las gracias por enviarle: " + paqueteEntrada.toString());
                bufferEntrada.read();
                System.out.println("---");
                //CLIENTE TERMINA DE RECIBIR COSAS DE CLASE
                //CLIENTE ALMACENA COSAS EN LISTA
                System.out.println("Añadiendo a pila...");
                almacen.add(paqueteEntrada.toString());
                System.out.println(almacen);
                //CLIENTE TERMINA DE ALMACENAR Y MUESTRA LISTA
            System.out.println("===");
            System.out.println("FIN");
            System.out.println("===");
        }
    }

}
