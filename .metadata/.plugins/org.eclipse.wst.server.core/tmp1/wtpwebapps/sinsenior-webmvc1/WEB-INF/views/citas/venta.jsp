<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Venta inmueble</h1><br/><br/>
    <form:form action="new" method="post" commandName="citas" cssClass="form-horizontal">
        <div class="row">
            <div class="control-group">
                <label>Nombre/Razon Social:</label>
                <div class="controls">
                    <form:input path="nombre"  readOnly="true"></form:input>
                    <form:errors path="nombre" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>DNI/RUC:</label>
                <div class="controls">
                    <form:input path="doc"  readOnly="true"></form:input>
                    <form:errors path="doc" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electr�nico:</label>
                <div class="controls">
                    <form:input path="correo"  readOnly="true"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Telefono:</label>
                <div class="controls">
                    <form:input path="telefono"  readOnly="true"></form:input>
                    <form:errors path="telefono" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Tipo  Inmueble:</label>
                <div class="controls">
                    <form:input path="tipoInmueble"></form:input>
                    <form:errors path="tipoInmueble" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Descripci�n:</label>
                <div class="controls">
                    <form:input path="descripcion"  readOnly="true"></form:input>
                    <form:errors path="descripcion" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Direcci�n</label>
                <div class="controls">
                    <form:input path="direccion"  readOnly="true"></form:input>
                    <form:errors path="direccion" cssstyle="color:red"></form:errors>
                </div>
            </div>    
            <div class="control-group" style="display:none">
                <label>Activo</label>
                <div class="controls">
                    <form:input path="activo" value="0"></form:input>
                </div>
            </div>           
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Save" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/usuarios/logout'/>">Cancelar</a>
        </div>                
    </form:form>
</div>
