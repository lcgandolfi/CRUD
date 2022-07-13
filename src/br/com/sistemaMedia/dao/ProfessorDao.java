
package br.com.sistemaMedia.dao;

import br.com.sistemaMedia.entidade.Professor;
import java.sql.SQLException;
import java.util.List;


public interface ProfessorDao {
    
    void salvar(Professor professor) throws SQLException;

    void alterar(Professor professor) throws SQLException;

    void excluir(Professor professor) throws SQLException;

    Professor pesquisarPorId(int id) throws SQLException;

    List<Professor> pesquisarPorNome(String nome) throws SQLException;
    
    Professor pesquisarUserSenha(String user, String senha) throws SQLException;
    
}
