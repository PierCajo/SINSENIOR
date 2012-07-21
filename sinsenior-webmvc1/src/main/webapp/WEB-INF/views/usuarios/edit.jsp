<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
 
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>

<div class="container">
    <h1>Editar Usuario</h1><br/><br/>
    <form:form action="edit" method="post" commandName="usuario" cssClass="form-horizontal">
        <div class="row">
            <form:hidden path="id"></form:hidden>
            <div class="control-group">
                <label>tipousuario:</label>
                <div class="controls">
                    <form:input path="tipousuario"></form:input>
                    <form:errors path="tipousuario" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Nombre:</label>
                <div class="controls">
                    <form:input path="nombre"></form:input>
                    <form:errors path="nombre" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>apellidos:</label>
                <div class="controls">
                    <form:input path="apellidos"></form:input>
                    <form:errors path="apellidos" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>sexo:</label>
                <div class="controls">
                    <form:input path="sexo"></form:input>
                    <form:errors path="sexo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>tipodocumento:</label>
                <div class="controls">
                    <form:input path="tipodocumento"></form:input>
                    <form:errors path="tipodocumento" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>numerodocumento:</label>
                <div class="controls">
                    <form:input path="numerodocumento"></form:input>
                    <form:errors path="numerodocumento" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>Correo electrónico:</label>
                <div class="controls">
                    <form:input path="correo"></form:input>
                    <form:errors path="correo" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>password:</label>
                <div class="controls">
                    <form:input path="password"></form:input>
                    <form:errors path="password" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>fechaNacimiento:</label>
                <div class="controls">
                    <form:input path="fechaNacimiento"></form:input>
                    <form:errors path="fechaNacimiento" cssstyle="color:red"></form:errors>
                </div>
            </div>
            <div class="control-group">
                <label>numerocelular:</label>
                <div class="controls">
                    <form:input path="numerocelular"></form:input>
                    <form:errors path="numerocelular" cssstyle="color:red"></form:errors>
                </div>
            </div>
                
        </div>
        <div class="actions" style="margin-left: 160px;">
            <input name="" value="Editar" type="submit" class="btn btn-primary">
            <a style="margin-left: 5px;" href="<c:url value='/pages/usuarios/index'/>">Cancelar</a>
        </div>
    </form:form>
</div>
