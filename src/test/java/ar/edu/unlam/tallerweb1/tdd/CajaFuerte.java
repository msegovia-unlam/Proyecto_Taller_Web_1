package ar.edu.unlam.tallerweb1.tdd;

public class CajaFuerte {
	private Integer claveDeApertura;
	private boolean estaAbierta = false;
	private Integer cantidadDeIntentosFallidos;

	public void cerrar(Integer clave) {
		claveDeApertura = clave;
		estaAbierta = false;
	}

	public CajaFuerte() {
		estaAbierta = true;
		cantidadDeIntentosFallidos = 0;
	}



	public void abrir(Integer clave) {
		if(clave.equals(claveDeApertura)) {
			cantidadDeIntentosFallidos = 0;
			estaAbierta = true;
		}
		else
			cantidadDeIntentosFallidos++;
	}

	public boolean estaAbierta() {
		
		return estaAbierta;
	}

	public boolean estaBloqueada() {
	
		return cantidadDeIntentosFallidos >= 3;
		
	}

}
