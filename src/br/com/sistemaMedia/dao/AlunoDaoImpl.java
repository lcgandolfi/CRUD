package br.com.sistemaMedia.dao;

import br.com.sistemaMedia.entidade.Aluno;
import br.com.sistemaMedia.entidade.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class AlunoDaoImpl implements AlunoDao {

    private Connection conexao;
    private PreparedStatement preparaSql;
    private ResultSet resultado;

    @Override
    public void salvar(Aluno aluno) throws SQLException {
        String sql = "INSERT INTO aluno(nome, nota1, nota2, professor_id,"
                + "media, estado)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        try {

            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparaSql.setString(1, aluno.getNome());
            preparaSql.setDouble(2, aluno.getNota1());
            preparaSql.setDouble(3, aluno.getNota2());
            preparaSql.setInt(4, aluno.getId_professor());
            preparaSql.setDouble(5, aluno.getMedia());
            preparaSql.setString(6, aluno.getEstado());
            preparaSql.executeUpdate();
            resultado = preparaSql.getGeneratedKeys();
            resultado.next();
            aluno.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("erro ao cadastrar aluno" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
    }

    @Override
    public void alterar(Aluno aluno) throws SQLException {
        String sql = "UPDATE aluno SET nome = ? WHERE id = ? ";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, aluno.getNome());
            preparaSql.setInt(2, aluno.getId());
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("aluno nao foi alterado" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public void excluir(Aluno aluno) throws SQLException {
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao
                    .prepareStatement("DELETE FROM aluno WHERE id = ?");
            preparaSql.setInt(1, aluno.getId());
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir o aluno" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public Aluno pesquisarPorId(int id) throws SQLException {
        Aluno aluno = null;
        String sql = "SELECT * FROM aluno WHERE id = ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setInt(1, id);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setNota1(resultado.getDouble("nota1"));
                aluno.setNota2(resultado.getDouble("nota2"));
                aluno.setId_professor(resultado.getInt("professor_id"));
                aluno.setMedia(resultado.getDouble("media"));
                aluno.setEstado(resultado.getString("estado"));

            }
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por id" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return aluno;

    }

    @Override
    public List<Aluno> pesquisarPorNome(String nome) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno WHERE nome LIKE ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, "%" + nome + "%");
            resultado = preparaSql.executeQuery();
            Aluno aluno;
            while (resultado.next()) {
                aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setNota1(resultado.getDouble("nota1"));
                aluno.setNota2(resultado.getDouble("nota2"));
                aluno.setId_professor(resultado.getInt("professor_id"));
                aluno.setMedia(resultado.getDouble("media"));
                aluno.setEstado(resultado.getString("estado"));
                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por nome "
                    + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return alunos;
    }

    @Override
    public List<Aluno> mostrarAlunos(Professor professor) throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        String sql = "SELECT * FROM aluno WHERE professor_id = ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setInt(1,professor.getId());
            resultado = preparaSql.executeQuery();
            Aluno aluno;
            while (resultado.next()) {
                aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setNota1(resultado.getDouble("nota1"));
                aluno.setNota2(resultado.getDouble("nota2"));
                aluno.setId_professor(resultado.getInt("professor_id"));
                aluno.setMedia(resultado.getDouble("media"));
                aluno.setEstado(resultado.getString("estado"));
                alunos.add(aluno);
            }

        } catch (Exception e) {
            System.out.println("Erro ao mostrar alunos "
                    + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return alunos;
    }

    @Override
    public Aluno pesquisarAluno(String nome) throws SQLException {
        Aluno aluno = null;
        String sql = "SELECT * FROM aluno WHERE nome LIKE ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, "%" + nome + "%");
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                aluno = new Aluno();
                aluno.setId(resultado.getInt("id"));
                aluno.setNome(resultado.getString("nome"));
                aluno.setNota1(resultado.getDouble("nota1"));
                aluno.setNota2(resultado.getDouble("nota2"));
                aluno.setId_professor(resultado.getInt("professor_id"));
                aluno.setMedia(resultado.getDouble("media"));
                aluno.setEstado(resultado.getString("estado"));
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por nome "
                    + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return aluno;
    }

}
