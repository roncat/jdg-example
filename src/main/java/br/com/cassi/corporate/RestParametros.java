package br.com.cassi.corporate;

import org.apache.camel.Exchange;
import org.apache.camel.model.rest.RestOperationParamDefinition;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public abstract class RestParametros {
    private List<RestOperationParamDefinition> restParams;
    private Class<?> postRestParam;
    private final Function<Exchange, String> chaveCacheCallBack;
    private String path;
    private String pathDescription;
    private String uri;
    private String uriDescription;
    private boolean usarCache;

    public RestParametros(String path, String pathDescription, String uri, String uriDescription, boolean usarCache, Function<Exchange,String> chaveCacheCallBack){
        this.path = path;
        this.pathDescription = pathDescription;
        this.uri = uri;
        this.uriDescription = uriDescription;
        this.usarCache = usarCache;
        this.chaveCacheCallBack = chaveCacheCallBack;
        this.restParams = new ArrayList<>();
    }

    public Class<?> getPostRestParam() {
        return postRestParam;
    }

    public void setPostRestParam(Class<?> postRestParam) {
        this.postRestParam = postRestParam;
    }

    public List<RestOperationParamDefinition> getRestParams() {
        return restParams;
    }

    public void setRestParams(List<RestOperationParamDefinition> restParams) {
        this.restParams = restParams;
    }

    public Function<Exchange, String> getChaveCacheCallBack() {
        return chaveCacheCallBack;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPathDescription() {
        return pathDescription;
    }

    public void setPathDescription(String pathDescription) {
        this.pathDescription = pathDescription;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getUriDescription() {
        return uriDescription;
    }

    public void setUriDescription(String uriDescription) {
        this.uriDescription = uriDescription;
    }

    public boolean isUsarCache() {
        return usarCache;
    }

    public void setUsarCache(boolean usarCache) {
        this.usarCache = usarCache;
    }
}
