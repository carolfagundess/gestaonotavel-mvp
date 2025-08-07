package br.com.gestao.notavel.mvp.dao;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author carol
 *
 * A interface 'DAO' é um contrato genérico para operações de acesso a dados
 * (CRUD) 'T' representa o tipo da entidade (ex: Produto, Cliente). 'K'
 * representa o tipo da chave primária (ex: Long, Integer, String).
 */
public interface GenericDAO<T, K> {
    // CREATE: Salva uma nova entidade no banco de dados.
    void salvar(T entidade);
    // READ (by ID): Busca uma entidade pela sua chave primária.
    // Usamos Optional para indicar que o resultado pode não existir (ser nulo).
    Optional<T> buscarPorId(K id);
    // READ (all): Retorna uma lista com todas as entidades.
    List<T> buscarTodos();
    // UPDATE: Atualiza uma entidade existente.
    void atualizar(T entidade);
    // DELETE: Remove uma entidade do banco de dados pelo seu ID.
    void excluir(K id);
}
