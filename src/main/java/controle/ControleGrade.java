package controle;
import dao.GradeDAO;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Grade;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleGrade {

    private GradeDAO GradeDAO;

    public ControleGrade(GradeDAO GradeDAO){

        this.GradeDAO = GradeDAO;

    }

    public void insere(String ano, Curso curso, Disciplina disciplina) throws SQLException {


        Grade Grade = new Grade(ano,curso,disciplina);

        try {

            GradeDAO.salva(Grade);

        }catch (SQLException ex){

            JOptionPane.showMessageDialog(null,"Grade Duplicada");

        }

    }

    public ArrayList<Grade> listGrades() throws SQLException {

        return GradeDAO.listaGrade();
    }


    public Grade buscaGradeAno(String ano) throws SQLException {

        Grade Grade = GradeDAO.buscaGradeAno(ano);

        return Grade;

    }

    public Grade buscaGradeCurso(int idCurso) throws SQLException {

        Grade Grade = GradeDAO.buscaGradeCurso(idCurso);

        return Grade;

    }

}
