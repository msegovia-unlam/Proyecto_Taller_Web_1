package ar.edu.unlam.tallerweb1.controladores;

import ar.edu.unlam.tallerweb1.modelo.Album;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.repositorios.RepositorioUsuarioImpl;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.ServicioLoginImpl;
import org.junit.Before;
import org.junit.Test;

import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;

public class ControladorListoTopTest {

    private ServicioCancion servicioCancion;
    private ControladorCancion controlador;
    private Cancion cancion;
    private List<Cancion> canciones;
    private Album album;
    private ModelAndView mav;
    private RepositorioUsuarioImpl repositorioUsuario;
    private ServicioLoginImpl serviciologin;


    @Before
    public void init(){
        servicioCancion = mock(ServicioCancion.class);
        repositorioUsuario = mock(RepositorioUsuarioImpl.class);
        serviciologin = mock(ServicioLoginImpl.class);
        controlador = new ControladorCancion(servicioCancion, serviciologin);

    }

    @Test
    public void llevaALaVistaCorrecta(){
        existenCanciones();
        ModelAndView mav = voyALaVista();
        compruebaVistaCorrecta(mav, "listatop");
    }



    private void compruebaVistaCorrecta(ModelAndView vistaRecibida, String vistaEsperada ) {
        assertThat(vistaRecibida).isEqualTo(vistaEsperada);
    }

    private ModelAndView voyALaVista() {
        return controlador.listaTop(10);
    }

    private void existenCanciones() {

        cancion = new Cancion("cancion 1", "/");
        doNothing().when(servicioCancion).guardarCancion(cancion);
        for(int i = 0; i < 10; i++){
            doNothing().when(servicioCancion).guardarCancion(cancion);
            }
    }


}
