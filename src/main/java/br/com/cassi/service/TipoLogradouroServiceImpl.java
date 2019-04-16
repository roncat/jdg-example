/*
 * Copyright 2019 Red Hat, Inc. and/or its affiliates
 * and other contributors as indicated by the @author tags.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package br.com.cassi.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.cassi.model.TipoLogradouro;
import br.com.cassi.repository.TipoLogradouroRepository;
import br.com.cassi.service.dto.TipoLogradouroDTO;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service("tipoLogradouro")
@Transactional
public class TipoLogradouroServiceImpl implements TipoLogradouroService {

    private static final Logger logger = LoggerFactory.getLogger(TipoLogradouroServiceImpl.class);

    @Autowired
    private TipoLogradouroRepository repository;

    @Override
    public TipoLogradouro findByFilter(TipoLogradouroDTO filter) {
        if (filter.getDescricao() == null) {
            return null;
        }

        List<TipoLogradouro> list = repository.findAll(new Specification<TipoLogradouro>() {

            @Override
            public Predicate toPredicate(Root<TipoLogradouro> root, CriteriaQuery<?> query, CriteriaBuilder cb) {

                List<Predicate> predicates = new ArrayList<>();

                if (filter.getDescricao() != null) {
                    predicates.add(
                            cb.equal(root.get(TipoLogradouro.getJPAColumnName(TipoLogradouro::getDescricao)), filter.getDescricao()));
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        });

        return (list != null && list.size() > 0) ? list.get(0) : null;
    }

}
