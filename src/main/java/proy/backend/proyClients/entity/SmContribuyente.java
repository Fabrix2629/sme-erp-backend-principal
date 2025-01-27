package proy.backend.proyClients.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "tb_tipo_contribuyente")
public class SmContribuyente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_tipo_contribuyente")
    private Integer idTipoContribuyente;

    @Column(name = "nombre", length = 50, nullable = false)
    private String nombre;

    @Column(name = "estado", nullable = false)
    private Boolean estado;

    // Getters y Setters
    public Integer getIdTipoContribuyente() {
        return idTipoContribuyente;
    }

    public void setIdTipoContribuyente(Integer idTipoContribuyente) {
        this.idTipoContribuyente = idTipoContribuyente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
