// com.franciscogiunta.ofertacomercial.service.impl.OfertaComercialServiceImpl.java
package com.franciscogiunta.ofertacomercial.service;

/// com.franciscogiunta.ofertacomercial.service.impl.OfertaComercialServiceImpl.java

import com.franciscogiunta.ofertacomercial.dto.OfertaCaptacionDTO;
import com.franciscogiunta.ofertacomercial.dto.OpcionRetencionDTO;
import com.franciscogiunta.ofertacomercial.dto.PaqueteRetencionDTO;
import com.franciscogiunta.ofertacomercial.entity.PrecioCaptacion;
import com.franciscogiunta.ofertacomercial.entity.PrecioRetencion;
import com.franciscogiunta.ofertacomercial.repository.PreciosCaptacionRepository;
import com.franciscogiunta.ofertacomercial.repository.PreciosRetencionRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OfertaComercialServiceImpl implements OfertaComercialService {

    private final PreciosCaptacionRepository captacionRepository;
    private final PreciosRetencionRepository retencionRepository;

    public OfertaComercialServiceImpl(PreciosCaptacionRepository captacionRepository, PreciosRetencionRepository retencionRepository) {
        this.captacionRepository = captacionRepository;
        this.retencionRepository = retencionRepository;
    }

    // ------------------- CAPTACIÓN -------------------

    @Override
    public List<OfertaCaptacionDTO> getOfertaCaptacionByZona(Integer zonaId) {
        List<PrecioCaptacion> precios = captacionRepository.findAll()
                .stream()
                .filter(pc -> pc.getZona().getZonaId().equals(zonaId))
                .collect(Collectors.toList());

        // ¡REFERENCIA AL MÉTODO CORREGIDA!
        return precios.stream()
                .map(this::mapToCaptacionDTO)
                .collect(Collectors.toList());
    }

    /**
     * Método auxiliar para mapear PrecioCaptacion a OfertaCaptacionDTO.
     */
    private OfertaCaptacionDTO mapToCaptacionDTO(PrecioCaptacion pc) {
        OfertaCaptacionDTO dto = new OfertaCaptacionDTO();

        // Mapeo de Paquete
        dto.setPaqueteId(pc.getPaquete().getPaqueteId());
        dto.setNombreDelPaquete(pc.getPaquete().getNombreDelPaquete());
        dto.setCategoria(pc.getPaquete().getCategoria());

        // Mapeo de Precios
        dto.setPrecioLista(pc.getPrecioLista());
        dto.setPorcentajeDcto(pc.getPorcentajeDcto());
        dto.setVigencia(pc.getVigencia());
        dto.setPromocionDesc(pc.getPromocionDesc());
        dto.setPrecioFinal(pc.getPrecioFinal());

        return dto;
    }

    // ------------------- RETENCIÓN -------------------

    @Override
    public List<PaqueteRetencionDTO> getOfertaRetencionByZona(Integer zonaId) {
        List<PrecioRetencion> precios = retencionRepository.findAll()
                .stream()
                .filter(pr -> pr.getZona().getZonaId().equals(zonaId))
                .collect(Collectors.toList());

        return precios.stream()
                .collect(Collectors.groupingBy(pr -> pr.getPaquete().getPaqueteId()))
                .values().stream()
                .map(this::mapToPaqueteRetencionDTO)
                .collect(Collectors.toList());
    }

    /**
     * Método auxiliar para mapear una lista de PrecioRetencion (del mismo paquete) a PaqueteRetencionDTO.
     */
    private PaqueteRetencionDTO mapToPaqueteRetencionDTO(List<PrecioRetencion> preciosRetencion) {
        if (preciosRetencion.isEmpty()) return null;

        PrecioRetencion primerPrecio = preciosRetencion.get(0);

        PaqueteRetencionDTO paqueteDTO = new PaqueteRetencionDTO();
        paqueteDTO.setPaqueteId(primerPrecio.getPaquete().getPaqueteId());
        paqueteDTO.setNombreDelPaquete(primerPrecio.getPaquete().getNombreDelPaquete());
        paqueteDTO.setCategoria(primerPrecio.getPaquete().getCategoria());

        List<OpcionRetencionDTO> opciones = preciosRetencion.stream()
                .map(this::mapToOpcionRetencionDTO)
                .collect(Collectors.toList());

        paqueteDTO.setOpciones(opciones);
        return paqueteDTO;
    }

    /**
     * Método auxiliar para mapear un único PrecioRetencion a OpcionRetencionDTO.
     */
    private OpcionRetencionDTO mapToOpcionRetencionDTO(PrecioRetencion pr) {
        OpcionRetencionDTO dto = new OpcionRetencionDTO();
        dto.setOpcion(pr.getOpcion());
        dto.setPrecioLista(pr.getPrecioLista());
        dto.setPorcentajeDcto(pr.getPorcentajeDcto());
        dto.setVigencia(pr.getVigencia());
        dto.setPromocionDesc(pr.getPromocionDesc());
        dto.setPrecioFinal(pr.getPrecioFinal());
        return dto;
    }
}