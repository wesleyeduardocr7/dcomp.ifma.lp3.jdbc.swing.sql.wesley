package controle;
import dao.ProfessorDAO;
import modelo.Professor;

import java.sql.SQLException;
import java.util.List;

public class ControleProfessor {

    private ProfessorDAO ProfessorDAO;

    public ControleProfessor(ProfessorDAO ProfessorDAO){

        this.ProfessorDAO = ProfessorDAO;

    }

    public void insere(String nome) throws SQLException {


        Professor Professor = new Professor(nome);

        try {

            ProfessorDAO.salva(Professor);

        }catch (SQLException ex){

            System.out.println(ex);

        }

    }


    public Professor buscaProfessor(int codigo) throws SQLException {

        Professor Professor = ProfessorDAO.buscaProfessor(codigo);

        return Professor;

    }

    public List listarProfessors() throws SQLException {

        return  ProfessorDAO.listaProfessors();

    }


    public void deleta(int codigo) throws SQLException {

        ProfessorDAO.deleta(codigo);

    }

}
