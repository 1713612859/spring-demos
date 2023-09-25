package com.example.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * 开启websocket
 *
 * @Desc WebsocketConfig
 * @Author LiuYunLong
 */

@Configuration
@EnableWebSocket
public class WebSocketConfig {


	 /**
	  * @return {@link ServerEndpointExporter}
	  */
	 @Bean
	 public ServerEndpointExporter serverEndpointExporter(){
		  return new ServerEndpointExporter();
	 }

}
