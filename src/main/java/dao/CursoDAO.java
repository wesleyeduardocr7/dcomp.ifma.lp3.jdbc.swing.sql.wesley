package dao;

import modelo.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoDAO {


    private final Connection connection;


    public CursoDAO(Connection connection) {
        this.connection = connection;
    }


    public Curso salva(Curso curso) throws SQLException {

        String sql = "insert into curso (nome) values (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, curso.getNome());

            statement.execute();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                int id = keys.getInt(1);
                curso.setId(id);
            }
        }
        return curso;

    }


    public List<Curso> listaCursos() throws SQLException {

        String sql = "select * from curso";

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            List<Curso> listaCurso = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                int id = resultSet.getInt("id");

                Curso curso = new Curso(nome);

                curso.setId(id);

                listaCurso.add(curso);
            }

            return listaCurso;
        }

    }


    public Curso buscaCurso(int codigo) throws SQLException {

        String sql = "select * from curso where id = "+codigo;

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);


            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                int id = resultSet.getInt("id");

                if(id==codigo){

                    Curso curso = new Curso(nome);

                    curso.setId(id);

                    return curso;

                }else{
                    return null;
                }

            }
        }

        return null;
    }


    public void deleta(int codigo) throws SQLException {

        String sql = "delete from curso where id="+codigo;

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

        }

    }


}
