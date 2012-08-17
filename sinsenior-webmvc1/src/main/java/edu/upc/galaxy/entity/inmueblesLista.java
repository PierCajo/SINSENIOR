package edu.upc.galaxy.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;


public class inmueblesLista  implements Serializable {

    private String tipoInmueble;
    private String distrito;
    private String tipoInmuebleDesc;
    private String distritoDesc;
  
    private String hJardin;
    private String hPatio;
	private String numRazSocial;
    private String correo;
    private String areade;
    private String areahasta;
    private String nroHabde;
    private String nroHabhasta;
    private String nroBanosde;
    private String nroBanoshasta;
    
    
    public String getAreade() {
		return areade;
	}
	public void setAreade(String areade) {
		this.areade = areade;
	}
	public String getAreahasta() {
		return areahasta;
	}
	public void setAreahasta(String areahasta) {
		this.areahasta = areahasta;
	}
	public String getNroHabde() {
		return nroHabde;
	}
	public void setNroHabde(String nroHabde) {
		this.nroHabde = nroHabde;
	}
	public String getNroHabhasta() {
		return nroHabhasta;
	}
	public void setNroHabhasta(String nroHabhasta) {
		this.nroHabhasta = nroHabhasta;
	}
	public String getNroBanosde() {
		return nroBanosde;
	}
	public void setNroBanosde(String nroBanosde) {
		this.nroBanosde = nroBanosde;
	}
	public String getNroBanoshasta() {
		return nroBanoshasta;
	}
	public void setNroBanoshasta(String nroBanoshasta) {
		this.nroBanoshasta = nroBanoshasta;
	}
	public String getTipoInmuebleDesc() {
		return tipoInmuebleDesc;
	}
	public void setTipoInmuebleDesc(String tipoInmuebleDesc) {
		this.tipoInmuebleDesc = tipoInmuebleDesc;
	}
	public String getDistritoDesc() {
		return distritoDesc;
	}
	public void setDistritoDesc(String distritoDesc) {
		this.distritoDesc = distritoDesc;
	}
	public String getNumRazSocial() {
		return numRazSocial;
	}
	public void setNumRazSocial(String numRazSocial) {
		this.numRazSocial = numRazSocial;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
    
  
	public String gethJardin() {
		return hJardin;
	}
	public void sethJardin(String hJardin) {
		this.hJardin = hJardin;
	}
	public String gethPatio() {
		return hPatio;
	}
	public void sethPatio(String hPatio) {
		this.hPatio = hPatio;
	}
	private List<Inmueble> inmuebles;
    
	public String getTipoInmueble() {
		return tipoInmueble;
	}
	public void setTipoInmueble(String tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}
	
	public List<Inmueble> getInmuebles() {
		return inmuebles;
	}
	public void setInmuebles(List<Inmueble> inmuebles) {
		this.inmuebles = inmuebles;
	}
    
    
    
    
    
    
    
    

 
    
    
}
