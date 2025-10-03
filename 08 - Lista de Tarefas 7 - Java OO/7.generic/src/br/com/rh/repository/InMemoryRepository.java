package br.com.rh.repository;

import br.com.rh.exception.EntidadeNaoEncontradaException;
import br.com.rh.model.Identificavel;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

// Implementação do repositório em memória.
public class InMemoryRepository<T extends Identificavel<ID>, ID> implements IRepository<T, ID> {

    private final Map<ID, T> bancoDeDados = new ConcurrentHashMap<>();

    @Override
    public void salvar(T entidade) {
        bancoDeDados.put(entidade.getId(), entidade);
    }

    @Override
    public Optional<T> buscarPorId(ID id) {
        return Optional.ofNullable(bancoDeDados.get(id));
    }

    @Override
    public List<T> listarTodos() {
        // Retorna uma cópia imutável da lista de valores.
        return Collections.unmodifiableList(new ArrayList<>(bancoDeDados.values()));
    }

    @Override
    public void remover(ID id) {
        if (!bancoDeDados.containsKey(id)) {
            throw new EntidadeNaoEncontradaException("Funcionário com ID " + id + " não encontrado.");
        }
        bancoDeDados.remove(id);
    }
}
