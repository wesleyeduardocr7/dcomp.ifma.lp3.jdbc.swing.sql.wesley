package controle;
import dao.DisciplinaDAO;
import modelo.Disciplina;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleDisciplina {

    private DisciplinaDAO DisciplinaDAO;

    public ControleDisciplina(DisciplinaDAO DisciplinaDAO){

        this.DisciplinaDAO = DisciplinaDAO;

    }

    public void insere(String nome, String ementa, String cargahr) throws SQLException {


        Disciplina Disciplina = new Disciplina(nome,ementa,cargahr);

        try {

            DisciplinaDAO.salva(Disciplina);

        }catch (SQLException ex){

            System.out.println(ex);

        }

    }


    public Disciplina buscaDisciplina(int codigo) throws SQLException {

        Disciplina Disciplina = DisciplinaDAO.buscaDisciplina(codigo);

        return Disciplina;

    }

    public ArrayList<Disciplina> listarDisciplinas() throws SQLException {

        return  DisciplinaDAO.listaDisciplinas();


    }


    public void deleta(int codigo) throws SQLException {


        DisciplinaDAO.deleta(codigo);


    }

}
