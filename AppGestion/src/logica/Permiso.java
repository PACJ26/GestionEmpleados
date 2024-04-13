
package logica;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class Permiso {
    private Empleado empleado;
    private Date Fecha;
    private  boolean Remunerado;
    private String Motivo;

    public Permiso(Empleado empleado, Date Fecha, boolean Remunerado, String Motivo) {
        this.empleado = empleado;
        this.Fecha = Fecha;
        this.Remunerado = Remunerado;
        this.Motivo = Motivo;
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

    public boolean isRemunerado() {
        return Remunerado;
    }

    public void setRemunerado(boolean Remunerado) {
        this.Remunerado = Remunerado;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }
    
    
}
