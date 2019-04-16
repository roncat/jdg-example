package br.com.cassi.fusebarramento;

import br.com.cassi.corporate.*;
import org.apache.camel.Exchange;
import org.apache.camel.model.rest.RestDefinition;
import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.springframework.http.HttpMethod;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

public abstract class FuseBarramentoBuilderBase extends CassiRouteBuilder {

    private final String fuseBarramentoResourcePath;
    private final String fuseBarramentoDescription;

    public FuseBarramentoBuilderBase() {
        this.fuseBarramentoResourcePath = "/barramento";
        this.fuseBarramentoDescription = "Fuse como barramento de serviço";
    }

    /*protected CassiRouteDefinition proxyGetTo(String uri, String uriDescription, String targetUrl, boolean usarCache) throws IOException {
        ProxyToParametros parametros = new ProxyToParametros(
                fuseBarramentoResourcePath,
                fuseBarramentoDescription,
                uri,
                uriDescription,
                targetUrl,
                usarCache,
                null);
        return super.proxyGetTo(parametros);
    }

    protected CassiRouteDefinition proxyGetTo(String uri, String uriDescription, String targetUrl, boolean usarCache, Supplier<String> chaveCacheCallBack) throws IOException {
        ProxyToParametros parametros = new ProxyToParametros(
                fuseBarramentoResourcePath,
                fuseBarramentoDescription,
                uri,
                uriDescription,
                targetUrl,
                usarCache,
                chaveCacheCallBack);
        return super.proxyGetTo(parametros);
    }

    protected CassiRouteDefinition proxyGetTo(String uri, String uriDescription, String targetUrl) throws IOException {
        ProxyToParametros parametros = new ProxyToParametros(
                fuseBarramentoResourcePath,
                fuseBarramentoDescription,
                uri,
                uriDescription,
                targetUrl,
                false,
                null);
        return super.proxyGetTo(parametros);
    }

    protected CassiRouteDefinition proxyPostTo(String uri, String urlDescription, String targetUrl, Class type, Supplier<String> chaveCacheCallBack) throws IOException {
        ProxyToParametros parametros = new ProxyToParametros(
                fuseBarramentoResourcePath,
                fuseBarramentoDescription,
                uri,
                urlDescription,
                targetUrl,
                false,
                chaveCacheCallBack);
        return super.proxyPostTo(parametros, type);
    }

    protected CassiRouteDefinition proxyPostTo(String uri, String urlDescription, String targetUrl, Class type, Supplier<String> chaveCacheCallBack, Supplier<String> chaveCacheProvider) throws IOException {
        ProxyToParametros parametros = new ProxyToParametros(
                fuseBarramentoResourcePath,
                fuseBarramentoDescription,
                uri,
                urlDescription,
                targetUrl,
                false,
                chaveCacheCallBack);
        return super.proxyPostTo(parametros, type);
    }*/

    /* GET */
    protected <T> CassiRouteDefinition proxyGetCallBack(String uri, String uriDescription, Function<Exchange, T> callBack) throws IOException {

        return proxyGetCallBack(uri, uriDescription, callBack, false, exchange -> null, new ArrayList<>());
    }

