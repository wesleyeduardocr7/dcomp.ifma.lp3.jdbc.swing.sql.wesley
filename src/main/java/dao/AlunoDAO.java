package dao;
import modelo.Aluno;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AlunoDAO {


    private final Connection connection;


    public AlunoDAO(Connection connection) {
        this.connection = connection;
    }


    public Aluno salva(Aluno aluno) throws SQLException {

        String sql = "insert into aluno (nome, endereco, rg, cpf, telefone) values (?, ?, ?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, aluno.getNome());
            statement.setString(2, aluno.getEndereco());
            statement.setString(3, aluno.getRg());
            statement.setString(4, aluno.getCpf());
            statement.setString(5, aluno.getTelefone());

            statement.execute();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                int id = keys.getInt(1);
                aluno.setId(id);
            }
        }
        return aluno;

    }


    public List<Aluno> listaAlunos() throws SQLException {

        String sql = "select * from aluno";

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            List<Aluno> listaAluno = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String rg = resultSet.getString("rg");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                int id = resultSet.getInt("id");

                Aluno aluno = new Aluno(nome,endereco,rg,cpf,telefone);

                aluno.setId(id);

                listaAluno.add(aluno);
            }

            return listaAluno;
        }

    }


    public Aluno buscaAluno(int codigo) throws SQLException {

        String sql = "select * from aluno where id = "+codigo;

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);


            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                String endereco = resultSet.getString("endereco");
                String rg = resultSet.getString("rg");
                String cpf = resultSet.getString("cpf");
                String telefone = resultSet.getString("telefone");
                int id = resultSet.getInt("id");

                if(id==codigo){

                    Aluno aluno = new Aluno(nome,endereco,rg,cpf,telefone);

                    aluno.setId(id);

                    return aluno;

                }else{
                    return null;
                }

            }
        }

        return null;
    }


    public void deleta(int codigo) throws SQLException {

        String sql = "delete from aluno where id="+codigo;

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

        }

    }


}
