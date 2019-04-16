package br.com.cassi.service;

import java.io.IOException;
import java.util.function.Supplier;

public interface CacheService {
    <T> T ObterOuAtribuir(String chave, Supplier<T> callback, Class<T> type) throws IOException;
}