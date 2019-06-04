package modelo;

import java.util.ArrayList;

public class Grade {

    private String ano;
    private Curso curso;
    private Disciplina disciplina;
    private ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();


    public Grade(String ano, Curso curso, Disciplina disciplina) {
        this.ano = ano;
        this.curso = curso;
        this.disciplina = disciplina;
        adiciona(disciplina);
    }

    public Grade() {

    }


    public String getAno() {
        return ano;
    }

    public Curso getCurso() {
        return curso;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }


    public ArrayList<Disciplina> getListaDisciplinas() {
        return this.listaDisciplinas;
    }

    public void  adiciona(Disciplina disciplina){
        this.listaDisciplinas.add(disciplina);
    }


    @Override
    public String toString() {
        return "Grade{" +
                "ano='" + ano + '\'' +
                ", curso=" + curso +
                ", disciplina=" + disciplina +
                ", listaDisciplinas=" + listaDisciplinas +
                '}';
    }
}
