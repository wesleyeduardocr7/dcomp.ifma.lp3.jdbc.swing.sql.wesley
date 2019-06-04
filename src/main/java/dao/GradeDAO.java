package dao;

import controle.ControleCurso;
import controle.ControleDisciplina;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Grade;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GradeDAO {


    private final Connection connection;
    CursoDAO CursoDAO;
    DisciplinaDAO disciplinaDAO;
    ControleCurso controleCurso;
    ControleDisciplina controleDisciplina;


    public GradeDAO(Connection connection) {
         this.connection = connection;
         this.CursoDAO = new CursoDAO(connection);
         this.controleCurso = new ControleCurso(CursoDAO);
         this.disciplinaDAO = new DisciplinaDAO(connection);
         this.controleDisciplina = new ControleDisciplina(disciplinaDAO);
    }


    public Grade salva(Grade Grade) throws SQLException {

        String sql = "insert into grade (ano,id_curso,id_disciplina) values (?, ?, ?)";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setString(1, Grade.getAno());
            statement.setInt(2, Grade.getCurso().getId());
            statement.setInt(3, Grade.getDisciplina().getId());

            Grade.getListaDisciplinas().add(Grade.getDisciplina());

            statement.execute();


        }

        return Grade;

    }



    public ArrayList<Grade> listaGrade() throws SQLException {

        String sql = "select * from grade";

        ArrayList<Grade> listaGrades = new ArrayList<>();

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            while (resultSet.next()) {

                String ano = resultSet.getString("ano");
                int id_curso = resultSet.getInt("id_curso");
                int id_disciplina = resultSet.getInt("id_disciplina");

                Curso curso = CursoDAO.buscaCurso(id_curso);

                Disciplina disciplina = disciplinaDAO.buscaDisciplina(id_disciplina);

                Grade grade = new Grade(ano,curso,disciplina);

                listaGrades.add(grade);

            }

            return listaGrades;
        }

    }




    public Grade buscaGradeAno(String ano) throws SQLException {

        String sql = "select * from grade where id_curso = "+ano;

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            while (resultSet.next()) {

                String anoAux = resultSet.getString("ano");
                int id_curso = resultSet.getInt("id_curso");
                int id_disciplina = resultSet.getInt("id_disciplina");

                if(ano.equalsIgnoreCase(anoAux)){

                    Curso curso = CursoDAO.buscaCurso(id_curso);

                    Disciplina disciplina = disciplinaDAO.buscaDisciplina(id_disciplina);

                    Grade Grade = new Grade(ano,curso,disciplina);

                    return Grade;

                }

            }
        }

        return null;
    }

    public Grade buscaGradeCurso(int id) throws SQLException {

        String sql = "select * from grade where id_curso = "+id;

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            while (resultSet.next()) {

                String ano = resultSet.getString("ano");
                int id_curso = resultSet.getInt("id_curso");
                int id_disciplina = resultSet.getInt("id_disciplina");

                if(id == id_curso){

                    Curso curso = CursoDAO.buscaCurso(id_curso);

                    Disciplina disciplina = disciplinaDAO.buscaDisciplina(id_disciplina);

                    Grade Grade = new Grade(ano,curso,disciplina);
                    Grade.getListaDisciplinas().add(disciplina);

                    return Grade;

                }

            }
        }

        return null;
    }




}
