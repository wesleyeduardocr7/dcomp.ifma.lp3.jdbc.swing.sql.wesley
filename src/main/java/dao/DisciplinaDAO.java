package dao;

import modelo.Disciplina;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DisciplinaDAO {


    private final Connection connection;


    public DisciplinaDAO(Connection connection) {
        this.connection = connection;
    }


    public Disciplina salva(Disciplina Disciplina) throws SQLException {

        String sql = "insert into disciplina (nome,ementa,cargahr) values (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, Disciplina.getNome());
            statement.setString(2, Disciplina.getEmenta());
            statement.setString(3, Disciplina.getCargahr());
            statement.execute();

            try (ResultSet keys = statement.getGeneratedKeys()) {
                keys.next();
                int id = keys.getInt(1);
                Disciplina.setId(id);
            }
        }
        return Disciplina;

    }


    public ArrayList<Disciplina> listaDisciplinas() throws SQLException {

        String sql = "select * from disciplina";

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            ArrayList<Disciplina> listaDisciplina = new ArrayList<>();

            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                String ementa = resultSet.getString("ementa");
                String carhahr = resultSet.getString("cargahr");
                int id = resultSet.getInt("id");

                Disciplina Disciplina = new Disciplina(nome,ementa,carhahr);

                Disciplina.setId(id);

                listaDisciplina.add(Disciplina);
            }

            return listaDisciplina;
        }

    }


    public Disciplina buscaDisciplina(int codigo) throws SQLException {

        String sql = "select * from disciplina where id = "+codigo;

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);


            while (resultSet.next()) {

                String nome = resultSet.getString("nome");
                String ementa = resultSet.getString("ementa");
                String cargarhr = resultSet.getString("cargahr");;
                int id = resultSet.getInt("id");

                if(id==codigo){

                    Disciplina Disciplina = new Disciplina(nome,ementa,cargarhr);

                    Disciplina.setId(id);

                    return Disciplina;

                }else{
                    return null;
                }

            }
        }

        return null;
    }


    public void deleta(int codigo) throws SQLException {

        String sql = "delete from disciplina where id="+codigo;

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.execute();

        }

    }


}
