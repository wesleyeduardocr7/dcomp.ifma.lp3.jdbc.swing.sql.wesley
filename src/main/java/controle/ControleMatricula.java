package controle;
import dao.MatriculaDAO;
import modelo.*;

import javax.swing.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class ControleMatricula {

    private MatriculaDAO MatriculaDAO;

    public ControleMatricula(MatriculaDAO MatriculaDAO){

        this.MatriculaDAO = MatriculaDAO;

    }

    public void insere(Aluno aluno, Curso curso) throws SQLException {


        Matricula Matricula = new Matricula(aluno,curso);

        try {

            MatriculaDAO.salva(Matricula);

        }catch (SQLException ex){

            JOptionPane.showMessageDialog(null,"Matricula Duplicada");

        }

    }

    public ArrayList<Matricula> listMatriculas() throws SQLException {

        return MatriculaDAO.listaMatricula();
    }


}
