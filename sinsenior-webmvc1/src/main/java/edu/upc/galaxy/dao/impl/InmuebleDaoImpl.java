package edu.upc.galaxy.dao.impl;

import edu.upc.galaxy.dao.InmuebleDao;
import edu.upc.galaxy.entity.DropDownList;
import edu.upc.galaxy.entity.Inmueble;
import edu.upc.galaxy.entity.inmueblesLista;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcDaoSupport;
import org.springframework.stereotype.Repository;

/**
 *
 * @author gian
 */
@Repository
public class InmuebleDaoImpl extends SimpleJdbcDaoSupport implements InmuebleDao {
    
    private static Logger log = LoggerFactory.getLogger(InmuebleDaoImpl.class);
    
    @Autowired
    public InmuebleDaoImpl(DataSource dataSource) {
            log.info("Asignando el dataSource");
            setDataSource(dataSource);
    }

	@Override
	public Integer suscribir(inmueblesLista inmueble) {
		   getJdbcTemplate().update(
	                "insert into preferencias (tipoInmueble,areade,areahasta,distrito,nroHabde,nroHabhasta," +
	                "nroBanosde,nroBanoshasta,hPatio,hJardin,nombreContacto,correoElectronico,staActivo) " +
	                "values (?, ?, ?, ?,?, ?, ?, ?, ?, ?, ?, ?,1)",
	                (inmueble.getTipoInmueble()=="0"||inmueble.getTipoInmueble()==""?null:inmueble.getTipoInmueble()) ,
	                (inmueble.getAreade()=="0"||inmueble.getAreade()==""?null:inmueble.getAreade()) ,
	                (inmueble.getAreahasta()=="0"||inmueble.getAreahasta()==""?null:inmueble.getAreahasta()) ,
	                (inmueble.getDistrito()=="0"||inmueble.getDistrito()==""?null:inmueble.getDistrito()) ,
	                (inmueble.getNroHabde()=="0"||inmueble.getNroHabde()==""?null:inmueble.getNroHabde()) ,
	                (inmueble.getNroHabhasta()=="0"||inmueble.getNroHabhasta()==""?null:inmueble.getNroHabhasta()) ,
	                (inmueble.getNroBanosde()=="0"||inmueble.getNroBanosde()==""?null:inmueble.getNroBanosde()) ,
	                (inmueble.getNroBanoshasta()=="0"||inmueble.getNroBanoshasta()==""?null:inmueble.getNroBanoshasta()) ,
	                (inmueble.gethPatio()=="2"?null:inmueble.gethPatio()=="1"?true:false) ,
	                (inmueble.gethJardin()=="2"?null:inmueble.gethJardin()=="1"?true:false),
	                inmueble.getNumRazSocial(),inmueble.getCorreo());
	        
	        Integer codigoautopreferencias;
	        codigoautopreferencias=getSimpleJdbcTemplate().queryForInt("call identity()");
	       
	        log.info("codigoautopreferencias" + codigoautopreferencias.toString());
	        return codigoautopreferencias;
	}
    @Override
    public Integer insertar(Inmueble Inmueble) {
        
        getJdbcTemplate().update(
                "insert into inmuebles (tipoInmueble, area, distrito,direccion,nroHab,nroBanos,hPatio,hJardin,observaciones) values (?, ?, ?, ?,?, ?, ?, ?, ?)",
                Inmueble.getTipoInmueble(),

                (Inmueble.getArea()=="0"||Inmueble.getArea()==""?null:Inmueble.getArea()) ,Inmueble.getDistrito(),
                Inmueble.getDireccion(), (Inmueble.getNroHab()=="0"||Inmueble.getNroHab()==""?null:Inmueble.getNroHab()),
                (Inmueble.getNroBanos()=="0"||Inmueble.getNroBanos()==""?null:Inmueble.getNroBanos()),
                Inmueble.gethPatio(),Inmueble.gethJardin(),Inmueble.getObservaciones());
        
        Integer codigoautoInmueble;
        codigoautoInmueble=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoInmueble" + codigoautoInmueble.toString()+ "-" + Inmueble.getTipoInmueble());
        
        getJdbcTemplate().update(
                "insert into persona (tipoPersona, numRazSocial, docId,telefono,celular,correo) values (?, ?, ?, ?, ?, ?)",
                Inmueble.getTipoPersona(),Inmueble.getNumRazSocial(),Inmueble.getDocId(),Inmueble.getTelefono(),Inmueble.getCelular(),Inmueble.getCorreo());

        Integer codigoautoPersona;
        codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoPersona" + codigoautoPersona.toString()+ "-" + Inmueble.getNumRazSocial());
        SimpleDateFormat formateador = new SimpleDateFormat(
        		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
        		java.util.Date fechaDate = new java.util.Date();
        		String fecha = formateador.format(fechaDate);
        getJdbcTemplate().update(
                "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoEstado,activo,credat) values (?, ?, ?, ?,?)",
                codigoautoInmueble,codigoautoPersona,Inmueble.getEstado(),true,fecha);

        Integer codigoautoDetalle;
        codigoautoDetalle=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoDetalle" + codigoautoDetalle.toString()+ "-" + Inmueble.getEstado());
        return codigoautoDetalle;
    }
    
    @Override
    public void actualizar(Inmueble Inmueble) {        
        getJdbcTemplate().update(
                "update inmuebles set tipoInmueble = ?, area = ?, distrito = ?, direccion = ? ,nroHab=?, nroBanos=?, hPatio=?, hJardin=?, observaciones=?  where codigo = ?",
                Inmueble.getTipoInmueble(),
                (Inmueble.getArea()=="0"||Inmueble.getArea()==""?null:Inmueble.getArea()),
                Inmueble.getDistrito(),Inmueble.getDireccion(),
                (Inmueble.getNroHab()=="0"||Inmueble.getNroHab()==""?null:Inmueble.getNroHab()),
                (Inmueble.getNroBanos()=="0"||Inmueble.getNroBanos()==""?null:Inmueble.getNroBanos()),
                Inmueble.gethPatio(),Inmueble.gethJardin(),Inmueble.getObservaciones(),Inmueble.getCodigo());        
    }
    
    @Override
    public void eliminar(Inmueble Inmueble) {
        getJdbcTemplate().update(
                "delete from inmuebles where id = ?",Inmueble.getCodigo());        
    }

    @Override
    public void AnulSuscrip(Integer codigo) {
        getJdbcTemplate().update(
                "update preferencias set staActivo=0   where codigo = " + codigo);        
    }
    @Override
    public Inmueble buscar(Integer id) {
    	try {
            return getSimpleJdbcTemplate().queryForObject(
                    "select codigo ,t.descripcion tipoInmuebleDesc,d.descripcion distritoDesc ,i.direccion," +
                    "p.numRazSocial, i.distrito, i.area, i.tipoInmueble,i.nroHab " +
                    "from inmuebles i " +
                    "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                    "left join distrito d on i.distrito=d.codigo " +
                    "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                    "left join persona p on p.codigo=ds.codigoPersona " +
                    "where ds.activo=1 and codigo=?",
                            new BeanPropertyRowMapper<Inmueble>(Inmueble.class), id);
        } catch (EmptyResultDataAccessException e) {
                return null;
        }        
    }
   

    @Override
    public List<Inmueble> buscarTodos() {
        return getSimpleJdbcTemplate().query(
                        "select codigo ,t.descripcion tipoInmuebleDesc,d.descripcion distritoDesc ,i.direccion," +
                        "p.numRazSocial, i.distrito, i.area, i.tipoInmueble,i.nroHab " +
                        "from inmuebles i " +
                        "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                        "left join distrito d on i.distrito=d.codigo " +
                        "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                        "left join persona p on p.codigo=ds.codigoPersona " +
                        "where ds.activo=1 and codigoEstado=6 " ,
                        new BeanPropertyRowMapper<Inmueble>(Inmueble.class));
    }
    @Override
    public List<Inmueble> buscarTodosEstadistico() {
        return getSimpleJdbcTemplate().query(
                        "select codigo ,t.descripcion tipoInmuebleDesc,d.descripcion distritoDesc ,i.direccion," +
                        "p.numRazSocial, i.distrito, i.area, i.tipoInmueble ,e.descripcion tipoEstadoDesc,i.nroHab " +
                        "from inmuebles i " +
                        "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
                        "left join distrito d on i.distrito=d.codigo " +
                        "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
                        "left join persona p on p.codigo=ds.codigoPersona " +
                        "left join estado e on e.codigo=ds.codigoEstado " +
                        "where ds.activo=1 " ,
                        new BeanPropertyRowMapper<Inmueble>(Inmueble.class));
    }
    @Override
    public List<Inmueble> buscarTodosActivos() {
        return getSimpleJdbcTemplate().query(
                        "select id,nombre, doc,correo,telefono,tipoInmueble,descripcion,direccion,Activo from inmuebles",
                        new BeanPropertyRowMapper<Inmueble>(Inmueble.class));
    }
    
    @Override
    public Inmueble buscar(String id) {
        try {
                return getSimpleJdbcTemplate().queryForObject(
                                "select id,nombre,caracteristica,fechaatencion,tarifa,promocion from inmuebles where id=?",
                                new BeanPropertyRowMapper<Inmueble>(Inmueble.class), id);
                
        } catch (EmptyResultDataAccessException e) {
                return null;
        }           
    }

	@Override
	public inmueblesLista buscarFiltro(String codigoDistrito,
			String codigoInmueble, String deArea, String HastaArea,
			String deHab, String HastaHab) {
		try {
			inmueblesLista InmuebleLista = new inmueblesLista();
			
			InmuebleLista.setTipoInmueble(codigoInmueble);
			InmuebleLista.setDistrito(codigoDistrito);
			InmuebleLista.setAreade(deArea);
			InmuebleLista.setAreahasta(HastaArea);
			InmuebleLista.setNroHabde(deHab);
			InmuebleLista.setNroHabhasta(HastaHab);
			
			String queryString ;
			
			queryString="select codigo ,t.descripcion tipoInmuebleDesc,d.descripcion distritoDesc ,i.direccion," +
             "p.numRazSocial, i.distrito, i.area, i.tipoInmueble,i.nroHab " +
             "from inmuebles i " +
             "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
             "left join distrito d on i.distrito=d.codigo " +
             "left join detalleSolicitud ds on ds.codigoInmueble=i.codigo " +
             "left join persona p on p.codigo=ds.codigoPersona " +
             "where ds.activo=1 and codigoEstado=6 ";
             if (!codigoDistrito.equalsIgnoreCase("0")){
            	 queryString= queryString + " and (d.codigo=" + codigoDistrito + ")" ;
             }
             if (!codigoInmueble.equalsIgnoreCase("0")){
            	 queryString= queryString + " and (t.codigo=" + codigoInmueble + ")" ;
             }

             if (deArea!="" && deArea !="0"){
            	 queryString= queryString + " and (i.area >=" + deArea + ")" ;
             }
             if (HastaArea!="" && HastaArea !="0"){
            	 queryString= queryString + " and (i.area <=" + HastaArea + ")" ;
             }
             if (deHab!="" && deHab !="0"){
            	 queryString= queryString + " and (i.nroHab >=" + deHab + ")" ;
             }
             if (HastaHab!="" && HastaHab !="0"){
            	 queryString= queryString + " and (i.nroHab <=" + HastaHab + ")" ;
             }
			
			List<Inmueble> listainm = getSimpleJdbcTemplate().query(queryString,  new BeanPropertyRowMapper<Inmueble>(Inmueble.class));
			InmuebleLista.setInmuebles(listainm);
			return InmuebleLista;
    } catch (EmptyResultDataAccessException e) {
            return null;
    }        
	}
    @Override
    public Integer solicita(Inmueble Inmueble) {
        
   	 getJdbcTemplate().update(
             "Update detalleSolicitud " +
             "set activo=0 where codigoInmueble=?",
             Inmueble.getCodigo());

        getJdbcTemplate().update(
                "insert into persona (tipoPersona, numRazSocial, docId,telefono,celular,correo) values (?, ?, ?, ?, ?, ?)",
                Inmueble.getTipoPersona(),Inmueble.getNumRazSocial(),Inmueble.getDocId(),Inmueble.getTelefono(),Inmueble.getCelular(),Inmueble.getCorreo());

        log.info("codigoautoDetalle" + Inmueble.getCodigo());
        Integer codigoautoPersona;
        codigoautoPersona=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoPersona" + codigoautoPersona.toString());
        SimpleDateFormat formateador = new SimpleDateFormat(
        		"dd 'de' MMMM 'de' yyyy", new Locale("es_ES"));
        		java.util.Date fechaDate = new java.util.Date();
        		String fecha = formateador.format(fechaDate);
        getJdbcTemplate().update(
                "insert into detalleSolicitud (codigoInmueble, codigoPersona, codigoEstado,activo,credat) values (?, ?, ?, ?,?)",
                Inmueble.getCodigo(),codigoautoPersona, 1, true, fecha);

        Integer codigoautoDetalle;
        codigoautoDetalle=getSimpleJdbcTemplate().queryForInt("call identity()");
        log.info("codigoautoDetalle" + codigoautoDetalle.toString()+ "-" + Inmueble.getEstado());
        return codigoautoDetalle;
    }

	@Override
	public List<inmueblesLista> buscarPreferencias() {
		try {
			String queryString ;
			
			queryString="select t.descripcion tipoInmuebleDesc,areade ,areahasta ,d.descripcion distritoDesc ," +
					"nroHabde ,nroHabhasta ,nroBanosde ,nroBanoshasta ,hPatio ,hJardin ,nombreContacto numRazSocial," +
					"correoElectronico correo, codigo " +
             "from preferencias i " +
             "left join tipoInmueble t on i.tipoInmueble=t.codigo " +
             "left join distrito d on i.distrito=d.codigo " +
             "where staActivo=1";
            
			
			List<inmueblesLista> listainm = getSimpleJdbcTemplate().query(queryString,  new BeanPropertyRowMapper<inmueblesLista>(inmueblesLista.class));
			
			return listainm;
	    } catch (EmptyResultDataAccessException e) {
	            return null;
	    }    
    }    
    
}


    