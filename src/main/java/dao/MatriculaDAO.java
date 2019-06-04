package dao;

import controle.ControleCurso;
import controle.ControleAluno;
import modelo.Curso;
import modelo.Aluno;
import modelo.Matricula;

import java.sql.*;
import java.util.ArrayList;

public class MatriculaDAO {


    private final Connection connection;
    
    AlunoDAO AlunoDAO;
    CursoDAO CursoDAO;

    ControleAluno controleAluno;
    ControleCurso controleCurso;


    public MatriculaDAO(Connection connection) {

         this.connection = connection;
         this.AlunoDAO = new AlunoDAO(connection);
         this.controleAluno = new ControleAluno(AlunoDAO);
         this.CursoDAO = new CursoDAO(connection);
         this.controleCurso = new ControleCurso(CursoDAO);
    }


    public Matricula salva(Matricula matricula) throws SQLException {

        String sql = "insert into matricula(id_aluno,id_curso) values(?,?);";

        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            statement.setInt(1, matricula.getAluno().getId());
            statement.setInt(2, matricula.getCurso().getId());

            statement.execute();

        }

        return matricula;

    }



    public ArrayList<Matricula> listaMatricula() throws SQLException {

        String sql = "select * from matricula";

        ArrayList<Matricula> listaMatricula = new ArrayList<>();

        try (PreparedStatement statment = connection.prepareStatement(sql)) {

            ResultSet resultSet = statment.executeQuery(sql);

            while (resultSet.next()) {

                int id_aluno = resultSet.getInt("id_aluno");
                int id_curso = resultSet.getInt("id_curso");

                Aluno Aluno = AlunoDAO.buscaAluno(id_aluno);

                Curso Curso = CursoDAO.buscaCurso(id_curso);

               Matricula matricula = new Matricula(Aluno,Curso);

               listaMatricula.add(matricula);

            }

            return listaMatricula;
        }

    }

}
