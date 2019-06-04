package dao;

import controle.ControleCurso;
import controle.ControleDisciplina;
import controle.ControleProfessor;
import modelo.*;
import modelo.ProfessorDisciplina;

import java.sql.*;
import java.util.ArrayList;

public class ProfessorDisciplinaDAO {


    private final Connection connection;
    ProfessorDAO professorDAO;
    DisciplinaDAO disciplinaDAO;

    ControleProfessor controleProfessor;
    ControleDisciplina controleDisciplina;


    public ProfessorDisciplinaDAO(Connection connection) {
         this.connection = connection;
         this.professorDAO = new ProfessorDAO(connection);
         this.controleProfessor = new ControleProfessor(professorDAO);
         this.disciplinaDAO = new DisciplinaDAO(connection);
         this.controleDisciplina = new ControleDisciplina(disciplinaDAO);
    }


    public ProfessorDisciplina salva(ProfessorDisciplina professorDisciplina) throws SQLException {

        String sql = "insert into professordisciplina(id_professor,id_disciplina) values(?,?);";


        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {


            statement.setInt(1, professorDisciplina.getProfessor().getId());
            statement.setInt(2, professorDisciplina.getDisciplina().getId());

            statement.execute();

        }

        return professorDisciplina;

    }



    public ArrayList<ProfessorDisciplina> listaProfessorDisciplina() throws SQLException {

        String sql = "select * from professorDisciplina";

        ArrayList<ProfessorDisciplina> listaProfessorDisciplinas = new ArrayList<>();

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            while (resultSet.next()) {

                int id_professor = resultSet.getInt("id_professor");
                int id_disciplina = resultSet.getInt("id_disciplina");

                Professor professor = professorDAO.buscaProfessor(id_professor);

                Disciplina disciplina = disciplinaDAO.buscaDisciplina(id_disciplina);

                ProfessorDisciplina ProfessorDisciplina = new ProfessorDisciplina(professor,disciplina);

                listaProfessorDisciplinas.add(ProfessorDisciplina);

            }

            return listaProfessorDisciplinas;
        }

    }

}
