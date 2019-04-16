package br.com.cassi.corporate;

import org.apache.camel.Exchange;

import java.util.function.Function;
import java.util.function.Supplier;

public class ProxyToParametros extends RestParametros {

    public String getTargetUrl() {
        return targetUrl;
    }

    private final String targetUrl;

    public ProxyToParametros(String path, String pathDescription, String uri, String uriDescription, String targetUrl, boolean usarCache, Function<Exchange, String> chaveCache) {
        super(path, pathDescription, uri, uriDescription, usarCache, chaveCache);
        this.targetUrl = targetUrl;
    }
}
