package br.com.cassi.fusebarramento;

import br.com.cassi.response.ApiResponse;
import br.com.cassi.service.DatabaseService;
import br.com.cassi.service.TipoLogradouroService;
import br.com.cassi.service.dto.TipoLogradouroDTO;

import org.apache.camel.model.rest.RestOperationParamDefinition;
import org.apache.camel.model.rest.RestParamType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Component
public class FuseBarramentoRouteBuilder extends FuseBarramentoBuilderBase {

    @Autowired
    private DatabaseService databaseService;

    @Autowired
    private TipoLogradouroService tipoLogradouroService;

    @Override
    public void configure() throws IOException {

        proxyPostCallBack("/", "Buscar tipo logradouro",
                exchange -> {
                        TipoLogradouroDTO jsonData = exchange.getIn().getBody(TipoLogradouroDTO.class);
                        return tipoLogradouroService.findByFilter(jsonData);
                } , true, "tipoLogradouro", TipoLogradouroDTO.class);
                
                /* ProxyCallBackParametros parametrosListarContratos = new ProxyCallBackParametros<>()
                .setUri("/")
                .setUrlDescription("Buscar tipo logradouro")
                .setCallback(exchange -> {
                        TipoLogradouroDTO jsonData = exchange.getIn().getBody(TipoLogradouroDTO.class);
                        return tipoLogradouroService.findByFilter(jsonData);
                })
                .setUsarCache(true)
                .setCallbackChaveCache(exchange -> "teste")
                .setType(TipoLogradouroDTO.class); */
    }
}
