//package com.gateway.filter;
//
//import org.springframework.cloud.gateway.filter.GatewayFilterChain;
//import org.springframework.cloud.gateway.filter.GlobalFilter;
//import org.springframework.core.annotation.Order;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.server.reactive.ServerHttpRequest;
//import org.springframework.http.server.reactive.ServerHttpResponse;
//import org.springframework.stereotype.Component;
//import org.springframework.util.MultiValueMap;
//import org.springframework.web.server.ServerWebExchange;
//import reactor.core.publisher.Mono;
//
//@Component
////数值越小 优先级越高 -1最高
//@Order(-1)
//public class CustumerGlobalFilter implements GlobalFilter {
//    @Override
//    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
//
//        ServerHttpRequest request = exchange.getRequest();
//
//        MultiValueMap<String, String> multiValueMap =  request.getQueryParams();
//
//        //获取请求参数
//        String author = multiValueMap.getFirst("xxx");
//        //处理参数
//        if("xxx".equals(author)){
//            //逻辑
//
//        }
//
//        //放行
//        ServerHttpResponse response =exchange.getResponse();
//
//        response.setStatusCode(HttpStatus.OK);
//
//        return  chain.filter(exchange);
//    }
//}
