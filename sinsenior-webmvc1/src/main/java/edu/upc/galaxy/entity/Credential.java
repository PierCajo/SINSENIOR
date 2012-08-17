package edu.upc.galaxy.entity;

import java.io.Serializable;


public class Credential implements Serializable {
    private String correo;
    private String password;
    private String nombre;
    private String apellidos;
    private String id;

    public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getId() {
		return id;
	}

	public void setId(String codigo) {
		this.id = codigo;
	}

	public Credential() {}

    public Credential(String correo, String password) {
        this.correo = correo;
        this.password = password;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }        
}
