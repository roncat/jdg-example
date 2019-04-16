package br.com.cassi.configuration.infinispan;

import org.apache.camel.component.infinispan.processor.idempotent.InfinispanIdempotentRepository;
import org.infinispan.client.hotrod.RemoteCacheManager;
import org.infinispan.client.hotrod.configuration.ConfigurationBuilder;
import org.infinispan.commons.api.BasicCacheContainer;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class InfinispanConfiguration {

    @Bean(initMethod = "start")
    public BasicCacheContainer remoteCacheContainer() {

        String hostPort = "localhost:11222";

        ConfigurationBuilder builder = new ConfigurationBuilder()
                .forceReturnValues(true)
                .addServers(hostPort)
                .maxRetries(Integer.valueOf(3))
                .connectionTimeout(3000);

        return new RemoteCacheManager(builder.create(), true);
    }

    @Bean
    public InfinispanIdempotentRepository infinispanRepository(BasicCacheContainer cacheContainer) {
        return InfinispanIdempotentRepository.infinispanIdempotentRepository(cacheContainer, "FUSEBARRAMENTO");
    }
}
