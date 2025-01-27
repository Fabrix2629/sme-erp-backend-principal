package proy.backend.proyClients.dto;

import jakarta.validation.constraints.NotNull;
public class SmClienteDto {

    private Integer idEntidad;
    private Integer idTipoDocumento;
    @NotNull(message = "El tipo de documento es obligatorio")
    private String nroDocumento;
    private String razonSocial;
    private String nombreComercial;
    private Integer idTipoContribuyente;
    private String direccion;
    private String telefono;
    private Boolean estado;

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Integer getIdTipoDocumento() {
        return idTipoDocumento;
    }

    public void setIdTipoDocumento(Integer idTipoDocumento) {
        this.idTipoDocumento = idTipoDocumento;
    }

    public String getNroDocumento() {
        return nroDocumento;
    }

    public void setNroDocumento(String nroDocumento) {
        this.nroDocumento = nroDocumento;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
