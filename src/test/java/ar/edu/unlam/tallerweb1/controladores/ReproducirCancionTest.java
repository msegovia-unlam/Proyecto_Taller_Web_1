package ar.edu.unlam.tallerweb1.controladores;
import ar.edu.unlam.tallerweb1.modelo.Cancion;
import org.junit.Test;
import static org.assertj.core.api.Assertions.*;

import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.servlet.ModelAndView;




public class ReproducirCancionTest {


    private ControladorReproductor controlador;
    private Cancion cancion;
    private ModelAndViewContainer mav;

    @Test
    public void SeReproduceCancion(){
        cancion = SiExisteUnaCancion("precarity","airtone_-_precarity_10.mp3");
        controlador = new ControladorReproductor();
        ModelAndView mav = cuandoVoyAVistaReproductor(cancion);
        CancionCargada(mav, cancion);
    }

    private Cancion SiExisteUnaCancion(String nombreCancion, String url) {
        return new Cancion(nombreCancion, url);
    }


    private ModelAndView cuandoVoyAVistaReproductor(Cancion cancion) {
        return controlador.reproducirCancion(cancion);
    }

    private void CancionCargada(ModelAndView mav, Cancion cancion) {
        assertThat( mav.getViewName()).isEqualTo("Reproductor");
        assertThat( mav.getModel().get("Cancion")).isEqualTo(cancion);
    }

}
