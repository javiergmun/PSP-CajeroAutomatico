import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
    public static void main(String[] args) throws IOException {
        //CREAMOS SERVIDOR CON CONTEO DE CLIENTES
        int numClientes=0;
        ServerSocket servidor;
        Socket cliente;
        int puerto = 6666;
        boolean salir = false;

        try{
            System.out.println("¡Servidor bancario montado! Estamos esperando a que se consulten las cuentas.");
            servidor= new ServerSocket(puerto);
            while(!salir) {
                cliente = servidor.accept();//se acepta
                numClientes++;
                //TODO IMPLEMENTAR HILOS GESTION DE CADA COSA
                System.out.println("El cliente ha sido aceptado, ahora tenemos: " + numClientes + " cuentas bancarias activas");
                System.out.println("El cliente llega desde: " + cliente.getInetAddress());
                System.out.println("Esperando acciones...\n====\n====");
                // 1- SACAR DINERO
                ObjectInputStream entradaSacarDinero = new ObjectInputStream(cliente.getInputStream());
                entradaSacarDinero.readUTF();
                ObjectOutputStream salidaSacarDinero = new ObjectOutputStream(cliente.getOutputStream());
                salidaSacarDinero.writeUTF("1.2 - OPERACION SACAR DINERO REALIZADA");
                System.out.println("1.2 - Operacion sacar dinero enviando al servidor...");
                // 2- DEPOSITAR DINERO
                ObjectInputStream entradaDepositarDinero = new ObjectInputStream(cliente.getInputStream());
                entradaDepositarDinero.readUTF();
                ObjectOutputStream salidaDepositarDinero = new ObjectOutputStream(cliente.getOutputStream());
                salidaDepositarDinero.writeUTF("2.2 - OPERACION DEPOSITAR DINERO REALIZADA");
                System.out.println("2.2 - Operacion depositar dinero enviando al servidor...");
                //3- CONSULTAR SALDO
                ObjectInputStream entradaConsultarSaldo = new ObjectInputStream(cliente.getInputStream());
                entradaConsultarSaldo.readUTF();
                ObjectOutputStream salidaConsultarSaldo = new ObjectOutputStream(cliente.getOutputStream());
                salidaConsultarSaldo.writeUTF("3.2 - OPERACION CONSULTAR SALDO REALIZADA");
                System.out.println("3.2 - Operacion consultar saldo enviando al servidor...");
                //4- CONSULTAR MOVIMIENTOS
                ObjectInputStream entradaConsultarMovimientos = new ObjectInputStream(cliente.getInputStream());
                entradaConsultarMovimientos.readUTF();
                ObjectOutputStream salidaConsultarMovimientos = new ObjectOutputStream(cliente.getOutputStream());
                salidaConsultarMovimientos.writeUTF("4.2 - OPERACION CONSULTAR MOVIMIENTOS REALIZADA");
                System.out.println("4.2 - Operacion consultar movimientos enviando al servidor...");
                //5- SALIR
                ObjectInputStream entradaDesconexion = new ObjectInputStream(cliente.getInputStream());
                entradaDesconexion.readUTF();
                ObjectOutputStream salidaDesconexion = new ObjectOutputStream(cliente.getOutputStream());
                salidaDesconexion.writeUTF("5.2 DESCONEXION PERMITIDA");
                //TODO HILO GESTION CLIENTES
                //GestionCliente gestion = new GestionCliente(numClientes, cliente);
                //gestion.start();
            }
            System.out.println("===");
            System.out.println("FIN");
            System.out.println("===");
            servidor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

