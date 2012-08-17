package org.assembly;



import javax.jms.Destination;

import javax.jms.JMSException;

import javax.jms.MapMessage;

import javax.jms.Message;

import javax.jms.Session;



import org.springframework.jms.core.JmsTemplate;

import org.springframework.jms.core.MessageCreator;





public class EnviadorDeMensajesImpl implements EnviadorDeMensajes {



private static final String MENSAJE = "Hoy te escribo una carta mi peque�a Maria, " +

                               "yo que tanto te quiero y que todos los d�as me acuerdo de ti, " +

                               "yo me acuerdo de ti.";



private JmsTemplate jmsTemplate = null;



// usado por spring para inyectar el jms template.

public void setJmsTemplate(JmsTemplate jmsTemplate) {

this.jmsTemplate = jmsTemplate;

}





private Destination destino = null;



// usado por spring para inyectar el destino.

public void setDestino(Destination destino) {

this.destino = destino;

}



public void enviarUnMensaje() {

jmsTemplate.send(

  this.destino,

  new MessageCreator() {


    public Message createMessage(Session session) throws JMSException {

     MapMessage mensaje = session.createMapMessage();

   

     mensaje.setString("mensaje", MENSAJE);

   

     return mensaje;

    }

   }

  );

}








}

