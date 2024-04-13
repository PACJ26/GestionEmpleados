
package logica;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class RegistroEntradaSalida {
    private Empleado empleado;
    private Date Fecha;
    private Date horaEntrada;
    private Date horaSalida;

    public RegistroEntradaSalida(Empleado empleado, Date Fecha, Date horaEntrada, Date horaSalida) {
        this.empleado = empleado;
        this.Fecha = Fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Date getFecha() {
        return Fecha;
    }

    public void setFecha(Date Fecha) {
        this.Fecha = Fecha;
    }

    public Date getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Date horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Date getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Date horaSalida) {
        this.horaSalida = horaSalida;
    }
    
    
}
