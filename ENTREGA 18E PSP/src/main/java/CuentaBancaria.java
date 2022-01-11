import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.UUID;

public class CuentaBancaria  implements Serializable {
        private String email;
        private String pin;
        private double dinero;
        private UUID idCuentaBancaria;
        private Instant sesionActiva;
        private LocalDateTime fecha;

    public CuentaBancaria(String email, String pin, double dinero, UUID idCuentaBancaria, Instant sesionActiva, LocalDateTime fecha) {
        this.email = email;
        this.pin = pin;
        this.dinero = dinero;
        this.idCuentaBancaria = idCuentaBancaria;
        this.sesionActiva = sesionActiva;
        this.fecha = fecha;
    }

    public CuentaBancaria(){
        email="";
        pin="";
        dinero=0;
        idCuentaBancaria=UUID.randomUUID();
        sesionActiva= Instant.now();
        fecha = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "email='" + email + '\'' +
                ", pin='" + pin + '\'' +
                ", dinero=" + dinero +
                ", idCuentaBancaria=" + idCuentaBancaria +
                ", sesionActiva=" + sesionActiva +
                ", fecha=" + fecha +
                '}';
    }
}
