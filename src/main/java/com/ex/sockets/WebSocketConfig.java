package com.ex.sockets;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

import com.ex.beans.Message;
import com.ex.beans.OutputMessage;

@Configuration
@EnableWebSocketMessageBroker
@CrossOrigin(origins = "*")
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {
 
	//final static Logger logger = Logger.getLogger(WebSocketConfig.class);
	
    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        config.setApplicationDestinationPrefixes("/app");
    }
 
    public void registerStompEndpoints(StompEndpointRegistry registry) {
         registry.addEndpoint("/chat").setAllowedOrigins("*");
         registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
    }
    
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage send(Message message) throws Exception {
    	
    	//logger.trace(message);
    	
    	String time = new SimpleDateFormat("HH:mm").format(new Date());
    	return new OutputMessage(message.getFrom(), message.getText(), time);
    }
}
