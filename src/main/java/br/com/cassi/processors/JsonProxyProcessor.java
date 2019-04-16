package br.com.cassi.processors;

import br.com.cassi.helper.CassiJsonHelper;
import br.com.cassi.corporate.CamelEnum;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;

public class JsonProxyProcessor implements org.apache.camel.Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        ObjectMapper mapper = CassiJsonHelper.getObjectMapper();

        exchange.getOut().setBody(mapper.writeValueAsString(exchange.getIn().getBody()));
        exchange.getOut().setHeaders(exchange.getIn().getHeaders());

        exchange.setProperty(CamelEnum.ORIGINAL_REQUEST.toString(), exchange.getIn().getBody());
    }
}
