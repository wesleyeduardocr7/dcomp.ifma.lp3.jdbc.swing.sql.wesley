package controle;
import dao.ProfessorDisciplinaDAO;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Professor;
import modelo.ProfessorDisciplina;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleProfessorDisciplina {

    private ProfessorDisciplinaDAO ProfessorDisciplinaDAO;

    public ControleProfessorDisciplina(ProfessorDisciplinaDAO ProfessorDisciplinaDAO){

        this.ProfessorDisciplinaDAO = ProfessorDisciplinaDAO;

    }

    public void insere(Professor professor, Disciplina disciplina) throws SQLException {


        System.out.println("aqui 01");

        ProfessorDisciplina ProfessorDisciplina = new ProfessorDisciplina(professor,disciplina);

        try {

            ProfessorDisciplinaDAO.salva(ProfessorDisciplina);

        }catch (SQLException ex){

            JOptionPane.showMessageDialog(null,"ProfessorDisciplina Duplicada");

        }

    }

    public ArrayList<ProfessorDisciplina> listProfessorDisciplinas() throws SQLException {

        return ProfessorDisciplinaDAO.listaProfessorDisciplina();
    }


}
