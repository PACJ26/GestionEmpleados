
package logica;

import java.util.Date;

/**
 *
 * @author Juan
 */
public class Empleado {
    private String Nombres;
    private String Apellidos;
    private String Documento;
    private String tipoDocumento;
    private String numeroTelefonico;
    private String Direccion;
    private String correoElectronico;
    private String Genero;
    private Date fechaNacimiento;
    private Date fechaContratacion;
    private String Cargo;
    private String Salirio;

    public Empleado(String Nombres, String Apellidos, String Documento, String tipoDocumento, String numeroTelefonico, String Direccion, String correoElectronico, String Genero, Date fechaNacimiento, Date fechaContratacion, String Cargo, String Salirio) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Documento = Documento;
        this.tipoDocumento = tipoDocumento;
        this.numeroTelefonico = numeroTelefonico;
        this.Direccion = Direccion;
        this.correoElectronico = correoElectronico;
        this.Genero = Genero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.Cargo = Cargo;
        this.Salirio = Salirio;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String Nombres) {
        this.Nombres = Nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String Apellidos) {
        this.Apellidos = Apellidos;
    }

    public String getDocumento() {
        return Documento;
    }

    public void setDocumento(String Documento) {
        this.Documento = Documento;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroTelefonico() {
        return numeroTelefonico;
    }

    public void setNumeroTelefonico(String numeroTelefonico) {
        this.numeroTelefonico = numeroTelefonico;
    }

    public String getDireccion() {
        return Direccion;
    }

    public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getGenero() {
        return Genero;
    }

    public void setGenero(String Genero) {
        this.Genero = Genero;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getFechaContratacion() {
        return fechaContratacion;
    }

    public void setFechaContratacion(Date fechaContratacion) {
        this.fechaContratacion = fechaContratacion;
    }

    public String getCargo() {
        return Cargo;
    }

    public void setCargo(String Cargo) {
        this.Cargo = Cargo;
    }

    public String getSalirio() {
        return Salirio;
    }

    public void setSalirio(String Salirio) {
        this.Salirio = Salirio;
    }
    
    
}
