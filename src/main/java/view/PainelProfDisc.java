package view;

import controle.*;
import dao.*;
import infra.Database;
import modelo.*;
import modelo.Professor;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PainelProfDisc extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    ControleProfessor controleProfessor;
    ProfessorDAO ProfessorDAO;
    DisciplinaDAO disciplinaDAO;
    ControleDisciplina controleDisciplina;
    ControleProfessorDisciplina controleProfessorDisciplina;
    ProfessorDisciplinaDAO professorDisciplinaDAO;
    Connection connection;
    JTable jTable1 = new javax.swing.JTable();


    JComboBox box = new JComboBox();
    JComboBox box2 = new JComboBox();


    public void cria() throws SQLException {


        iniciaConexao();
        inicialControle();


        this.setVisible(true);
		this.setLayout(null);
		
    	
        JLabel nomeAluno = new JLabel();
        this.add(nomeAluno);       
        nomeAluno.setText("Professor / Disciplina");
        nomeAluno.setBounds(570, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeAluno.setFont(f0);
        nomeAluno.setForeground(Color.black);
        
        JLabel nomeCodigo = new JLabel();
        this.add(nomeCodigo);       
        nomeCodigo.setText("Professor:");
        nomeCodigo.setBounds(400, 120, 300, 50);
        Font f1 = new Font("SansSerif", Font.BOLD, 25);
        nomeCodigo.setFont(f1);
        nomeCodigo.setForeground(Color.black);
        
        JLabel nomeNome = new JLabel();
        this.add(nomeNome);       
        nomeNome.setText("Disciplina:");
        nomeNome.setBounds(400, 180, 300, 50);
        Font f2 = new Font("SansSerif", Font.BOLD, 25);
        nomeNome.setFont(f2);
        nomeNome.setForeground(Color.black);

        limparBoxDisciplina();
        limparBoxProfessor();

        atualizaBoxDisciplina();
		this.add(box2);		
		box2.setBounds(550, 133, 300, 25);
                
        atualizaBoxProfessor();
		this.add(box);		
		box.setBounds(550,193,300,25);
		
			               
        JButton botaoCadastrarAluno = new JButton();
        this.add(botaoCadastrarAluno);
        botaoCadastrarAluno.addActionListener(new insere());
        botaoCadastrarAluno.setText("Inserir");
        botaoCadastrarAluno.setBounds(610, 570, 180, 35);
        Font f7 = new Font("SansSerif", Font.BOLD, 25);
        botaoCadastrarAluno.setFont(f7);
        botaoCadastrarAluno.setForeground(Color.black);

        JButton botaoBuscar = new JButton();
        this.add(botaoBuscar);
        botaoBuscar.addActionListener(new buscar());
        botaoBuscar.setText("Buscar");
        botaoBuscar.setBounds(870, 130, 140, 30);
        Font f77 = new Font("SansSerif", Font.BOLD, 25);
        botaoBuscar.setFont(f77);
        botaoBuscar.setForeground(Color.black);


        JScrollPane jScrollPane1 = new javax.swing.JScrollPane();


        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
                    {null, null},
               
            },
            new String [] {
                "Title 1", "Title 2",
            }
        ));
        jScrollPane1.setViewportView(jTable1);
        
        
        this.add(jTable1);
        this.add(jScrollPane1);
        
        jTable1.setBounds(550,290,300,240);
        
        
        JLabel nomeProfessor = new JLabel();
        this.add(nomeProfessor);       
        nomeProfessor.setText("Professor");
        nomeProfessor.setBounds(590, 250, 200, 50);
        Font f4 = new Font("SansSerif", Font.BOLD, 15);
        nomeProfessor.setFont(f4);
        nomeProfessor.setForeground(Color.black);
        
        JLabel nomeCh = new JLabel();
        this.add(nomeCh);       
        nomeCh.setText("Disciplina");
        nomeCh.setBounds(735, 250, 200, 50);
        Font f5 = new Font("SansSerif", Font.BOLD, 15);
        nomeCh.setFont(f5);
        nomeCh.setForeground(Color.black);
    	

	}




    public void atualizaBoxProfessor() throws SQLException {

        box2.addItem("Selecione");

        ArrayList<Professor> listProfessor ;


        listProfessor = (ArrayList<Professor>) ProfessorDAO.listaProfessors();

        box2.setMaximumRowCount(20);

        for(Professor Professor : listProfessor){

            box2.addItem(Professor.getId() + "-" +  Professor.getNome());

        }
    }

    public  void atualizaBoxDisciplina() throws SQLException {

        box.addItem("Selecione");


        ArrayList<Disciplina> listDisciplina ;


        listDisciplina = disciplinaDAO.listaDisciplinas();

        box.setMaximumRowCount(20);

        for(Disciplina disciplina : listDisciplina){

            box.addItem(disciplina.getId() + "-" +  disciplina.getNome());

        }
    }

    public void limparBoxProfessor(){


        box.removeAllItems();



    }

    public void limparBoxDisciplina(){


        box2.removeAllItems();



    }

    public void iniciaConexao(){

        connection = Database.getConnection();
        professorDisciplinaDAO = new ProfessorDisciplinaDAO(connection);
        disciplinaDAO = new DisciplinaDAO(connection);
        ProfessorDAO = new ProfessorDAO(connection);

    }


    public void inicialControle(){

         controleDisciplina = new ControleDisciplina(disciplinaDAO);
        controleProfessor = new ControleProfessor(ProfessorDAO);
        controleProfessorDisciplina = new ControleProfessorDisciplina(professorDisciplinaDAO);

    }


    private class  insere implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {

            if(box2.getSelectedItem().equals("Selecione") || box.getSelectedItem().equals("Selecione") ){
                JOptionPane.showMessageDialog(null,"Insira os dados Corretamente");
            }else{



                try {


                    String professor = (String) box2.getSelectedItem();
                    String disciplina = (String) box.getSelectedItem();

                    int id_professor = 0;
                    int id_disciplina = 0;

                    try{
                        id_professor = Integer.parseInt(professor.substring(0,2));

                    }catch (Exception e){

                        id_professor = Integer.parseInt(professor.substring(0,1));
                    }


                    try {
                        id_disciplina = Integer.parseInt(disciplina.substring(0,2));
                    }catch (Exception e){
                        id_disciplina = Integer.parseInt(disciplina.substring(0,1));
                    }

                    DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                    dtm.setNumRows(0);

                    ArrayList<ProfessorDisciplina> listProfessorDisciplinas ;
                    listProfessorDisciplinas = professorDisciplinaDAO.listaProfessorDisciplina();

                    if(listProfessorDisciplinas.isEmpty()){
                        Professor professorAux = ProfessorDAO.buscaProfessor(id_professor);

                        Disciplina disciplinaAux = controleDisciplina.buscaDisciplina(id_disciplina);

                        if(professorAux!= null & disciplinaAux!= null){

                            controleProfessorDisciplina.insere(professorAux,disciplinaAux);

                            ArrayList<ProfessorDisciplina> listProfessorDisciplinas2 ;
                            listProfessorDisciplinas2 = professorDisciplinaDAO.listaProfessorDisciplina();

                            dtm.addRow(new String[]{professorAux.getNome()});

                            for(ProfessorDisciplina professorDisciplina:listProfessorDisciplinas2){

                                if(professorDisciplina.getProfessor().getNome().equals(professorAux.getNome())){

                                    dtm.addRow(new String[]{null,professorDisciplina.getDisciplina().getNome()});

                                }

                            }

                        }




                    }else{



                        try{
                            id_professor = Integer.parseInt(professor.substring(0,2));

                        }catch (Exception e){
                            id_professor = Integer.parseInt(professor.substring(0,1));
                        }


                        try {
                            id_disciplina = Integer.parseInt(disciplina.substring(0,2));
                        }catch (Exception e){
                            id_disciplina = Integer.parseInt(disciplina.substring(0,1));
                        }

                        Professor professorAux = ProfessorDAO.buscaProfessor(id_professor);

                        Disciplina disciplinaAux = controleDisciplina.buscaDisciplina(id_disciplina);

                        if(professorAux!= null & disciplinaAux!= null){

                            boolean duplicado = false;

                            dtm.addRow(new String[]{professorAux.getNome()});

                            for(ProfessorDisciplina professorDisciplina:listProfessorDisciplinas){

                                if(professorAux.getNome().equals(professorDisciplina.getProfessor().getNome()) &&
                                        disciplinaAux.getNome().equals(professorDisciplina.getDisciplina().getNome())){


                                    duplicado = true;

                                    JOptionPane.showMessageDialog(null,"Dados Duplicados");


                                    ArrayList<ProfessorDisciplina> listProfessorDisciplinas4 ;
                                    listProfessorDisciplinas4 = professorDisciplinaDAO.listaProfessorDisciplina();

                                    for(ProfessorDisciplina professorDisciplina4:listProfessorDisciplinas4){

                                        if(professorDisciplina4.getProfessor().getNome().equals(professorAux.getNome())){

                                            dtm.addRow(new String[]{null,professorDisciplina4.getDisciplina().getNome()});

                                        }

                                    }

                                    break;

                                }

                            }


                            if(duplicado==false){

                                controleProfessorDisciplina.insere(professorAux,disciplinaAux);

                                ArrayList<ProfessorDisciplina> listProfessorDisciplinas3 ;
                                listProfessorDisciplinas3 = professorDisciplinaDAO.listaProfessorDisciplina();

                                for(ProfessorDisciplina professorDisciplina3:listProfessorDisciplinas3){


                                    if(professorDisciplina3.getProfessor().getNome().equals(professorAux.getNome())){

                                        dtm.addRow(new String[]{null,professorDisciplina3.getDisciplina().getNome()});

                                    }

                                }

                            }



                        }



                    }




                } catch (SQLException e) {
                    e.printStackTrace();
                }


            }




        }
    }

    private class buscar implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            if(box2.getSelectedItem().equals("Selecione")){

                JOptionPane.showMessageDialog(null,"Selecione um Professor");

            }else{

                String professor = (String) box2.getSelectedItem();

                int id_professor = 0;

                try{
                    id_professor = Integer.parseInt(professor.substring(0,2));

                }catch (Exception e){
                    id_professor = Integer.parseInt(professor.substring(0,1));
                }

                try {

                    Professor professorAux = ProfessorDAO.buscaProfessor(id_professor);


                    if(professorAux==null){

                        JOptionPane.showMessageDialog(null,"Professor Nao Encontrado");

                    }else{

                        DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

                        dtm.setNumRows(0);

                        ArrayList<ProfessorDisciplina> listProfessorDisciplinas5 ;
                        listProfessorDisciplinas5 = professorDisciplinaDAO.listaProfessorDisciplina();

                        dtm.addRow(new String[]{professorAux.getNome()});

                        for(ProfessorDisciplina professorDisciplina5:listProfessorDisciplinas5){


                            if(professorDisciplina5.getProfessor().getNome().equals(professorAux.getNome())){


                                dtm.addRow(new String[]{null,professorDisciplina5.getDisciplina().getNome()});

                            }

                        }

                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }




        }
    }

}


//03/06/2019 12:22