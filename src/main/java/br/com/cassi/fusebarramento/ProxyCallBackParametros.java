package br.com.cassi.fusebarramento;

import org.apache.camel.Exchange;
import org.apache.camel.model.rest.RestOperationParamDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public class ProxyCallBackParametros<T> {

    ProxyCallBackParametros() {
        this.restParans = new ArrayList<>();
    }

    private Class<?> type;

    public Class<?> getType() {
        return type;
    }

    public void setType(Class<?> type) {
        this.type = type;
    }

    private Function<Exchange, T> callback;
    private Function<Exchange, T> callbackChaveCache;
    private String uri;
    private String urlDescription;
    private List<RestOperationParamDefinition> restParans;
    private boolean usarCache;


    public Function<Exchange, T> getCallback() {
        return callback;
    }

    public ProxyCallBackParametros<T> setCallback(Function<Exchange, T> callback) {
        this.callback = callback;
        return this;
    }

    public Function<Exchange, T> getCallbackChaveCache() {
        return callbackChaveCache;
    }

    public ProxyCallBackParametros<T> setCallbackChaveCache(Function<Exchange, T> callbackChaveCache) {
        this.callbackChaveCache = callbackChaveCache;
        return this;
    }

    public String getUri() {
        return uri;
    }

    public ProxyCallBackParametros<T> setUri(String uri) {
        this.uri = uri;
        return this;
    }

    public String getUrlDescription() {
        return urlDescription;
    }

    public ProxyCallBackParametros<T> setUrlDescription(String urlDescription) {
        this.urlDescription = urlDescription;
        return this;
    }

    public List<RestOperationParamDefinition> getRestParans() {
        return restParans;
    }

    public ProxyCallBackParametros<T> setRestParans(List<RestOperationParamDefinition> restParans) {
        this.restParans = restParans;
        return this;
    }

    public boolean isUsarCache() {
        return usarCache;
    }

    public ProxyCallBackParametros<T> setUsarCache(boolean usarCache) {
        this.usarCache = usarCache;
        return this;
    }
}