    protected <T> CassiRouteDefinition proxyGetCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, List<RestOperationParamDefinition> restParameteres) throws IOException {

        return proxyGetCallBack(uri, uriDescription, callBack, false, exchange -> null, restParameteres);
    }

    protected <T> CassiRouteDefinition proxyGetCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, Function<Exchange, String> chaveFactory) throws IOException {

        return proxyGetCallBack(uri, uriDescription, callBack, usarCache, chaveFactory, new ArrayList<>());
    }

    protected <T> CassiRouteDefinition proxyGetCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, String chave) throws IOException {

        return proxyGetCallBack(uri, uriDescription, callBack, usarCache, exchange -> chave);
    }

    protected <T> CassiRouteDefinition proxyGetCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, String chave, List<RestOperationParamDefinition> restParameteres) throws IOException {

        return proxyGetCallBack(uri, uriDescription, callBack, usarCache, exchange -> chave);
    }

    protected <T> CassiRouteDefinition proxyGetCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, Function<Exchange, String> chaveFactory, List<RestOperationParamDefinition> restParameteres) throws IOException {
        ProxyCallBackParametros parametros = proxyCallBackParametros();

        parametros
                .setUri(uri)
                .setUrlDescription(uriDescription)
                .setCallback(callBack)
                .setUsarCache(usarCache)
                .setCallbackChaveCache(chaveFactory)
                .setRestParans(restParameteres);

        return proxyGetCallBack(parametros);
    }

    protected <T> CassiRouteDefinition proxyGetCallBack(ProxyCallBackParametros proxyCallBackParametros) throws IOException {

        ServiceCallBackParametros<T> parametros = obterServiceCallBackParametros(proxyCallBackParametros);

        return super.proxyCallBack(parametros, HttpMethod.GET, null);
    }


    /* POST */
    protected <T, Y> CassiRouteDefinition proxyPostCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, Class<Y> type) throws IOException {

        return proxyPostCallBack(uri, uriDescription, callBack, false, exchange -> null, new ArrayList<>(), type);
    }

    protected <T, Y> CassiRouteDefinition proxyPostCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, List<RestOperationParamDefinition> restParameteres, Class<Y> type) throws IOException {

        return proxyPostCallBack(uri, uriDescription, callBack, false, exchange -> null, restParameteres, type);
    }

    protected <T, Y> CassiRouteDefinition proxyPostCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, Function<Exchange, String> chaveFactory, Class<Y> type) throws IOException {

        return proxyPostCallBack(uri, uriDescription, callBack, usarCache, chaveFactory, new ArrayList<>(), type);
    }

    protected <T, Y> CassiRouteDefinition proxyPostCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, String chave, Class<Y> type) throws IOException {

        return proxyPostCallBack(uri, uriDescription, callBack, usarCache, exchange -> chave, type);
    }

    protected <T, Y> CassiRouteDefinition proxyPostCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, String chave, List<RestOperationParamDefinition> restParameteres, Class<Y> type) throws IOException {

        return proxyPostCallBack(uri, uriDescription, callBack, usarCache, exchange -> chave, type);
    }

    protected <T, Y> CassiRouteDefinition proxyPostCallBack(String uri, String uriDescription, Function<Exchange, T> callBack, boolean usarCache, Function<Exchange, String> chaveFactory, List<RestOperationParamDefinition> restParameteres, Class<Y> type) throws IOException {
        ProxyCallBackParametros parametros = proxyCallBackParametros();

        parametros
                .setUri(uri)
                .setUrlDescription(uriDescription)
                .setCallback(callBack)
                .setUsarCache(usarCache)
                .setCallbackChaveCache(chaveFactory)
                .setRestParans(restParameteres)
                .setType(type);

        return proxyPostCallBack(parametros);
    }

    protected <T> CassiRouteDefinition proxyPostCallBack(ProxyCallBackParametros proxyCallBackParametros) throws IOException {

        ServiceCallBackParametros<T> parametros = obterServiceCallBackParametros(proxyCallBackParametros);

        return super.proxyCallBack(parametros, HttpMethod.POST, proxyCallBackParametros.getType());
    }

    private <T> ServiceCallBackParametros<T> obterServiceCallBackParametros(ProxyCallBackParametros proxyCallBackParametros) {
        ServiceCallBackParametros<T> parametros = new ServiceCallBackParametros<T>(
                proxyCallBackParametros.getCallback(),
                fuseBarramentoResourcePath,
                fuseBarramentoDescription,
                proxyCallBackParametros.getUri(),
                proxyCallBackParametros.getUrlDescription(),
                proxyCallBackParametros.isUsarCache(),
                proxyCallBackParametros.getCallbackChaveCache()
        );

        if (proxyCallBackParametros.getRestParans() != null && !proxyCallBackParametros.getRestParans().isEmpty())
            parametros.setRestParams(proxyCallBackParametros.getRestParans());

        return parametros;
    }

    protected ProxyCallBackParametros proxyCallBackParametros(){
        return new ProxyCallBackParametros();
    }
}
