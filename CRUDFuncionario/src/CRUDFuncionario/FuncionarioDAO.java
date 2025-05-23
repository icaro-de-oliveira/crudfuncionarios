package CRUDFuncionario;

import java.sql.*;
import java.util.*;

public class FuncionarioDAO {
    private Connection con;

    public FuncionarioDAO() throws SQLException {
        this.con = ConnectionFactory.getConnection();
    }

    public void adicionar(Funcionario funcionario) throws SQLException {
        String sql = "INSERT INTO funcionario(idFuncionario, nome, cargo, dataAdmissao, salario) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, funcionario.getIdFuncionario());
        stmt.setString(2, funcionario.getNome());
        stmt.setString(3, funcionario.getCargo());
        stmt.setString(4, funcionario.getDataAdmissao());
        stmt.setDouble(5, funcionario.getSalario());
        stmt.execute();
        stmt.close();
    }

    public void alterar(Funcionario funcionario) throws SQLException {
        String sql = "UPDATE funcionario SET nome=?, cargo=?, dataAdmissao=?, salario=? WHERE idFuncionario=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, funcionario.getNome());
        stmt.setString(2, funcionario.getCargo());
        stmt.setString(3, funcionario.getDataAdmissao());
        stmt.setDouble(4, funcionario.getSalario());
        stmt.setInt(5, funcionario.getIdFuncionario());
        stmt.executeUpdate();
        stmt.close();
        System.out.println("Funcionário atualizado com sucesso.");
    }

    public void apagar(Funcionario funcionario) throws SQLException {
        String sql = "DELETE FROM funcionario WHERE idFuncionario=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, funcionario.getIdFuncionario());
        stmt.execute();
        stmt.close();
        System.out.println("Funcionário removido.");
    }

    public List<Funcionario> getLista() throws SQLException {
        List<Funcionario> lista = new ArrayList<>();
        String sql = "SELECT * FROM funcionario";
        PreparedStatement stmt = con.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            Funcionario f = new Funcionario();
            f.setIdFuncionario(rs.getInt("idFuncionario"));
            f.setNome(rs.getString("nome"));
            f.setCargo(rs.getString("cargo"));
            f.setDataAdmissao(rs.getString("dataAdmissao"));
            f.setSalario(rs.getDouble("salario"));
            lista.add(f);
        }
        rs.close();
        stmt.close();
        return lista;
    }
}