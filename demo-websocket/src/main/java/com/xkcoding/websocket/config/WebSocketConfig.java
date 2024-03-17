package com.xkcoding.websocket.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

/**
 * <p>
 * WebSocket配置
 * </p>
 *
 * @author yangkai.shen
 * @date Created in 2018-12-14 15:58
 */
@Configuration
@EnableWebSocket
@EnableWebSocketMessageBroker
public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // 注册一个 /notification 端点，前端通过这个端点进行连接
        registry.addEndpoint("/notification") // 怪不得
            //解决跨域问题
            .setAllowedOrigins("*").withSockJS();
    }

    /*
    * enableSimpleBroker()方法指定了一个前缀地址 /topic，
    * 这意味着所有以 /topic 开始的消息目的地（destination）都将通过此代理发送和接收消息。
    * 在实际应用中，这意味着当服务端通过STOMP协议向指定的主题（topic）地址发送消息时，
    * 例如 /topic/news 或 /topic/update，订阅了这些主题的客户端将会接收到对应的消息。
    * */
    @Override
    public void configureMessageBroker(MessageBrokerRegistry registry) {
        //定义了一个客户端订阅地址的 前缀信息，也就是客户端接收服务端发送消息的 前缀信息
        registry.enableSimpleBroker("/topic");
    }

}
