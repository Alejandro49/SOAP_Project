package com.ligaClient;

import com.client.generated.CrearLiga;
import com.client.generated.CrearLigaService;
import com.client.generated.Equipo;

public class App 
{
    public static void main( String[] args )
    {
        CrearLigaService servicio = new CrearLigaService();
        CrearLiga creacionLiga = servicio.getCrearLigaPort();
        Equipo equipo = creacionLiga.crearEquipo();
        System.out.println(equipo);
    }
}
