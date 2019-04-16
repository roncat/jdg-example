package br.com.cassi.routesettings;

import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.stereotype.Component;

@Component
public class RouteSettings extends RouteBuilder {
    @Override
    public void configure() {
        restConfiguration()
                .apiContextPath("/api-doc")
                .contextPath("/api")
                .apiProperty("api.title", "Fuse Como Barramento de Serviço - Blue Print")
                .apiProperty("api.version", "1.0")
                .apiProperty("cors", "true")
                .apiProperty("host", "")
                .apiContextRouteId("doc-api")
                .component("servlet")
                .bindingMode(RestBindingMode.json);
    }
}
