package controle;
import dao.AlunoDAO;
import infra.Database;
import modelo.Aluno;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ControleAluno {

    private AlunoDAO alunoDAO;

    public ControleAluno(AlunoDAO alunoDAO){

        this.alunoDAO = alunoDAO;

    }

    public void insere(String nome, String endereco, String rg, String cpf, String telefone) throws SQLException {


        Aluno aluno = new Aluno(nome,endereco,rg,cpf,telefone);

        try {

            alunoDAO.salva(aluno);

        }catch (SQLException ex){

            System.out.println(ex);

        }

    }


    public Aluno buscaAluno(int codigo) throws SQLException {

        Aluno aluno = alunoDAO.buscaAluno(codigo);

        return aluno;

    }

    public List listarAlunos() throws SQLException {

        return  alunoDAO.listaAlunos();


    }


    public void deleta(int codigo) throws SQLException {


        alunoDAO.deleta(codigo);


    }

}
