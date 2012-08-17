﻿using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;

namespace RegistrosPublicos.Entidades
{
    public class Persona
    {
        String _nroDoc;
        String _tipoPersona;
        String _NombrePersona;
        List<Propiedades> _listaPropiedades;
        public Persona()
        { }
        public Persona(String nroDoc, String tipoPersona, String NombrePersona, List<Propiedades> listaPropiedades)
        {
            this.nroDoc = nroDoc;
            this.tipoPersona = tipoPersona;
            this.NombrePersona = NombrePersona;
            this.listaPropiedades = listaPropiedades;
        }
        public String nroDoc
        {
            get { return _nroDoc; }
            set { _nroDoc = value; }
        }
        public String tipoPersona
        {
            get { return _tipoPersona; }
            set { _tipoPersona = value; }
        }
        public String NombrePersona
        {
            get { return _NombrePersona; }
            set { _NombrePersona = value; }
        }
        public List<Propiedades> listaPropiedades
        {
            get { return _listaPropiedades; }
            set { _listaPropiedades = value; }
        }
    }
}