package modelo;

import java.util.ArrayList;

public class Matricula {

    private Aluno aluno;
    private Curso curso;


    public Matricula(Aluno aluno, Curso curso) {
        this.aluno = aluno;
        this.curso = curso;
    }


    public Aluno getAluno() {
        return aluno;
    }

    public Curso getCurso() {
        return curso;
    }


}
