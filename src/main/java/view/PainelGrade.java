package view;

import controle.ControleCurso;
import controle.ControleDisciplina;
import controle.ControleGrade;
import dao.CursoDAO;
import dao.DisciplinaDAO;
import dao.GradeDAO;
import infra.Database;
import modelo.Curso;
import modelo.Disciplina;
import modelo.Grade;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PainelGrade extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
        ControleCurso controleCurso;
        CursoDAO cursoDAO;
        DisciplinaDAO disciplinaDAO;
        ControleDisciplina controleDisciplina;
        ControleGrade controleGrade;
        GradeDAO gradeDAO;
        JTable jTable1 = new javax.swing.JTable();
        Connection connection;
        JComboBox box = new JComboBox();
        JComboBox box2 = new JComboBox();
        JTextField areaNomeCodigo = new JTextField();



	public void cria() throws SQLException {
            iniciaConexao();
            inicialControle();

		this.setVisible(true);
		this.setLayout(null);
		
    	
        JLabel nomeAluno = new JLabel();
        this.add(nomeAluno);       
        nomeAluno.setText("Grade Currícular");
        nomeAluno.setBounds(590, 50, 312, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeAluno.setFont(f0);
        nomeAluno.setForeground(Color.black);

        JLabel nomeCodigo = new JLabel();
        this.add(nomeCodigo);
        nomeCodigo.setText("Ano:");
        nomeCodigo.setBounds(260, 120, 312, 50);
        Font f1 = new Font("SansSerif", Font.BOLD, 25);
        nomeCodigo.setFont(f1);
        nomeCodigo.setForeground(Color.black);

        JLabel nomeNome = new JLabel();
        this.add(nomeNome);
        nomeNome.setText("Curso:");
        nomeNome.setBounds(260, 180, 312, 50);
        Font f2 = new Font("SansSerif", Font.BOLD, 25);
        nomeNome.setFont(f2);
        nomeNome.setForeground(Color.black);


        JLabel nomeDisc = new JLabel();
        this.add(nomeDisc);
        nomeDisc.setText("Disciplina:");
        nomeDisc.setBounds(260, 240, 312, 50);
        Font f3 = new Font("SansSerif", Font.BOLD, 25);
        nomeDisc.setFont(f3);
        nomeDisc.setForeground(Color.black);



        this.add(areaNomeCodigo);
        areaNomeCodigo.setText("");
        areaNomeCodigo.setBounds(440, 133, 350, 25);
        Font f8 = new Font("SansSerif", Font.BOLD, 25);
        areaNomeCodigo.setFont(f8);
        areaNomeCodigo.setForeground(Color.black);

        limparBoxCurso();
        limparBoxDisciplina();

        atualizaBoxCurso();


		this.add(box);
		box.setBounds(440,193,350,25);

            atualizaBoxDisciplina();

		this.add(box2);
		box2.setBounds(440,253,350,25);



        JButton botaoCadastrarAluno = new JButton();
        this.add(botaoCadastrarAluno);
        botaoCadastrarAluno.setText("Inserir Grade");
        botaoCadastrarAluno.addActionListener(new insereGrade());
        botaoCadastrarAluno.setBounds(820, 253, 230, 30);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoCadastrarAluno.setFont(f7);
        botaoCadastrarAluno.setForeground(Color.black);

            JButton buscaGrade = new JButton();
            this.add(buscaGrade);
            buscaGrade.addActionListener(new buscaGrade());
            buscaGrade.setText("Busca Grade");
            buscaGrade.setBounds(820, 130, 230, 30);
            Font f9 = new Font("SansSerif", Font.BOLD, 25);
            buscaGrade.setFont(f9);
            buscaGrade.setForeground(Color.black);




         JScrollPane jScrollPane1 = new javax.swing.JScrollPane();



        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},


            },
            new String [] {
                "Title 1", "Title 2","Title 1", "Title 2",
            }
        ));
        jScrollPane1.setViewportView(jTable1);


        this.add(jTable1);
        this.add(jScrollPane1);

        jTable1.setBounds(250,353,800,306);


        JLabel nomeCurso = new JLabel();
        this.add(nomeCurso);
        nomeCurso.setText("Disciplina");
        nomeCurso.setBounds(720, 312, 200, 50);
        Font f4 = new Font("SansSerif", Font.BOLD, 15);
        nomeCurso.setFont(f4);
        nomeCurso.setForeground(Color.black);

        JLabel nomeCh = new JLabel();
        this.add(nomeCh);
        nomeCh.setText("Carga Hora");
        nomeCh.setBounds(920, 312, 238, 50);
        Font f5 = new Font("SansSerif", Font.BOLD, 15);
        nomeCh.setFont(f5);
        nomeCh.setForeground(Color.black);

            JLabel ano = new JLabel();
            this.add(ano);
            ano.setText("Ano");
            ano.setBounds(337, 312, 238, 50);
            Font f6 = new Font("SansSerif", Font.BOLD, 15);
            ano.setFont(f6);
            nomeCurso.setForeground(Color.black);

            JLabel nomeCurso2 = new JLabel();
            this.add(nomeCurso2);
            nomeCurso2.setText("Curso");
            nomeCurso2.setBounds(520, 312, 238, 50);
            Font f12 = new Font("SansSerif", Font.BOLD, 15);
            nomeCurso2.setFont(f12);
            nomeCurso2.setForeground(Color.black);

	}


	private class insereGrade implements ActionListener{

            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                if(areaNomeCodigo.getText().equals("") || box.getSelectedItem().equals("Selecione") || box2.getSelectedItem().equals("Selecione")){

                        JOptionPane.showMessageDialog(null,"Preencha os Dados Corretamente");

                }else{

                        String ano = areaNomeCodigo.getText();
                        String curso = (String) box.getSelectedItem();
                        String disciplina = (String) box2.getSelectedItem();


                        int id_curso = 0;
                        int id_disciplina = 0;

                        try{
                            id_curso = Integer.parseInt(curso.substring(0,2));

                        }catch (Exception e){
                                id_curso = Integer.parseInt(curso.substring(0,1));
                        }


                        try {
                                id_disciplina = Integer.parseInt(disciplina.substring(0,2));
                        }catch (Exception e){
                                id_disciplina = Integer.parseInt(disciplina.substring(0,1));
                        }

                        boolean achou = false;

                        try {
                                Curso cursoAux = controleCurso.buscaCurso(id_curso);

                                Disciplina disciplinaAux = controleDisciplina.buscaDisciplina(id_disciplina);

                                if(cursoAux!= null && disciplinaAux!=null){

                                        ArrayList<Grade> listGrades = controleGrade.listGrades();


                                        if(listGrades.isEmpty()){
                                                controleGrade.insere(ano,cursoAux,disciplinaAux);

                                                ArrayList<Grade> listGrades2 = controleGrade.listGrades();

                                                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                                                dtm.setNumRows(0);

                                                for(Grade grade : listGrades2){
                                                        if(grade.getCurso().getNome().equals(cursoAux.getNome()) &&  ano.equals(grade.getAno())) {

                                                                dtm.addRow(new String[]{grade.getAno(), cursoAux.getNome(),
                                                                        grade.getDisciplina().getNome(), grade.getDisciplina().getCargahr()});

                                                        }
                                                }



                                        }else{

                                                for(Grade grade : listGrades){

                                                        if(cursoAux.getNome().equals(grade.getCurso().getNome()) &&  ano.equals(grade.getAno())
                                                        && disciplinaAux.getNome().equals(grade.getDisciplina().getNome())){
                                                                achou = true;
                                                                controleGrade.insere(ano,cursoAux,disciplinaAux);

                                                                ArrayList<Grade> listGrades3 = controleGrade.listGrades();

                                                                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                                                                dtm.setNumRows(0);

                                                                dtm.addRow(new String[]{ano,cursoAux.getNome()});

                                                                for(Grade grade1:listGrades3){

                                                                        if(grade1.getCurso().getNome().equals(cursoAux.getNome()) &&  ano.equals(grade.getAno())){

                                                                                dtm.addRow(new String[]{null,null,
                                                                                        grade1.getDisciplina().getNome(),
                                                                                        grade1.getDisciplina().getCargahr()});
                                                                        }


                                                                }


                                                                achou = true;


                                                                break;

                                                        }


                                                }

                                                if(!achou) {
                                                        ArrayList<Grade> listGrades3 = controleGrade.listGrades();

                                                        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                                                        dtm.setNumRows(0);

                                                        dtm.addRow(new String[]{ano,cursoAux.getNome()});

                                                        for(Grade grade1:listGrades3){
                                                                if(cursoAux.getNome().equals(grade1.getCurso().getNome())
                                                                        && disciplinaAux.getNome().equals(grade1.getDisciplina().getNome())){
                                                                        dtm.setNumRows(0);


                                                                }else {

                                                                        boolean achouAux10 = false;
                                                                        controleGrade.insere(ano,cursoAux,disciplinaAux);

                                                                        ArrayList<Grade> listGrades4 = controleGrade.listGrades();

                                                                        for(Grade aux5 : listGrades4){

                                                                                if(cursoAux.getNome().equals(aux5.getCurso().getNome()) &&
                                                                                        areaNomeCodigo.getText().equals(aux5.getAno())){

                                                                                        achouAux10 = true;

                                                                                        dtm.addRow(new String[]{null,null,
                                                                                                aux5.getDisciplina().getNome(),
                                                                                                aux5.getDisciplina().getCargahr()});


                                                                                }


                                                                        }


                                                                        break;


                                                                }


                                                        }


                                                }



                                        }



                                }else{
                                        JOptionPane.showMessageDialog(null,"Ocorreu Um erro");
                                }

                        } catch (SQLException e) {
                                System.out.println(e);
                        }

                }


            }
    }


        public void iniciaConexao(){

                connection = Database.getConnection();
                cursoDAO = new CursoDAO(connection);
                disciplinaDAO = new DisciplinaDAO(connection);
                gradeDAO = new GradeDAO(connection);

        }


        public void inicialControle(){

                controleCurso = new ControleCurso(cursoDAO);
                controleDisciplina = new ControleDisciplina(disciplinaDAO);
                controleGrade = new ControleGrade(gradeDAO);

        }


        public void atualizaBoxCurso() throws SQLException {

                box.addItem("Selecione");

                ArrayList<Curso> listCurso = new ArrayList<>();


                listCurso = (ArrayList<Curso>) cursoDAO.listaCursos();

                box.setMaximumRowCount(20);

                for(Curso curso : listCurso){

                        box.addItem(curso.getId() + "-" +  curso.getNome());

                }
        }

        public  void atualizaBoxDisciplina() throws SQLException {

                box2.addItem("Selecione");


                ArrayList<Disciplina> listDisciplina = new ArrayList<>();


                listDisciplina = (ArrayList<Disciplina>) disciplinaDAO.listaDisciplinas();

                box2.setMaximumRowCount(20);

                for(Disciplina disciplina : listDisciplina){

                        box2.addItem(disciplina.getId() + "-" +  disciplina.getNome());

                }
        }

        public void limparBoxCurso(){


	        box.removeAllItems();



        }

        public void limparBoxDisciplina(){


                box2.removeAllItems();



        }

        private class buscaGrade implements ActionListener{


                @Override
                public void actionPerformed(ActionEvent actionEvent) {

                        ArrayList<Grade> listGrades3 = null;
                        try {
                                listGrades3 = controleGrade.listGrades();

                        } catch (SQLException e) {
                                e.printStackTrace();
                        }

                        if(listGrades3.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Lista Vazia");
                        }else{

                                if(areaNomeCodigo.getText().equals("") || box.getSelectedItem().equals("Selecione")){
                                        JOptionPane.showMessageDialog(null,"Informe o Ano e o Curso");
                                }else{


                                        String curso = (String) box.getSelectedItem();

                                        int id_curso = 0;

                                        try{
                                                id_curso = Integer.parseInt(curso.substring(0,2));

                                        }catch (Exception e){
                                                id_curso = Integer.parseInt(curso.substring(0,1));
                                        }

                                        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                                        dtm.setNumRows(0);

                                        try {
                                                Curso cursoAux = controleCurso.buscaCurso(id_curso);

                                                dtm.addRow(new String[]{areaNomeCodigo.getText(),cursoAux.getNome()});

                                                boolean achou = false;

                                                for(Grade grade1:listGrades3){

                                                        if(grade1.getAno().equals(areaNomeCodigo.getText()) && cursoAux.getNome().equals(grade1.getCurso().getNome()) ){

                                                                achou = true;

                                                                dtm.addRow(new String[]{null,null,
                                                                        grade1.getDisciplina().getNome(),
                                                                        grade1.getDisciplina().getCargahr()});
                                                        }


                                                }

                                                if(!achou){

                                                        JOptionPane.showMessageDialog(null,"Dados Nao Encontrados");
                                                        dtm.setNumRows(0);
                                                }


                                        } catch (SQLException e) {
                                                System.out.println(e);
                                        }


                                }




                        }






                }

	    }


 }

