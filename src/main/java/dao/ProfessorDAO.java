package dao;

import modelo.Professor;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO {


    private final Connection connection;


    public ProfessorDAO(Connection connection) {
        this.connection = connection;
    }


    public Professor salva(Professor Professor) throws SQLException {

        String sql = "insert into professor (nome) values (?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, Professor.getNome());

            statement.execute();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                int id = keys.getInt(1);
                Professor.setId(id);
            }
        }
        return Professor;

    }


    public List<Professor> listaProfessors() throws SQLException {

        String sql = "select * from professor";

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            List<Professor> listaProfessor = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                int id = resultSet.getInt("id");

                Professor Professor = new Professor(nome);

                Professor.setId(id);

                listaProfessor.add(Professor);
            }

            return listaProfessor;
        }

    }


    public Professor buscaProfessor(int codigo) throws SQLException {

        String sql = "select * from professor where id = "+codigo;

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);


            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                int id = resultSet.getInt("id");

                if(id==codigo){

                    Professor Professor = new Professor(nome);

                    Professor.setId(id);

                    return Professor;

                }else{
                    return null;
                }

            }
        }

        return null;
    }


    public void deleta(int codigo) throws SQLException {

        String sql = "delete from professor where id="+codigo;

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

        }

    }


}
