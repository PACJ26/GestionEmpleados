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
    private String tipoGenero;
    private Date fechaNacimiento;
    private Date fechaContratacion;
    private String tipoCargo;
    private String Salario;
    private String Clave;

    public Empleado(String Nombres, String Apellidos, String Documento, String tipoDocumento, String numeroTelefonico, String Direccion, String correoElectronico, String tipoGenero, Date fechaNacimiento, Date fechaContratacion, String tipoCargo, String Salario, String Clave) {
        this.Nombres = Nombres;
        this.Apellidos = Apellidos;
        this.Documento = Documento;
        this.tipoDocumento = tipoDocumento;
        this.numeroTelefonico = numeroTelefonico;
        this.Direccion = Direccion;
        this.correoElectronico = correoElectronico;
        this.tipoGenero = tipoGenero;
        this.fechaNacimiento = fechaNacimiento;
        this.fechaContratacion = fechaContratacion;
        this.tipoCargo = tipoCargo;
        this.Salario = Salario;
        this.Clave = Clave;
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

    public String getTipoGenero() {
        return tipoGenero;
    }

    public void setTipoGenero(String tipoGenero) {
        this.tipoGenero = tipoGenero;
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

    public String getTipoCargo() {
        return tipoCargo;
    }

    public void setTipoCargo(String tipoCargo) {
        this.tipoCargo = tipoCargo;
    }

    public String getSalario() {
        return Salario;
    }

    public void setSalario(String Salario) {
        this.Salario = Salario;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }
    
    

}
