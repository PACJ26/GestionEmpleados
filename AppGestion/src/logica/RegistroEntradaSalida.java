package logica;

import java.sql.Timestamp;

public class RegistroEntradaSalida {
    private Empleado empleado;
    private Timestamp fecha;
    private Timestamp horaEntrada;
    private Timestamp horaSalida;

    public RegistroEntradaSalida(Empleado empleado, Timestamp fecha, Timestamp horaEntrada, Timestamp horaSalida) {
        this.empleado = empleado;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Timestamp getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Timestamp horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Timestamp getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Timestamp horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
}
