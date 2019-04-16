package br.com.cassi.corporate;

import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.RouteDefinition;
import org.apache.camel.model.dataformat.JsonLibrary;

public class CassiRouteDefinition<T extends ProcessorDefinition<?>> extends RouteDefinition {
    private RouteDefinition routeDefinition;

    public RouteDefinition getRoute() {
        return routeDefinition;
    }

    public void setRoute(RouteDefinition routeDefinition) {
        this.routeDefinition = routeDefinition;
    }

    public CassiRouteDefinition(RouteDefinition routeDefinition) {
        this.routeDefinition = routeDefinition;
    }

    public T parseToJson(){
        return (T) this.getRoute().convertBodyTo(String.class)
                .unmarshal().json(JsonLibrary.Jackson);
    }

    public T parseJsonAs(Class tipoDestino){
        return (T) this.getRoute().convertBodyTo(String.class)
                .unmarshal().json(JsonLibrary.Jackson, tipoDestino);
    }


}
