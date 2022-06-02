package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancion;
import ar.edu.unlam.tallerweb1.servicios.Cancion.ServicioCancionImpl;
import org.junit.Before;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.mockito.stubbing.OngoingStubbing;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;

public class ReproducirCancionTest {

    private ServicioCancion servicioCancion;
    private ControladorReproductor controlador;
    private Cancion cancion;
    private ModelAndViewContainer mav;

    @Before
    public void init(){
        servicioCancion = mock(ServicioCancion.class);
        controlador = new ControladorReproductor(servicioCancion);
    }

    @Test
    public void SeReproduceCancion(){
        cancion = SiExisteUnaCancion("precarity","airtone_-_precarity_10.mp3");
        ModelAndView mav = cuandoVoyAVistaReproductor(cancion);
        CancionCargada(mav, cancion);
    }

    private Cancion SiExisteUnaCancion(String nombreCancion, String pathArchivo) {
        cancion = new Cancion(nombreCancion, pathArchivo);
        doNothing().when(servicioCancion).guardarCancion(cancion);
        return cancion;
    }


    private ModelAndView cuandoVoyAVistaReproductor(Cancion cancion) {
        return controlador.reproducirCancion(cancion.getId());
    }

    private void CancionCargada(ModelAndView mav, Cancion cancion) {
        assertThat( mav.getViewName()).isEqualTo("Reproductor");
        assertThat( mav.getModel().get("Cancion")).isEqualTo(cancion);
    }

}
