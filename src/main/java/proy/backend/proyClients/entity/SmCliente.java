package proy.backend.proyClients.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_entidad")
public class SmCliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_entidad")
    private Integer idEntidad;

    @ManyToOne
    @JoinColumn(name = "id_tipo_documento", referencedColumnName = "id_tipo_documento", nullable = false)
    private SmDocumento TipoDocumento;

    @Column(name = "nro_documento", length = 25, nullable = false, unique = true)
    private String nroDocumento;

    @Column(name = "razon_social", length = 100, nullable = false)
    private String razonSocial;

    @Column(name = "nombre_comercial", length = 100)
    private String nombreComercial;

    @ManyToOne
    @JoinColumn(name = "id_tipo_contribuyente", referencedColumnName = "id_tipo_contribuyente", nullable = false)
    private SmContribuyente TipoContribuyente;

    @Column(name = "direccion", length = 250)
    private String direccion;

    @Column(name = "telefono", length = 50)
    private String telefono;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    public Integer getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(Integer idEntidad) {
        this.idEntidad = idEntidad;
    }

    public SmDocumento getTipoDocumento() {
        return TipoDocumento;
    }

    public void setTipoDocumento(SmDocumento tipoDocumento) {
        TipoDocumento = tipoDocumento;
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

    public SmContribuyente getTipoContribuyente() {
        return TipoContribuyente;
    }

    public void setTipoContribuyente(SmContribuyente tipoContribuyente) {
        TipoContribuyente = tipoContribuyente;
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

    public Integer setTipoContribuyente(Integer idTipoContribuyente) {
        return idTipoContribuyente;
    }

    public Integer setTipoDocumento(Integer idTipoDocumento) {
        return idTipoDocumento;
    }
}
