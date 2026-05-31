// com.franciscogiunta.ofertacomercial.model.entity.PrecioCaptacion.java
package com.franciscogiunta.ofertacomercial.entity;

import com.franciscogiunta.ofertacomercial.id.PrecioCaptacionId;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "precios_captacion")
@IdClass(PrecioCaptacionId.class)
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class PrecioCaptacion {
    @Id
    @ManyToOne(optional = false)
    @JoinColumn(name = "zona_id")
    private Zona zona;
    @Id
    @ManyToOne

    @JoinColumn(name = "paquete_id")
    private Paquete paquete;
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
        PrecioCaptacion that = (PrecioCaptacion) o;
        return getZona() != null && Objects.equals(getZona(), that.getZona())
                && getPaquete() != null && Objects.equals(getPaquete(), that.getPaquete());
    }

    @Override
    public final int hashCode() {
        return Objects.hash(zona, paquete);
    }
}
