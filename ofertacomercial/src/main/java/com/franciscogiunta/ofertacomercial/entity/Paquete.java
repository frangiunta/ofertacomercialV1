// com.franciscogiunta.ofertacomercial.entity.Paquete.java
package com.franciscogiunta.ofertacomercial.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@Entity
@Table(name = "paquetes")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Paquete {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "paquete_id")
    private Integer paqueteId;
    @Column(name = "nombre_del_paquete", nullable = false)
    private String nombreDelPaquete;
    @Column(name = "categoria", nullable = false)
    private String categoria;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        Paquete paquete = (Paquete) o;
        return getPaqueteId() != null && Objects.equals(getPaqueteId(), paquete.getPaqueteId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
