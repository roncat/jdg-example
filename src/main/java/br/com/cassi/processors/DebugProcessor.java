package br.com.cassi.processors;

import br.com.cassi.response.ApiResponse;
import br.com.cassi.service.CacheService;
import br.com.cassi.service.CacheServiceImpl;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.infinispan.commons.api.BasicCacheContainer;
import org.infinispan.manager.CacheContainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DebugProcessor implements Processor {

    @Autowired
    private CacheService cacheService;

    @Override
    public void process(Exchange exchange) throws Exception {
        cacheService.ObterOuAtribuir("Cache", () -> exchange.getIn().getBody(ApiResponse.class).getData(), Object.class);
    }
}
