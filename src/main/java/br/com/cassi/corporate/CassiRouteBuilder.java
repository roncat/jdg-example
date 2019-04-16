package br.com.cassi.corporate;

        import br.com.cassi.processors.JsonProxyProcessor;
import br.com.cassi.service.CacheService;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.rest.RestDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;

import java.io.IOException;

public abstract class CassiRouteBuilder extends RouteBuilder {

    @Autowired
    private CacheService cacheService;

    private CassiRouteDefinition proxyTo(ProxyToParametros parametros, HttpMethod httpMethod, Class type) throws IOException {

        RouteDefinition routeDef = ObterRouteDefinition(parametros, httpMethod, type);

        if (httpMethod == HttpMethod.POST) {
            routeDef = routeDef.process(new JsonProxyProcessor());
        }

        if (parametros.isUsarCache()){
            routeDef.to(parametros.getTargetUrl())
                    .process(exchange ->
                            cacheService.ObterOuAtribuir(parametros.getTargetUrl(),
                                    () -> exchange.getIn().getBody(String.class), String.class));
        }

        routeDef.to(parametros.getTargetUrl());

        return new CassiRouteDefinition(routeDef);
    }

    protected RouteDefinition ObterRouteDefinition(RestParametros parametros, HttpMethod httpMethod, Class type){
        RestDefinition restDefinition = rest(parametros.getPath())
                .description(parametros.getPathDescription());

        if (httpMethod == HttpMethod.GET)
            restDefinition = restDefinition.get(parametros.getUri());
        else if (httpMethod == HttpMethod.POST) {
            restDefinition = restDefinition.post(parametros.getUri()).type(type);
        }

        if (parametros.getRestParams() != null && !parametros.getRestParams().isEmpty()){
            restDefinition.params(parametros.getRestParams());
        }

        return restDefinition.description(parametros.getUriDescription())
                .produces("aplication/json")
                .route()
                .removeHeaders("CamelHttp*", "CamelHttpMethod");
    }

    protected CassiRouteDefinition proxyGetTo(ProxyToParametros parametros) throws IOException {
        return proxyTo(parametros, HttpMethod.GET, null);
    }

    protected CassiRouteDefinition proxyPostTo(ProxyToParametros parametros, Class type) throws IOException {
        return proxyTo(parametros, HttpMethod.POST, type);
    }

    protected CassiRouteDefinition proxyCallBack(ServiceCallBackParametros parametros, HttpMethod httpMethod, Class type) throws IOException {

        RouteDefinition routeDef = ObterRouteDefinition(parametros, httpMethod, type);

        routeDef = routeDef.process(exchange -> {
            Object item;
            if (parametros.isUsarCache()){
                item = cacheService.ObterOuAtribuir(parametros.getChaveCacheCallBack().apply(exchange), () -> parametros.getCallback().apply(exchange), type);
            } else
                item = parametros.getCallback().apply(exchange);

            exchange.getOut().setBody(item);
        });

        return new CassiRouteDefinition(routeDef);
    }
}
