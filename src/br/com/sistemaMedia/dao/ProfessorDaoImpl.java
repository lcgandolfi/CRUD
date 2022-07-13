package br.com.sistemaMedia.dao;

import br.com.sistemaMedia.entidade.Professor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDaoImpl implements ProfessorDao {

    private Connection conexao;
    private PreparedStatement preparaSql;
    private ResultSet resultado;

    @Override
    public void salvar(Professor professor) throws SQLException {
        String sql = "INSERT INTO professor(nome, qtdAluno, diciplina, senha,"
                + "usuario, mediaPassar)"
                + " VALUES(?, ?, ?, ?, ?, ?)";
        try {

            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql,
                    Statement.RETURN_GENERATED_KEYS);
            preparaSql.setString(1, professor.getNome());
            preparaSql.setInt(2, professor.getQtdAluno());
            preparaSql.setString(3, professor.getDiciplina());
            preparaSql.setString(4, professor.getSenha());
            preparaSql.setString(5, professor.getUsuario());
            preparaSql.setDouble(6, professor.getMediaPassar());
            preparaSql.executeUpdate();
            resultado = preparaSql.getGeneratedKeys();
            resultado.next();
            professor.setId(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("erro ao cadastrar professor" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
    }

    @Override
    public void alterar(Professor professor) throws SQLException {
        String sql = "UPDATE professor SET nome = ?, qtdAluno = ?, "
                + "diciplina = ?, senha = ?, usuario = ?, mediaPassar = ? "
                + "WHERE id = ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, professor.getNome());
            preparaSql.setInt(2, professor.getQtdAluno());
            preparaSql.setString(3, professor.getDiciplina());
            preparaSql.setString(4, professor.getSenha());
            preparaSql.setString(5, professor.getUsuario());
            preparaSql.setDouble(6, professor.getMediaPassar());
            preparaSql.setInt(7, professor.getId());
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("professor nao foi alterado" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public void excluir(Professor professor) throws SQLException {
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao
                    .prepareStatement("DELETE FROM professor WHERE id = ?");
            preparaSql.setInt(1, professor.getId());
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("erro ao excluir o professor" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public Professor pesquisarPorId(int id) throws SQLException {
        Professor professor = null;
        String sql = "SELECT * FROM professor WHERE id = ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setInt(1, id);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                professor = new Professor();
                professor.setId(resultado.getInt("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setQtdAluno(resultado.getInt("qtdAluno"));
                professor.setDiciplina(resultado.getString("diciplina"));
                professor.setSenha(resultado.getString("senha"));
                professor.setUsuario(resultado.getString("usuario"));
                professor.setMediaPassar(resultado.getDouble("mediaPassar"));

            }
        } catch (Exception e) {
            System.out.println("erro ao pesquisar por id" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return professor;
    }

    @Override
    public List<Professor> pesquisarPorNome(String nome) throws SQLException {
        List<Professor> professores = new ArrayList<>();
        String sql = "SELECT * FROM professor WHERE nome LIKE ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, "%" + nome + "%");
            resultado = preparaSql.executeQuery();
            Professor professor;
            while (resultado.next()) {
                professor = new Professor();
                professor.setId(resultado.getInt("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setQtdAluno(resultado.getInt("qtdAluno"));
                professor.setDiciplina(resultado.getString("diciplina"));
                professor.setSenha(resultado.getString("senha"));
                professor.setUsuario(resultado.getString("usuario"));
                professor.setMediaPassar(resultado.getDouble("mediaPassar"));
                professores.add(professor);
            }

        } catch (Exception e) {
            System.out.println("Erro ao pesquisar por nome "
                    + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return professores;

    }

    @Override
    public Professor pesquisarUserSenha(String user, String senha) throws SQLException {
        Professor professor = null;
        String sql = "SELECT * FROM professor WHERE usuario LIKE ? AND senha LIKE ?";
        try {
            conexao = Conectar.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, "%" + user + "%");
            preparaSql.setString(2, "%" + senha + "%");
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                professor = new Professor();
                professor.setId(resultado.getInt("id"));
                professor.setNome(resultado.getString("nome"));
                professor.setQtdAluno(resultado.getInt("qtdAluno"));
                professor.setDiciplina(resultado.getString("diciplina"));
                professor.setSenha(resultado.getString("senha"));
                professor.setUsuario(resultado.getString("usuario"));
                professor.setMediaPassar(resultado.getDouble("mediaPassar"));

            }
        } catch (Exception e) {
            System.out.println("erro ao pesquisar o usuario e a senha" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return professor;
    }

}
