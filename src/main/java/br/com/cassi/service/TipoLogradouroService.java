package br.com.cassi.service;

import br.com.cassi.model.TipoLogradouro;
import br.com.cassi.service.dto.TipoLogradouroDTO;

public interface TipoLogradouroService {

    TipoLogradouro findByFilter(TipoLogradouroDTO filter);

}