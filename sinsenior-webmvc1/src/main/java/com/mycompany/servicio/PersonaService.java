package com.mycompany.servicio;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.2.1
 * Fri Aug 17 15:13:20 COT 2012
 * Generated source version: 2.2.1
 * 
 */
 
@WebService(targetNamespace = "http://servicio.mycompany.com/", name = "PersonaService")
@XmlSeeAlso({ObjectFactory.class})
public interface PersonaService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "consultarPersona", targetNamespace = "http://servicio.mycompany.com/", className = "com.mycompany.servicio.ConsultarPersona")
    @ResponseWrapper(localName = "consultarPersonaResponse", targetNamespace = "http://servicio.mycompany.com/", className = "com.mycompany.servicio.ConsultarPersonaResponse")
    @WebMethod
    public com.mycompany.servicio.Persona consultarPersona(
        @WebParam(name = "codigoPersona", targetNamespace = "")
        java.lang.String codigoPersona
    );
}
