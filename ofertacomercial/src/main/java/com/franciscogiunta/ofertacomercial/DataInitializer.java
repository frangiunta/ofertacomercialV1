package com.franciscogiunta.ofertacomercial;

import com.franciscogiunta.ofertacomercial.entity.Zona;
import com.franciscogiunta.ofertacomercial.service.LocalidadService;
import com.franciscogiunta.ofertacomercial.service.ZonaService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class DataInitializer implements CommandLineRunner {

    private final ZonaService zonaService;
    private final LocalidadService localidadService;

    public DataInitializer(ZonaService zonaService, LocalidadService localidadService) {
        this.zonaService = zonaService;
        this.localidadService = localidadService;
    }

    @Override
    public void run(String... args) throws Exception {
        if (zonaService.getAllZonas().isEmpty()) {
            System.out.println("Base de datos vacía. Inicializando zonas y localidades...");

            // 1. Crear Zonas
            Map<String, Zona> zonasMap = new HashMap<>();
            List<String> zonasNombres = Arrays.asList("Buenos Aires", "CABA", "Chaco", "Corrientes", "Entre Ríos", "Misiones", "Santa Fe");
            for (String nombre : zonasNombres) {
                zonasMap.put(nombre, zonaService.createZona(nombre));
            }
            System.out.println("Zonas creadas.");

            // 2. Definir Localidades por Zona
            Map<String, List<String>> localidadesPorZona = new HashMap<>();
            localidadesPorZona.put("Buenos Aires", Arrays.asList("Campana", "San Pedro"));
            localidadesPorZona.put("CABA", Arrays.asList("CABA (Ciudad Autónoma de Buenos Aires)"));
            localidadesPorZona.put("Chaco", Arrays.asList("Barranqueras", "General José de San Martín", "Puerto Tirol", "Resistencia"));
            localidadesPorZona.put("Corrientes", Arrays.asList("Bella Vista", "Corrientes (Capital)", "Goya", "San Luis del Palmar", "Santa Lucía"));
            localidadesPorZona.put("Entre Ríos", Arrays.asList("Crespo", "Paraná", "General Ramírez (Ramírez)"));
            localidadesPorZona.put("Misiones", Arrays.asList("Garupá", "Posadas"));
            localidadesPorZona.put("Santa Fe", Arrays.asList("Ángel Gallardo", "Colastiné", "Coronda", "Monte Vera", "San José del Rincón", "Santa Fe (Capital)", "Santo Tomé", "Sauce Viejo"));

            // 3. Crear y asociar Localidades
            for (Map.Entry<String, List<String>> entry : localidadesPorZona.entrySet()) {
                String zonaNombre = entry.getKey();
                Zona zona = zonasMap.get(zonaNombre);
                if (zona != null) {
                    for (String localidadNombre : entry.getValue()) {
                        localidadService.createLocalidad(localidadNombre, zona.getZonaId());
                    }
                }
            }
            System.out.println("Localidades creadas y asociadas.");
            System.out.println("Datos inicializados correctamente.");
        } else {
            System.out.println("La base de datos ya contiene datos. No se requiere inicialización.");
        }
    }
}
