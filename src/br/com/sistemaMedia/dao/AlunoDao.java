package br.com.sistemaMedia.dao;

import br.com.sistemaMedia.entidade.Aluno;
import br.com.sistemaMedia.entidade.Professor;
import java.sql.SQLException;
import java.util.List;

public interface AlunoDao {

    void salvar(Aluno aluno) throws SQLException;

    void alterar(Aluno aluno) throws SQLException;

    void excluir(Aluno aluno) throws SQLException;

    Aluno pesquisarPorId(int id) throws SQLException;

    List<Aluno> pesquisarPorNome(String nome) throws SQLException;

    List<Aluno> mostrarAlunos(Professor professor) throws SQLException;
    
    Aluno pesquisarAluno(String nome) throws SQLException;

}
