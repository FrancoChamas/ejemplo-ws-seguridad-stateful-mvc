package com.fac.seguridad.appweb.controlador;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Clase controlador de prueba
 * @author Franco Antonio Chamás.
 *
 */
@Controller
public class Controlador {
	
	@RequestMapping(value = { "/noticiaAdmin" }, method = {RequestMethod.GET })
	public ModelAndView getNoticiaAdmin() {
		Noticia noticia = new Noticia(1, "noticia 1");
		return new ModelAndView("noticias", "noticias", noticia);
	}
	
	/**
	 * clase interna de prueba.
	 * @author Franco Antonio Chamás.
	 *
	 */
	public class Noticia {
		  private int id;
		  private String nombre;

		  public Noticia(int id, String nombre)
		  {
		    this.id = id;
		    this.nombre = nombre;
		  }

		  public int getId() {
		    return this.id; }

		  public void setId(int id) {
		    this.id = id; }

		  public String getNombre() {
		    return this.nombre; }

		  public void setNombre(String nombre) {
		    this.nombre = nombre;
		  }
		}
}
