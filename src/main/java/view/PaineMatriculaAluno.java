package view;

import controle.ControleCurso;
import controle.ControleAluno;
import controle.ControleMatricula;
import dao.CursoDAO;
import dao.AlunoDAO;
import dao.MatriculaDAO;
import infra.Database;
import modelo.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class PaineMatriculaAluno extends JPanel {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;


    ControleAluno controleAluno;
    AlunoDAO AlunoDAO;
    CursoDAO CursoDAO;
    ControleCurso controleCurso;
    ControleMatricula controleMatricula;
    MatriculaDAO matriculaDAO;
    Connection connection;




    JTable jTable1 = new javax.swing.JTable();
    JComboBox box = new JComboBox();
    JComboBox box2 = new JComboBox();

	public void criaPainelMatAluno() throws SQLException {

        iniciaConexao();
        inicialControle();



        this.setVisible(true);
		this.setLayout(null);

        JLabel nomeAluno = new JLabel();
        this.add(nomeAluno);
        nomeAluno.setText("Matrícula de Aluno");
        nomeAluno.setBounds(570, 50, 300, 50);
        Font f0 = new Font("SansSerif", Font.BOLD, 25);
        nomeAluno.setFont(f0);
        nomeAluno.setForeground(Color.black);

        JLabel nomeCodigo = new JLabel();
        this.add(nomeCodigo);
        nomeCodigo.setText("Aluno:");
        nomeCodigo.setBounds(400, 120, 300, 50);
        Font f1 = new Font("SansSerif", Font.BOLD, 25);
        nomeCodigo.setFont(f1);
        nomeCodigo.setForeground(Color.black);

        JLabel nomeNome = new JLabel();
        this.add(nomeNome);
        nomeNome.setText("Curso:");
        nomeNome.setBounds(400, 180, 300, 50);
        Font f2 = new Font("SansSerif", Font.BOLD, 25);
        nomeNome.setFont(f2);
        nomeNome.setForeground(Color.black);


        limparBoxcurso();
        limparBoxaluno();

        atualizaBoxCurso();
        atualizaBoxAluno();

		this.add(box2);
		box2.setBounds(550,133,300,25);

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
        //botaoBuscar.addActionListener(new PainelProfDisc.buscar());
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


       JLabel nomeCurso = new JLabel();
       this.add(nomeCurso);
       nomeCurso.setText("Aluno");
       nomeCurso.setBounds(590, 250, 200, 50);
       Font f4 = new Font("SansSerif", Font.BOLD, 15);
       nomeCurso.setFont(f4);
       nomeCurso.setForeground(Color.black);

       JLabel nomeCh = new JLabel();
       this.add(nomeCh);
       nomeCh.setText("Curso");
       nomeCh.setBounds(735, 250, 200, 50);
       Font f5 = new Font("SansSerif", Font.BOLD, 15);
       nomeCh.setFont(f5);
       nomeCh.setForeground(Color.black);


	}



    public void iniciaConexao(){

        connection = Database.getConnection();
        CursoDAO = new CursoDAO(connection);
        matriculaDAO = new MatriculaDAO(connection);
        CursoDAO = new CursoDAO(connection);
        AlunoDAO = new AlunoDAO(connection);

    }


    public void inicialControle(){

        controleCurso = new ControleCurso(CursoDAO);
        controleAluno = new ControleAluno(AlunoDAO);
        controleCurso = new ControleCurso(CursoDAO);
        controleMatricula = new ControleMatricula(matriculaDAO);

    }

    public void atualizaBoxAluno() throws SQLException {

        box2.addItem("Selecione");

        ArrayList<Aluno> listAluno ;


        listAluno = (ArrayList<Aluno>) AlunoDAO.listaAlunos();

        box2.setMaximumRowCount(20);

        for(Aluno aluno : listAluno){

            box2.addItem(aluno.getId() + "-" +  aluno.getNome());

        }
    }

    public  void atualizaBoxCurso() throws SQLException {

        box.addItem("Selecione");

        ArrayList<Curso> listCurso ;


        listCurso = (ArrayList<Curso>) CursoDAO.listaCursos();

        box.setMaximumRowCount(20);

        for(Curso curso : listCurso){

            box.addItem(curso.getId() + "-" +  curso.getNome());

        }
    }

    public void limparBoxaluno(){


        box.removeAllItems();



    }

    public void limparBoxcurso(){


        box2.removeAllItems();



    }

    private class insere implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();

            if(box2.getSelectedItem().equals("Selecione") || box.getSelectedItem().equals("Selecione") ){
                JOptionPane.showMessageDialog(null,"Insira os dados Corretamente");
            }else{

                try {

                    dtm.setNumRows(0);

                    ArrayList<Matricula> listMatriculas ;
                    listMatriculas = matriculaDAO.listaMatricula();

                    String aluno = (String) box2.getSelectedItem();
                    String curso = (String) box.getSelectedItem();

                    int id_aluno = 0;
                    int id_curso = 0;

                    try{
                        id_aluno = Integer.parseInt(aluno.substring(0,2));

                    }catch (Exception e){

                        id_aluno = Integer.parseInt(aluno.substring(0,1));
                    }


                    try {
                        id_curso = Integer.parseInt(curso.substring(0,2));
                    }catch (Exception e){
                        id_curso = Integer.parseInt(curso.substring(0,1));
                    }


                    if(listMatriculas.isEmpty()){


                        Aluno alunoAux = AlunoDAO.buscaAluno(id_aluno);

                        Curso cursoux = CursoDAO.buscaCurso(id_curso);

                        if(alunoAux!= null & cursoux!= null){

                            controleMatricula.insere(alunoAux,cursoux);

                            ArrayList<Matricula> listMatriculas2 ;
                            listMatriculas2 = matriculaDAO.listaMatricula();

                            dtm.addRow(new String[]{alunoAux.getNome()});

                            for(Matricula matricula:listMatriculas2){

                                if(matricula.getAluno().getNome().equals(alunoAux.getNome())){

                                    dtm.addRow(new String[]{null,matricula.getCurso().getNome()});

                                }

                            }

                        }




                    }else{


                        dtm.setNumRows(0);

                        Aluno alunoAux = AlunoDAO.buscaAluno(id_aluno);

                        Curso cursoux = CursoDAO.buscaCurso(id_curso);

                        if(alunoAux!= null & cursoux!= null){

                            boolean duplicado = false;

                            dtm.addRow(new String[]{alunoAux.getNome()});

                            for(Matricula Matricula:listMatriculas){

                                if(alunoAux.getNome().equals(Matricula.getAluno().getNome()) &&
                                        cursoux.getNome().equals(Matricula.getCurso().getNome())){


                                    duplicado = true;

                                    JOptionPane.showMessageDialog(null,"Dados Duplicados");


                                    ArrayList<Matricula> listMatriculas4 ;
                                    listMatriculas4 = matriculaDAO.listaMatricula();

                                    for(Matricula matricula4:listMatriculas4){

                                        if(matricula4.getAluno().getNome().equals(alunoAux.getNome())){

                                            dtm.addRow(new String[]{null,matricula4.getCurso().getNome()});

                                        }

                                    }

                                    break;

                                }

                            }


                            if(duplicado==false){

                                dtm.setNumRows(0);

                                controleMatricula.insere(alunoAux,cursoux);

                                ArrayList<Matricula> listMatriculas3 ;
                                listMatriculas3 = matriculaDAO.listaMatricula();

                                dtm.addRow(new String[]{alunoAux.getNome()});

                                for(Matricula Matricula3:listMatriculas3){

                                    if(Matricula3.getAluno().getNome().equals(alunoAux.getNome())){

                                        dtm.addRow(new String[]{null,Matricula3.getCurso().getNome()});

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

            DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();


            if(box2.getSelectedItem().equals("Selecione")){

                JOptionPane.showMessageDialog(null,"Selecione um Aluno");

            }else{
                String aluno = (String) box2.getSelectedItem();

                int id_aluno = 0;

                try{
                    id_aluno = Integer.parseInt(aluno.substring(0,2));

                }catch (Exception e){
                    id_aluno = Integer.parseInt(aluno.substring(0,1));
                }

                try {

                    Aluno alunoAux = AlunoDAO.buscaAluno(id_aluno);


                    if(alunoAux==null){

                        JOptionPane.showMessageDialog(null,"Ano Nao Está Matriculado");
                        dtm.setNumRows(0);


                    }else{



                        dtm.setNumRows(0);

                        ArrayList<Matricula> listMatriculas5 ;
                        listMatriculas5 = matriculaDAO.listaMatricula();

                        dtm.addRow(new String[]{alunoAux.getNome()});

                        boolean achou = false;

                        for(Matricula Matricula5:listMatriculas5){


                            if(Matricula5.getAluno().getNome().equals(alunoAux.getNome())){

                                achou = true;

                                dtm.addRow(new String[]{null,Matricula5.getCurso().getNome()});

                            }

                        }

                        if(!achou){
                            JOptionPane.showMessageDialog(null,"Ano Nao Está Matriculado");
                            dtm.setNumRows(0);
                        }

                    }


                } catch (SQLException e) {
                    e.printStackTrace();
                }

            }




        }
    }


}

	