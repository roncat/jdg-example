package br.com.cassi.corporate;

import org.apache.camel.Exchange;

import java.util.function.Function;

public class ServiceCallBackParametros<T> extends RestParametros{

    private Function<Exchange, T> callback;

    public ServiceCallBackParametros(
            Function<Exchange, T> callback,
            String path,
            String pathDescription,
            String uri,
            String uriDescription,
            boolean usarCache,
            Function<Exchange, String> chaveCacheProvider) {
        super(path, pathDescription, uri, uriDescription, usarCache, chaveCacheProvider);

        this.callback = callback;
    }

    public Function<Exchange, T> getCallback() {
        return callback;
    }

    public void setCallback(Function<Exchange, T> callback) {
        this.callback = callback;
    }
}
