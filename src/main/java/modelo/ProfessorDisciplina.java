package modelo;

import java.util.ArrayList;

public class ProfessorDisciplina {

    private Professor professor;
    private Disciplina disciplina;
    private ArrayList<Disciplina> listaDisciplinas = new ArrayList<>();

    public ProfessorDisciplina(Professor professor, Disciplina disciplina) {

        this.professor = professor;
        this.disciplina = disciplina;
        adiciona(disciplina);
    }

    public Professor getProfessor() {
        return professor;
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


}
