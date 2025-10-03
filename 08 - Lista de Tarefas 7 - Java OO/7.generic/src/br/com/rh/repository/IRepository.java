package br.com.rh.repository;

import br.com.rh.model.Identificavel;
import java.util.List;
import java.util.Optional;

// Interface para o repositório.
public interface IRepository<T extends Identificavel<ID>, ID> {

    void salvar(T entidade);

    Optional<T> buscarPorId(ID id);

    List<T> listarTodos();

    void remover(ID id);
}
