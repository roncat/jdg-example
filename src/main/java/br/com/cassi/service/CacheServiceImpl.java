package br.com.cassi.service;

import org.infinispan.commons.api.BasicCacheContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.io.IOException;
import java.util.function.Supplier;

@Component
public class CacheServiceImpl implements CacheService {

    @Autowired
    private BasicCacheContainer cacheContainer;

    @Override
    public <T> T ObterOuAtribuir(String chave, Supplier<T> callback, Class<T> type) throws IOException {
        T item;

        Object objeto = cacheContainer.getCache().get(chave);

        if (objeto == null)
        {
            item = callback.get();
            cacheContainer.getCache().put(chave, item);
        }
        else
        {
            return (T)objeto;
        }

        return item;
    }
}
