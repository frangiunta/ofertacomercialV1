// com.franciscogiunta.ofertacomercial.model.entity.PrecioRetencion.java
package com.franciscogiunta.ofertacomercial.entity;

import com.franciscogiunta.ofertacomercial.id.PrecioRetencionId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "precios_retencion")
@IdClass(PrecioRetencionId.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PrecioRetencion {
    @Id
    @ManyToOne
    @JoinColumn(name = "zona_id")
    private Zona zona;
    @Id
    @ManyToOne
    @JoinColumn(name = "paquete_id")
    private Paquete paquete;
    @Id
    private String opcion;
    @Column(name = "precio_lista", nullable = false)
    private Double precioLista;
    @Column(name = "promocion_desc")
    private String promocionDesc;
    @Column(name = "porcentaje_dcto")
    private Double porcentajeDcto;
    @Column(name = "vigencia")
    private Integer vigencia;
    @Column(name = "precio_final", nullable = false)
    private Double precioFinal;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        PrecioRetencion that = (PrecioRetencion) o;
        return getZona() != null && Objects.equals(getZona(), that.getZona())
                && getPaquete() != null && Objects.equals(getPaquete(), that.getPaquete())
                && getOpcion() != null && Objects.equals(getOpcion(), that.getOpcion());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(zona, paquete, opcion);
    }
}
