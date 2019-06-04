package controle;
import dao.CursoDAO;
import modelo.Curso;
import modelo.Curso;

import java.sql.SQLException;
import java.util.List;

public class ControleCurso {

    private CursoDAO cursoDAO;

    public ControleCurso(CursoDAO cursoDAO){

        this.cursoDAO = cursoDAO;

    }

    public void insere(String nome) throws SQLException {


        Curso curso = new Curso(nome);

        try {

            cursoDAO.salva(curso);

        }catch (SQLException ex){

            System.out.println(ex);

        }

    }


    public Curso buscaCurso(int codigo) throws SQLException {

        Curso Curso = cursoDAO.buscaCurso(codigo);

        return Curso;

    }

    public List listarCursos() throws SQLException {

        return  cursoDAO.listaCursos();

    }


    public void deleta(int codigo) throws SQLException {

        cursoDAO.deleta(codigo);

    }

}
